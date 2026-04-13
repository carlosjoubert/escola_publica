package com.cjrock.geo.controller;

import com.cjrock.geo.model.OcorrenciaDiarioDeClasse;
import com.cjrock.geo.repository.OcorrenciaDiarioDeClasseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ocorrencia-diario-de-classe")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class OcorrenciaDiarioDeClasseController {

    @Autowired
    private OcorrenciaDiarioDeClasseRepository repository;

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrarOcorrencia(@RequestBody OcorrenciaDiarioDeClasse ocorrencia) {
        OcorrenciaDiarioDeClasse novaOcorrencia = repository.save(ocorrencia);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaOcorrencia);
    }

    @GetMapping
    public ResponseEntity<List<OcorrenciaDiarioDeClasse>> listarTodos() {
        List<OcorrenciaDiarioDeClasse> lista = repository.findAll();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OcorrenciaDiarioDeClasse> buscarPorId(@PathVariable Integer id) {
        OcorrenciaDiarioDeClasse ocorrencia = repository.findById(id).orElse(null);
        if (ocorrencia != null) {
            return ResponseEntity.ok(ocorrencia);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<OcorrenciaDiarioDeClasse> atualizarPorId(@PathVariable Integer id, @RequestBody OcorrenciaDiarioDeClasse ocorrenciaAtualizada) {
        OcorrenciaDiarioDeClasse ocorrencia = repository.findById(id).orElse(null);
        if (ocorrencia != null) {
            ocorrencia.setOcorrencia(ocorrenciaAtualizada.getOcorrencia());
            ocorrencia.setConteudoPrevisto(ocorrenciaAtualizada.getConteudoPrevisto());
            ocorrencia.setConteudoRealizado(ocorrenciaAtualizada.getConteudoRealizado());
            ocorrencia.setTurmaDisciplina(ocorrenciaAtualizada.getTurmaDisciplina());
            ocorrencia.setDataHora(ocorrenciaAtualizada.getDataHora());
            repository.save(ocorrencia);
            return ResponseEntity.ok(ocorrencia);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Integer id) {
        OcorrenciaDiarioDeClasse ocorrencia = repository.findById(id).orElse(null);
        if (ocorrencia != null) {
            repository.delete(ocorrencia);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

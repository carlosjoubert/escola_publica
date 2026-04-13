package com.cjrock.geo.controller;

import com.cjrock.geo.model.HistoricoNotas;
import com.cjrock.geo.repository.HistoricoNotasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/historico-notas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class HistoricoNotasController {

    @Autowired
    private HistoricoNotasRepository repository;
    
    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrarHistoricoNotas(@RequestBody HistoricoNotas historicoNotas) {
        HistoricoNotas novoHistorico = repository.save(historicoNotas);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoHistorico);
    }

    @GetMapping
    public ResponseEntity<List<HistoricoNotas>> listarTodos() {
        List<HistoricoNotas> lista = repository.findAll();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HistoricoNotas> buscarPorId(@PathVariable Integer id) {
        HistoricoNotas historico = repository.findById(id).orElse(null);
        if (historico != null) {
            return ResponseEntity.ok(historico);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<HistoricoNotas> atualizarPorId(@PathVariable Integer id, @RequestBody HistoricoNotas historicoAtualizado) {
        return repository.findById(id).map(historico -> {

            historico.setAluno(historicoAtualizado.getAluno());
            historico.setTurmaDisciplina(historicoAtualizado.getTurmaDisciplina());

            // CORREÇÃO: Atualiza apenas a nota única e o período correspondente daquele ID
            historico.setNota(historicoAtualizado.getNota());
            historico.setTrimestre(historicoAtualizado.getTrimestre());
            HistoricoNotas historicoSalvo = repository.save(historico);
            return ResponseEntity.ok(historicoSalvo);

        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Integer id) {
        HistoricoNotas historico = repository.findById(id).orElse(null);
        if (historico != null) {
            repository.delete(historico);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

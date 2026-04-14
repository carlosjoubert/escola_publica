package com.cjrock.geo.controller;

import com.cjrock.geo.exception.RecursoNaoEncontradoException;
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
        HistoricoNotas historico = repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Histórico de Notas com ID " + id + " não existe no sistema."));
        return ResponseEntity.ok(historico);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HistoricoNotas> atualizarPorId(@PathVariable Integer id, @RequestBody HistoricoNotas historicoAtualizado) {
        HistoricoNotas historico = repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Histórico de Notas com ID " + id + " não existe no sistema."));

        historico.setAluno(historicoAtualizado.getAluno());
        historico.setTurmaDisciplina(historicoAtualizado.getTurmaDisciplina());
        historico.setNota(historicoAtualizado.getNota());
        historico.setTrimestre(historicoAtualizado.getTrimestre());

        repository.save(historico);
        return ResponseEntity.ok(historico);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Integer id) {
        HistoricoNotas historico = repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Histórico de Notas com ID " + id + " não existe no sistema."));

        repository.delete(historico);
        return ResponseEntity.noContent().build();
    }
}

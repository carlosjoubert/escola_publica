package com.cjrock.geo.controller;

import com.cjrock.geo.exception.RecursoNaoEncontradoException;
import com.cjrock.geo.model.HistoricoFrequencia;
import com.cjrock.geo.repository.HistoricoFrequenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/historico-frequencia")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class HistoricoFrequenciaController {
    
    @Autowired
    private HistoricoFrequenciaRepository repository;
    
    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrarHistoricoFrequencia(@RequestBody HistoricoFrequencia historicoFrequencia) {
        HistoricoFrequencia novoHistorico = repository.save(historicoFrequencia);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoHistorico);
    }

    @GetMapping
    public ResponseEntity<List<HistoricoFrequencia>> listarTodos() {
        List<HistoricoFrequencia> lista = repository.findAll();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HistoricoFrequencia> buscarPorId(@PathVariable Integer id) {
        HistoricoFrequencia historico = repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Histórico de Frequência com ID " + id + " não existe no sistema."));
        return ResponseEntity.ok(historico);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HistoricoFrequencia> atualizarPorId(@PathVariable Integer id, @RequestBody HistoricoFrequencia historicoAtualizado) {
        HistoricoFrequencia historico = repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Histórico de Frequência com ID " + id + " não existe no sistema."));

        historico.setAluno(historicoAtualizado.getAluno());
        historico.setTurmaDisciplina(historicoAtualizado.getTurmaDisciplina());
        historico.setQtdFaltas(historicoAtualizado.getQtdFaltas());

        repository.save(historico);
        return ResponseEntity.ok(historico);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Integer id) {
        HistoricoFrequencia historico = repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Histórico de Frequência com ID " + id + " não existe no sistema."));

        repository.delete(historico);
        return ResponseEntity.noContent().build();
    }
}

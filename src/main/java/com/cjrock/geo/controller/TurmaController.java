package com.cjrock.geo.controller;

import com.cjrock.geo.exception.RecursoNaoEncontradoException;
import com.cjrock.geo.model.Turma;
import com.cjrock.geo.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turmas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TurmaController {

    @Autowired
    private TurmaRepository repository;

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrarTurma(@RequestBody Turma turma) {
        Turma novaTurma = repository.save(turma);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaTurma);
    }

    @GetMapping
    public ResponseEntity<List<Turma>> listarTodas() {
        List<Turma> turmas = repository.findAll();
        return ResponseEntity.ok(turmas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Turma> buscarPorId(@PathVariable Long id) {
        Turma turma = repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Turma com ID " + id + " não existe no sistema."));
        return ResponseEntity.ok(turma);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Turma> atualizarPorId(@PathVariable Long id, @RequestBody Turma turmaAtualizada) {
        Turma turma = repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Turma com ID " + id + " não existe no sistema."));

        turma.setSerie(turmaAtualizada.getSerie());
        turma.setTurma(turmaAtualizada.getTurma());
        turma.setFase(turmaAtualizada.getFase());
        turma.setEscola(turmaAtualizada.getEscola());
        turma.setTurno(turmaAtualizada.getTurno());
        
        repository.save(turma);
        return ResponseEntity.ok(turma);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Long id) {
        Turma turma = repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Turma com ID " + id + " não existe no sistema."));

        repository.delete(turma);
        return ResponseEntity.noContent().build();
    }
}

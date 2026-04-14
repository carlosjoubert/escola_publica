package com.cjrock.geo.controller;

import com.cjrock.geo.exception.RecursoNaoEncontradoException;
import com.cjrock.geo.model.Disciplina;
import com.cjrock.geo.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disciplinas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DisciplinaController {

    @Autowired
    private DisciplinaRepository repository;

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrarDisciplina(@RequestBody Disciplina disciplina) {
        Disciplina novaDisciplina = repository.save(disciplina);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaDisciplina);
    }

    @GetMapping
    public ResponseEntity<List<Disciplina>> listarTodas() {
        List<Disciplina> disciplinas = repository.findAll();
        return ResponseEntity.ok(disciplinas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Disciplina> buscarPorId(@PathVariable Long id) {
        Disciplina disciplina = repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Disciplina com ID " + id + " não existe no sistema."));
        return ResponseEntity.ok(disciplina);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Disciplina> atualizarPorId(@PathVariable Long id, @RequestBody Disciplina disciplinaAtualizada) {
        Disciplina disciplina = repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Disciplina com ID " + id + " não existe no sistema."));

        disciplina.setNome(disciplinaAtualizada.getNome());
        repository.save(disciplina);
        return ResponseEntity.ok(disciplina);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Long id) {
        Disciplina disciplina = repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Disciplina com ID " + id + " não existe no sistema."));

        repository.delete(disciplina);
        return ResponseEntity.noContent().build();
    }
}

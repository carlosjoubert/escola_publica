package com.cjrock.geo.controller;

import com.cjrock.geo.model.Professor;
import com.cjrock.geo.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professores")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProfessorController {

    @Autowired
    private ProfessorRepository repository;

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrarProfessor(@RequestBody Professor professor) {
        if (repository.findByEmail(professor.getEmail()).isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("E-mail já em uso!");
        }
        Professor novoProfessor = repository.save(professor);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoProfessor);
    }

    @GetMapping
    public ResponseEntity<List<Professor>> listarTodos() {
        List<Professor> professores = repository.findAll();
        return ResponseEntity.ok(professores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Professor> buscarPorId(@PathVariable Long id) {
        Professor professor = repository.findById(id).orElse(null);
        if (professor != null) {
            return ResponseEntity.ok(professor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Professor> atualizarPorId(@PathVariable Long id, @RequestBody Professor professorAtualizado) {
        Professor professor = repository.findById(id).orElse(null);
        if (professor != null) {
            professor.setNome(professorAtualizado.getNome());
            professor.setEmail(professorAtualizado.getEmail());
            professor.setSenha(professorAtualizado.getSenha());
            repository.save(professor);
            return ResponseEntity.ok(professor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Long id) {
        Professor professor = repository.findById(id).orElse(null);
        if (professor != null) {
            repository.delete(professor);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}


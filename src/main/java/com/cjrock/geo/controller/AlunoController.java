package com.cjrock.geo.controller;

import com.cjrock.geo.model.Aluno;
import com.cjrock.geo.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/alunos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AlunoController {

    @Autowired
    private AlunoRepository repository;

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrarAluno(@RequestBody Aluno aluno){
        Aluno novoAluno = repository.save(aluno);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoAluno);
    }

    @GetMapping
    public ResponseEntity<List<Aluno>> listarTodos() {
        List<Aluno> alunos = repository.findAll();
        return ResponseEntity.ok(alunos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> buscarPorId(@PathVariable Long id) {
        Aluno aluno = repository.findById(id).orElse(null);
        if (aluno != null) {
            return ResponseEntity.ok(aluno);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aluno> atualizarPorId(@PathVariable Long id, @RequestBody Aluno alunoAtualizado) {
        Aluno aluno = repository.findById(id).orElse(null);
        if (aluno != null) {
            aluno.setNome(alunoAtualizado.getNome());
            repository.save(aluno);
            return ResponseEntity.ok(aluno);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Long id) {
        Aluno aluno = repository.findById(id).orElse(null);
        if (aluno != null) {
            repository.delete(aluno);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

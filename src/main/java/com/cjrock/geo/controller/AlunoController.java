package com.cjrock.geo.controller;

import com.cjrock.geo.exception.RecursoNaoEncontradoException;
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
        Aluno aluno = repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Aluno com ID " + id + " não existe no sistema."));
        return ResponseEntity.ok(aluno);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aluno> atualizarPorId(@PathVariable Long id, @RequestBody Aluno alunoAtualizado) {
        Aluno aluno = repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Aluno com ID " + id + " não existe no sistema."));

        aluno.setNome(alunoAtualizado.getNome());
        // Adicione outros campos aqui se o modelo Aluno possuir email/senha/etc como o Professor
        
        repository.save(aluno);
        return ResponseEntity.ok(aluno);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Long id) {
        Aluno aluno = repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Aluno com ID " + id + " não existe no sistema."));

        repository.delete(aluno);
        return ResponseEntity.noContent().build();
    }
}

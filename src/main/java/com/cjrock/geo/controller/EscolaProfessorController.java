package com.cjrock.geo.controller;

import com.cjrock.geo.model.EscolaProfessor;
import com.cjrock.geo.repository.EscolaProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/escola-professor")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EscolaProfessorController {

    @Autowired
    private EscolaProfessorRepository repository;

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrarEscolaProfessor(@RequestBody EscolaProfessor escolaProfessor) {
        EscolaProfessor novoEscolaProfessor = repository.save(escolaProfessor);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoEscolaProfessor);
    }

    @GetMapping
    public ResponseEntity<List<EscolaProfessor>> listarTodos() {
        List<EscolaProfessor> lista = repository.findAll();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EscolaProfessor> buscarPorId(@PathVariable Integer id) {
        EscolaProfessor escolaProfessor = repository.findById(id).orElse(null);
        if (escolaProfessor != null) {
            return ResponseEntity.ok(escolaProfessor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<EscolaProfessor> atualizarPorId(@PathVariable Integer id, @RequestBody EscolaProfessor escolaProfessorAtualizado) {
        EscolaProfessor escolaProfessor = repository.findById(id).orElse(null);
        if (escolaProfessor != null) {
            escolaProfessor.setEscola(escolaProfessorAtualizado.getEscola());
            escolaProfessor.setProfessor(escolaProfessorAtualizado.getProfessor());
            repository.save(escolaProfessor);
            return ResponseEntity.ok(escolaProfessor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Integer id) {
        EscolaProfessor escolaProfessor = repository.findById(id).orElse(null);
        if (escolaProfessor != null) {
            repository.delete(escolaProfessor);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

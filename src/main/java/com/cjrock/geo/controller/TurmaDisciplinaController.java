package com.cjrock.geo.controller;

import com.cjrock.geo.model.TurmaDisciplina;
import com.cjrock.geo.repository.TurmaDisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turma-disciplina")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TurmaDisciplinaController {

    @Autowired
    private TurmaDisciplinaRepository repository;

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrarTurmaDisciplina(@RequestBody TurmaDisciplina turmaDisciplina) {
        TurmaDisciplina novaTurmaDisciplina = repository.save(turmaDisciplina);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaTurmaDisciplina);
    }

    @GetMapping
    public ResponseEntity<List<TurmaDisciplina>> listarTodos() {
        List<TurmaDisciplina> lista = repository.findAll();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TurmaDisciplina> buscarPorId(@PathVariable Integer id) {
        TurmaDisciplina turmaDisciplina = repository.findById(id).orElse(null);
        if (turmaDisciplina != null) {
            return ResponseEntity.ok(turmaDisciplina);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<TurmaDisciplina> atualizarPorId(@PathVariable Integer id, @RequestBody TurmaDisciplina turmaDisciplinaAtualizada) {
        TurmaDisciplina turmaDisciplina = repository.findById(id).orElse(null);
        if (turmaDisciplina != null) {
            turmaDisciplina.setTurma(turmaDisciplinaAtualizada.getTurma());
            turmaDisciplina.setDisciplina(turmaDisciplinaAtualizada.getDisciplina());
            repository.save(turmaDisciplina);
            return ResponseEntity.ok(turmaDisciplina);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Integer id) {
        TurmaDisciplina turmaDisciplina = repository.findById(id).orElse(null);
        if (turmaDisciplina != null) {
            repository.delete(turmaDisciplina);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

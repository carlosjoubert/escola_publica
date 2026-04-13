package com.cjrock.geo.controller;

import com.cjrock.geo.model.Horario;
import com.cjrock.geo.repository.HorarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/horarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class HorarioController {

    @Autowired
    private HorarioRepository repository;

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrarHorario (@RequestBody Horario horario){
        Horario novoHorario = repository.save(horario);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoHorario);
    }

    @GetMapping
    public ResponseEntity<List<Horario>> listarTodos() {
        List<Horario> horarios = repository.findAll();
        return ResponseEntity.ok(horarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Horario> buscarPorId(@PathVariable Long id) {
        Horario horario = repository.findById(id).orElse(null);
        if (horario != null) {
            return ResponseEntity.ok(horario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Horario> atualizarPorId(@PathVariable Long id, @RequestBody Horario horarioAtualizado) {
        Horario horario = repository.findById(id).orElse(null);
        if (horario != null) {
            horario.setDiaSemana(horarioAtualizado.getDiaSemana());
            repository.save(horario);
            return ResponseEntity.ok(horario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Long id) {
        Horario horario = repository.findById(id).orElse(null);
        if (horario != null) {
            repository.delete(horario);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

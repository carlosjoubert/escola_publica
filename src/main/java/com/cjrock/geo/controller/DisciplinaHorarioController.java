package com.cjrock.geo.controller;

import com.cjrock.geo.model.DisciplinaHorario;
import com.cjrock.geo.repository.DisciplinaHorarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disciplina-horario")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DisciplinaHorarioController {
    
    @Autowired
    private DisciplinaHorarioRepository repository;

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrarDisciplinaHorario(@RequestBody DisciplinaHorario disciplinaHorario) {
        DisciplinaHorario novaDisciplinaHorario = repository.save(disciplinaHorario);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaDisciplinaHorario);
    }

    @GetMapping
    public ResponseEntity<List<DisciplinaHorario>> listarTodos() {
        List<DisciplinaHorario> horarios = repository.findAll();
        return ResponseEntity.ok(horarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisciplinaHorario> buscarPorId(@PathVariable Integer id) {
        DisciplinaHorario horario = repository.findById(id).orElse(null);
        if (horario != null) {
            return ResponseEntity.ok(horario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<DisciplinaHorario> atualizarPorId(@PathVariable Integer id, @RequestBody DisciplinaHorario horarioAtualizado) {
        DisciplinaHorario horario = repository.findById(id).orElse(null);
        if (horario != null) {
            horario.setHorario(horarioAtualizado.getHorario());
            horario.setTurmaDisciplina(horarioAtualizado.getTurmaDisciplina());
            repository.save(horario);
            return ResponseEntity.ok(horario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Integer id) {
        DisciplinaHorario horario = repository.findById(id).orElse(null);
        if (horario != null) {
            repository.delete(horario);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}

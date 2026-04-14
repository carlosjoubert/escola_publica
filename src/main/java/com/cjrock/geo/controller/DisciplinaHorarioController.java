package com.cjrock.geo.controller;

import com.cjrock.geo.exception.RecursoNaoEncontradoException;
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
        DisciplinaHorario horario = repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Horário com ID " + id + " não existe no sistema."));
        return ResponseEntity.ok(horario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DisciplinaHorario> atualizarPorId(@PathVariable Integer id, @RequestBody DisciplinaHorario horarioAtualizado) {
        DisciplinaHorario horario = repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Horário com ID " + id + " não existe no sistema."));

        horario.setHorario(horarioAtualizado.getHorario());
        horario.setTurmaDisciplina(horarioAtualizado.getTurmaDisciplina());
        repository.save(horario);
        return ResponseEntity.ok(horario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Integer id) {
        DisciplinaHorario horario = repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Horário com ID " + id + " não existe no sistema."));

        repository.delete(horario);
        return ResponseEntity.noContent().build();
    }

}

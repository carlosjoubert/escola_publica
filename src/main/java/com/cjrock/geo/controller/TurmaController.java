package com.cjrock.geo.controller;

import com.cjrock.geo.model.Turma;
import com.cjrock.geo.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/turmas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TurmaController {
    @Autowired
    private TurmaRepository repository;

    public ResponseEntity<?> cadastrarTurma (@RequestBody Turma turma){
        Turma novaTurma = repository.save(turma);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaTurma);
    }
}

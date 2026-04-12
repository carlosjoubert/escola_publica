package com.cjrock.geo.controller;

import com.cjrock.geo.model.Professor;
import com.cjrock.geo.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/professores")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProfessorController {

    @Autowired
    private ProfessorRepository repository;

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrarProfessor (@RequestBody Professor professor){
        if(repository.findByEmail(professor.getEmail()).isPresent()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("E-mail já em uso!");
        }
        Professor novoProfessor = repository.save(professor);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoProfessor);
    }

}

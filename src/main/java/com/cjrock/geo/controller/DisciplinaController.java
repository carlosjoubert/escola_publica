package com.cjrock.geo.controller;
import com.cjrock.geo.model.Disciplina;
import com.cjrock.geo.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/disciplinas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DisciplinaController {
    @Autowired
    private DisciplinaRepository repository;

    @RequestMapping("/cadastrar")
    public ResponseEntity<?> cadastrarDisciplina (@RequestBody Disciplina disciplina){
        Disciplina novaDisciplina = repository.save(disciplina);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaDisciplina);
    }
}

package com.cjrock.geo.controller;

import com.cjrock.geo.model.Escola;
import com.cjrock.geo.repository.EscolaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/escolas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EscolaController {

    private EscolaRepository repository;

    public ResponseEntity<?> cadastrarEscola (@RequestBody Escola escola){
        Escola novaEscola = repository.save(escola);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaEscola);
    }
}

package com.cjrock.geo.controller;

import com.cjrock.geo.model.Horario;
import com.cjrock.geo.repository.HorarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/horarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class HorarioController {
    private HorarioRepository repository;

    public ResponseEntity<?> cadastrarHorario (@RequestBody Horario horario){
        Horario novoHorario = repository.save(horario);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoHorario);
    }
}

package com.cjrock.geo.controller;

import com.cjrock.geo.model.AlunoEscola;
import com.cjrock.geo.repository.AlunoEscolaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matriculas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AlunoEscolaController {
    
    @Autowired
    private AlunoEscolaRepository repository;
    
    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrarAlunoEscola(@RequestBody AlunoEscola alunoEscola){
        AlunoEscola novoAlunoEscola = repository.save(alunoEscola);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoAlunoEscola);
    }
    @GetMapping
    public ResponseEntity<List<AlunoEscola>> listarTodos() {
        List<AlunoEscola> alunoEscolas = repository.findAll();
        return ResponseEntity.ok(alunoEscolas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoEscola> buscarPorId(@PathVariable Integer id) {
        AlunoEscola alunoEscola = repository.findByMatricula(id).orElse(null);
        if (alunoEscola != null) {
            return ResponseEntity.ok(alunoEscola);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlunoEscola> atualizarPorId(@PathVariable Integer id, @RequestBody AlunoEscola alunoEscolaAtualizado) {
        AlunoEscola alunoEscola = repository.findByMatricula(id).orElse(null);
        if (alunoEscola != null) {
            alunoEscola.setAluno(alunoEscolaAtualizado.getAluno());
            alunoEscola.setEscola(alunoEscolaAtualizado.getEscola());
            alunoEscola.setTurno(alunoEscolaAtualizado.getTurno());
            alunoEscola.setAnoLetivo(alunoEscolaAtualizado.getAnoLetivo());
            repository.save(alunoEscola);
            return ResponseEntity.ok(alunoEscola);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Integer id) {
        AlunoEscola alunoEscola = repository.findByMatricula(id).orElse(null);
        if (alunoEscola != null) {
            repository.delete(alunoEscola);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

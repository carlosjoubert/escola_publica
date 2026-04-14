package com.cjrock.geo.controller;

import com.cjrock.geo.exception.RecursoNaoEncontradoException;
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
        AlunoEscola alunoEscola = repository.findByMatricula(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Matrícula com ID " + id + " não existe no sistema."));
        return ResponseEntity.ok(alunoEscola);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlunoEscola> atualizarPorId(@PathVariable Integer id, @RequestBody AlunoEscola alunoEscolaAtualizado) {
        AlunoEscola alunoEscola = repository.findByMatricula(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Matrícula com ID " + id + " não existe no sistema."));

        alunoEscola.setAluno(alunoEscolaAtualizado.getAluno());
        alunoEscola.setEscola(alunoEscolaAtualizado.getEscola());
        alunoEscola.setTurno(alunoEscolaAtualizado.getTurno());
        alunoEscola.setAnoLetivo(alunoEscolaAtualizado.getAnoLetivo());
        
        repository.save(alunoEscola);
        return ResponseEntity.ok(alunoEscola);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Integer id) {
        AlunoEscola alunoEscola = repository.findByMatricula(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Matrícula com ID " + id + " não existe no sistema."));

        repository.delete(alunoEscola);
        return ResponseEntity.noContent().build();
    }
}

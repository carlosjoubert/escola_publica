package com.cjrock.geo.controller;

import com.cjrock.geo.exception.RecursoNaoEncontradoException;
import com.cjrock.geo.model.Escola;
import com.cjrock.geo.repository.EscolaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/escolas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EscolaController {

    @Autowired
    private EscolaRepository repository;

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrarEscola (@RequestBody Escola escola){
        Escola novaEscola = repository.save(escola);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaEscola);
    }

    @GetMapping
    public ResponseEntity<List<Escola>> listarTodas() {
        List<Escola> escolas = repository.findAll();
        return ResponseEntity.ok(escolas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Escola> buscarPorId(@PathVariable Long id) {
        Escola escola = repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Escola com ID " + id + " não existe no sistema."));
        return ResponseEntity.ok(escola);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Escola> atualizarPorId(@PathVariable Long id, @RequestBody Escola escolaAtualizada) {
        Escola escola = repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Escola com ID " + id + " não existe no sistema."));

        escola.setNome(escolaAtualizada.getNome());
        repository.save(escola);
        return ResponseEntity.ok(escola);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Long id) {
        Escola escola = repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Escola com ID " + id + " não existe no sistema."));

        repository.delete(escola);
        return ResponseEntity.noContent().build();
    }
}

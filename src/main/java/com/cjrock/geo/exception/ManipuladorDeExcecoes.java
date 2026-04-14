package com.cjrock.geo.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ManipuladorDeExcecoes {

    // Avisa ao Spring que este método vai tratar a RecursoNaoEncontradoException
    @ExceptionHandler(RecursoNaoEncontradoException.class)
    public ResponseEntity<ErroPadrao> recursoNaoEncontrado(RecursoNaoEncontradoException e, HttpServletRequest request) {

        String erro = "Recurso não encontrado";
        HttpStatus status = HttpStatus.NOT_FOUND; // Erro 404

        // Monta o JSON bonitinho
        ErroPadrao erroPadrao = new ErroPadrao(
                Instant.now(),
                status.value(),
                erro,
                e.getMessage(),
                request.getRequestURI()
        );

        return ResponseEntity.status(status).body(erroPadrao);
    }
}
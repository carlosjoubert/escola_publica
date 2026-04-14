package com.cjrock.geo.exception;

// Estende RuntimeException para que não seja obrigatório usar try/catch em todo lugar
public class RecursoNaoEncontradoException extends RuntimeException {

    public RecursoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}
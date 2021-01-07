package br.com.zup.desafio.validation;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PessoaNaoEncontradaException extends RuntimeException {
    public PessoaNaoEncontradaException() {
        super("Já existe uma pessoa cadastrada com esse E-mail ou CPF");
    }
}

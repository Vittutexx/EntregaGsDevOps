package br.com.fiap.inovacao.azul.api.exception;

public class DomainException extends RuntimeException{

    public DomainException(String msg){
        super(msg);
    }
}

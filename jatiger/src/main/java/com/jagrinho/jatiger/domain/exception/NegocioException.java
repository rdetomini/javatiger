package com.jagrinho.jatiger.domain.exception;


public class NegocioException extends RuntimeException{
    public NegocioException(String message){
        super(message);
    }
}

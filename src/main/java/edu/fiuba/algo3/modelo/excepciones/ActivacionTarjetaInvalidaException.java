package edu.fiuba.algo3.modelo.excepciones;

public class ActivacionTarjetaInvalidaException extends RuntimeException {
    public ActivacionTarjetaInvalidaException(String msg) {
        super((msg));
    }
}
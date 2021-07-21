package edu.fiuba.algo3.modelo.excepciones;

public class CanjeInvalidoException extends RuntimeException {
    public CanjeInvalidoException(String msg) {
        super((msg));
    }
}

package edu.fiuba.algo3.modelo.excepciones;

public class CanjeNoPermitidoException extends RuntimeException {
    public CanjeNoPermitidoException(String msg) {
        super((msg));
    }
}

package edu.fiuba.algo3.modelo.excepciones;

public class TurnoInvalidoError extends RuntimeException {
    public TurnoInvalidoError(String msg) {
        super((msg));
    }
}

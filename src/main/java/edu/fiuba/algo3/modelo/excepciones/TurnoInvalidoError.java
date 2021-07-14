package edu.fiuba.algo3.Modelo.excepciones;

public class TurnoInvalidoError extends RuntimeException {
    public TurnoInvalidoError(String msg) {
        super((msg));
    }
}

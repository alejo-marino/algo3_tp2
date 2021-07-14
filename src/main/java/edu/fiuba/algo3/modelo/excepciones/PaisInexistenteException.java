package edu.fiuba.algo3.modelo.excepciones;

public class PaisInexistenteException extends RuntimeException {
    public PaisInexistenteException(String msg) {
        super((msg));
    }
}

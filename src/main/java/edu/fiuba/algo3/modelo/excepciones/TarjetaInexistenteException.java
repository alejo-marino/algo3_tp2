package edu.fiuba.algo3.modelo.excepciones;

public class TarjetaInexistenteException extends RuntimeException {
    public TarjetaInexistenteException(String msg) {
        super((msg));
    }
}
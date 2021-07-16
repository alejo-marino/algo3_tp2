package edu.fiuba.algo3.modelo.excepciones;

public class PaisNoPerteneceAlJugador extends RuntimeException {
    public PaisNoPerteneceAlJugador(String msg) {
        super((msg));
    }
}

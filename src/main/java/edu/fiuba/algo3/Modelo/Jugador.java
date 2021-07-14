package edu.fiuba.algo3.modelo;

public class Jugador {
    private String nombreJugador;

    public Jugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Jugador)) {
            return false;
        }
        Jugador otroJugador = (Jugador) o;
        return this.nombreJugador.equals(otroJugador.getNombre());
    }

    protected String getNombre() {
        return this.nombreJugador;
    }
}


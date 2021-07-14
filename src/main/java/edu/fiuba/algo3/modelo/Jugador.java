package edu.fiuba.algo3.modelo;

public class Jugador {
    private String nombreJugador;
    private Batallon batallon;

    public Jugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
        this.batallon = new Batallon();
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


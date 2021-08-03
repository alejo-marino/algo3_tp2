package edu.fiuba.algo3.modelo;


import java.util.Map;

public class MisionComun implements Mision{

    private final Jugador jugador;
    private final Juego juego;
    private final Integer numeroPaisesAConquistar;

    public MisionComun(Jugador jugador, Juego juego, Integer numeroPaisesAConquistar) {
        this.jugador = jugador;
        this.juego = juego;
        this.numeroPaisesAConquistar = numeroPaisesAConquistar;
    }

    public String verMision() {
        return "Misión Comun: Ocupar " + numeroPaisesAConquistar + " paises";
    }

    public boolean completoMision() {
        return juego.obtenerCantidadPaisesSegunJugador(jugador) >= numeroPaisesAConquistar;
    }

    public boolean sigueSiendoPosible() {
        return true;
    }

}

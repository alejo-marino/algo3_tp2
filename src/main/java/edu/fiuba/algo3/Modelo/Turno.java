package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.*;

import java.util.ArrayList;

public class Turno {
    public ArrayList<String> listaJugadores;
    public String jugadorActual;
    private Juego juegoActual;
    private int indiceJugador;

    public Turno(ArrayList<String> listaJugadores, Juego juego) {
        this.listaJugadores = listaJugadores;
        this.juegoActual = juego;
        this.indiceJugador = 0;
        jugadorActual = listaJugadores.get(indiceJugador);
    }

    public void realizarMovimiento(String jugador) {
        if (jugador != jugadorActual) {
            throw new TurnoInvalidoError("No es su turno.");
        }

    }

    public void agrupar(String jugador, String pais, int cantidadTropas) {
        realizarMovimiento(jugador);
        juegoActual.agruparA(jugador, pais, cantidadTropas);

    }

    public void cambiarTurno() {
        indiceJugador = (indiceJugador + 1) % listaJugadores.size();
    }
}

package edu.fiuba.algo3.Modelo;

import edu.fiuba.algo3.Modelo.excepciones.ReforzarPaisAjenoError;
import edu.fiuba.algo3.Modelo.excepciones.TurnoInvalidoError;

import java.util.ArrayList;

public class Turno {
    public ArrayList<String> listaJugadores;
    public String jugadorActual;
    private Juego juegoActual;

    public Turno(ArrayList<String> listaJugadores, Juego juego) {
        this.listaJugadores = listaJugadores;
        this.juegoActual = juego;
        jugadorActual = listaJugadores.get(0);
    }

    public void realizarMovimiento(String jugador) {
        if (jugador != jugadorActual) {
            throw new TurnoInvalidoError("No es su turno.");
        }

    }
}

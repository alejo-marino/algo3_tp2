package edu.fiuba.algo3.Modelo;

import edu.fiuba.algo3.Modelo.excepciones.CantidadErroneaDeJugadoresError;

import java.util.Dictionary;
import java.util.Hashtable;

public class Juego {
    private Dictionary<String, Jugador> listaJugadores;
    private int cantidadJugadores;

    public Juego() {
        cantidadJugadores = 0;
        listaJugadores = new Hashtable<String, Jugador>();
    }

    public void agregarJugadores(int i) {
        // Se agrega un jugador nuevo al juego.
        if (cantidadJugadores < 2 && cantidadJugadores > 7 ) {
            throw new CantidadErroneaDeJugadoresError("El numero de jugadores debe estar entre 2-6");
        }
        cantidadJugadores += i;
    }

    public int obtenerCantJugadores() {
        return cantidadJugadores;
    }
}

package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.CantidadErroneaDeJugadoresError;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;

public class Juego {

    private Tablero tablero;
    private ArrayList<Jugador> listaJugadores;

    public Juego(int cantidadJugadores) {
        if (cantidadJugadores< 2 | cantidadJugadores > 6) {
            throw new CantidadErroneaDeJugadoresError("Se puede jugar de minimo 2 jugadores y maximo 6");
        }
    }


}

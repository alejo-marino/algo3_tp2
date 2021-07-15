package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.CantidadErroneaDeJugadoresError;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;

public class Juego {

    private Tablero tablero;
    private ArrayList<Jugador> listaJugadores;

    public Juego(ArrayList<String> listaJugadores) {
        if (listaJugadores.size() < 2 | listaJugadores.size() > 6) {
            throw new CantidadErroneaDeJugadoresError("Se puede jugar de minimo 2 jugadores y maximo 6");
        }
        this.listaJugadores = new ArrayList<>();
        for (String jugador: listaJugadores) {
            this.listaJugadores.add(new Jugador(jugador));
        }
    }


}

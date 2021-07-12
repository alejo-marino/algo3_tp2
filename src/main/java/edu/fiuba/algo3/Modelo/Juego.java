package edu.fiuba.algo3.Modelo;

import edu.fiuba.algo3.Modelo.excepciones.CantidadErroneaDeJugadoresError;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;

public class Juego {
    private Dictionary<String, Jugador> listaJugadores;
    private int cantidadJugadores;
    private Tablero tableroActual;

    public Juego() {
        cantidadJugadores = 0;
        listaJugadores = new Hashtable<String, Jugador>();
    }

    public void agregarJugadores(int cantidadJugadores) {
        // Se agrega un jugador nuevo al juego.
        if (cantidadJugadores < 2 | cantidadJugadores > 6 ) {
            throw new CantidadErroneaDeJugadoresError("El numero de jugadores debe estar entre 2-6");
        }
        this.cantidadJugadores += cantidadJugadores;
    }

    public int obtenerCantidadJugadores() {
        return cantidadJugadores;
    }

    public void inicializarJuego(String[] listaPaises) {
        tableroActual = new Tablero();
        tableroActual.iniciarTablero(listaPaises, cantidadJugadores);
    }

    public Tablero obtenerTablero() {
        return tableroActual;
    }

    public Dictionary<Integer, ArrayList<Pais>> obtenerPaises() {return tableroActual.obtenerPaisesOcupados();}
}

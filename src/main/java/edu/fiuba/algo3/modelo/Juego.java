package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.CantidadErroneaDeJugadoresError;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;

public class Juego {
    /*
    public Dictionary<String, Jugador> jugadoresActuales;
    private ArrayList<String> listaJugadores;
    private int cantidadJugadores;
    private Tablero tableroActual;
    private Turno turnoJuego;

    public Juego() {
        cantidadJugadores = 0;
        jugadoresActuales = new Hashtable<String, Jugador>();
    }

    public void agregarJugadores(int cantidadJugadores) {
        // Se agrega un jugador nuevo al juego.
        if (cantidadJugadores < 2 | cantidadJugadores > 6 ) {
            throw new CantidadErroneaDeJugadoresError("El numero de jugadores debe estar entre 2-6");
        }
        this.cantidadJugadores += cantidadJugadores;
    }

    public void asignarJugadores(ArrayList<String> listaJugadores) {
        this.listaJugadores = listaJugadores;
        for (String jugadorNuevo: listaJugadores) {
            this.jugadoresActuales.put(jugadorNuevo, new Jugador(jugadorNuevo));
        }
        turnoJuego = new Turno(listaJugadores, this);
    }

    public int obtenerCantidadJugadores() {
        return cantidadJugadores;
    }

    public void inicializarJuego(Dictionary<String, ArrayList<String>> listaPaises) {
        tableroActual = new Tablero();
        //tableroActual.iniciarTablero(listaPaises, listaJugadores);
    }

    public void agrupar(String jugador, String pais, int cantidadTropas){
        Jugador jugadorActual = jugadoresActuales.get(jugador);
        while (jugadorActual.puedeSeguirAgrupando()) {
            turnoJuego.agrupar(jugador, pais, cantidadTropas);
            jugadorActual.agruparTropas(cantidadTropas);
        }
        turnoJuego.cambiarTurno();
    }

    public void agruparA(String jugador, String pais, int cantidadTropas) {
        //tableroActual.agrupar(pais, jugador, cantidadTropas);
    }
    public Tablero obtenerTablero() {
        return tableroActual;
    }

    //public Dictionary<String, Pais> obtenerPaises() {return tableroActual.obtenerPaisesOcupados();}

*/
}

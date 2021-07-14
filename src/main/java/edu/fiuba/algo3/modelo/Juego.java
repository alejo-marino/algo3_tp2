package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.CantidadErroneaDeJugadoresError;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;

public class Juego {

    /*private ArrayList<Jugador> listaJugadores;
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

    public void asignarJugadores(ArrayList<Jugador> listaJugadores) {
        this.listaJugadores = listaJugadores;
        for (Jugador jugadorNuevo: listaJugadores) {
            this.jugadoresActuales.put(jugadorNuevo, new Jugador());
        }
        turnoJuego = new Turno(listaJugadores, this);
    }

    public int obtenerCantidadJugadores() {
        return cantidadJugadores;
    }

    public void inicializarJuego(Dictionary<Str, ArrayList<Jugador> listaPaises) {
        tableroActual = new Tablero();
        tableroActual.iniciarTablero(listaPaises, listaJugadores);
    }

    public void agrupar(Jugador jugador, Pais pais, int cantidadTropas){
        turnoJuego.agrupar(jugador, pais, cantidadTropas);
    }
    public void agruparA(Jugador jugador, Pais pais, int cantidadTropas) {
        tableroActual.agrupar(pais, jugador, cantidadTropas);
    }
    public Tablero obtenerTablero() {
        return tableroActual;
    }

    public Dictionary<String, Pais> obtenerPaises() {return tableroActual.obtenerPaisesOcupados();}

*/
}

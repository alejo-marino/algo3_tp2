package edu.fiuba.algo3.Modelo;

import edu.fiuba.algo3.Modelo.Estados.Estado;
import edu.fiuba.algo3.Modelo.Estados.EstadoInicial;

import java.util.Dictionary;
import java.util.Hashtable;

public class Juego {

    private Dictionary<String, Jugador> listaJugadores;
    private Tablero tableroActual;
    private Estado estadoJuego;
    private Turno turno;

    public Juego(String[] jugadores,String[] paises) {
        listaJugadores = new Hashtable<String, Jugador>();
        tableroActual = new Tablero(paises);
        turno = new Turno(jugadores);
        estadoJuego = new EstadoInicial(turno, tableroActual);

        for (String jugador: jugadores) {
            listaJugadores.put(jugador, new Jugador(jugador));
        }
    }

    public void comenzarFaseActual() {
        estadoJuego.iniciarFase();
    }
    public void siguienteFase() {
        estadoJuego = estadoJuego.siguienteEstado();
    }
    public void atacar() {
        estadoJuego.atacar();
    }
    public String turnoDe() {
        return turno.turnoDe();
    }

    public int cantidadJugadores() {
        return listaJugadores.size();
    }
}

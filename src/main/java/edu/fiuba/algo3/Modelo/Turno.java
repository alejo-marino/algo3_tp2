package edu.fiuba.algo3.Modelo;
import java.util.Random;

public class Turno {
    private String[] listaJugadores;
    private String jugadorActual;

    public Turno(String[] listaJugadores) {
        this.listaJugadores = listaJugadores;
    }

    public void iniciarTurnos() {
        Random random = new Random();
        jugadorActual = listaJugadores[random.nextInt(listaJugadores.length)];
    }

    public String turnoDe() {
        return jugadorActual;
    }

    public String repartirCartas() {
        return "repartiendo fichas";
    }
}


package edu.fiuba.algo3.Modelo;

import edu.fiuba.algo3.Modelo.excepciones.CantidadDeTropasNoDisponiblesError;

public class Jugador {
    private String nombreJugador;
    private int tropasPrimerRefuerzo;
    private int tropasSegundoRefuerzo;

    public Jugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
        this.tropasPrimerRefuerzo = 5;
        this.tropasSegundoRefuerzo = 3;
    }

    public void agruparTropas(int cantidadTropas) {
        if (cantidadTropas > tropasPrimerRefuerzo) {
            throw new CantidadDeTropasNoDisponiblesError("Usted no posee tantas tropas para colocar.");
        }
        tropasPrimerRefuerzo -= cantidadTropas;
    }

    public boolean puedeSeguirAgrupando() {
        return tropasPrimerRefuerzo != 0;
    }
}

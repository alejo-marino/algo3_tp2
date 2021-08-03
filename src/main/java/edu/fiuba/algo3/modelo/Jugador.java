package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

import static edu.fiuba.algo3.modelo.Constantes.*;

public class Jugador {



    private final String colorJugador;
    private final String nombreJugador;
    private Integer numeroDeCanje;
    private final ArrayList<Mision> misiones;

    public Jugador(String colorJugador, String nombreJugador) {
        this.colorJugador = colorJugador;
        this.nombreJugador = nombreJugador;
        this.misiones = new ArrayList<>();
        this.numeroDeCanje = 0;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Jugador)) {
            return false;
        }
        Jugador otroJugador = (Jugador) o;
        return this.colorJugador.equals(otroJugador.toString());
    }

    @Override
    public String toString() {
        return this.colorJugador;
    }

    public String getNombre() {
        return this.nombreJugador;
    }

    public void agregarMision(Mision mision) {
        misiones.add(mision);
    }

    public void verificarMisiones () {
        for(Mision mision: misiones) {
            if (!mision.sigueSiendoPosible()) {
                misiones.remove(mision);
                break;
            }
        }
    }

    public boolean gano() {
        for (Mision mision: misiones) {
            if (mision.completoMision()) {
                return true;
            }
        }
        return false;
    }

    public Integer canjeValido() {
        numeroDeCanje++;
        return this.calcularEjercitosCanje();
    }

    private Integer calcularEjercitosCanje() {
        switch (numeroDeCanje) {
            case 1:
                return numeroEjercitosPrimerCanje;
            case 2:
                return numeroEjercitosSegundoCanje;
            case 3:
                return numeroEjercitosTercerCanje;
            default:
                return (numeroDeCanje - 1) * 5;
        }
    }

    public String getColor() {
        return colorJugador;
    }

    public String verMisiones() {
        String resultado = "";
        for (Mision mision: misiones) {
            resultado += " - " + mision.verMision() + "\n";
        }
        return resultado;
    }

}


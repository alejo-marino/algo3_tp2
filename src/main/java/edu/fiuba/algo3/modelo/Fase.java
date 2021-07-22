package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public abstract class Fase {

    Ronda ronda;

    public Fase(Ronda ronda) {
        this.ronda = ronda;
    }

    public void empezarTurno(Jugador jugador) {
        ronda.empezarTurno(jugador);
    }

    abstract Fase siguienteRonda();

    abstract String getFaseActual();

    public Pais seleccionarPais(String nombrePais, Jugador jugador) {
        return ronda.seleccionarPais(nombrePais, jugador);
    }
    public void atacar(int cantidadEjercitos) {   // las variables atacante y defensor son innecesarias
        ronda.atacar(cantidadEjercitos);
    }

    public void reagrupar(int cantidadEjercitos) {
        ronda.reagrupar(cantidadEjercitos);
    }

    public void canjearTarjetas(ArrayList<Tarjeta> tarjetasACanjear) {
        ronda.canjearTarjetas(tarjetasACanjear);
    }

    public void reforzar(int cantidadEjercitosAAgregar) {
        ronda.reforzar(cantidadEjercitosAAgregar);
    }

    protected Ronda getRonda() {
        return ronda;
    }

    protected void setRonda(Ronda ronda) {
        this.ronda = ronda;
    }
}

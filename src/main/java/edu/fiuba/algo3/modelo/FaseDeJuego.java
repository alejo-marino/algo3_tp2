package edu.fiuba.algo3.modelo;

public class FaseDeJuego implements Fase {
    @Override
    public void siguienteTurno() {

    }

    @Override
    public void reforzar(Pais argentina, int cantidadEjercitos) {

    }

    @Override
    public Fase siguienteRonda() {
        return this;
    }

    @Override
    public String getFaseActual() {
        return "Fase de juego";
    }

    @Override
    public Pais seleccionarPais(String nombrePais, Jugador jugador) {
        return null;
    }

    public void atacar() {}

    public void reagrupar() {}

    public void reforzar() {}
}

package edu.fiuba.algo3.modelo;

public interface Fase {
    void siguienteTurno();

    void reforzar(Pais argentina, int cantidadEjercitos);

    Fase siguienteRonda();

    String getFaseActual();

    Pais seleccionarPais(String nombrePais, Jugador jugador);
}

package edu.fiuba.algo3.modelo;

public interface Fase {
    void siguienteTurno();

    void reforzar(int cantidadEjercitos);

    Fase siguienteRonda();

    String getFaseActual();

    Pais seleccionarPais(String nombrePais, Jugador jugador);

    void atacar(int cantidadEjercitos);

    void reagrupar(int cantidadEjercitos);

}

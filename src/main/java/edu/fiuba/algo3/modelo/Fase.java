package edu.fiuba.algo3.modelo;

public interface Fase {
    void siguienteTurno();

    void reforzar(Pais argentina, int cantidadEjercitos);

    Fase siguienteRonda();

    String getFaseActual();

    Pais seleccionarPais(String nombrePais, Jugador jugador);

    void atacar(Pais atacante, Pais defensor, int cantidadEjercitos);

    void reagrupar(Pais origen, Pais destino, int cantidadEjercitos);
}

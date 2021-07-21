package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public interface Fase {
    void siguienteTurno();

    void reforzar(int cantidadEjercitos);

    Fase siguienteRonda();

    String getFaseActual();

    Pais seleccionarPais(String nombrePais, Jugador jugador);

    void atacar(int cantidadEjercitos);

    void reagrupar(int cantidadEjercitos);

    void canjearTarjetas(ArrayList<Tarjeta> tarjetasACanjear);

}

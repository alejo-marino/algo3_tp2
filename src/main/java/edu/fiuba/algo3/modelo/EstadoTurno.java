package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public interface EstadoTurno {

    void atacar(int cantidadEjercitosAtacantes);

    Pais seleccionarPais(Pais pais, Jugador jugador);

    void cancelarAccion();

    void reagrupar(int cantidadEjercitos);

    void reforzar(int cantidadEjercitosAReforzar);

    void canjearTarjetas(ArrayList<Tarjeta> tarjetasACanjear);

}

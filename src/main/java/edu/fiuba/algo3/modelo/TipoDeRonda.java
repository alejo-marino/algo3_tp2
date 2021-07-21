package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public interface TipoDeRonda {

    void atacar(int cantidadEjercitos);

    void reagrupar(int cantidadEjercitos);

    void reforzar(Integer ejercitosAReforzar);

    Pais seleccionarPais(String nombrePais, Jugador jugador);

    void cancelarAccion();

    TipoDeRonda siguienteRonda();

    void siguienteTurno();

    void canjearTarjetas(ArrayList<Tarjeta> tarjetasACanjear);
}

package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public interface EstadoTurno {

    void atacar(int cantidadEjercitosAtacantes);

    Pais seleccionarPais(Pais paisSeleccionado);

    void cancelarAccion();

    void reagrupar(int cantidadEjercitos);

    void reforzar(int cantidadEjercitosAReforzar);

    void canjearTarjetas(ArrayList<Tarjeta> tarjetasACanjear);

    void activarTarjeta(Tarjeta tarjetaAActivar);

}

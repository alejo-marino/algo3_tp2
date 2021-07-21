package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public interface Ronda {

    public void atacar(int cantidadEjercitos);

    public void reagrupar(int cantidadEjercitos);

    public void reforzar(Integer ejercitosAReforzar);

    public Pais seleccionarPais(String nombrePais, Jugador jugador);

    public void cancelarAccion();

    public void canjearTarjetas(ArrayList<Tarjeta> tarjetasACanjear);

    abstract Ronda siguienteRonda();

    abstract void empezarTurno(Jugador jugador);


}

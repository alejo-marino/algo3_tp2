package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public abstract class Ronda {

    private Tablero tablero;
    private EstadoTurno estadoTurno;

    public Ronda(Tablero tablero, EstadoTurno estadoTurno) {
        this.tablero = tablero;
        this.estadoTurno = estadoTurno;
    }

    public void atacar(int cantidadEjercitos) {
        this.estadoTurno.atacar(cantidadEjercitos);
    }

    public void reagrupar(int cantidadEjercitos) {
        this.estadoTurno.reagrupar(cantidadEjercitos);
    }

    public void reforzar(Integer ejercitosAReforzar) {
        this.estadoTurno.reforzar(ejercitosAReforzar);
    }

    public Pais seleccionarPais(String nombrePais, Jugador jugador)  {
        Pais pais = this.tablero.seleccionarPais(nombrePais);
        return this.estadoTurno.seleccionarPais(pais, jugador);
    }

    public void cancelarAccion() {
        this.estadoTurno.cancelarAccion();
    }

    public void canjearTarjetas(ArrayList<Tarjeta> tarjetasACanjear) {
        estadoTurno.canjearTarjetas(tarjetasACanjear);
    }

    abstract Ronda siguienteRonda();

    abstract void empezarTurno(Jugador jugador);

    public EstadoTurno getEstadoTurno() {
        return estadoTurno;
    }

    public void setEstadoTurno(EstadoTurno estadoTurno) {
        this.estadoTurno = estadoTurno;
    }
}

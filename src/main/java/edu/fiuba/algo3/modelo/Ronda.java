package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public abstract class Ronda {

    private Juego juego;
    private EstadoTurno estadoTurno;

    public Ronda(Juego juego, EstadoTurno estadoTurno) {
        this.juego = juego;
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

    public Pais seleccionarPais(String nombrePais)  {
        Pais pais = this.juego.seleccionarPais(nombrePais);
        return this.estadoTurno.seleccionarPais(pais);
    }

    public void cancelarAccion() {
        this.estadoTurno.cancelarAccion();
    }

    public void canjearTarjetas(ArrayList<Tarjeta> tarjetasACanjear) {
        estadoTurno.canjearTarjetas(tarjetasACanjear);
    }

    abstract Ronda siguienteRonda();

    abstract void empezarTurno(Jugador jugador);

    protected EstadoTurno getEstadoTurno() {
        return estadoTurno;
    }

    protected void setEstadoTurno(EstadoTurno estadoTurno) {
        this.estadoTurno = estadoTurno;
    }

    abstract void terminarAtaque(Jugador jugador);

    public void activarTarjeta(Tarjeta tarjetaAActivar) {
        this.estadoTurno.activarTarjeta(tarjetaAActivar);
    }
}

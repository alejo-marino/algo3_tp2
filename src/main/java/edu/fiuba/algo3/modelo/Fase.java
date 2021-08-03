package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public abstract class Fase {

    Ronda ronda;

    public Fase(Ronda ronda) {
        this.ronda = ronda;
    }

    public void empezarTurno(Jugador jugador) {
        ronda.empezarTurno(jugador);
    }

    abstract Fase siguienteRonda();

    abstract String getFaseActual();

    public void seleccionarPais(String nombrePais) {
        ronda.seleccionarPais(nombrePais);
    }

    public void atacar(int cantidadEjercitos) {   // las variables atacante y defensor son innecesarias
        ronda.atacar(cantidadEjercitos);
    }

    public void reagrupar(int cantidadEjercitos) {
        ronda.reagrupar(cantidadEjercitos);
    }

    public void canjearTarjetas(ArrayList<String> tarjetasACanjear) {
        ronda.canjearTarjetas(tarjetasACanjear);
    }

    public void reforzar(int cantidadEjercitosAAgregar) {
        ronda.reforzar(cantidadEjercitosAAgregar);
    }

    protected Ronda getRonda() {
        return ronda;
    }

    protected void setRonda(Ronda ronda) {
        this.ronda = ronda;
    }

    public void terminarAtaque(Jugador jugador) {
        this.ronda.terminarAtaque(jugador);
    }

    public void activarTarjeta(String nombreTarjeta) {
        this.ronda.activarTarjeta(nombreTarjeta);
    }

    public boolean puedoAtacar() {
        return this.ronda.puedoAtacar();
    }

    public int getEjercitosParaAtacar() {
        return this.ronda.getEjercitosParaAtacar();
    }

    public boolean puedoReforzar() {
        return this.ronda.puedoReforzar();
    }

    public int getEjercitosParaReforzar() {
        return this.ronda.getEjercitosParaReforzar();
    }

    public void cancelarAccion() {
        this.ronda.cancelarAccion();
    }

    public boolean puedoCancelar() {
        return this.ronda.puedoCancelar();
    }

    public boolean estoyEnTurnoAtaque() {
        return this.ronda.estoyEnTurnoAtaque();
    }

    public boolean puedoPasarDeTurno() {
        return this.ronda.puedoPasarDeTurno();
    }

    public boolean puedoReagrupar() {
        return this.ronda.puedoReagrupar();
    }

    public boolean paisPuedeSeleccionarse(String nombrePais) {
        return this.ronda.paisPuedeSeleccionarse(nombrePais);
    }
}

package edu.fiuba.algo3.modelo.TurnoAtaque;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.excepciones.*;

import java.util.ArrayList;

public class TurnoAtaque implements EstadoTurno {

    private EstadoSeleccionarPaisAtaque estadoSeleccionarPaisAtaque;

    public TurnoAtaque(Jugador jugador) {
        this.estadoSeleccionarPaisAtaque = new NingunPaisSeleccionadoAtaque(this, jugador);
    }

    protected void cambiarEstado(EstadoSeleccionarPaisAtaque estadoSeleccionarPaisAtaque) {
        this.estadoSeleccionarPaisAtaque = estadoSeleccionarPaisAtaque;
    }

    public void atacar(int cantidadEjercitos) {
        estadoSeleccionarPaisAtaque.atacar(cantidadEjercitos);
    }

    @Override
    public void seleccionarPais(Pais paisSeleccionado) {
        estadoSeleccionarPaisAtaque.seleccionarPais(paisSeleccionado);
    }

    public void cancelarAccion() {
        estadoSeleccionarPaisAtaque.cancelarAccion();
    }

    @Override
    public void reagrupar(int cantidadEjercitos) {
        estadoSeleccionarPaisAtaque.reagrupar(cantidadEjercitos);
    }

    @Override
    public void reforzar(int cantidadEjercitosAReforzar) {
        throw new RefuerzoInvalidoException("No es posible reforzar en un turno de ataque");
    }

    @Override
    public void canjearTarjetas(ArrayList<String> tarjetasACanjear, Juego juego) {
        throw new CanjeNoPermitidoException("No se puede canjear en una ronda de ataque y reagrupe");
    }

    @Override
    public void activarTarjeta(String nombreTarjeta, Juego juego) {
        throw new ActivacionTarjetaInvalidaException("No podés activar la tarjeta en un turno de ataque.");
    }

    @Override
    public boolean puedoAtacar() {
        return this.estadoSeleccionarPaisAtaque.puedoAtacar();
    }

    @Override
    public int getEjercitosParaAtacar() {
        return estadoSeleccionarPaisAtaque.getEjercitosParaAtacar();
    }

    @Override
    public boolean puedoReforzar() {
        return false;
    }

    @Override
    public int getEjercitosParaReforzar() {
        return 0;
    }

    @Override
    public boolean puedoCancelar() {
        return estadoSeleccionarPaisAtaque.puedoCancelar();
    }

    @Override
    public boolean estoyEnTurnoAtaque() {
        return true;
    }

    @Override
    public boolean puedoPasarDeTurno() {
        return false;
    }

    @Override
    public boolean puedoReagrupar() {
        return estadoSeleccionarPaisAtaque.puedoReagrupar();
    }

    @Override
    public boolean puedoSeleccionarPais(Pais pais) {
        return estadoSeleccionarPaisAtaque.puedoSeleccionarPais(pais);
    }

    @Override
    public boolean puedoActivarTarjeta(String nombreTarjeta) {
        return false;
    }

    @Override
    public boolean puedoCanjearTarjeta() {
        return false;
    }

    @Override
    public boolean paisSeleccionado(String nombrePais) {
        return estadoSeleccionarPaisAtaque.paisSeleccionado(nombrePais);
    }

}

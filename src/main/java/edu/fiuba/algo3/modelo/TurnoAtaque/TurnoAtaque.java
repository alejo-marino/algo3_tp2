package edu.fiuba.algo3.modelo.TurnoAtaque;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.excepciones.*;

import java.util.ArrayList;

public class TurnoAtaque implements EstadoTurno {

    private EstadoSeleccionarPaisAtaque estadoSeleccionarPaisAtaque;
    private Jugador jugador;

    public TurnoAtaque(Jugador jugador) {
        this.jugador = jugador;
        this.estadoSeleccionarPaisAtaque = new NingunPaisSeleccionadoAtaque(this, jugador);
    }

    public void cambiarEstado(EstadoSeleccionarPaisAtaque estadoSeleccionarPaisAtaque) {
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
        throw new ReagrupeInvalidoException("No es posible reagrupar mientras estas atacando");
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
        return false;
    }

    @Override
    public boolean paisPuedeSeleccionarse(Pais pais) {
        return estadoSeleccionarPaisAtaque.paisPuedeSeleccionarse(pais);
    }
}

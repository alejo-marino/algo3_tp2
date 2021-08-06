package edu.fiuba.algo3.modelo.TurnoRefuerzo;

import edu.fiuba.algo3.modelo.EstadoTurno;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Pais;
import edu.fiuba.algo3.modelo.TurnoAtaque.EstadoSeleccionarPaisAtaque;
import edu.fiuba.algo3.modelo.TurnoAtaque.NingunPaisSeleccionadoAtaque;
import edu.fiuba.algo3.modelo.excepciones.*;

import java.util.ArrayList;

import static edu.fiuba.algo3.modelo.Constantes.numeroTarjetasParaCanje;

public class TurnoRefuerzo implements EstadoTurno {

    private EstadoSeleccionarPaisRefuerzo estadoSeleccionarPaisRefuerzo;
    private final Jugador jugador;

    public TurnoRefuerzo(Jugador jugador, Integer ejercitosAReforzar) {
        this.jugador = jugador;
        this.estadoSeleccionarPaisRefuerzo = new NingunPaisSeleccionadoRefuerzo(this, jugador, ejercitosAReforzar);
    }

    protected void cambiarEstado(EstadoSeleccionarPaisRefuerzo estadoSeleccionarPaisRefuerzo) {
        this.estadoSeleccionarPaisRefuerzo = estadoSeleccionarPaisRefuerzo;
    }

    @Override
    public void atacar(int cantidadEjercitosAtacantes) {
        throw new AtaqueInvalidoException("No es posible atacar en un turno de reagrupe");
    }

    @Override
    public void seleccionarPais(Pais paisSeleccionado) {
        estadoSeleccionarPaisRefuerzo.seleccionarPais(paisSeleccionado);
    }

    @Override
    public void cancelarAccion() {
        estadoSeleccionarPaisRefuerzo.cancelarAccion();
    }

    @Override
    public void reagrupar(int cantidadEjercitos) {
        throw new ReagrupeInvalidoException("No puede reagrupar en turno de refuerzo");
    }

    @Override
    public void reforzar(int cantidadEjercitosAReforzar) {
        estadoSeleccionarPaisRefuerzo.reforzar(cantidadEjercitosAReforzar);
    }

    @Override
    public void canjearTarjetas(ArrayList<String> tarjetasACanjear, Juego juego) {
        if (tarjetasACanjear.size() != numeroTarjetasParaCanje) {
            throw new CanjeInvalidoException("Cantidad erronea de tarjetas para el canje.");
        }
        estadoSeleccionarPaisRefuerzo.agregarEjercitos(juego.canjearTarjetas(tarjetasACanjear, jugador));
        estadoSeleccionarPaisRefuerzo.cancelarAccion();
    }

    public boolean tieneEjercitosParaReforzar() {
        return estadoSeleccionarPaisRefuerzo.tieneEjercitosParaReforzar();
    }

    public void activarTarjeta(String tarjetaAActivar, Juego juego) {
        juego.activarTarjeta(tarjetaAActivar);
    }

    @Override
    public boolean puedoAtacar() {
        return false;
    }

    @Override
    public int getEjercitosParaAtacar() {
        return 0;
    }

    @Override
    public boolean puedoReforzar() {
        return estadoSeleccionarPaisRefuerzo.puedoReforzar();
    }

    @Override
    public int getEjercitosParaReforzar() {
        return estadoSeleccionarPaisRefuerzo.getEjercitosParaReforzar();
    }

    @Override
    public boolean puedoCancelar() {
        return estadoSeleccionarPaisRefuerzo.puedoCancelar();
    }

    @Override
    public boolean estoyEnTurnoAtaque() {
        return false;
    }

    @Override
    public boolean puedoPasarDeTurno() {
        return estadoSeleccionarPaisRefuerzo.puedoPasarDeTurno();
    }

    @Override
    public boolean puedoReagrupar() {
        return false;
    }

    @Override
    public boolean puedoSeleccionarPais(Pais pais) {
        return estadoSeleccionarPaisRefuerzo. paisPuedeSeleccionarse(pais);
    }

    @Override
    public boolean puedoActivarTarjeta(String nombreTarjeta) {
        return true;
    }

    @Override
    public boolean puedoCanjearTarjeta(){
        return true;
    }

    @Override
    public boolean paisSeleccionado(String nombrePais) {
        return estadoSeleccionarPaisRefuerzo.paisSeleccionado(nombrePais);
    }

}

package edu.fiuba.algo3.modelo.TurnoReagrupe;

import edu.fiuba.algo3.modelo.EstadoTurno;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Pais;
import edu.fiuba.algo3.modelo.excepciones.*;

import java.util.ArrayList;
import java.util.Hashtable;

public class TurnoReagrupe implements EstadoTurno {

    private EstadoSeleccionarPaisReagrupe estadoSeleccionarPaisReagrupe;
    private final Jugador jugador;
    private Pais paisOrigen;
    private Pais paisDestino;
    private Hashtable<Pais, Integer> datosRefuerzo;

    public TurnoReagrupe(Jugador jugador) {
        this.jugador = jugador;
        this.datosRefuerzo = new Hashtable<>();
        this.estadoSeleccionarPaisReagrupe = new NingunPaisSeleccionadoReagrupe(this, jugador, datosRefuerzo);
    }

    public void cambiarEstado(EstadoSeleccionarPaisReagrupe estadoSeleccionarPaisReagrupe) {
        this.estadoSeleccionarPaisReagrupe = estadoSeleccionarPaisReagrupe;
    }

    @Override
    public void atacar(int cantidadEjercitosAtacantes) {
        throw new AtaqueInvalidoException("No es posible atacar en un turno de reagrupe");
    }

    @Override
    public void seleccionarPais(Pais paisSeleccionado) {
        estadoSeleccionarPaisReagrupe.seleccionarPais(paisSeleccionado);
    }

    @Override
    public void cancelarAccion() {
        estadoSeleccionarPaisReagrupe.cancelarAccion();
    }

    @Override
    public void reagrupar(int cantidadEjercitos) {
        estadoSeleccionarPaisReagrupe.reagrupar(cantidadEjercitos);
    }

    @Override
    public void reforzar(int cantidadEjercitosAReforzar) {
        throw new RefuerzoInvalidoException("No es posible reforzar en un turno de ataque");
    }

    @Override
    public void canjearTarjetas(ArrayList<String> tarjetasACanjear, Juego juego) {
        throw new CanjeNoPermitidoException("No se puede canjear en una ronda de ataque y reagrupe");
    }

    public void efectivizarReagrupe() {
        datosRefuerzo.forEach((pais, ejercitosAEfectivizar) -> {
            pais.reforzar(ejercitosAEfectivizar);
        });
    }

    @Override
    public void activarTarjeta(String nombreTarjeta, Juego juego) {
        throw new ActivacionTarjetaInvalidaException("No podés activar la tarjeta en un turno de reagrupe.");
    }
}

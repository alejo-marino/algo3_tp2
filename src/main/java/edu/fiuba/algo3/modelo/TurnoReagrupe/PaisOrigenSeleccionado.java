package edu.fiuba.algo3.modelo.TurnoReagrupe;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Pais;
import edu.fiuba.algo3.modelo.TurnoAtaque.PaisAtacanteSeleccionado;
import edu.fiuba.algo3.modelo.excepciones.*;

import java.util.Hashtable;

public class PaisOrigenSeleccionado implements EstadoSeleccionarPaisReagrupe {

    private final TurnoReagrupe turnoReagrupe;
    private final Jugador jugador;
    private final Hashtable<Pais, Integer> datosRefuerzo;
    private final Pais paisOrigen;

    public PaisOrigenSeleccionado(TurnoReagrupe turnoReagrupe, Jugador jugador, Hashtable<Pais, Integer> datosRefuerzo, Pais paisOrigen) {
        this.turnoReagrupe = turnoReagrupe;
        this.jugador = jugador;
        this.datosRefuerzo = datosRefuerzo;
        this.paisOrigen = paisOrigen;
    }

    @Override
    public void seleccionarPais(Pais pais) {
        if (!pais.esLimitrofe(paisOrigen)) {
            throw new ReagrupeAPaisNoLimitrofeException(pais.toString() + " no limita con " + paisOrigen.toString());
        }
        if (!pais.esAliado(paisOrigen)) {
            throw new ReagrupeAPaisAjenoException("No podes reagrupar con un pais ajeno como destino");
        }
        turnoReagrupe.cambiarEstado(new PaisDestinoSeleccionado(turnoReagrupe, jugador, datosRefuerzo, paisOrigen, pais));
    }

    @Override
    public void cancelarAccion() {
        turnoReagrupe.cambiarEstado(new NingunPaisSeleccionadoReagrupe(turnoReagrupe, jugador, datosRefuerzo));
    }

    @Override
    public void reagrupar(int cantidadEjercitos) {
        throw new PaisNoSeleccionadoException("No selecciono un país destino.");
    }

    @Override
    public boolean puedoCancelar() {
        return true;
    }

    @Override
    public boolean puedoReagrupar() {
        return false;
    }

    @Override
    public int getEjercitosParaReagrupar() {
        return 0;
    }

    @Override
    public boolean paisPuedeSeleccionarse(Pais pais) {
        return pais.esDuenio(jugador) && pais.esLimitrofe(paisOrigen);
    }
}

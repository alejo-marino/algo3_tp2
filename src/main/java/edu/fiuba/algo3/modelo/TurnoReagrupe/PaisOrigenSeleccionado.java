package edu.fiuba.algo3.modelo.TurnoReagrupe;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Pais;
import edu.fiuba.algo3.modelo.excepciones.PaisNoSeleccionadoException;
import edu.fiuba.algo3.modelo.excepciones.PaisesYaSeleccionadosException;
import edu.fiuba.algo3.modelo.excepciones.ReagrupeAPaisAjenoException;
import edu.fiuba.algo3.modelo.excepciones.ReagrupeAPaisNoLimitrofeException;

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
    public void seleccionarPais(Pais paisDestino) {
        if (!paisDestino.esLimitrofe(paisOrigen)) {
            throw new ReagrupeAPaisNoLimitrofeException(paisDestino.toString() + " no limita con " + paisOrigen.toString());
        }
        if (!paisDestino.esAliado(paisOrigen)) {
            throw new ReagrupeAPaisAjenoException("No podes reagrupar con un pais ajeno como destino");
        }
        turnoReagrupe.cambiarEstado(new PaisDestinoSeleccionado(turnoReagrupe, jugador, datosRefuerzo, paisOrigen, paisDestino));
    }

    @Override
    public void cancelarAccion() {
        turnoReagrupe.cambiarEstado(new NingunPaisSeleccionadoReagrupe(turnoReagrupe, jugador, datosRefuerzo));
    }

    @Override
    public void reagrupar(int cantidadEjercitos) {
        throw new PaisNoSeleccionadoException("No selecciono un país destino.");
    }
}

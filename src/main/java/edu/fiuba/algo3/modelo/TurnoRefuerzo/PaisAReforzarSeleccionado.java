package edu.fiuba.algo3.modelo.TurnoRefuerzo;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Pais;
import edu.fiuba.algo3.modelo.excepciones.NoPuedeColocarTantosEjercitosException;
import edu.fiuba.algo3.modelo.excepciones.PaisesYaSeleccionadosException;

public class PaisAReforzarSeleccionado implements EstadoSeleccionarPaisRefuerzo {

    private final TurnoRefuerzo turnoRefuerzo;
    private final Jugador jugador;
    private final Pais paisAReforzar;
    private Integer ejercitosDisponibles;

    public PaisAReforzarSeleccionado(TurnoRefuerzo turnoRefuerzo, Jugador jugador, Integer ejercitosAReforzar, Pais paisAReforzar) {
        this.turnoRefuerzo = turnoRefuerzo;
        this.jugador = jugador;
        this.paisAReforzar = paisAReforzar;
        this.ejercitosDisponibles = ejercitosAReforzar;
    }

    @Override
    public void seleccionarPais(Pais pais) {
        throw new PaisesYaSeleccionadosException(paisAReforzar + " ya esta seleccionado, apreta 'Reforzar' o 'Cancelar accion'.");
    }

    @Override
    public void cancelarAccion() {
        turnoRefuerzo.cambiarEstado(new NingunPaisSeleccionadoRefuerzo(turnoRefuerzo, jugador, ejercitosDisponibles));
    }

    @Override
    public void reforzar(int cantidadEjercitosAReforzar) {
        if (ejercitosDisponibles < cantidadEjercitosAReforzar) {
            throw new NoPuedeColocarTantosEjercitosException("Solo disponde de " + ejercitosDisponibles + " ejercitos.");
        }
        this.ejercitosDisponibles -= cantidadEjercitosAReforzar;
        this.paisAReforzar.reforzar(cantidadEjercitosAReforzar);
        cancelarAccion();
    }

    @Override
    public void agregarEjercitos(int ejercitos) {
        ejercitosDisponibles += ejercitos;
    }

    @Override
    public boolean tieneEjercitosParaReforzar() {
        return ejercitosDisponibles > 0;
    }

}

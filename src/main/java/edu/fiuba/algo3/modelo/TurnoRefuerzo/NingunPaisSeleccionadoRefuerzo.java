package edu.fiuba.algo3.modelo.TurnoRefuerzo;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Pais;
import edu.fiuba.algo3.modelo.excepciones.PaisNoSeleccionadoException;
import edu.fiuba.algo3.modelo.excepciones.SeleccionaPaisAjenoException;

public class NingunPaisSeleccionadoRefuerzo implements EstadoSeleccionarPaisRefuerzo {

    private final TurnoRefuerzo turnoRefuerzo;
    private final Jugador jugador;
    private Integer ejercitosDisponibles;

    public NingunPaisSeleccionadoRefuerzo(TurnoRefuerzo turnoRefuerzo, Jugador jugador, Integer ejercitosAReforzar) {
        this.turnoRefuerzo = turnoRefuerzo;
        this.jugador = jugador;
        this.ejercitosDisponibles = ejercitosAReforzar;
    }

    @Override
    public void seleccionarPais(Pais paisAReforzar) {
        if (!paisAReforzar.esDuenio(jugador)) {
            throw new SeleccionaPaisAjenoException("El pais " + paisAReforzar + " no te pertenece");
        }
        turnoRefuerzo.cambiarEstado(new PaisAReforzarSeleccionado(turnoRefuerzo, jugador, ejercitosDisponibles, paisAReforzar));
    }

    @Override
    public void cancelarAccion() {}

    @Override
    public void reforzar(int cantidadEjercitosAReforzar) {
        throw new PaisNoSeleccionadoException("No seleccionó ningún país.");
    }

    @Override
    public void agregarEjercitos(int ejercitos) {
        ejercitosDisponibles += ejercitos;
    }

    @Override
    public boolean tieneEjercitosParaReforzar() {
        return ejercitosDisponibles > 0;
    }

    @Override
    public boolean puedoReforzar() {
        return false;
    }

    @Override
    public int getEjercitosParaReforzar() {
        return ejercitosDisponibles;
    }

    @Override
    public boolean puedoCancelar() {
        return false;
    }

    @Override
    public boolean puedoPasarDeTurno() {
        return ejercitosDisponibles == 0;
    }

    @Override
    public boolean paisPuedeSeleccionarse(Pais pais) {
        return pais.esDuenio(jugador);
    }
}

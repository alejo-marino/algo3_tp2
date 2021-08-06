package edu.fiuba.algo3.modelo.TurnoRefuerzo;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Pais;
import edu.fiuba.algo3.modelo.excepciones.NoPuedeColocarTantosEjercitosException;
import edu.fiuba.algo3.modelo.excepciones.PaisesYaSeleccionadosException;
import edu.fiuba.algo3.modelo.excepciones.SeleccionaPaisAjenoException;

public class PaisAReforzarSeleccionado implements EstadoSeleccionarPaisRefuerzo {

    private final TurnoRefuerzo turnoRefuerzo;
    private final Jugador jugador;
    private final Pais paisAReforzar;
    private Integer ejercitosDisponibles;

    public PaisAReforzarSeleccionado(TurnoRefuerzo turnoRefuerzo, Jugador jugador, Integer ejercitosDisponibles, Pais paisAReforzar) {
        this.turnoRefuerzo = turnoRefuerzo;
        this.jugador = jugador;
        this.paisAReforzar = paisAReforzar;
        this.ejercitosDisponibles = ejercitosDisponibles;
    }

    @Override
    public void seleccionarPais(Pais pais) {
        if (pais.esAliado(paisAReforzar)) {
            turnoRefuerzo.cambiarEstado(new PaisAReforzarSeleccionado(turnoRefuerzo, jugador, ejercitosDisponibles, pais));
        } else {
            throw new SeleccionaPaisAjenoException("El pais " + paisAReforzar + " no te pertenece");
        }
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

    @Override
    public boolean puedoReforzar() {
        return ejercitosDisponibles > 0;
    }

    @Override
    public int getEjercitosParaReforzar() {
        return ejercitosDisponibles;
    }

    @Override
    public boolean puedoCancelar() {
        return true;
    }

    @Override
    public boolean puedoPasarDeTurno() {
        return ejercitosDisponibles == 0;
    }

    @Override
    public boolean paisPuedeSeleccionarse(Pais pais) {
        return pais.esDuenio(jugador);
    }

    @Override
    public boolean paisSeleccionado(String nombrePais) {
        return paisAReforzar.toString().equals(nombrePais);
    }

}

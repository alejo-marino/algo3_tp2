package edu.fiuba.algo3.modelo.TurnoReagrupe;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Pais;
import edu.fiuba.algo3.modelo.excepciones.EjercitosInvalidosException;
import edu.fiuba.algo3.modelo.excepciones.PaisNoSeleccionadoException;
import edu.fiuba.algo3.modelo.excepciones.SeleccionaPaisAjenoException;

import java.util.Hashtable;

public class NingunPaisSeleccionadoReagrupe implements EstadoSeleccionarPaisReagrupe {

    private final TurnoReagrupe turnoReagrupe;
    private final Jugador jugador;
    private final Hashtable<Pais, Integer> datosRefuerzo;

    public NingunPaisSeleccionadoReagrupe(TurnoReagrupe turnoReagrupe, Jugador jugador, Hashtable<Pais, Integer> datosRefuerzo) {
        this.turnoReagrupe = turnoReagrupe;
        this.jugador = jugador;
        this.datosRefuerzo = datosRefuerzo;
    }

    @Override
    public void seleccionarPais(Pais paisOrigen) {
        if (!paisOrigen.esDuenio(jugador)) {
            throw new SeleccionaPaisAjenoException("El pais: " + paisOrigen + " no te pertenece");
        }
        if (!paisOrigen.puedeAtacar()) {    // simplemente checkea que la cantEjercitos del pais sea > 1
            throw new EjercitosInvalidosException("El pais: " + paisOrigen + " no tiene ejercitos suficientes para atacar");
        }
        turnoReagrupe.cambiarEstado(new PaisOrigenSeleccionado(turnoReagrupe, jugador, datosRefuerzo, paisOrigen));
    }

    @Override
    public void cancelarAccion() {

    }

    @Override
    public void reagrupar(int cantidadEjercitos) {
        throw new PaisNoSeleccionadoException("No selecciono ningún país.");
    }

    @Override
    public boolean puedoCancelar() {
        return false;
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
        return pais.esDuenio(jugador) && pais.puedeAtacar();
    }
}

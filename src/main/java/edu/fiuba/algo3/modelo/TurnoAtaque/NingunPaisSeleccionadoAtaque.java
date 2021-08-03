package edu.fiuba.algo3.modelo.TurnoAtaque;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Pais;
import edu.fiuba.algo3.modelo.excepciones.AtaqueInvalidoException;
import edu.fiuba.algo3.modelo.excepciones.EjercitosInvalidosException;
import edu.fiuba.algo3.modelo.excepciones.SeleccionaPaisAjenoException;

public class NingunPaisSeleccionadoAtaque implements EstadoSeleccionarPaisAtaque {

    private final TurnoAtaque turnoAtaque;
    private final Jugador jugador;

    public NingunPaisSeleccionadoAtaque(TurnoAtaque turnoAtaque, Jugador jugador) {
        this.turnoAtaque = turnoAtaque;
        this.jugador = jugador;
    }

    @Override
    public void seleccionarPais(Pais paisAtacante) {
        if (!paisAtacante.esDuenio(jugador)) {
            throw new SeleccionaPaisAjenoException("El pais: " + paisAtacante + " no te pertenece");
        }
        if (!paisAtacante.puedeAtacar()) {
            throw new EjercitosInvalidosException("El pais: " + paisAtacante + " no tiene ejercitos suficientes para atacar");
        }
        turnoAtaque.cambiarEstado(new PaisAtacanteSeleccionado(turnoAtaque, jugador, paisAtacante));
    }

    @Override
    public void atacar(int cantidadEjercitos) {
        throw new AtaqueInvalidoException("Pais atacante no seleccionado.");
    }

    @Override
    public void cancelarAccion() {}

    @Override
    public int getEjercitosParaAtacar() {
        return 0;
    }

    @Override
    public boolean puedoAtacar() {
        return false;
    }

    @Override
    public boolean puedoCancelar() {
        return false;
    }
}

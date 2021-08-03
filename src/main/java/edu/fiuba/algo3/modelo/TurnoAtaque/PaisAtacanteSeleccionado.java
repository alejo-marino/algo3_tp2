package edu.fiuba.algo3.modelo.TurnoAtaque;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Pais;
import edu.fiuba.algo3.modelo.excepciones.AtaqueAPaisNoLimitrofeException;
import edu.fiuba.algo3.modelo.excepciones.AtaqueAPaisPropioException;
import edu.fiuba.algo3.modelo.excepciones.AtaqueInvalidoException;
import edu.fiuba.algo3.modelo.excepciones.EjercitosInvalidosException;

public class PaisAtacanteSeleccionado implements EstadoSeleccionarPaisAtaque {

    private final TurnoAtaque turnoAtaque;
    private final Jugador jugador;
    private final Pais paisAtacante;

    public PaisAtacanteSeleccionado(TurnoAtaque turnoAtaque, Jugador jugador, Pais paisAtacante) {
        this.turnoAtaque = turnoAtaque;
        this.jugador = jugador;
        this.paisAtacante = paisAtacante;
    }

    @Override
    public void seleccionarPais(Pais pais) {
        if (!pais.esLimitrofe(paisAtacante)) {
            throw new AtaqueAPaisNoLimitrofeException(pais + " no limita con " + paisAtacante.toString());
        }
        if (pais.esAliado(paisAtacante)) {
            if (pais.puedeAtacar()) {
                turnoAtaque.cambiarEstado(new PaisAtacanteSeleccionado(turnoAtaque, jugador, pais));
            } else {
                throw new EjercitosInvalidosException(pais + " no tiene suficientes ejércitos para atacar.");
            }
        }
        turnoAtaque.cambiarEstado(new PaisDefensorSeleccionado(turnoAtaque, jugador, paisAtacante, pais));
    }

    @Override
    public void atacar(int cantidadEjercitos) {
        throw new AtaqueInvalidoException("Pais defensor no seleccionado.");
    }

    @Override
    public void cancelarAccion() {
        turnoAtaque.cambiarEstado(new NingunPaisSeleccionadoAtaque(turnoAtaque, jugador));
    }

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
        return true;
    }

    @Override
    public boolean paisPuedeSeleccionarse(Pais pais) {
        return (pais != paisAtacante &&
                ((!pais.esAliado(paisAtacante) && paisAtacante.esLimitrofe(pais)) ||
                        (pais.puedeAtacar() && pais.esAliado(paisAtacante))));
    }

}

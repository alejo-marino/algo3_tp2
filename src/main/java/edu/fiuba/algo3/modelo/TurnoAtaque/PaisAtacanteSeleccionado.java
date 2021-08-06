package edu.fiuba.algo3.modelo.TurnoAtaque;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Pais;
import edu.fiuba.algo3.modelo.excepciones.*;

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
        if (pais.esAliado(paisAtacante)) {
            if (!pais.puedeAtacar()) {
                throw new EjercitosInvalidosException(pais + " no tiene suficientes ejércitos para atacar.");
            }
            turnoAtaque.cambiarEstado(new PaisAtacanteSeleccionado(turnoAtaque, jugador, pais));
        } else {
            if (!pais.esLimitrofe(paisAtacante)) {
                throw new AtaqueAPaisNoLimitrofeException(pais + " no limita con " + paisAtacante.toString());
            }
            turnoAtaque.cambiarEstado(new PaisDefensorSeleccionado(turnoAtaque, jugador, paisAtacante, pais));
        }

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
    public boolean puedoSeleccionarPais(Pais pais) {
        return (pais != paisAtacante &&
                ((!pais.esAliado(paisAtacante) && paisAtacante.esLimitrofe(pais)) ||
                        (pais.puedeAtacar() && pais.esAliado(paisAtacante))));
    }

    @Override
    public boolean puedoReagrupar() {
        return false;
    }

    @Override
    public void reagrupar(int cantidadEjercitos) {
        throw new ReagrupeInvalidoException("No es posible reagrupar mientras estás atacando");
    }

    @Override
    public boolean paisSeleccionado(String nombrePais) {
        return paisAtacante.toString().equals(nombrePais);
    }

}

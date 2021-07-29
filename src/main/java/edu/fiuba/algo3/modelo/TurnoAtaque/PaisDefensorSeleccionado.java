package edu.fiuba.algo3.modelo.TurnoAtaque;

import edu.fiuba.algo3.modelo.Combate;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Pais;
import edu.fiuba.algo3.modelo.excepciones.EjercitosInvalidosException;
import edu.fiuba.algo3.modelo.excepciones.PaisesYaSeleccionadosException;

public class PaisDefensorSeleccionado implements EstadoSeleccionarPaisAtaque {

    private final TurnoAtaque turnoAtaque;
    private final Jugador jugador;
    private final Pais paisAtacante;
    private final Pais paisDefensor;

    public PaisDefensorSeleccionado(TurnoAtaque turnoAtaque, Jugador jugador, Pais paisAtacante, Pais paisDefensor) {
        this.turnoAtaque = turnoAtaque;
        this.jugador = jugador;
        this.paisAtacante = paisAtacante;
        this.paisDefensor = paisDefensor;
    }

    @Override
    public void seleccionarPais(Pais pais) {
        throw new PaisesYaSeleccionadosException("Los paises atacantes y defensores ya estan seleccionados, apreta 'Atacar' o 'Cancelar accion'.");
    }

    @Override
    public void atacar(int cantidadEjercitos) {
        this.paisPuedeAtacar(cantidadEjercitos);
        Combate combate = new Combate(paisAtacante, paisDefensor, cantidadEjercitos);
        combate.combatir();
        if (!this.paisAtacante.puedeAtacar()) {
            this.cancelarAccion();
        }
    }

    @Override
    public void cancelarAccion() {
        turnoAtaque.cambiarEstado(new PaisAtacanteSeleccionado(turnoAtaque, jugador, paisAtacante));
    }

    private void paisPuedeAtacar(int cantidadEjercitos) {
        if (cantidadEjercitos > 3 || (cantidadEjercitos < 1) || ((cantidadEjercitos > paisAtacante.getEjercitosParaAtacar()))) {
            throw new EjercitosInvalidosException("No hay suficientes ejércitos para atacar");
        }
    }



}

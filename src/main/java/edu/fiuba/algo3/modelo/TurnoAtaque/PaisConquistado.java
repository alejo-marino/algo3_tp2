package edu.fiuba.algo3.modelo.TurnoAtaque;

import edu.fiuba.algo3.modelo.Combate;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Pais;
import edu.fiuba.algo3.modelo.TurnoReagrupe.NingunPaisSeleccionadoReagrupe;
import edu.fiuba.algo3.modelo.excepciones.AtaqueInvalidoException;
import edu.fiuba.algo3.modelo.excepciones.EjercitosInvalidosException;
import edu.fiuba.algo3.modelo.excepciones.PaisYaConquistadoException;
import edu.fiuba.algo3.modelo.excepciones.PaisesYaSeleccionadosException;

public class PaisConquistado implements EstadoSeleccionarPaisAtaque {

    private final TurnoAtaque turnoAtaque;
    private final Jugador jugador;
    private final Pais paisAtacante;
    private final Pais paisDefensor;

    public PaisConquistado(TurnoAtaque turnoAtaque, Jugador jugador, Pais paisAtacante, Pais paisDefensor) {
        this.turnoAtaque = turnoAtaque;
        this.jugador = jugador;
        this.paisAtacante = paisAtacante;
        this.paisDefensor = paisDefensor;
    }

    @Override
    public void seleccionarPais(Pais pais) {
        throw new PaisesYaSeleccionadosException("Los paises atacantes y defensores ya estan seleccionados, apreta 'Reagrupar' o 'Cancelar'.");
    }

    @Override
    public void atacar(int cantidadEjercitos) {
        throw new PaisYaConquistadoException("El país ya fue conquistado, apreta 'Reagrupar' o 'Cancelar'");
    }

    @Override
    public void cancelarAccion() {
        turnoAtaque.cambiarEstado(new NingunPaisSeleccionadoAtaque(turnoAtaque, jugador));
    }

    @Override
    public int getEjercitosParaAtacar() {
        return paisAtacante.getEjercitosParaReagruparEnAtaque();
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
        return false;
    }

    @Override
    public boolean puedoReagrupar() {
        return true;
    }

    @Override
    public void reagrupar(int cantidadEjercitos) {
        this.paisPuedeReagruparEnAtaque(cantidadEjercitos);
        this.paisAtacante.disminuirEjercitos(cantidadEjercitos);
        this.paisDefensor.reforzar(cantidadEjercitos);
        this.turnoAtaque.cambiarEstado(new NingunPaisSeleccionadoAtaque(turnoAtaque, jugador));
    }

    private void paisPuedeReagruparEnAtaque(int cantidadEjercitosAReagrupar) {
        if (cantidadEjercitosAReagrupar < 1) {
            throw new EjercitosInvalidosException("Cantidad de ejércitos a reagrupar invalida");
        }
        if (cantidadEjercitosAReagrupar > (paisAtacante.getEjercitosParaReagruparEnAtaque())) {
            throw new EjercitosInvalidosException("No se puede reagrupar con más de 3 ejércitos en el ataque.");
        }
    }

}

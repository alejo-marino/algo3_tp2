package edu.fiuba.algo3.modelo.TurnoReagrupe;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Pais;
import edu.fiuba.algo3.modelo.excepciones.AtaqueInvalidoException;
import edu.fiuba.algo3.modelo.excepciones.EjercitosInvalidosException;
import edu.fiuba.algo3.modelo.excepciones.PaisesYaSeleccionadosException;

import java.util.Hashtable;

public class PaisDestinoSeleccionado implements EstadoSeleccionarPaisReagrupe {

    private final TurnoReagrupe turnoReagrupe;
    private final Jugador jugador;
    private final Hashtable<Pais, Integer> datosRefuerzo;
    private final Pais paisOrigen;
    private final Pais paisDestino;

    public PaisDestinoSeleccionado(TurnoReagrupe turnoReagrupe, Jugador jugador, Hashtable<Pais, Integer> datosRefuerzo, Pais paisOrigen, Pais paisDestino) {
        this.turnoReagrupe = turnoReagrupe;
        this.jugador = jugador;
        this.datosRefuerzo  = datosRefuerzo;
        this.paisOrigen = paisOrigen;
        this.paisDestino = paisDestino;
    }

    @Override
    public void seleccionarPais(Pais pais) {
        throw new PaisesYaSeleccionadosException("Los paises origen y destino ya estan seleccionados, apreta 'Reagrupar' o 'Cancelar accion'.");
    }

    @Override
    public void cancelarAccion() {
        turnoReagrupe.cambiarEstado(new PaisOrigenSeleccionado(turnoReagrupe, jugador, datosRefuerzo, paisOrigen));
    }

    @Override
    public void reagrupar(int cantidadEjercitos) {
        this.paisPuedeReagrupar(cantidadEjercitos);
        this.paisOrigen.disminuirEjercitos(cantidadEjercitos);
        if (!(datosRefuerzo.containsKey(paisDestino))) {
            this.datosRefuerzo.put(paisDestino, 0);
        }
        this.datosRefuerzo.put(paisDestino, this.datosRefuerzo.get(paisDestino) + cantidadEjercitos);
        this.cancelarAccion();
    }

    @Override
    public boolean puedoCancelar() {
        return true;
    }

    @Override
    public boolean puedoReagrupar() {
        return true;
    }

    @Override
    public int getEjercitosParaReagrupar() {
        return paisOrigen.getEjercitosParaAtacar();
    }

    @Override
    public boolean paisPuedeSeleccionarse(Pais pais) {
        return false;
    }

    private void paisPuedeReagrupar(int cantidadEjercitosAMovilizar) {
        if ((this.paisOrigen == null) || (this.paisDestino == null)) {
            throw new AtaqueInvalidoException("Pais origen o destino faltante");
        }
        if (cantidadEjercitosAMovilizar < 1) {
            throw new EjercitosInvalidosException("Cantidad de ejércitos a realocar invalida");
        }
        if (cantidadEjercitosAMovilizar > (paisOrigen.getEjercitos() - 1)) {
            throw new EjercitosInvalidosException("No hay suficientes ejércitos para realocar");
        }
    }

}

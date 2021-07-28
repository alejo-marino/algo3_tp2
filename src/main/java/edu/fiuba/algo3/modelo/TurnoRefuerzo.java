package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.*;

import java.util.ArrayList;

import static edu.fiuba.algo3.modelo.Constantes.numeroTarjetasParaCanje;

public class TurnoRefuerzo implements EstadoTurno {

    private Pais paisRefuerzo;
    private Integer ejercitosDisponibles;
    private final Jugador jugador;

    public TurnoRefuerzo(Jugador jugador, Integer ejercitosAReforzar) {
        this.jugador = jugador;
        this.ejercitosDisponibles = ejercitosAReforzar;
    }

    @Override
    public void atacar(int cantidadEjercitosAtacantes) {
        throw new AtaqueInvalidoException("No es posible atacar en un turno de reagrupe");
    }

    @Override
    public void seleccionarPais(Pais paisSeleccionado) {
        if (this.paisRefuerzo != null) {
            throw new PaisesYaSeleccionadosException(paisSeleccionado + " ya esta seleccionado, apreta 'Reforzar' o 'Cancelar accion'.");
        }

        if (!paisSeleccionado.esDuenio(jugador)) {
            throw new SeleccionaPaisAjenoException("El pais: " + paisSeleccionado + " no te pertenece");
        }
        paisRefuerzo = paisSeleccionado;
    }

    @Override
    public void cancelarAccion() {
        paisRefuerzo = null;

    }

    @Override
    public void reagrupar(int cantidadEjercitos){
        throw new ReagrupeInvalidoException("No puede reagrupar en turno de refuerzo");
    }

    @Override
    public void reforzar(int cantidadEjercitosAReforzar) {
        if (ejercitosDisponibles < cantidadEjercitosAReforzar) {
            throw new NoPuedeColocarTantosEjercitosException("Solo disponde de " + ejercitosDisponibles + " ejercitos.");
        }
        this.ejercitosDisponibles -= cantidadEjercitosAReforzar;
        this.paisRefuerzo.reforzar(cantidadEjercitosAReforzar);
        this.cancelarAccion();
    }

    @Override
    public void canjearTarjetas(ArrayList<String> tarjetasACanjear, Juego juego) {
        if (tarjetasACanjear.size() != numeroTarjetasParaCanje) {
            throw new CanjeInvalidoException("Cantidad erronea de tarjetas para el canje.");
        }
        ejercitosDisponibles += juego.canjearTarjetas(tarjetasACanjear, jugador);
    }

    public boolean tieneEjercitosParaReforzar() {
        return ejercitosDisponibles > 0;
    }

    public void activarTarjeta(String tarjetaAActivar, Juego juego) {
        juego.activarTarjeta(tarjetaAActivar);
    }
}

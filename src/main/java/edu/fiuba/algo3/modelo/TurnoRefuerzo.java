package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.*;

import java.util.ArrayList;

public class TurnoRefuerzo implements EstadoTurno {

    private Pais paisRefuerzo;
    private Integer ejercitosDisponibles;
    private Jugador jugador;

    public TurnoRefuerzo(Jugador jugador, Integer ejercitosAReforzar) {
        this.jugador = jugador;
        this.ejercitosDisponibles = ejercitosAReforzar;
    }

    @Override
    public void atacar(int cantidadEjercitosAtacantes) {
        throw new AtaqueInvalidoException("No es posible atacar en un turno de reagrupe");
    }

    @Override
    public Pais seleccionarPais(Pais paisSeleccionado, Jugador jugador) {
        if (this.paisRefuerzo != null) {
            throw new PaisesYaSeleccionadosException(paisSeleccionado + " ya esta seleccionado, apreta 'Reforzar' o 'Cancelar accion'.");
        }

        if (this.paisRefuerzo == null) {
            if (!paisSeleccionado.esDuenio(jugador)) {
                throw new SeleccionaPaisAjenoException("El pais: " + paisSeleccionado + " no te pertenece");
            }
            paisRefuerzo = paisSeleccionado;
        }
        return paisRefuerzo;
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
    }

    @Override
    public void canjearTarjetas(ArrayList<Tarjeta> tarjetasACanjear) {
        int NRO_TARJETAS_PARA_CANJE = 3;
        if (tarjetasACanjear.size() != NRO_TARJETAS_PARA_CANJE) {
            throw new CanjeInvalidoException("Cantidad erronea de tarjetas para el canje.");
        }
        ejercitosDisponibles = ejercitosDisponibles + jugador.canjearTarjetas(tarjetasACanjear);
    }

    public boolean reforzoTodo() {
        System.out.println(ejercitosDisponibles);
        return ejercitosDisponibles == 0;
    }
}

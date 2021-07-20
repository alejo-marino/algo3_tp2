package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.*;

public class TurnoRefuerzo implements EstadoTurno {

    private final Tablero tablero;
    private Pais paisRefuerzo;

    public TurnoRefuerzo(Tablero tablero) {
        this.tablero = tablero;
    }

    @Override
    public void atacar(int cantidadEjercitosAtacantes) {
        throw new AtaqueInvalidoException("No es posible atacar en un turno de reagrupe");
    }

    @Override
    public EstadoTurno cambiarEstado() {
        return null;
    }

    @Override
    public Pais seleccionarPais(String nombrePais, Jugador jugador) {
        if (this.paisRefuerzo != null) {
            throw new PaisesYaSeleccionadosException("El pais a reforzar ya esta seleccionado, apreta 'Reforzar' o 'Cancelar accion'.");
        }
        Pais paisSeleccionado = this.tablero.seleccionarPais(nombrePais);
        if (this.paisRefuerzo == null) {
            if (!paisSeleccionado.esDuenio(jugador)) {
                throw new SeleccionaPaisAjenoException("El pais: " + nombrePais + " no te pertenece");
            }
            paisRefuerzo = paisSeleccionado;
        }
        return  paisRefuerzo;
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
        paisRefuerzo.reforzar(cantidadEjercitosAReforzar);
    }
}

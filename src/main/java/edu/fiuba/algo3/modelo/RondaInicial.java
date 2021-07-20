package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.*;

import java.util.Queue;

public class RondaInicial implements TipoDeRonda {

    private Queue<Integer> colaRefuerzo;
    Integer ejercitosAColocar;
    Tablero tablero;
    private Pais paisAReforzar;

    public RondaInicial(Queue<Integer> colaDeNumerosDeRefuerzoPorRonda, Tablero referenciaTablero) {
        colaRefuerzo = colaDeNumerosDeRefuerzoPorRonda;
        this.tablero = referenciaTablero;
        this.ejercitosAColocar = this.cantidadRefuerzo();
    }

    public boolean puedeContinuar() {
        return colaRefuerzo.size() != 1;
    }

    public TipoDeRonda siguienteRonda() {
        colaRefuerzo.remove();
        this.ejercitosAColocar = this.cantidadRefuerzo();
        return this;
    }

    public Integer cantidadRefuerzo() {
        return colaRefuerzo.peek();
    }

    public String getRondaActual() {
        return "Colocando " + this.cantidadRefuerzo() + " ejercitos";
    }

    public void atacar(int cantidadEjercitos) {
        throw new AtaqueInvalidoException("No es posible atacar en un turno de refuerzo inicial");
    }

    @Override
    public void reagrupar(int cantidadEjercitos) {
        throw new ReagrupeInvalidoException("No es posible reagrupar en un turno de refuerzo inicial");
    }

    public void siguienteTurno() {
        if (this.ejercitosAColocar > 0) {
            throw new NoReforzoTodosLosEjercitosException();
        }
        ejercitosAColocar = colaRefuerzo.peek();
    }

    @Override
    public Pais seleccionarPais(String nombrePais, Jugador jugador) {
        Pais paisASeleccionar = tablero.seleccionarPais(nombrePais);
        if (!paisASeleccionar.esDuenio(jugador)) {
            throw new SeleccionaPaisAjenoException("El pais: " + nombrePais + " no te pertenece.");
        }
        this.paisAReforzar = paisASeleccionar;
        return paisASeleccionar;
    }

    @Override
    public void reforzar(Integer ejercitosAReforzar) {
        if (this.ejercitosAColocar < ejercitosAReforzar) {
            throw new NoPuedeColocarTantosEjercitosException("Solo disponde de " + ejercitosAReforzar + " fichas.");
        }
        this.ejercitosAColocar -= ejercitosAReforzar;
        this.paisAReforzar.reforzar(ejercitosAReforzar);
    }

    @Override
    public void cancelarAccion() {
        this.paisAReforzar = null;
    }

    public Tablero pedirTablero() {
        return tablero;
    }

}

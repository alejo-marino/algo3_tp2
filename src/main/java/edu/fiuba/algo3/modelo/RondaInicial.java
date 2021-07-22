package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.*;

import java.util.Queue;

public class RondaInicial extends RondaDeRefuerzo {

    private final Queue<Integer> colaRefuerzo;
    Tablero tablero;

    public RondaInicial(Queue<Integer> colaDeNumerosDeRefuerzoPorRonda, Tablero tablero) {
        super(tablero);
        colaRefuerzo = colaDeNumerosDeRefuerzoPorRonda;
        this.tablero = tablero;
    }

    public boolean puedeContinuar() {
        return colaRefuerzo.size() != 1;
    }

    @Override
    public Ronda siguienteRonda() {
        colaRefuerzo.remove();
        return this;
    }

    private Integer cantidadRefuerzo() {
        return colaRefuerzo.peek();
    }

    public String getRondaActual() {
        return "Colocando " + this.cantidadRefuerzo() + " ejercitos";
    }

    @Override
    public void empezarTurno(Jugador jugador) {
        TurnoRefuerzo estadoTurno = (TurnoRefuerzo) super.getEstadoTurno();
        if (!estadoTurno.reforzoTodo()) {
            throw new NoReforzoTodosLosEjercitosException();
        }
        super.setEstadoTurno(new TurnoRefuerzo(jugador, this.cantidadRefuerzo()));
    }

    public Tablero pedirTablero() {
        return tablero;
    }

}

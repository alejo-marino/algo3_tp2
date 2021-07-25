package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.*;

import java.util.Queue;

public class RondaInicial extends RondaDeRefuerzo {

    private final Queue<Integer> colaRefuerzo;
    private Juego juego;

    public RondaInicial(Queue<Integer> colaDeNumerosDeRefuerzoPorRonda, Juego juego) {
        super(juego);
        colaRefuerzo = colaDeNumerosDeRefuerzoPorRonda;
        this.juego = juego;
    }

    public boolean puedeContinuar() {
        return colaRefuerzo.size() != 1;
    }

    @Override
    public Ronda siguienteRonda() {
        TurnoRefuerzo estadoTurno = (TurnoRefuerzo) super.getEstadoTurno();
        if (estadoTurno.tieneEjercitosParaReforzar()) {
            throw new NoReforzoTodosLosEjercitosException();
        }
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
        if (estadoTurno.tieneEjercitosParaReforzar()) {
            throw new NoReforzoTodosLosEjercitosException();
        }
        super.setEstadoTurno(new TurnoRefuerzo(jugador, this.cantidadRefuerzo()));
    }

    public Juego pedirJuego() {
        return juego;
    }

    public void terminarAtaque(Jugador jugador) {
        throw new AtaqueInvalidoException("No se puede atacar en las rondas iniciales");
    }

}

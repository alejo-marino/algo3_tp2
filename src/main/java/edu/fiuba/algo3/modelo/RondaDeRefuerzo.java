package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.AtaqueInvalidoException;
import edu.fiuba.algo3.modelo.excepciones.NoReforzoTodosLosEjercitosException;

public class RondaDeRefuerzo extends Ronda {

    private final Juego juego;

    public RondaDeRefuerzo(Juego juego) {
        super(juego, new TurnoRefuerzo(null, 0));
        this.juego = juego;
    }

    @Override
    public Ronda siguienteRonda() {
        return new RondaDeAtaqueYReagrupe(juego);
    }

    @Override
    public void empezarTurno(Jugador jugador) {
        TurnoRefuerzo estadoTurno = (TurnoRefuerzo) super.getEstadoTurno();
        if (estadoTurno.tieneEjercitosParaReforzar()) {
            throw new NoReforzoTodosLosEjercitosException();
        }
        Integer ejercitosAColocar = juego.calcularEjercitosDisponibles(jugador);
        super.setEstadoTurno(new TurnoRefuerzo(jugador, ejercitosAColocar));
    }

    public void terminarAtaque(Jugador jugador) {
        throw new AtaqueInvalidoException("No se puede atacar en las rondas de refuerzo");
    }

}
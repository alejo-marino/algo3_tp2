package edu.fiuba.algo3.modelo;

public class RondaDeRefuerzo extends Ronda {

    private final Tablero tablero;

    public RondaDeRefuerzo(Tablero tablero) {
        super(tablero, new TurnoRefuerzo(null, 0));
        this.tablero = tablero;
    }

    @Override
    public Ronda siguienteRonda() {
        return new RondaDeAtaqueYReagrupe(tablero);
    }

    @Override
    public void empezarTurno(Jugador jugador) {
        Integer ejercitosAColocar = tablero.calcularEjercitosDisponibles(jugador);
        super.setEstadoTurno(new TurnoRefuerzo(jugador, ejercitosAColocar));
    }
}
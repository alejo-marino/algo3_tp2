package edu.fiuba.algo3.modelo;

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
        Integer ejercitosAColocar = juego.calcularEjercitosDisponibles(jugador);
        super.setEstadoTurno(new TurnoRefuerzo(jugador, ejercitosAColocar));
    }
}
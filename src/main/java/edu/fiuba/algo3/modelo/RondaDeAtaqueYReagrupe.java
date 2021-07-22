package edu.fiuba.algo3.modelo;

public class RondaDeAtaqueYReagrupe extends Ronda {

    private final Tablero tablero;

    public RondaDeAtaqueYReagrupe(Tablero tablero) {
        super(tablero, new TurnoAtaque(null));
        this.tablero = tablero;
    }

    // se llamara a este metodo cuando se termine la parte de ataque del turno, el jugador podra reagrupar antes de terminar su turno.
    public void terminarAtaque(Jugador jugador) {
        super.setEstadoTurno(new TurnoReagrupe(jugador));
    }

    // se llamara a este metodo cuando se termine la parte de reagrupe del turno, el proximo jugador podra atacar cuando empieze su turno.
    public void empezarTurno(Jugador jugador) {
        super.setEstadoTurno(new TurnoAtaque(jugador));
    }

    public Ronda siguienteRonda() {
        return new RondaDeRefuerzo(tablero);
    }
}


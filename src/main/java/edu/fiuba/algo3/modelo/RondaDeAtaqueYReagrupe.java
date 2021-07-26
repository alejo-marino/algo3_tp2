package edu.fiuba.algo3.modelo;

public class RondaDeAtaqueYReagrupe extends Ronda {

    private final Juego juego;

    public RondaDeAtaqueYReagrupe(Juego juego) {
        super(juego, new TurnoReagrupe(null));
        this.juego = juego;
    }

    // se llamara a este metodo cuando se termine la parte de ataque del turno, el jugador podra reagrupar antes de terminar su turno.
    public void terminarAtaque(Jugador jugador) {
        super.setEstadoTurno(new TurnoReagrupe(jugador));
    }

    // se llamara a este metodo cuando se termine la parte de reagrupe del turno, el proximo jugador podra atacar cuando empieze su turno.
    public void empezarTurno(Jugador jugador) {
        TurnoReagrupe estadoTurno = (TurnoReagrupe) super.getEstadoTurno();
        estadoTurno.efectivizarReagrupe();

        super.setEstadoTurno(new TurnoAtaque(jugador));
    }

    public Ronda siguienteRonda() {
        return new RondaDeRefuerzo(juego);
    }
}


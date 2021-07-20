package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.*;


public class RondaDeAtaqueYReagrupe implements TipoDeRonda {

    private final Tablero tablero;
    private EstadoTurno estadoTurno;

    public RondaDeAtaqueYReagrupe(Tablero tablero) {
        this.tablero = tablero;
        estadoTurno = new TurnoAtaque(tablero);
    }

    // se llamara a este metodo cuando se termine la parte de ataque del turno, el jugador podra reagrupar antes de terminar su turno.
    public void terminarAtaque() {
        //estadoTurno.cancelarAccion();
        estadoTurno = estadoTurno.cambiarEstado();
    }

    // se llamara a este metodo cuando se termine la parte de reagrupe del turno, el proximo jugador podra atacar cuando empieze su turno.
    public void siguienteTurno() {
        estadoTurno = estadoTurno.cambiarEstado();
    }

    public TipoDeRonda siguienteRonda() {
        return new RondaDeRefuerzo(tablero);
    }

    public void atacar(int cantidadEjercitos) {
        this.estadoTurno.atacar(cantidadEjercitos);
    }

    public void reagrupar(int cantidadEjercitos) {
        this.estadoTurno.reagrupar(cantidadEjercitos);
    }

    public void reforzar(Integer ejercitosAReforzar) {
        this.estadoTurno.reforzar(ejercitosAReforzar);
    }

    public Pais seleccionarPais(String nombrePais, Jugador jugador) {
        return this.estadoTurno.seleccionarPais(nombrePais, jugador);
    }

    public void cancelarAccion() {
        this.estadoTurno.cancelarAccion();
    }
}

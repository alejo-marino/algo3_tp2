package edu.fiuba.algo3.modelo;

import java.util.ArrayList;


public class RondaDeAtaqueYReagrupe implements Ronda {

    private final Tablero tablero;
    private EstadoTurno estadoTurno;

    public RondaDeAtaqueYReagrupe(Tablero tablero) {
        this.tablero = tablero;
        this.estadoTurno = new TurnoAtaque(null);
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

    public Pais seleccionarPais(String nombrePais, Jugador jugador)  {
        Pais pais = this.tablero.seleccionarPais(nombrePais);
        System.out.println("hol");
        return this.estadoTurno.seleccionarPais(pais, jugador);
    }

    public void cancelarAccion() {
        this.estadoTurno.cancelarAccion();
    }

    public void canjearTarjetas(ArrayList<Tarjeta> tarjetasACanjear) {
        estadoTurno.canjearTarjetas(tarjetasACanjear);
    }

    // se llamara a este metodo cuando se termine la parte de ataque del turno, el jugador podra reagrupar antes de terminar su turno.
    public void terminarAtaque(Jugador jugador) {
        this.estadoTurno = new TurnoReagrupe(jugador);
    }

    // se llamara a este metodo cuando se termine la parte de reagrupe del turno, el proximo jugador podra atacar cuando empieze su turno.
    public void empezarTurno(Jugador jugador) {
        this.estadoTurno = new TurnoAtaque(jugador);
    }

    public Ronda siguienteRonda() {
        return new RondaDeRefuerzo(tablero);
    }
}


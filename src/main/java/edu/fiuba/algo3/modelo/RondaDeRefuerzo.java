package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class RondaDeRefuerzo implements Ronda {

    private final Tablero tablero;
    private EstadoTurno estadoTurno;

    public RondaDeRefuerzo(Tablero tablero) {
        this.tablero = tablero;
        this.estadoTurno = new TurnoRefuerzo(null, 0);
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
        return this.estadoTurno.seleccionarPais(pais, jugador);
    }

    public void cancelarAccion() {
        this.estadoTurno.cancelarAccion();
    }

    public void canjearTarjetas(ArrayList<Tarjeta> tarjetasACanjear) {
        estadoTurno.canjearTarjetas(tarjetasACanjear);
    }

    @Override
    public Ronda siguienteRonda() {
        return new RondaDeAtaqueYReagrupe(tablero);
    }

    @Override
    public void empezarTurno(Jugador jugador) {
        Integer ejercitosAColocar = tablero.calcularEjercitosDisponibles(jugador);
        estadoTurno = new TurnoRefuerzo(jugador, ejercitosAColocar);
    }
}
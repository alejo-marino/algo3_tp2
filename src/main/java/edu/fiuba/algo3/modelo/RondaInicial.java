package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.*;

import javax.rmi.ssl.SslRMIClientSocketFactory;
import java.util.ArrayList;
import java.util.Queue;

public class RondaInicial implements Ronda {

    private Queue<Integer> colaRefuerzo;
    Tablero tablero;
    private TurnoRefuerzo estadoTurno;

    public RondaInicial(Queue<Integer> colaDeNumerosDeRefuerzoPorRonda, Tablero tablero) {
        colaRefuerzo = colaDeNumerosDeRefuerzoPorRonda;
        this.tablero = tablero;
        this.estadoTurno = new TurnoRefuerzo(null, 0);
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
        if (!estadoTurno.reforzoTodo()) {
            throw new NoReforzoTodosLosEjercitosException();
        }
        System.out.println(this.cantidadRefuerzo());
        estadoTurno = new TurnoRefuerzo(jugador, this.cantidadRefuerzo());
    }

    public Tablero pedirTablero() {
        return tablero;
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

}

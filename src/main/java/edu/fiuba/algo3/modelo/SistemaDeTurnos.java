package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.JugadorGanoException;

import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class SistemaDeTurnos {

    Queue<Jugador> colaJugadores;
    Integer movimientos;
    Fase faseActual;
    boolean esPrimerTurno;

    public SistemaDeTurnos(ArrayList<Jugador> listaJugadores, Juego juego, Queue<Integer> colaDeNumerosDeRefuerzoPorRonda) {
        this.colaJugadores = this.crearColaDeLista(listaJugadores);
        this.movimientos = 0;
        this.faseActual = new FaseInicial(colaDeNumerosDeRefuerzoPorRonda, juego);
        this.esPrimerTurno = true;
    }

    private Queue<Jugador> crearColaDeLista(ArrayList<Jugador> lista) {
        return new LinkedList<>(lista);
    }

    public Jugador turnoDe() {
        return colaJugadores.peek();
    }

    public void empezarTurno() {
        movimientos++;
        if ((movimientos % (colaJugadores.size() + 1)) == 0) {  // se pasa de ronda
            faseActual = faseActual.siguienteRonda();
            movimientos++;
        }
        if (!esPrimerTurno) {
            Jugador jugadorAnterior = colaJugadores.remove();
            colaJugadores.add(jugadorAnterior);
        }
        faseActual.empezarTurno(this.turnoDe());
        esPrimerTurno = false;
    }

    public String getFaseActual() {
        return faseActual.getFaseActual();
    }

    public void reforzar(int cantidadEjercitos) {
        faseActual.reforzar(cantidadEjercitos);
    }

    public Pais seleccionarPais(String nombrePais) {
        return faseActual.seleccionarPais(nombrePais);
    }

    public void atacar(int cantidadEjercitos) {
        faseActual.atacar(cantidadEjercitos);
        // Veo si ganó
        if (turnoDe().gano()) {
            throw new JugadorGanoException("Felicitaciones! Ganaste el juego.");
        }
        // Veo si alguien perdió
        for (Jugador jugador: colaJugadores) {
            if (Juego.getInstancia().obtenerCantidadPaisesSegunJugador(jugador) == 0) {
                colaJugadores.remove(jugador);
                for(Jugador otroJugador: colaJugadores) {
                    otroJugador.verificarMisiones();
                }
            }
        }
    }

    public void reagrupar(int cantidadEjercitos) {
        faseActual.reagrupar(cantidadEjercitos);
    }

    public ArrayList<Tarjeta> obtenerTarjetas() {
        return this.turnoDe().getTarjetas();
    }

    public void canjearTarjetas(ArrayList<Tarjeta> tarjetasACanjear) {
        faseActual.canjearTarjetas(tarjetasACanjear);
    }

    public void terminarAtaque() {
        faseActual.terminarAtaque(turnoDe());
    }

}

package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.JugadorGanoException;

import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class SistemaDeTurnos {

    private final Juego juego;
    Queue<Jugador> colaJugadores;
    Integer movimientos;
    Fase faseActual;
    boolean esPrimerTurno;
    private Integer cantidadPaisesPrincipioDeRonda;

    public SistemaDeTurnos(ArrayList<Jugador> listaJugadores, Juego juego, Queue<Integer> colaDeNumerosDeRefuerzoPorRonda) {
        this.colaJugadores = this.crearColaDeLista(listaJugadores);
        this.movimientos = 0;
        this.faseActual = new FaseInicial(colaDeNumerosDeRefuerzoPorRonda, juego);
        this.esPrimerTurno = true;
        this.juego = juego;
        this.cantidadPaisesPrincipioDeRonda = 50;
    }

    private Queue<Jugador> crearColaDeLista(ArrayList<Jugador> lista) {
        return new LinkedList<>(lista);
    }

    public Jugador turnoDe() {
        return colaJugadores.peek();
    }

    public void empezarTurno() {
        if (juego.obtenerCantidadPaisesSegunJugador(this.turnoDe()) > cantidadPaisesPrincipioDeRonda) {
            juego.darTarjeta(this.turnoDe());
        }
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
        this.cantidadPaisesPrincipioDeRonda = juego.obtenerCantidadPaisesSegunJugador(this.turnoDe());
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
        Jugador jugadorAEliminar = null;
        for (Jugador jugador: colaJugadores) {
            if (juego.obtenerCantidadPaisesSegunJugador(jugador) == 0) {
                jugadorAEliminar = jugador;
                for(Jugador otroJugador: colaJugadores) {
                    otroJugador.verificarMisiones();
                }
            }
        }
        if(jugadorAEliminar != null) {
            colaJugadores.remove(jugadorAEliminar);
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
        juego.devolverTarjetas(tarjetasACanjear);
    }

    public void terminarAtaque() {
        faseActual.terminarAtaque(turnoDe());
    }

}

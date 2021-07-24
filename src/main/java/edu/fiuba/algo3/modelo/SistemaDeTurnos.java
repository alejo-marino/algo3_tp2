package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class SistemaDeTurnos {

    Queue<Jugador> colaJugadores;
    Integer movimientos;
    Fase faseActual;
    boolean esPrimerTurno;

    private Queue<Jugador> crearColaDeLista(ArrayList<Jugador> lista) {
        return new LinkedList<>(lista);
    }

    public Jugador turnoDe() {
        return colaJugadores.peek();
    }

    public SistemaDeTurnos(ArrayList<Jugador> listaJugadores, Juego juego, Queue<Integer> colaDeNumerosDeRefuerzoPorRonda) {
        this.colaJugadores = this.crearColaDeLista(listaJugadores);
        this.movimientos = 0;
        this.faseActual = new FaseInicial(colaDeNumerosDeRefuerzoPorRonda, juego);
        this.esPrimerTurno = true;
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
        return faseActual.seleccionarPais(nombrePais, this.turnoDe());
    }

    public void atacar(int cantidadEjercitos) {
        faseActual.atacar(cantidadEjercitos);
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

    /*
    int numeroDeFase = 1;

    while (sistTurnos.numeroDeFase <= CANT_FASES_REFUERZO_INICIALES) {  //
        jugador = desencolar(colaJugadores)
        turno.darTurno(jugador);
        colaJugadores.encolarJugador(jugador);
        turno.siguiente;
    }

    turno.setearAtaque

    while (true) {
        {for i in cantJugadores: {
            jugador = desencolar(colaJugadores)
            sistTurnos.darTurno(jugador);
            encolarJugador(colaJugadores);
            if (jugador.checkearSiGane())
                juego.ganoJugador(jugador); // deberia cortar la ejecucion de todos los demas objetos y mostrar por pantalla quien gano
        }
        turno.siguiente;
        numeroDeFase++;
    }
     */
}

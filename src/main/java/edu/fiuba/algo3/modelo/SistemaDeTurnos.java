package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class SistemaDeTurnos {

    Queue<Jugador> colaJugadores;
    Tablero tablero;
    Integer cantidadJugadores;
    Integer movimientos;
    Fase faseActual;

    private Queue<Jugador> crearColaDeLista(ArrayList<Jugador> lista) {
        Queue<Jugador> cola = new LinkedList<>();
        for (Jugador jugador: lista){
            cola.add(jugador);
        }
        return cola;
    }

    public Jugador turnoDe() {
        return colaJugadores.peek();
    }

    public SistemaDeTurnos(ArrayList<Jugador> listaJugadores, Tablero tablero, Queue colaDeNumerosDeRefuerzoPorRonda) {
        this.colaJugadores = this.crearColaDeLista(listaJugadores);
        this.tablero = tablero;
        this.movimientos = 0;
        this.faseActual = new FaseInicial(colaDeNumerosDeRefuerzoPorRonda, tablero);
    }

    public void siguienteTurno() {
        Jugador jugadorAnterior = colaJugadores.remove();
        faseActual.siguienteTurno();
        colaJugadores.add(jugadorAnterior);
        movimientos++;
        if ((movimientos % colaJugadores.size()) == 0) {
            faseActual = faseActual.siguienteRonda();
        }
    }

    public String getFaseActual() {
        return faseActual.getFaseActual();
    }

    public void reforzar(Pais argentina, int cantidadEjercitos) {
        faseActual.reforzar(argentina, cantidadEjercitos);
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

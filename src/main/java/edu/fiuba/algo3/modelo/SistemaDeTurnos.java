package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.JugadorGanoException;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Queue;
import java.util.LinkedList;

public class SistemaDeTurnos extends Observable {

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
        setChanged();
        notifyObservers();
    }

    public String getFaseActual() {
        return faseActual.getFaseActual();
    }

    public void reforzar(int cantidadEjercitos) {
        faseActual.reforzar(cantidadEjercitos);
        setChanged();
        notifyObservers();
    }

    public void seleccionarPais(String nombrePais) {
        faseActual.seleccionarPais(nombrePais);
        setChanged();
        notifyObservers();
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
        setChanged();
        notifyObservers();
    }

    public void reagrupar(int cantidadEjercitos) {
        faseActual.reagrupar(cantidadEjercitos);
        setChanged();
        notifyObservers();
    }

    public ArrayList<String> obtenerNombreTarjetas() {
        return this.juego.obtenerNombreTarjetasDe(this.turnoDe());
    }

    public void canjearTarjetas(ArrayList<String> tarjetasACanjear) {
        faseActual.canjearTarjetas(tarjetasACanjear);
    }

    public void terminarAtaque() {
        faseActual.terminarAtaque(turnoDe());
        setChanged();
        notifyObservers();
    }

    public void activarTarjeta(String nombreTarjeta) {
        this.faseActual.activarTarjeta(nombreTarjeta);
    }

    public boolean puedoAtacar() {
        return this.faseActual.puedoAtacar();
    }

    public int getEjercitosParaAtacar() {
        return this.faseActual.getEjercitosParaAtacar();
    }

    public boolean puedoReforzar() {
        return this.faseActual.puedoReforzar();
    }

    public int getEjercitosParaReforzar() {
        return this.faseActual.getEjercitosParaReforzar();
    }

    public void cancelarAccion() {
        this.faseActual.cancelarAccion();
        setChanged();
        notifyObservers();
    }

    public boolean puedoCancelar() {
        return this.faseActual.puedoCancelar();
    }

    public boolean estoyEnTurnoAtaque() {
        return this.faseActual.estoyEnTurnoAtaque();
    }

    public boolean puedoPasarDeTurno() {
        return this.faseActual.puedoPasarDeTurno();
    }

    public String nombreTurnoDe() {
        return this.turnoDe().getNombre();
    }

    public boolean puedoReagrupar() {
        return this.faseActual.puedoReagrupar();
    }

    public String verMisiones() {
        return this.turnoDe().verMisiones();
    }

    public boolean paisPuedeSeleccionarse(String nombrePais) {
        return this.faseActual.paisPuedeSeleccionarse(nombrePais);
    }

    public String getColorDePais(String nombrePais) {
        return juego.getColorDe(nombrePais);
    }

    public String getColorTurnoActual() {
        return this.turnoDe().getColor();
    }

}

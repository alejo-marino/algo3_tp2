package edu.fiuba.algo3.modelo;

public class MisionDestruccion implements Mision{
    private Jugador objetivo;
    private final Juego juego;


    public MisionDestruccion(Juego juego, Jugador objetivo) {
        this.objetivo = objetivo;
        this.juego = juego;
    }

    public String verMision () {
        return ("Misión de Destrucción: destruir al ejercito de \"" + objetivo.getNombre() + "\".");
    }

    public boolean completoMision () {
        return (juego.obtenerCantidadPaisesSegunJugador(objetivo) == 0);
    }

    public boolean sigueSiendoPosible() {
        return (juego.obtenerCantidadPaisesSegunJugador(objetivo) > 0);
    }

    public Jugador getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(Jugador jugador) {
        this.objetivo = jugador;
    }
}

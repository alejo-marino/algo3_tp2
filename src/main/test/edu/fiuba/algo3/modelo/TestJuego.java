package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.NumeroDeJugadoresInvalidoException;
import edu.fiuba.algo3.modelo.excepciones.NumeroDeJugadoresNoAsignadoException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestJuego {

    private Juego juego;

    @BeforeEach
    void setUp() {
        this.juego = Juego.getInstancia();
    }

    @Test
    void test01CreoUnJuegoYNoEsNull () {
        assertNotNull(this.juego);
    }

    @Test
    void test02CreoUnJuegoYNoPuedoAsignarle7Jugadores () {
        Integer cantidadDeJugadores = 7;

        assertThrows(NumeroDeJugadoresInvalidoException.class, () -> juego.setearCantidadJugadores(cantidadDeJugadores));
    }

    @Test
    void test03CreoUnJuegoYNoPuedoAsignarle1Jugador () {
        Integer cantidadDeJugadores = 1;

        assertThrows(NumeroDeJugadoresInvalidoException.class, () -> juego.setearCantidadJugadores(cantidadDeJugadores));
    }

    @Test
    void test04CreoUnJuegoYNoPuedoAsignarle50Jugadores () {
        Integer cantidadDeJugadores = 50;

        assertThrows(NumeroDeJugadoresInvalidoException.class, () -> juego.setearCantidadJugadores(cantidadDeJugadores));
    }

    @Test
    void test05CreoUnJuegoYNoPuedoIniciarElJuegoSinAsignarJugadores () {
        assertThrows(NumeroDeJugadoresNoAsignadoException.class, () -> juego.iniciarJuego());
    }

    @Test
    void test05CreoUnJuegoYSeteo6JugadoresYInicioElJuegoYElSistemaDeTurnosNoEsNull () {
        juego.setearCantidadJugadores(6);

        SistemaDeTurnos sistemaDeTurnos = juego.iniciarJuego();

        assertNotNull(sistemaDeTurnos);
    }

}

package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.NumeroDeJugadoresInvalidoException;
import edu.fiuba.algo3.modelo.excepciones.NumeroDeJugadoresNoAsignadoException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.spy;

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

    // TODO: Arreglar este test (encontrar forma de testear un Singleton)
//    @Test
//    void test02CreoUnJuegoYNoPuedoIniciarElJuegoSinAsignarJugadores () {
//        System.out.println(juego);
//        System.out.println(juego.obtenerJugadores());
//        assertThrows(NumeroDeJugadoresNoAsignadoException.class, () -> juego.iniciarJuego());
//    }

    @Test
    void test03CreoUnJuegoYNoPuedoAsignarle7Jugadores () {
        Integer cantidadDeJugadores = 7;

        assertThrows(NumeroDeJugadoresInvalidoException.class, () -> juego.setearCantidadJugadores(cantidadDeJugadores));
    }

    @Test
    void test04CreoUnJuegoYNoPuedoAsignarle1Jugador () {
        Integer cantidadDeJugadores = 1;

        assertThrows(NumeroDeJugadoresInvalidoException.class, () -> juego.setearCantidadJugadores(cantidadDeJugadores));
    }

    @Test
    void test05CreoUnJuegoYNoPuedoAsignarle50Jugadores () {
        System.out.println(juego);
        Integer cantidadDeJugadores = 50;

        assertThrows(NumeroDeJugadoresInvalidoException.class, () -> juego.setearCantidadJugadores(cantidadDeJugadores));
    }

    @Test
    void test06CreoUnJuegoYSeteo6JugadoresYInicioElJuegoYElSistemaDeTurnosNoEsNull () {
        juego.setearCantidadJugadores(6);

        SistemaDeTurnos sistemaDeTurnos = juego.iniciarJuego();

        assertNotNull(sistemaDeTurnos);
    }

    @Test
    public void test07InicioUnJuegoCon2JugadoresYVerificoQueCadaJugadorTiene25Paises () {
        juego.setearCantidadJugadores(2);
        juego.iniciarJuego();
        ArrayList<Jugador> jugadores = juego.obtenerJugadores();
        int contadorJugadoresCon25Paises = 0;
        for (Jugador jugador: jugadores) {
            Integer cantidadPaises = juego.obtenerCantidadPaisesSegunJugador(jugador);
            if (cantidadPaises == 25) {
                contadorJugadoresCon25Paises++;
            }
        }
        assertEquals(2, contadorJugadoresCon25Paises);
    }

    @Test
    public void test08InicioUnJuegoCon3JugadoresY2JugadoresTienen17PaisesY1Tiene16 () {
        juego.setearCantidadJugadores(3);
        juego.iniciarJuego();
        ArrayList<Jugador> jugadores = juego.obtenerJugadores();
        int contadorJugadoresCon17Paises = 0;
        int contadorJugadoresCon16Paises = 0;
        for (Jugador jugador: jugadores) {
            Integer cantidadPaises = juego.obtenerCantidadPaisesSegunJugador(jugador);
            if (cantidadPaises == 17) {
                contadorJugadoresCon17Paises++;
            } else if (cantidadPaises == 16) {
                contadorJugadoresCon16Paises++;
            }
        }
        assertEquals(2, contadorJugadoresCon17Paises);
        assertEquals(1, contadorJugadoresCon16Paises);
    }

    @Test
    public void test09InicioUnJuegoCon4JugadoresY2JugadoresTienen13PaisesY2Tienen12 () {
        juego.setearCantidadJugadores(4);
        juego.iniciarJuego();
        ArrayList<Jugador> jugadores = juego.obtenerJugadores();
        int contadorJugadoresCon13Paises = 0;
        int contadorJugadoresCon12Paises = 0;
        for (Jugador jugador: jugadores) {
            Integer cantidadPaises = juego.obtenerCantidadPaisesSegunJugador(jugador);
            if (cantidadPaises == 13) {
                contadorJugadoresCon13Paises++;
            } else if (cantidadPaises == 12) {
                contadorJugadoresCon12Paises++;
            }
        }
        assertEquals(2, contadorJugadoresCon13Paises);
        assertEquals(2, contadorJugadoresCon12Paises);
    }

    @Test
    public void test10InicioUnJuegoCon5JugadoresYCadaJugadorTiene10Paises () {
        juego.setearCantidadJugadores(5);
        juego.iniciarJuego();
        ArrayList<Jugador> jugadores = juego.obtenerJugadores();
        int contadorJugadoresCon10Paises = 0;
        for (Jugador jugador: jugadores) {
            Integer cantidadPaises = juego.obtenerCantidadPaisesSegunJugador(jugador);
            if (cantidadPaises == 10) {
                contadorJugadoresCon10Paises++;
            }
        }
        assertEquals(5, contadorJugadoresCon10Paises);
    }

    @Test
    public void test11InicioUnJuegoCon6JugadoresY2JugadoresTienen9PaisesY4Tienen8 () {
        juego.setearCantidadJugadores(6);
        juego.iniciarJuego();
        ArrayList<Jugador> jugadores = juego.obtenerJugadores();
        int contadorJugadoresCon9Paises = 0;
        int contadorJugadoresCon8Paises = 0;
        for (Jugador jugador: jugadores) {
            Integer cantidadPaises = juego.obtenerCantidadPaisesSegunJugador(jugador);
            if (cantidadPaises == 9) {
                contadorJugadoresCon9Paises++;
            } else if (cantidadPaises == 8) {
                contadorJugadoresCon8Paises++;
            }
        }
        assertEquals(2, contadorJugadoresCon9Paises);
        assertEquals(4, contadorJugadoresCon8Paises);
    }

}

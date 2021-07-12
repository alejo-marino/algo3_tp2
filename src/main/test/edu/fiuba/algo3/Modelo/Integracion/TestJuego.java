package edu.fiuba.algo3.Modelo.Integracion;

import edu.fiuba.algo3.Modelo.Juego;
import edu.fiuba.algo3.Modelo.excepciones.CantidadErroneaDeJugadoresError;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestJuego {
    @Test
    public void test01CreoUnJuegoYNoEsNull(){
        Juego juego = new Juego();
        assertNotNull(juego);
    }

    @Test
    public void test02CreoUnJuegoYLeAsigno3JugadoresYTiene3Jugadores(){
        Juego juego = new Juego();
        juego.agregarJugadores(3);

        assertEquals(juego.obtenerCantJugadores(), 3);
    }

    @Test
    public void test03CreoUnJuegoYLeAsigno1JugadoresYLaCantidadNoEsValida(){
        Juego juego = new Juego();
        try {
            juego.agregarJugadores(1);
        }catch (CantidadErroneaDeJugadoresError error) {
            assertEquals("El numero de jugadores debe estar entre 2-6",error.getMessage());
        }
    }
/*
    @Test
    public test04CreoUnJuegoYLeAsigno7JugadoresYLaCantidadNoEsValida (){
        Juego juego = Juego();
        assertThrows(CantidadErroneaDeJugadores.class, () -> juego.agregarJugadores(7));
    }

    @Test
    public test05CreoUnJuegoYLeAsigno6JugadoresYLaCantidadEsValida (){
        Juego juego = Juego();
        assertEquals(obtenerCantJugadores(juego), 6);
    }

    @Test
    public test06CreoUnJuegoYLeAsigno300JugadoresYLaCantidadNoEsValida (){
        Juego juego = Juego();
        assertThrows(CantidadErroneaDeJugadores.class, () -> juego.agregarJugadores(300));
    }

    @Test
    public test07CreoUnJuegoYLeAsignoJugadoresYInicioElJuegoYTodosLosPaisesTienenDueño (){
        Juego juego = Juego();

        juego.agregarJugadores(6);
        juego.inicializarJuego;
        Tablero tablero = obtenerTablero(juego);

        assertEquals(len(tablero.listaPaisesVacios, 0)
    }

    @Test
    public test08CreoUnJuegoYLeAsignoJugadoresYInicioElJuegoYTodosLosPaisesTienen1Ejercito (){
        Juego juego = Juego();

        juego.agregarJugadores(6);
        juego.inicializarJuego;
        Tablero tablero = obtenerTablero(juego);
        boolean cantidadEjercitosIncorrecta = false;
        for (int i=0; i < len(tablero.listaPaises); i++) {
            if (cantPaises(tablero.listaPaises[i]) != 1) {
                cantidadEjercitosIncorrecta = true;
                break;
            }
        }
        assertTrue(cantidadEjercitosIncorrecta);
    }

    @Test
    public test09CreoUnJuegoYLeAsigno2JugadoresYInicioElJuegoYLosPaisesFueronRepartidosEquitativamente (){
        Juego juego = Juego();

        juego.agregarJugadores(2);
        juego.inicializarJuego;
        Tablero tablero = obtenerTablero(juego);
        for (int i=0; i < len(tablero.listaJugadores); i++) {
            if (cantPaises(tablero.listaJugadores[i]) != 25) {
                cantidadPaisesIncorrecta = true;
                break;
            }
        }
        assertTrue(cantidadPaisesIncorrecta);
    }

    @Test
    public test10CreoUnJuegoYLeAsigno3JugadoresYInicioElJuegoYLosPaisesFueronRepartidosEquitativamente (){
        Juego juego = Juego();

        juego.agregarJugadores(3);
        juego.inicializarJuego;
        Tablero tablero = obtenerTablero(juego);
        int cont16 = 0;
        int cont17 = 0;

        for (int i=0; i < len(tablero.listaJugadores); i++) {
            if (cantPaises(tablero.listaJugadores[i] == 17))
                cont17++;
            else if (cantPaises(tablero.listaJugadores[i] == 16))
                cont16++;
        }
        assertTrue(cont16 == 1 && cont17 == 2);
    }

    @Test
    public test11CreoUnJuegoYLeAsigno4JugadoresYInicioElJuegoYLosPaisesFueronRepartidosEquitativamente (){
        Juego juego = Juego();

        juego.agregarJugadores(4);
        juego.inicializarJuego;
        Tablero tablero = obtenerTablero(juego);
        int cont12 = 0;
        int cont13 = 0;

        for (int i=0; i < len(tablero.listaJugadores); i++) {
            if (cantPaises(tablero.listaJugadores[i] == 12))
                cont12++;
            else if (cantPaises(tablero.listaJugadores[i] == 13))
                cont13++;
        }
        assertTrue(cont12 == 2 && cont13 == 2);
    }

    @Test
    public test12CreoUnJuegoYLeAsigno5JugadoresYInicioElJuegoYLosPaisesFueronRepartidosEquitativamente (){
        Juego juego = Juego();

        juego.agregarJugadores(5);
        juego.inicializarJuego;
        Tablero tablero = obtenerTablero(juego);

        for (int i=0; i < len(tablero.listaJugadores); i++) {
            if (cantPaises(tablero.listaJugadores[i]) != 10) {
                cantidadPaisesIncorrecta = true;
                break;
            }
        }
        assertTrue(cantidadPaisesIncorrecta);
    }
    @Test

    public test13CreoUnJuegoYLeAsigno6JugadoresYInicioElJuegoYLosPaisesFueronRepartidosEquitativamente (){
        Juego juego = Juego();

        juego.agregarJugadores(6);
        juego.inicializarJuego;
        Tablero tablero = obtenerTablero(juego);
        int cont8 = 0;
        int cont9 = 0;

        for (int i=0; i < len(tablero.listaJugadores); i++) {
            if (cantPaises(tablero.listaJugadores[i] == 9))
                cont9++;
            else if (cantPaises(tablero.listaJugadores[i] == 8))
                cont8++;
        }
        assertTrue(cont8 == 4 && cont9 == 2);
    }

    @Test
    public void test14CreoUnJuegoYLeAsigno2JugadoresYInicioElJuegoYElJugador1PoneEjercitosEnUnPaisAjeno (){
        Juego juego = Juego();

        juego.agregarJugadores(2);
        juego.inicializarJuego;

        List lista_jugadores = juego.getJugadoresList();
        Jugador jugador1 = lista_jugadores[0];
        List listaDePaisesJug1 = getPaisesJugador(jugador1);
        Jugador jugador2 = lista_jugadores[1];
        List listaDePaisesJug2 = getPaisesJugador(jugador2);

        assertThrows(ReforzarPaisAjenoException.class, () -> jugador1.reforzar(listaDePaisesJug2[0], 3));
    }

    @Test
    public void test15CreoUnJuegoYLeAsigno2JugadoresYInicioElJuegoYElJugador1PoneMasEjercitosDeLosQuePuedeEnUnPaisPropio (){
        Juego juego = Juego();

        juego.agregarJugadores(2);
        juego.inicializarJuego;

        List lista_jugadores = juego.getJugadoresList();
        Jugador jugador1 = lista_jugadores[0];
        List listaDePaisesJug1 = getPaisesJugador(jugador1);
        Jugador jugador2 = lista_jugadores[1];
        List listaDePaisesJug2 = getPaisesJugador(jugador2);

        assertThrows(CantidadAReforzarInvalidaException.class, () -> jugador1.reforzar(listaDePaisesJug1[0], 6));
    }

    @Test
    public void test16CreoUnJuegoYLeAsigno2JugadoresYInicioElJuegoYElJugador1PoneMasEjercitosDeLosQuePuedeEnUnPaisPropio (){
        Juego juego = Juego();

        juego.agregarJugadores(2);
        juego.inicializarJuego;

        List lista_jugadores = juego.getJugadoresList();
        Jugador jugador1 = lista_jugadores[0];
        List listaDePaisesJug1 = getPaisesJugador(jugador1);
        Jugador jugador2 = lista_jugadores[1];
        List listaDePaisesJug2 = getPaisesJugador(jugador2);

        assertThrows(CantidadAReforzarInvalidaException.class, () -> jugador1.reforzar(listaDePaisesJug1[0], 6));
    }

    @Test
    public void test17CreoUnJuegoYLeAsigno2JugadoresYInicioElJuegoYElJugador1Pone3EjercitosEnUnPaisPropio (){
        Juego juego = Juego();

        juego.agregarJugadores(2);
        juego.inicializarJuego;

        List lista_jugadores = juego.getJugadoresList();
        Jugador jugador1 = lista_jugadores[0];
        List listaDePaisesJug1 = getPaisesJugador(jugador1);
        Jugador jugador2 = lista_jugadores[1];
        List listaDePaisesJug2 = getPaisesJugador(jugador2);

        jugador1.reforzar(listaDePaisesJug1[0], 3);

        assertEquals(listaDePaisesJug1[0].cantidadEjercitos(), 4)
    }

    @Test
    public void test18CreoUnJuegoYLeAsigno2JugadoresYInicioElJuegoYElJugador1IntentaAtacarConUnPaisQueNoEsSuyo (){
        Juego juego = Juego();

        juego.agregarJugadores(2);
        juego.inicializarJuego;

        List lista_jugadores = juego.getJugadoresList();
        Jugador jugador1 = lista_jugadores[0];
        List listaDePaisesJug1 = juego.getPaisesJugador(jugador1);
        Jugador jugador2 = lista_jugadores[1];
        List listaDePaisesJug2 = getPaisesJugador(jugador2);

        Pais paisAtacante = listaDePaisesJug1[0];
        List listaLimitrofesAtacante = paisAtacante.getLimitrofesAjenos();
        Pais paisDefensor = listaLimitrofesAtacante[0];

        paisAtacante.reforzar(3);
        paisDefensor.reforzar(3);

        assertThrows(AtaqueConPaisAjenoException.class, () -> jugador1.atacar(listaDePaisesJug2[0], listaDePaisesJug2[1]));
    }

    @Test
    public void test19CreoUnJuegoYLeAsigno2JugadoresYInicioElJuegoYElJugador1Ataca (){
        Juego juego = Juego();

        juego.agregarJugadores(2);
        juego.inicializarJuego;

        List lista_jugadores = juego.getJugadoresList();
        Jugador jugador1 = lista_jugadores[0];
        List listaDePaisesJug1 = getPaisesJugador(jugador1);
        Jugador jugador2 = lista_jugadores[1];
        List listaDePaisesJug2 = getPaisesJugador(jugador2);

    }

    @Test
    public void test20Jugador1AtacaUnPaisConquistadoPorElMismo (){
        Juego juego = Juego();

        juego.agregarJugadores(2);
        juego.inicializarJuego;

        List lista_jugadores = juego.getJugadoresList();
        Jugador jugador1 = lista_jugadores[0];
        List listaDePaisesJug1 = jugador1.getPaisesJugador();
        Jugador jugador2 = lista_jugadores[1];
        List listaDePaisesJug2 = jugador2.getPaisesJugador();

        Pais paisAtacante = listaDePaisesJug1[0];
        paisAtacante.reforzar(3)
        List listaAdyacentesPropios = paisAtacante.getLimitrofesPropios();
        Pais paisDefensor = listaAdyacentesPropios[0];

        assertThrows(AtaqueAUnPaisPropioException.class, () -> jugador1.atacar(paisAtacante, paisDefensor));
    }

    @Test
    public void test2xJugador1AtacaUnPaisAjenoPeroNoLimitrofe (){
        Juego juego = Juego();

        juego.agregarJugadores(2);
        juego.inicializarJuego;

        List lista_jugadores = juego.getJugadoresList();
        Jugador jugador1 = lista_jugadores[0];
        List listaDePaisesJug1 = getPaisesJugador(jugador1);
        Jugador jugador2 = lista_jugadores[1];
        List listaDePaisesJug2 = getPaisesJugador(jugador2);

        Pais pais = listaDePaisesJug1[0];
        List limitrofes = pais.getLimitrofes();



    }

    @Test
    public void test2xJugador1AtacaUnPaisAjenoPeroNoTieneSuficientesEjercitos (){
        Juego juego = Juego();

        juego.agregarJugadores(2);
        juego.inicializarJuego;

        List lista_jugadores = juego.getJugadoresList();
        Jugador jugador1 = lista_jugadores[0];
        List listaDePaisesJug1 = getPaisesJugador(jugador1);
        Jugador jugador2 = lista_jugadores[1];
        List listaDePaisesJug2 = getPaisesJugador(jugador2);

        Pais paisAtacante = listaDePaisesJug1[0];
        List listaLimitrofesAtacante = paisAtacante.getLimitrofesAjenos();
        Pais paisDefensor = listaLimitrofesAtacante[0];
        assertTrue()
    }
*/
}


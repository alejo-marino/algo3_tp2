package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TestSistemaDeTurnos {
        @Test
        public void test01CreoUnSistemaDeTurnosYNoEsNull () {
            Jugador jugador1 = new Jugador("000000");
            Jugador jugador2 = new Jugador("ffffff");
            Jugador jugador3 = new Jugador("ff0000");

            Queue<Integer> cola = new LinkedList<>();
            cola.add(5);    // Primera Ronda Inicial dejara a cada jugador poner 5 ejercitos en sus paises.
            cola.add(3);    // Segunda Ronda Inicial dejara a cada jugador poner 3 ejercitos en sus paises. Luego de esta Ronda, comenzara la Fase De Juego.

            Pais argentina = new Pais("Argentina",jugador1);
            Pais uruguay = new Pais("Uruguay",jugador2);
            Pais china = new Pais("China",jugador3);
            ArrayList<Jugador> listaJugadores = new ArrayList<>();

            listaJugadores.add(jugador1);
            listaJugadores.add(jugador2);
            listaJugadores.add(jugador3);
            ArrayList<Pais> paises = new ArrayList<>();
            paises.add(argentina);
            paises.add(uruguay);
            paises.add(china);
            argentina.hacerLimitrofe(uruguay);
            uruguay.hacerLimitrofe(argentina);
            Tablero tablero = new Tablero(paises);

            SistemaDeTurnos sistema = new SistemaDeTurnos(listaJugadores, tablero, cola);
            assertNotNull(sistema);
        }

    @Test
    public void test02CreoUnSistemaDeTurnosYComienzaElJugadorCorrecto () {
        Jugador jugador1 = new Jugador("000000");
        Jugador jugador2 = new Jugador("ffffff");
        Jugador jugador3 = new Jugador("ff0000");

        Pais argentina = new Pais("Argentina",jugador1);
        Pais uruguay = new Pais("Uruguay",jugador2);
        Pais china = new Pais("China",jugador3);
        ArrayList<Jugador> listaJugadores = new ArrayList<>();

        Queue<Integer> cola = new LinkedList<>();
        cola.add(5);
        cola.add(3);

        listaJugadores.add(jugador1);
        listaJugadores.add(jugador2);
        listaJugadores.add(jugador3);
        ArrayList<Pais> paises = new ArrayList<>();
        paises.add(argentina);
        paises.add(uruguay);
        paises.add(china);
        argentina.hacerLimitrofe(uruguay);
        uruguay.hacerLimitrofe(argentina);
        Tablero tablero = new Tablero(paises);

        SistemaDeTurnos sistema = new SistemaDeTurnos(listaJugadores, tablero, cola);
        assertEquals(jugador1, sistema.turnoDe());
    }

    @Test
    public void test03CreoUnSistemaDeTurnosYJugadorNoPuedeSeleccionarUnPaisAjeno () {
        Jugador jugador1 = new Jugador("000000");
        Jugador jugador2 = new Jugador("ffffff");
        Jugador jugador3 = new Jugador("ff0000");

        Pais argentina = new Pais("Argentina",jugador1);
        Pais uruguay = new Pais("Uruguay",jugador2);
        Pais china = new Pais("China",jugador3);
        ArrayList<Jugador> listaJugadores = new ArrayList<>();

        Queue<Integer> cola = new LinkedList<>();
        cola.add(5);
        cola.add(3);

        listaJugadores.add(jugador1);
        listaJugadores.add(jugador2);
        listaJugadores.add(jugador3);
        ArrayList<Pais> paises = new ArrayList<>();
        paises.add(argentina);
        paises.add(uruguay);
        paises.add(china);
        argentina.hacerLimitrofe(uruguay);
        uruguay.hacerLimitrofe(argentina);
        Tablero tablero = new Tablero(paises);

        SistemaDeTurnos sistema = new SistemaDeTurnos(listaJugadores,tablero, cola);
        sistema.reforzar(argentina, 2);
        assertThrows(SeleccionaPaisAjenoException.class, () -> sistema.seleccionarPais("Uruguay"));
    }

    @Test
    public void test04CreoUnSistemaDeTurnosYJugadorPuedeSeleccionarUnPaisPropio () {
        Jugador jugador1 = new Jugador("000000");
        Jugador jugador2 = new Jugador("ffffff");
        Jugador jugador3 = new Jugador("ff0000");

        Pais argentina = new Pais("Argentina",jugador1);
        Pais uruguay = new Pais("Uruguay",jugador2);
        Pais china = new Pais("China",jugador3);
        ArrayList<Jugador> listaJugadores = new ArrayList<>();

        Queue<Integer> cola = new LinkedList<>();
        cola.add(5);
        cola.add(3);

        listaJugadores.add(jugador1);
        listaJugadores.add(jugador2);
        listaJugadores.add(jugador3);
        ArrayList<Pais> paises = new ArrayList<>();
        paises.add(argentina);
        paises.add(uruguay);
        paises.add(china);
        argentina.hacerLimitrofe(uruguay);
        uruguay.hacerLimitrofe(argentina);
        Tablero tablero = new Tablero(paises);

        SistemaDeTurnos sistema = new SistemaDeTurnos(listaJugadores,tablero, cola);
        Pais unPais = sistema.seleccionarPais("Argentina");
        assertEquals(unPais,argentina);
    }

    @Test
    public void test05CreoUnSistemaDeTurnosYPasoDeTurnoYJugador2NoPuedeSeleccionarPaisDeJugador1 () {
        Jugador jugador1 = new Jugador("000000");
        Jugador jugador2 = new Jugador("ffffff");
        Jugador jugador3 = new Jugador("ff0000");

        Pais argentina = new Pais("Argentina",jugador1);
        Pais uruguay = new Pais("Uruguay",jugador2);
        Pais china = new Pais("China",jugador3);
        ArrayList<Jugador> listaJugadores = new ArrayList<>();

        Queue<Integer> cola = new LinkedList<>();
        cola.add(5);
        cola.add(3);

        listaJugadores.add(jugador1);
        listaJugadores.add(jugador2);
        listaJugadores.add(jugador3);
        ArrayList<Pais> paises = new ArrayList<>();
        paises.add(argentina);
        paises.add(uruguay);
        paises.add(china);
        argentina.hacerLimitrofe(uruguay);
        uruguay.hacerLimitrofe(argentina);
        Tablero tablero = new Tablero(paises);

        SistemaDeTurnos sistema = new SistemaDeTurnos(listaJugadores,tablero, cola);
        sistema.reforzar(argentina, 5);
        sistema.siguienteTurno();
        assertThrows(SeleccionaPaisAjenoException.class, () -> sistema.seleccionarPais("Argentina"));
    }

   @Test
    public void test05CreoUnSistemaDeTurnosYCambiaElTurnoCorrectamente () {
        Jugador jugador1 = new Jugador("000000");
        Jugador jugador2 = new Jugador("ffffff");
        Jugador jugador3 = new Jugador("ff0000");

        Pais argentina = new Pais("Argentina",jugador1);
        Pais uruguay = new Pais("Uruguay",jugador2);
        Pais china = new Pais("China",jugador3);
        ArrayList<Jugador> listaJugadores = new ArrayList<>();

        Queue<Integer> cola = new LinkedList<>();
        cola.add(5);
        cola.add(3);

        listaJugadores.add(jugador1);
        listaJugadores.add(jugador2);
        listaJugadores.add(jugador3);
        ArrayList<Pais> paises = new ArrayList<>();
        paises.add(argentina);
        paises.add(uruguay);
        paises.add(china);
        argentina.hacerLimitrofe(uruguay);
        uruguay.hacerLimitrofe(argentina);
        Tablero tablero = new Tablero(paises);

        SistemaDeTurnos sistema = new SistemaDeTurnos(listaJugadores, tablero, cola);
        Pais unPais = sistema.seleccionarPais("Argentina");
        sistema.reforzar(unPais, 5);
        sistema.siguienteTurno();
        assertEquals(jugador2, sistema.turnoDe());
    }

    @Test
    public void test04CreoUnSistemaDeTurnosYHagoUnaRondaCompletaYVuelveAlPrimerJugador () {
        Jugador jugador1 = new Jugador("000000");
        Jugador jugador2 = new Jugador("ffffff");
        Jugador jugador3 = new Jugador("ff0000");

        Pais argentina = new Pais("Argentina",jugador1);
        Pais uruguay = new Pais("Uruguay",jugador2);
        Pais china = new Pais("China",jugador3);
        ArrayList<Jugador> listaJugadores = new ArrayList<>();

        Queue<Integer> cola = new LinkedList<>();
        cola.add(5);
        cola.add(3);

        listaJugadores.add(jugador1);
        listaJugadores.add(jugador2);
        listaJugadores.add(jugador3);
        ArrayList<Pais> paises = new ArrayList<>();
        paises.add(argentina);
        paises.add(uruguay);
        paises.add(china);
        argentina.hacerLimitrofe(uruguay);
        uruguay.hacerLimitrofe(argentina);
        Tablero tablero = new Tablero(paises);

        SistemaDeTurnos sistema = new SistemaDeTurnos(listaJugadores, tablero,cola );
        Pais unPais = sistema.seleccionarPais("Argentina");
        sistema.reforzar(unPais, 5);
        sistema.siguienteTurno();
        Pais unPais1 = sistema.seleccionarPais("Uruguay");
        sistema.reforzar(unPais1, 5);
        sistema.siguienteTurno();
        Pais unPais2 = sistema.seleccionarPais("China");
        sistema.reforzar(unPais2, 5);
        sistema.siguienteTurno();
        assertEquals(jugador1, sistema.turnoDe());
    }

    @Test
    public void test05CreoUnSistemaDeTurnosYJugadorColocanCincoEjercitosCorrectamente () {
        Jugador jugador1 = new Jugador("000000");
        Jugador jugador2 = new Jugador("ffffff");
        Jugador jugador3 = new Jugador("ff0000");

        Pais argentina = new Pais("Argentina",jugador1);
        Pais uruguay = new Pais("Uruguay",jugador2);
        Pais china = new Pais("China",jugador3);
        ArrayList<Jugador> listaJugadores = new ArrayList<>();

        Queue<Integer> cola = new LinkedList<>();
        cola.add(5);
        cola.add(3);

        listaJugadores.add(jugador1);
        listaJugadores.add(jugador2);
        listaJugadores.add(jugador3);
        ArrayList<Pais> paises = new ArrayList<>();
        paises.add(argentina);
        paises.add(uruguay);
        paises.add(china);
        argentina.hacerLimitrofe(uruguay);
        uruguay.hacerLimitrofe(argentina);
        Tablero tablero = new Tablero(paises);

        SistemaDeTurnos sistema = new SistemaDeTurnos(listaJugadores,tablero, cola);
        Pais unPais = sistema.seleccionarPais("Argentina");
        sistema.reforzar(unPais, 5);
        assertEquals(6, argentina.getEjercitos());
    }

    @Test
    public void test06CreoUnSistemaDeTurnosYJugadorNoPuedeColocarMasDeCincoFichas () {
        Jugador jugador1 = new Jugador("000000");
        Jugador jugador2 = new Jugador("ffffff");
        Jugador jugador3 = new Jugador("ff0000");

        Pais argentina = new Pais("Argentina",jugador1);
        Pais uruguay = new Pais("Uruguay",jugador2);
        Pais china = new Pais("China",jugador3);
        ArrayList<Jugador> listaJugadores = new ArrayList<>();

        Queue<Integer> cola = new LinkedList<>();
        cola.add(5);
        cola.add(3);

        listaJugadores.add(jugador1);
        listaJugadores.add(jugador2);
        listaJugadores.add(jugador3);
        ArrayList<Pais> paises = new ArrayList<>();
        paises.add(argentina);
        paises.add(uruguay);
        paises.add(china);
        argentina.hacerLimitrofe(uruguay);
        uruguay.hacerLimitrofe(argentina);
        Tablero tablero = new Tablero(paises);

        SistemaDeTurnos sistema = new SistemaDeTurnos(listaJugadores,tablero, cola);
        Pais unPais = sistema.seleccionarPais("Argentina");
        sistema.reforzar(unPais, 2);
        assertThrows(NoPuedeColocarTantosEjercitosException.class, () -> sistema.reforzar(argentina, 4));

    }
    @Test
    public void test07CreoUnSistemaDeTurnosYJugadoresColocanCincoFichasCorrectamente () {
        Jugador jugador1 = new Jugador("000000");
        Jugador jugador2 = new Jugador("ffffff");
        Jugador jugador3 = new Jugador("ff0000");

        Pais argentina = new Pais("Argentina",jugador1);
        Pais uruguay = new Pais("Uruguay",jugador2);
        Pais china = new Pais("China",jugador3);
        ArrayList<Jugador> listaJugadores = new ArrayList<>();

        Queue<Integer> cola = new LinkedList<>();
        cola.add(5);
        cola.add(3);

        listaJugadores.add(jugador1);
        listaJugadores.add(jugador2);
        listaJugadores.add(jugador3);
        ArrayList<Pais> paises = new ArrayList<>();
        paises.add(argentina);
        paises.add(uruguay);
        paises.add(china);
        argentina.hacerLimitrofe(uruguay);
        uruguay.hacerLimitrofe(argentina);
        Tablero tablero = new Tablero(paises);

        SistemaDeTurnos sistema = new SistemaDeTurnos(listaJugadores,tablero, cola);
        Pais unPais = sistema.seleccionarPais("Argentina");
        sistema.reforzar(unPais, 5);
        sistema.siguienteTurno();
        Pais unPais1 = sistema.seleccionarPais("Uruguay");

        sistema.reforzar(unPais1, 5);
        sistema.siguienteTurno();
        Pais unPais2 = sistema.seleccionarPais("China");

        sistema.reforzar(unPais, 5);

        int cantidadTropasTotales = 0;
        cantidadTropasTotales += argentina.getEjercitos();
        cantidadTropasTotales += uruguay.getEjercitos();
        cantidadTropasTotales += china.getEjercitos();

        assertEquals(18, cantidadTropasTotales);
    }

    @Test
    public void test07CreoUnSistemaDeTurnosYJugadoresColocanCincoYDespuesNoPuedenColocarCinco () {
        Jugador jugador1 = new Jugador("000000");
        Jugador jugador2 = new Jugador("ffffff");
        Jugador jugador3 = new Jugador("ff0000");

        Pais argentina = new Pais("Argentina",jugador1);
        Pais uruguay = new Pais("Uruguay",jugador2);
        Pais china = new Pais("China",jugador3);
        ArrayList<Jugador> listaJugadores = new ArrayList<>();

        Queue<Integer> cola = new LinkedList<>();
        cola.add(5);
        cola.add(3);

        listaJugadores.add(jugador1);
        listaJugadores.add(jugador2);
        listaJugadores.add(jugador3);
        ArrayList<Pais> paises = new ArrayList<>();
        paises.add(argentina);
        paises.add(uruguay);
        paises.add(china);
        argentina.hacerLimitrofe(uruguay);
        uruguay.hacerLimitrofe(argentina);
        Tablero tablero = new Tablero(paises);

        SistemaDeTurnos sistema = new SistemaDeTurnos(listaJugadores,tablero, cola);
        sistema.reforzar(argentina, 5);
        sistema.siguienteTurno();
        sistema.reforzar(uruguay, 5);
        sistema.siguienteTurno();
        sistema.reforzar(china, 5);

        sistema.siguienteTurno();

        assertThrows(NoPuedeColocarTantosEjercitosException.class, () -> sistema.reforzar(argentina, 5));
    }

    @Test
    public void test08SeColocanTodosLosEjercitosEnLaFaseIncialCorrectamente() {
        Jugador jugador1 = new Jugador("000000");
        Jugador jugador2 = new Jugador("ffffff");
        Jugador jugador3 = new Jugador("ff0000");

        Pais argentina = new Pais("Argentina",jugador1);
        Pais uruguay = new Pais("Uruguay",jugador2);
        Pais china = new Pais("China",jugador3);
        ArrayList<Jugador> listaJugadores = new ArrayList<>();

        Queue<Integer> cola = new LinkedList<>();
        cola.add(5);
        cola.add(3);

        listaJugadores.add(jugador1);
        listaJugadores.add(jugador2);
        listaJugadores.add(jugador3);
        ArrayList<Pais> paises = new ArrayList<>();
        paises.add(argentina);
        paises.add(uruguay);
        paises.add(china);
        argentina.hacerLimitrofe(uruguay);
        uruguay.hacerLimitrofe(argentina);
        Tablero tablero = new Tablero(paises);

        SistemaDeTurnos sistema = new SistemaDeTurnos(listaJugadores,tablero, cola);
        sistema.reforzar(argentina, 5);
        sistema.siguienteTurno();
        sistema.reforzar(uruguay, 5);
        sistema.siguienteTurno();
        sistema.reforzar(china, 5);
        sistema.siguienteTurno();
        sistema.reforzar(argentina, 3);
        sistema.siguienteTurno();
        sistema.reforzar(uruguay, 3);
        sistema.siguienteTurno();
        sistema.reforzar(china, 3);

        int cantidadTropasTotales = 0;
        cantidadTropasTotales += argentina.getEjercitos();
        cantidadTropasTotales += uruguay.getEjercitos();
        cantidadTropasTotales += china.getEjercitos();

        assertEquals(27, cantidadTropasTotales);

    }
    @Test
    public void test09SeColocanTodosLosEjercitosEnLaFaseIncialCorrectamenteYComienzaLaFaseDeJuego() {
        Jugador jugador1 = new Jugador("000000");
        Jugador jugador2 = new Jugador("ffffff");
        Jugador jugador3 = new Jugador("ff0000");

        Pais argentina = new Pais("Argentina",jugador1);
        Pais uruguay = new Pais("Uruguay",jugador2);
        Pais china = new Pais("China",jugador3);
        ArrayList<Jugador> listaJugadores = new ArrayList<>();

        Queue<Integer> cola = new LinkedList<>();
        cola.add(5);
        cola.add(3);

        listaJugadores.add(jugador1);
        listaJugadores.add(jugador2);
        listaJugadores.add(jugador3);
        ArrayList<Pais> paises = new ArrayList<>();
        paises.add(argentina);
        paises.add(uruguay);
        paises.add(china);
        argentina.hacerLimitrofe(uruguay);
        uruguay.hacerLimitrofe(argentina);
        Tablero tablero = new Tablero(paises);

        SistemaDeTurnos sistema = new SistemaDeTurnos(listaJugadores,tablero, cola);
        sistema.reforzar(argentina, 5);
        sistema.siguienteTurno();
        sistema.reforzar(uruguay, 5);
        sistema.siguienteTurno();
        sistema.reforzar(china, 5);
        sistema.siguienteTurno();
        sistema.reforzar(argentina, 3);
        sistema.siguienteTurno();
        sistema.reforzar(uruguay, 3);
        sistema.siguienteTurno();
        sistema.reforzar(china, 3);
        sistema.siguienteTurno();

        assertEquals("Fase de juego", sistema.getFaseActual());
    }

    @Test
    public void test10CreoUnSistemaDeTurnosYJugadorNoPuedeColocarMenosDeCincoFichas () {
        Jugador jugador1 = new Jugador("000000");
        Jugador jugador2 = new Jugador("ffffff");
        Jugador jugador3 = new Jugador("ff0000");

        Pais argentina = new Pais("Argentina",jugador1);
        Pais uruguay = new Pais("Uruguay",jugador2);
        Pais china = new Pais("China",jugador3);
        ArrayList<Jugador> listaJugadores = new ArrayList<>();

        Queue<Integer> cola = new LinkedList<>();
        cola.add(5);
        cola.add(3);

        listaJugadores.add(jugador1);
        listaJugadores.add(jugador2);
        listaJugadores.add(jugador3);
        ArrayList<Pais> paises = new ArrayList<>();
        paises.add(argentina);
        paises.add(uruguay);
        paises.add(china);
        argentina.hacerLimitrofe(uruguay);
        uruguay.hacerLimitrofe(argentina);
        Tablero tablero = new Tablero(paises);

        SistemaDeTurnos sistema = new SistemaDeTurnos(listaJugadores,tablero, cola);
        sistema.reforzar(argentina, 2);
        assertThrows(NoReforzoTodosLosEjercitosException.class, () -> sistema.siguienteTurno());
    }

    @Test
    public void test11CreoUnSistemaDeTurnosYNoPuedoAtacar () {
        Jugador jugador1 = new Jugador("000000");
        Jugador jugador2 = new Jugador("ffffff");
        Jugador jugador3 = new Jugador("ff0000");

        Pais argentina = new Pais("Argentina",jugador1);
        Pais uruguay = new Pais("Uruguay",jugador2);
        Pais china = new Pais("China",jugador3);
        ArrayList<Jugador> listaJugadores = new ArrayList<>();

        Queue<Integer> cola = new LinkedList<>();
        cola.add(5);
        cola.add(3);

        listaJugadores.add(jugador1);
        listaJugadores.add(jugador2);
        listaJugadores.add(jugador3);
        ArrayList<Pais> paises = new ArrayList<>();
        paises.add(argentina);
        paises.add(uruguay);
        paises.add(china);
        argentina.hacerLimitrofe(uruguay);
        uruguay.hacerLimitrofe(argentina);
        Tablero tablero = new Tablero(paises);

        SistemaDeTurnos sistema = new SistemaDeTurnos(listaJugadores,tablero, cola);
        sistema.reforzar(argentina, 2);
        assertThrows(AtaqueInvalidoException.class, () -> sistema.atacar(argentina, uruguay, 3));
    }

    @Test
    public void test12CreoUnSistemaDeTurnosYNoPuedoReagrupar () {
        Jugador jugador1 = new Jugador("000000");
        Jugador jugador2 = new Jugador("ffffff");
        Jugador jugador3 = new Jugador("ff0000");

        Pais argentina = new Pais("Argentina",jugador1);
        Pais uruguay = new Pais("Uruguay",jugador2);
        Pais china = new Pais("China",jugador3);
        ArrayList<Jugador> listaJugadores = new ArrayList<>();

        Queue<Integer> cola = new LinkedList<>();
        cola.add(5);
        cola.add(3);

        listaJugadores.add(jugador1);
        listaJugadores.add(jugador2);
        listaJugadores.add(jugador3);
        ArrayList<Pais> paises = new ArrayList<>();
        paises.add(argentina);
        paises.add(uruguay);
        paises.add(china);
        argentina.hacerLimitrofe(uruguay);
        uruguay.hacerLimitrofe(argentina);
        Tablero tablero = new Tablero(paises);

        SistemaDeTurnos sistema = new SistemaDeTurnos(listaJugadores,tablero, cola);
        sistema.reforzar(argentina, 2);
        assertThrows(ReagrupeInvalidoException.class, () -> sistema.reagrupar(argentina, uruguay, 3));
    }


//    @Test
//    public void test12CreoUnSistemaDeTurnosYJugadorNoPuedeColocarMenosDeCincoFichas () {
//        Jugador jugador1 = new Jugador("000000");
//        Jugador jugador2 = new Jugador("ffffff");
//        Jugador jugador3 = new Jugador("ff0000");
//
//        Pais argentina = new Pais("Argentina",jugador1);
//        Pais uruguay = new Pais("Uruguay",jugador2);
//        Pais china = new Pais("China",jugador3);
//        ArrayList<Jugador> listaJugadores = new ArrayList<>();
//
//        Queue<Integer> cola = new LinkedList<>();
//        cola.add(5);
//        cola.add(3);
//
//        listaJugadores.add(jugador1);
//        listaJugadores.add(jugador2);
//        listaJugadores.add(jugador3);
//        ArrayList<Pais> paises = new ArrayList<>();
//        paises.add(argentina);
//        paises.add(uruguay);
//        paises.add(china);
//        argentina.hacerLimitrofe(uruguay);
//        uruguay.hacerLimitrofe(argentina);
//        Tablero tablero = new Tablero(paises);
//        argentina.reforzar(3);
//
//        SistemaDeTurnos sistema = new SistemaDeTurnos(listaJugadores,tablero, cola);
//        sistema.reforzar(argentina, 5);
//        sistema.siguienteTurno();
//        sistema.reforzar(uruguay, 5);
//        sistema.siguienteTurno();
//        sistema.reforzar(china, 5);
//        sistema.siguienteTurno();
//        sistema.reforzar(argentina, 3);
//        sistema.siguienteTurno();
//        sistema.reforzar(uruguay, 3);
//        sistema.siguienteTurno();
//        sistema.reforzar(china, 3);
//        sistema.siguienteTurno();
//
//        Pais paisAtacante = sistema.seleccionarPais("Argentina");
//        assertThrows(AtaqueAPaisPropioException.class,() -> sistema.seleccionarPais("Uruguay"));
//    }
    
    /*@Test
    public void test06CreoUnSistemaDeTurnosYEmpiezaEnFaseInicial () {
        Jugador jugador1 = new Jugador("000000");
        Jugador jugador2 = new Jugador("ffffff");
        Jugador jugador3 = new Jugador("ff0000");

        Pais argentina = new Pais("Argentina",jugador1);
        Pais uruguay = new Pais("Uruguay",jugador2);
        Pais china = new Pais("China",jugador3);
        ArrayList<Jugador> listaJugadores = new ArrayList<>();

        listaJugadores.add(jugador1);
        listaJugadores.add(jugador2);
        listaJugadores.add(jugador3);
        ArrayList<Pais> paises = new ArrayList<>();
        paises.add(argentina);
        paises.add(uruguay);
        paises.add(china);
        argentina.hacerLimitrofe(uruguay);
        uruguay.hacerLimitrofe(argentina);
        Tablero tablero = new Tablero(paises);

        SistemaDeTurnos sistema = new SistemaDeTurnos(listaJugadores, tablero);
        assertEquals("Fase inicial", sistema.getFaseActual());
    }*/
}
package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

public class TestRondaDeAtaqueYReagrupe {

    @Test
    public void test01CreoUnaRondaDeAtaqueYReagrupeYNoEsNull() {
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

        RondaDeAtaqueYReagrupe ronda = new RondaDeAtaqueYReagrupe(tablero);
        assertNotNull(ronda);
    }

    @Test
    public void test02CreoUnaRondaDeAtaqueYReagrupeYNoPuedoSeleccionarUnPaisAjenoLaPrimeraVez() {
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

        RondaDeAtaqueYReagrupe ronda = new RondaDeAtaqueYReagrupe(tablero);
        assertThrows(SeleccionaPaisAjenoException.class, () -> ronda.seleccionarPais("Uruguay", jugador1));
    }

    @Test
    public void test03CreoUnaRondaDeAtaqueYReagrupeYNoPuedoSeleccionarUnPaisConUnEjercitoLaPrimeraVez() {
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

        RondaDeAtaqueYReagrupe ronda = new RondaDeAtaqueYReagrupe(tablero);
        assertThrows(EjercitosInvalidosException.class, () -> ronda.seleccionarPais("Argentina", jugador1));
    }

    @Test
    public void test04CreoUnaRondaDeAtaqueYReagrupeYPuedoSeleccionarUnPaisPropioLaPrimeraVez() {
        Jugador jugador1 = new Jugador("000000");
        Jugador jugador2 = new Jugador("ffffff");
        Jugador jugador3 = new Jugador("ff0000");

        Pais argentina = new Pais("Argentina",jugador1);
        Pais uruguay = new Pais("Uruguay",jugador2);
        Pais china = new Pais("China",jugador3);
        argentina.reforzar(1);
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

        RondaDeAtaqueYReagrupe ronda = new RondaDeAtaqueYReagrupe(tablero);
        assertEquals(argentina, ronda.seleccionarPais("Argentina", jugador1));
    }

    @Test
    public void test05CreoUnaRondaDeAtaqueYReagrupeYNoPuedoSeleccionarUnPaisPropioLaSegundaVez() {
        Jugador jugador1 = new Jugador("000000");
        Jugador jugador2 = new Jugador("ffffff");
        Jugador jugador3 = new Jugador("ff0000");

        Pais argentina = new Pais("Argentina",jugador1);
        Pais uruguay = new Pais("Uruguay",jugador1);
        Pais china = new Pais("China",jugador3);
        argentina.reforzar(3);
        uruguay.reforzar(3);
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

        RondaDeAtaqueYReagrupe ronda = new RondaDeAtaqueYReagrupe(tablero);
        Pais paisAtacante = ronda.seleccionarPais("Argentina", jugador1);
        assertThrows(AtaqueAPaisPropioException.class , () -> ronda.seleccionarPais("Uruguay", jugador1));
    }

    @Test
    public void test06CreoUnaRondaDeAtaqueYReagrupeYPuedoSeleccionarUnPaisAjenoLaSegundaVez() {
        Jugador jugador1 = new Jugador("000000");
        Jugador jugador2 = new Jugador("ffffff");
        Jugador jugador3 = new Jugador("ff0000");

        Pais argentina = new Pais("Argentina",jugador1);
        Pais uruguay = new Pais("Uruguay",jugador2);
        Pais china = new Pais("China",jugador3);
        argentina.reforzar(3);
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

        RondaDeAtaqueYReagrupe ronda = new RondaDeAtaqueYReagrupe(tablero);
        ronda.seleccionarPais("Argentina", jugador1);
        assertEquals(uruguay, ronda.seleccionarPais("Uruguay", jugador1));
    }

    @Test
    public void test07CreoUnaRondaDeAtaqueYReagrupeYNoPuedoReforzar() {
        Jugador jugador1 = new Jugador("000000");
        Jugador jugador2 = new Jugador("ffffff");
        Jugador jugador3 = new Jugador("ff0000");

        Pais argentina = new Pais("Argentina",jugador1);
        Pais uruguay = new Pais("Uruguay",jugador1);
        Pais china = new Pais("China",jugador3);
        argentina.reforzar(3);
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

        RondaDeAtaqueYReagrupe ronda = new RondaDeAtaqueYReagrupe(tablero);
        Pais unPais = ronda.seleccionarPais("Argentina", jugador1);

        assertThrows(RefuerzoInvalidoException.class , () -> ronda.reforzar(3));
    }

    @Test
    public void test08CreoUnaRondaDeAtaqueYReagrupeYNoPuedoReagrupar() {
        Jugador jugador1 = new Jugador("000000");
        Jugador jugador2 = new Jugador("ffffff");
        Jugador jugador3 = new Jugador("ff0000");

        Pais argentina = new Pais("Argentina",jugador1);
        Pais uruguay = new Pais("Uruguay",jugador1);
        Pais china = new Pais("China",jugador3);
        argentina.reforzar(3);
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

        RondaDeAtaqueYReagrupe ronda = new RondaDeAtaqueYReagrupe(tablero);

        assertThrows(ReagrupeInvalidoException.class , () -> ronda.reagrupar(3));
    }

    @Test
    public void test09CreoUnaRondaDeAtaqueYReagrupeSeleccionoYNoPuedoSeleccionarTresPaises() {
        Jugador jugador1 = new Jugador("000000");
        Jugador jugador2 = new Jugador("ffffff");
        Jugador jugador3 = new Jugador("ff0000");

        Pais argentina = new Pais("Argentina",jugador1);
        Pais uruguay = new Pais("Uruguay",jugador2);
        Pais china = new Pais("China",jugador3);
        argentina.reforzar(3);
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

        RondaDeAtaqueYReagrupe ronda = new RondaDeAtaqueYReagrupe(tablero);
        ronda.seleccionarPais("Argentina", jugador1);
        ronda.seleccionarPais("Uruguay", jugador1);

        assertThrows(PaisesYaSeleccionadosException.class , () -> ronda.seleccionarPais("Uruguay", jugador1));
    }
    @Test
    public void test10CreoUnaRondaDeAtaqueYReagrupeYAtacoYSeModificanEjercitos() {
        Jugador jugador1 = new Jugador("000000");
        Jugador jugador2 = new Jugador("ffffff");
        Jugador jugador3 = new Jugador("ff0000");

        Pais argentina = new Pais("Argentina",jugador1);
        Pais uruguay = new Pais("Uruguay",jugador2);
        Pais china = new Pais("China",jugador3);
        argentina.reforzar(9);
        uruguay.reforzar(9);
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

        RondaDeAtaqueYReagrupe ronda = new RondaDeAtaqueYReagrupe(tablero);

        Pais paisAtacante = ronda.seleccionarPais("Argentina", jugador1);
        Pais paisDefensor = ronda.seleccionarPais("Uruguay", jugador1);
        int ejercitosIniciales = paisAtacante.getEjercitos() + paisDefensor.getEjercitos();
        ronda.atacar(3);
        assertEquals(ejercitosIniciales - 3, paisAtacante.getEjercitos() + paisDefensor.getEjercitos());
    }

    @Test
    public void test11CreoUnaRondaDeAtaqueYReagrupeYTerminoElAtaqueYNoPuedoAtacar() {
        Jugador jugador1 = new Jugador("000000");
        Jugador jugador2 = new Jugador("ffffff");
        Jugador jugador3 = new Jugador("ff0000");

        Pais argentina = new Pais("Argentina",jugador1);
        Pais uruguay = new Pais("Uruguay",jugador2);
        Pais china = new Pais("China",jugador3);
        argentina.reforzar(3);
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

        RondaDeAtaqueYReagrupe ronda = new RondaDeAtaqueYReagrupe(tablero);
        Pais unPais = ronda.seleccionarPais("Argentina", jugador1);
        Pais otroPais = ronda.seleccionarPais("Uruguay", jugador1);
        ronda.terminarAtaque();

        assertThrows(AtaqueInvalidoException.class , () -> ronda.atacar(2));
    }

    @Test
    public void test12CreoUnaRondaDeAtaqueYReagrupeTerminoElAtaqueYNoPuedoAtacar() {
        Jugador jugador1 = new Jugador("000000");
        Jugador jugador2 = new Jugador("ffffff");
        Jugador jugador3 = new Jugador("ff0000");

        Pais argentina = new Pais("Argentina",jugador1);
        Pais uruguay = new Pais("Uruguay",jugador1);
        Pais china = new Pais("China",jugador3);
        argentina.reforzar(3);
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

        RondaDeAtaqueYReagrupe ronda = new RondaDeAtaqueYReagrupe(tablero);
        ronda.terminarAtaque();
        ronda.seleccionarPais("Argentina", jugador1);
        ronda.seleccionarPais("Uruguay", jugador1);

        assertThrows(AtaqueInvalidoException.class , () -> ronda.atacar(2));
    }

    @Test
    public void test13CreoUnaRondaDeAtaqueYReagrupeYReagrupeTerminoElAtaqueYNoPuedoSeleccionarUnPaisAgeno() {
        Jugador jugador1 = new Jugador("000000");
        Jugador jugador2 = new Jugador("ffffff");
        Jugador jugador3 = new Jugador("ff0000");

        Pais argentina = new Pais("Argentina",jugador1);
        Pais uruguay = new Pais("Uruguay",jugador2);
        Pais china = new Pais("China",jugador3);
        argentina.reforzar(3);
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

        RondaDeAtaqueYReagrupe ronda = new RondaDeAtaqueYReagrupe(tablero);
        ronda.terminarAtaque();
        assertThrows(SeleccionaPaisAjenoException.class , () -> ronda.seleccionarPais("Uruguay", jugador1));
    }

    @Test
    public void test14CreoUnaRondaDeAtaqueYReagrupeYReagrupeTerminoElAtaqueYPuedoSeleccionarUnPaisPropio() {
        Jugador jugador1 = new Jugador("000000");
        Jugador jugador2 = new Jugador("ffffff");
        Jugador jugador3 = new Jugador("ff0000");

        Pais argentina = new Pais("Argentina",jugador1);
        Pais uruguay = new Pais("Uruguay",jugador2);
        Pais china = new Pais("China",jugador3);
        argentina.reforzar(3);
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

        RondaDeAtaqueYReagrupe ronda = new RondaDeAtaqueYReagrupe(tablero);
        ronda.terminarAtaque();
        assertEquals(argentina,ronda.seleccionarPais("Argentina", jugador1));
    }

    @Test
    public void test15CreoUnaRondaDeAtaqueYReagrupeYReagrupeTerminoElAtaqueSeleccionoUnPaisPropioYLuegoNoPuedoSeleccionarUnPaisAgeno() {
        Jugador jugador1 = new Jugador("000000");
        Jugador jugador2 = new Jugador("ffffff");
        Jugador jugador3 = new Jugador("ff0000");

        Pais argentina = new Pais("Argentina",jugador1);
        Pais uruguay = new Pais("Uruguay",jugador2);
        Pais china = new Pais("China",jugador3);
        argentina.reforzar(3);
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

        RondaDeAtaqueYReagrupe ronda = new RondaDeAtaqueYReagrupe(tablero);
        ronda.terminarAtaque();
        ronda.seleccionarPais("Argentina", jugador1);
        assertThrows(ReagrupeAPaisAjenoException.class, () -> ronda.seleccionarPais("Uruguay",jugador1));
    }

    @Test
    public void test16CreoUnaRondaDeAtaqueYReagrupeYReagrupeTerminoElAtaqueSeleccionoUnPaisPropioYLuegoSeleccionoOtroPais() {
        Jugador jugador1 = new Jugador("000000");
        Jugador jugador2 = new Jugador("ffffff");
        Jugador jugador3 = new Jugador("ff0000");

        Pais argentina = new Pais("Argentina",jugador1);
        Pais uruguay = new Pais("Uruguay",jugador1);
        Pais china = new Pais("China",jugador3);
        argentina.reforzar(3);
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

        RondaDeAtaqueYReagrupe ronda = new RondaDeAtaqueYReagrupe(tablero);
        ronda.terminarAtaque();
        ronda.seleccionarPais("Argentina", jugador1);
        assertEquals(ronda.seleccionarPais("Uruguay",jugador1), uruguay);
    }

    @Test
    public void test17UnPaisConTresEjercitosReagrupaDosHaciaOtroPaisYQuedaCon1Ejercito() {
        Jugador jugador1 = new Jugador("000000");
        Jugador jugador2 = new Jugador("ffffff");
        Jugador jugador3 = new Jugador("ff0000");

        Pais argentina = new Pais("Argentina",jugador1);
        Pais uruguay = new Pais("Uruguay",jugador1);
        Pais china = new Pais("China",jugador3);
        argentina.reforzar(2);
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
        RondaDeAtaqueYReagrupe ronda = new RondaDeAtaqueYReagrupe(tablero);
        ronda.terminarAtaque();
        ronda.seleccionarPais("Argentina", jugador1);
        ronda.seleccionarPais("Uruguay",jugador1);
        ronda.reagrupar(2);
        assertEquals(1, argentina.getEjercitos());
    }

    @Test
    public void test18UnPaisConTresEjercitosReagrupaDosHaciaOtroPaisConUnEjercitoYEsteQuedaConTres() {
        Jugador jugador1 = new Jugador("000000");
        Jugador jugador2 = new Jugador("ffffff");
        Jugador jugador3 = new Jugador("ff0000");

        Pais argentina = new Pais("Argentina",jugador1);
        Pais uruguay = new Pais("Uruguay",jugador1);
        Pais china = new Pais("China",jugador3);
        argentina.reforzar(3);
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
        argentina.reforzar(2);
        RondaDeAtaqueYReagrupe ronda = new RondaDeAtaqueYReagrupe(tablero);
        ronda.terminarAtaque();
        ronda.seleccionarPais("Argentina", jugador1);
        ronda.seleccionarPais("Uruguay",jugador1);
        ronda.reagrupar(2);
        assertEquals(uruguay.getEjercitos(),3);
    }

    @Test
    public void test19CreoUnaRondaDeRefuerzoYReagrupeYTerminoElAtaqueYPasoDeTurnoYElJugador2NoPuedeReagrupar() {
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
        argentina.reforzar(3);
        RondaDeAtaqueYReagrupe ronda = new RondaDeAtaqueYReagrupe(tablero);
        ronda.terminarAtaque();
        ronda.siguienteTurno();
        ronda.seleccionarPais("Argentina", jugador1);
        ronda.seleccionarPais("Uruguay", jugador1);
        assertThrows(ReagrupeInvalidoException.class, () -> ronda.reagrupar(3));
    }
}

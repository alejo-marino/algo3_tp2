package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class TestRondaDeAtaqueYReagrupe {

    private Jugador jugador1;
    private Jugador jugador2;
    private Jugador jugador3;
    private Pais argentina;
    private Pais uruguay;
    private Pais china;
    private Pais chile;
    private RondaDeAtaqueYReagrupe ronda;


    @BeforeEach
    void setUp() {
        this.jugador1 = new Jugador("000000");
        this.jugador2 = new Jugador("ffffff");
        this.jugador3 = new Jugador("fff000");
        ArrayList<Jugador> listaJugadores = new ArrayList<>();
        listaJugadores.add(jugador1);
        listaJugadores.add(jugador2);
        listaJugadores.add(jugador3);

        this.argentina = new Pais("Argentina",jugador1);
        this.uruguay = new Pais("Uruguay",jugador2);
        this.china = new Pais("China",jugador3);
        this.chile = new Pais("Chile", jugador1);
        argentina.hacerLimitrofe(uruguay);
        uruguay.hacerLimitrofe(argentina);
        argentina.hacerLimitrofe(chile);
        chile.hacerLimitrofe(argentina);
        argentina.reforzar(3);
        ArrayList<Pais> paises = new ArrayList<>();
        paises.add(argentina);
        paises.add(uruguay);
        paises.add(china);
        paises.add(chile);

        Tablero tablero = new Tablero(paises);
        this.ronda = new RondaDeAtaqueYReagrupe(tablero);
    }

    @Test
    public void test01CreoUnaRondaDeAtaqueYReagrupeYNoEsNull() {
        assertNotNull(ronda);
    }

    @Test
    public void test02CreoUnaRondaDeAtaqueYReagrupeYNoPuedoSeleccionarUnPaisAjenoLaPrimeraVez() {
        assertThrows(SeleccionaPaisAjenoException.class, () -> ronda.seleccionarPais("Uruguay", jugador1));
    }

    @Test
    public void test03CreoUnaRondaDeAtaqueYReagrupeYNoPuedoSeleccionarUnPaisConUnEjercitoLaPrimeraVez() {
        assertThrows(EjercitosInvalidosException.class, () -> ronda.seleccionarPais("Chile", jugador1));
    }

    @Test
    public void test04CreoUnaRondaDeAtaqueYReagrupeYPuedoSeleccionarUnPaisPropioLaPrimeraVez() {
        assertEquals(argentina, ronda.seleccionarPais("Argentina", jugador1));
    }

    @Test
    public void test05CreoUnaRondaDeAtaqueYReagrupeYNoPuedoSeleccionarUnPaisPropioLaSegundaVez() {
        ronda.seleccionarPais("Argentina", jugador1);

        assertThrows(AtaqueAPaisPropioException.class , () -> ronda.seleccionarPais("Chile", jugador1));
    }

    @Test
    public void test06CreoUnaRondaDeAtaqueYReagrupeYPuedoSeleccionarUnPaisAjenoLaSegundaVez() {
        ronda.seleccionarPais("Argentina", jugador1);

        assertEquals(uruguay, ronda.seleccionarPais("Uruguay", jugador1));
    }

    @Test
    public void test07CreoUnaRondaDeAtaqueYReagrupeYNoPuedoReforzar() {
        ronda.seleccionarPais("Argentina", jugador1);

        assertThrows(RefuerzoInvalidoException.class , () -> ronda.reforzar(3));
    }

    @Test
    public void test08CreoUnaRondaDeAtaqueYReagrupeYNoPuedoReagrupar() {
        assertThrows(ReagrupeInvalidoException.class , () -> ronda.reagrupar(3));
    }

    @Test
    public void test09CreoUnaRondaDeAtaqueYReagrupeSeleccionoYNoPuedoSeleccionarTresPaises() {
        ronda.seleccionarPais("Argentina", jugador1);
        ronda.seleccionarPais("Uruguay", jugador1);

        assertThrows(PaisesYaSeleccionadosException.class , () -> ronda.seleccionarPais("Uruguay", jugador1));
    }

    @Test
    public void test10CreoUnaRondaDeAtaqueYReagrupeYAtacoYSeModificanEjercitos() {
        Pais paisAtacante = ronda.seleccionarPais("Argentina", jugador1);
        Pais paisDefensor = ronda.seleccionarPais("Uruguay", jugador1);
        paisDefensor.reforzar(5);
        int ejercitosIniciales = paisAtacante.getEjercitos() + paisDefensor.getEjercitos();
        ronda.atacar(3);

        assertEquals(ejercitosIniciales - 3, paisAtacante.getEjercitos() + paisDefensor.getEjercitos());
    }

    @Test
    public void test11CreoUnaRondaDeAtaqueYReagrupeYTerminoElAtaqueYNoPuedoAtacar() {
        ronda.seleccionarPais("Argentina", jugador1);
        ronda.seleccionarPais("Uruguay", jugador1);
        ronda.terminarAtaque();

        assertThrows(AtaqueInvalidoException.class , () -> ronda.atacar(2));
    }

    @Test
    public void test12CreoUnaRondaDeAtaqueYReagrupeTerminoElAtaqueYNoPuedoAtacar() {
        ronda.terminarAtaque();
        ronda.seleccionarPais("Argentina", jugador1);
        ronda.seleccionarPais("Chile", jugador1);

        assertThrows(AtaqueInvalidoException.class , () -> ronda.atacar(2));
    }

    @Test
    public void test13CreoUnaRondaDeAtaqueYReagrupeYReagrupeTerminoElAtaqueYNoPuedoSeleccionarUnPaisAgeno() {
        ronda.terminarAtaque();

        assertThrows(SeleccionaPaisAjenoException.class , () -> ronda.seleccionarPais("Uruguay", jugador1));
    }

    @Test
    public void test14CreoUnaRondaDeAtaqueYReagrupeYReagrupeTerminoElAtaqueYPuedoSeleccionarUnPaisPropio() {
        ronda.terminarAtaque();

        assertEquals(argentina,ronda.seleccionarPais("Argentina", jugador1));
    }

    @Test
    public void test15CreoUnaRondaDeAtaqueYReagrupeYReagrupeTerminoElAtaqueSeleccionoUnPaisPropioYLuegoNoPuedoSeleccionarUnPaisAgeno() {
        ronda.terminarAtaque();
        ronda.seleccionarPais("Argentina", jugador1);

        assertThrows(ReagrupeAPaisAjenoException.class, () -> ronda.seleccionarPais("Uruguay",jugador1));
    }

    @Test
    public void test16CreoUnaRondaDeAtaqueYReagrupeYReagrupeTerminoElAtaqueSeleccionoUnPaisPropioYLuegoSeleccionoOtroPais() {
        ronda.terminarAtaque();
        ronda.seleccionarPais("Argentina", jugador1);

        assertEquals(chile, ronda.seleccionarPais("Chile",jugador1));
    }

    @Test
    public void test17UnPaisConTresEjercitosReagrupaDosHaciaOtroPaisYQuedaCon2Ejercitos() {
        ronda.terminarAtaque();
        ronda.seleccionarPais("Argentina", jugador1);
        ronda.seleccionarPais("Chile",jugador1);
        ronda.reagrupar(2);

        assertEquals(2, argentina.getEjercitos());
    }

    @Test
    public void test18UnPaisConTresEjercitosReagrupaDosHaciaOtroPaisConUnEjercitoYEsteQuedaConTres() {
        argentina.reforzar(1);
        ronda.terminarAtaque();
        ronda.seleccionarPais("Argentina", jugador1);
        ronda.seleccionarPais("Chile", jugador1);
        ronda.reagrupar(2);

        assertEquals(chile.getEjercitos(),3);
    }

    @Test
    public void test19CreoUnaRondaDeRefuerzoYReagrupeYTerminoElAtaqueYPasoDeTurnoYElJugador2NoPuedeReagrupar() {
        argentina.reforzar(3);
        ronda.terminarAtaque();
        ronda.siguienteTurno();
        ronda.seleccionarPais("Argentina", jugador1);
        ronda.seleccionarPais("Uruguay", jugador1);
        assertThrows(ReagrupeInvalidoException.class, () -> ronda.reagrupar(3));
    }
}

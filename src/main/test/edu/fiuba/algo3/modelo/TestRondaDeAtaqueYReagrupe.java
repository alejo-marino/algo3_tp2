package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestRondaDeAtaqueYReagrupe {

    private Jugador jugador1;
    private RondaDeAtaqueYReagrupe ronda;
    private Jugador jugador2;
    private Pais argentina;
    private Pais uruguay;
    private Pais chile;
    private Pais brasil;


    @BeforeEach
    void setUp() {
        this.jugador1 = new Jugador("000000");
        this.jugador2 = new Jugador("ffffff");

        argentina = new Pais("Argentina");
        argentina.asignarDuenio(jugador1);
        uruguay = new Pais("Uruguay");
        uruguay.asignarDuenio(jugador2);
        chile = new Pais("Chile");
        chile.asignarDuenio(jugador1);
        brasil = new Pais("Brasil");
        brasil.asignarDuenio(jugador1);
        Pais china = new Pais("China");
        china.asignarDuenio(jugador2);
        Pais rusia = new Pais("Rusia");
        rusia.asignarDuenio(jugador1);
        argentina.hacerLimitrofe(uruguay);
        uruguay.hacerLimitrofe(argentina);
        argentina.hacerLimitrofe(chile);
        chile.hacerLimitrofe(argentina);
        argentina.hacerLimitrofe(brasil);
        brasil.hacerLimitrofe(argentina);
        argentina.reforzar(3);
        chile.reforzar(3);

        Juego juegoMock = mock(Juego.class);
        when(juegoMock.seleccionarPais("Argentina")).thenReturn(argentina);
        when(juegoMock.seleccionarPais("Chile")).thenReturn(chile);
        when(juegoMock.seleccionarPais("Uruguay")).thenReturn(uruguay);
        when(juegoMock.seleccionarPais("Brasil")).thenReturn(brasil);
        when(juegoMock.seleccionarPais("China")).thenReturn(china);
        when(juegoMock.seleccionarPais("Rusia")).thenReturn(rusia);
        this.ronda = new RondaDeAtaqueYReagrupe(juegoMock);
        ronda.empezarTurno(jugador1);
    }

    @Test
    public void test01CreoUnaRondaDeAtaqueYReagrupeYNoEsNull() {
        assertNotNull(ronda);
    }

    @Test
    public void test02CreoUnaRondaDeAtaqueYReagrupeYNoPuedoSeleccionarUnPaisAjenoLaPrimeraVez() {
        assertThrows(SeleccionaPaisAjenoException.class, () -> ronda.seleccionarPais("Uruguay"));
    }

    @Test
    public void test03CreoUnaRondaDeAtaqueYReagrupeYNoPuedoSeleccionarUnPaisConUnEjercitoLaPrimeraVez() {
        assertThrows(EjercitosInvalidosException.class, () -> ronda.seleccionarPais("Brasil"));
    }

//    @Test
//    public void test04CreoUnaRondaDeAtaqueYReagrupeYPuedoSeleccionarUnPaisPropioLaPrimeraVez() {
//        assertEquals("Argentina", ronda.seleccionarPais("Argentina"));
//    }

    @Test
    public void test05CreoUnaRondaDeAtaqueYReagrupeYNoPuedoSeleccionarUnPaisPropioLaSegundaVez() {
        ronda.seleccionarPais("Argentina");

        assertThrows(AtaqueAPaisPropioException.class , () -> ronda.seleccionarPais("Chile"));
    }

//    @Test
//    public void test06CreoUnaRondaDeAtaqueYReagrupeYPuedoSeleccionarUnPaisAjenoLaSegundaVez() {
//        ronda.seleccionarPais("Argentina");
//
//        assertEquals("Uruguay", ronda.seleccionarPais("Uruguay").toString());
//    }

    @Test
    public void test07CreoUnaRondaDeAtaqueYReagrupeYNoPuedoReforzar() {
        ronda.seleccionarPais("Argentina");

        assertThrows(RefuerzoInvalidoException.class , () -> ronda.reforzar(3));
    }

    @Test
    public void test08CreoUnaRondaDeAtaqueYReagrupeYNoPuedoReagrupar() {
        assertThrows(ReagrupeInvalidoException.class , () -> ronda.reagrupar(3));
    }

    @Test
    public void test09CreoUnaRondaDeAtaqueYReagrupeSeleccionoYNoPuedoSeleccionarTresPaises() {
        ronda.seleccionarPais("Argentina");
        ronda.seleccionarPais("Uruguay");

        assertThrows(PaisesYaSeleccionadosException.class , () -> ronda.seleccionarPais("Uruguay"));
    }

    @Test
    public void test10CreoUnaRondaDeAtaqueYReagrupeYAtacoYSeModificanEjercitos() {
        uruguay.reforzar(5);
        ronda.seleccionarPais("Argentina");
        ronda.seleccionarPais("Uruguay");
        int ejercitosIniciales = argentina.getEjercitos() + uruguay.getEjercitos();
        ronda.atacar(3);

        assertEquals(ejercitosIniciales - 3, argentina.getEjercitos() + uruguay.getEjercitos());
    }

    @Test
    public void test11CreoUnaRondaDeAtaqueYReagrupeYTerminoElAtaqueYNoPuedoAtacar() {
        ronda.seleccionarPais("Argentina");
        ronda.seleccionarPais("Uruguay");
        ronda.terminarAtaque(jugador1);

        assertThrows(AtaqueInvalidoException.class , () -> ronda.atacar(2));
    }

    @Test
    public void test12CreoUnaRondaDeAtaqueYReagrupeTerminoElAtaqueYNoPuedoAtacar() {
        ronda.terminarAtaque(jugador1);
        ronda.seleccionarPais("Argentina");
        ronda.seleccionarPais("Chile");

        assertThrows(AtaqueInvalidoException.class , () -> ronda.atacar(2));
    }

    @Test
    public void test13CreoUnaRondaDeAtaqueYReagrupeYReagrupeTerminoElAtaqueYNoPuedoSeleccionarUnPaisAgeno() {
        ronda.terminarAtaque(jugador1);

        assertThrows(SeleccionaPaisAjenoException.class , () -> ronda.seleccionarPais("Uruguay"));
    }

//    @Test
//    public void test14CreoUnaRondaDeAtaqueYReagrupeYReagrupeTerminoElAtaqueYPuedoSeleccionarUnPaisPropio() {
//        ronda.terminarAtaque(jugador1);
//
//        assertEquals("Argentina", ronda.seleccionarPais("Argentina").toString());
//    }

    @Test
    public void test15CreoUnaRondaDeAtaqueYReagrupeYReagrupeTerminoElAtaqueSeleccionoUnPaisPropioYLuegoNoPuedoSeleccionarUnPaisAgeno() {
        ronda.terminarAtaque(jugador1);
        ronda.seleccionarPais("Argentina");

        assertThrows(ReagrupeAPaisAjenoException.class, () -> ronda.seleccionarPais("Uruguay"));
    }

//    @Test
//    public void test16CreoUnaRondaDeAtaqueYReagrupeYReagrupeTerminoElAtaqueSeleccionoUnPaisPropioYLuegoSeleccionoOtroPais() {
//        ronda.terminarAtaque(jugador1);
//        ronda.seleccionarPais("Argentina");
//
//        assertEquals("Chile", ronda.seleccionarPais("Chile").toString());
//    }

    @Test
    public void test17UnPaisConTresEjercitosReagrupaDosHaciaOtroPaisYQuedaCon2Ejercitos() {
        ronda.terminarAtaque(jugador1);
        ronda.seleccionarPais("Argentina");
        ronda.seleccionarPais("Chile");
        ronda.reagrupar(2);

        assertEquals(2, argentina.getEjercitos());
    }

    @Test
    public void test18UnPaisConTresEjercitosReagrupaDosHaciaOtroPaisConCuatroEjercitosYEsteQuedaConSeis() {
        ronda.terminarAtaque(jugador1);
        ronda.seleccionarPais("Argentina");
        ronda.seleccionarPais("Chile");
        ronda.reagrupar(2);
        ronda.empezarTurno(jugador2);

        assertEquals(6,chile.getEjercitos());
    }

    @Test
    public void test19CreoUnaRondaDeRefuerzoYReagrupeYTerminoElAtaqueYPasoDeTurnoYElJugador2NoPuedeReagrupar() {
        ronda.terminarAtaque(jugador1);
        ronda.empezarTurno(jugador1);
        ronda.seleccionarPais("Argentina");
        ronda.seleccionarPais("Uruguay");
        assertThrows(ReagrupeInvalidoException.class, () -> ronda.reagrupar(3));
    }

    @Test
    public void test20CreoUnaRondaDeAtaqueYReagrupeYNoPuedoCanjearTarjetas() {
        assertThrows(CanjeNoPermitidoException.class , () -> ronda.canjearTarjetas(null));
    }

    @Test
    public void test21ReagrupoTresEjercitosDeChileAArgentinaYNoPuedoReagruparMasEjercitosDeLosQueTeniaAntesDelReagrupeHaciaBrasil() {
        ronda.terminarAtaque(jugador1);

        ronda.seleccionarPais("Chile");
        ronda.seleccionarPais("Argentina");
        ronda.reagrupar(3);
        ronda.seleccionarPais("Argentina");
        ronda.seleccionarPais("Brasil");

        assertThrows(EjercitosInvalidosException.class, () -> ronda.reagrupar(6));
    }

    @Test
    public void test22ReagrupoTresEjercitosDeChileAArgentinaYPuedoReagruparLosEjercitosQueTeniaAntesDelReagrupeHaciaBrasil() {
        ronda.terminarAtaque(jugador1);

        ronda.seleccionarPais("Chile");
        ronda.seleccionarPais("Argentina");
        ronda.reagrupar(3);
        ronda.seleccionarPais("Argentina");
        ronda.seleccionarPais("Brasil");

        ronda.reagrupar(3);
        ronda.empezarTurno(jugador2);
        assertEquals(4, brasil.getEjercitos());
    }

    @Test
    public void test23SeleccionoPaisPropioYLuegoSeleccionoPaisNoLimitrofe() {
        ronda.seleccionarPais("Argentina");

        assertThrows(AtaqueAPaisNoLimitrofeException.class, () -> ronda.seleccionarPais("China"));
    }

    @Test
    public void test24SeleccionoPaisPropioYLuegoSeleccionoPaisNoLimitrofe() {
        ronda.terminarAtaque(jugador1);
        ronda.seleccionarPais("Argentina");

        assertThrows(ReagrupeAPaisNoLimitrofeException.class, () -> ronda.seleccionarPais("Rusia"));
    }

}

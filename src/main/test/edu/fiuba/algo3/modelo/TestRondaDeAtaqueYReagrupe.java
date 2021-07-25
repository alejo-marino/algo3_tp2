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


    @BeforeEach
    void setUp() {
        this.jugador1 = new Jugador("000000");
        Jugador jugador2 = new Jugador("ffffff");

        Pais argentina = new Pais("Argentina",jugador1);
        Pais uruguay = new Pais("Uruguay", jugador2);
        Pais chile = new Pais("Chile", jugador1);
        argentina.hacerLimitrofe(uruguay);
        uruguay.hacerLimitrofe(argentina);
        argentina.hacerLimitrofe(chile);
        chile.hacerLimitrofe(argentina);
        argentina.reforzar(3);

        Juego juegoMock = mock(Juego.class);
        when(juegoMock.seleccionarPais("Argentina")).thenReturn(argentina);
        when(juegoMock.seleccionarPais("Chile")).thenReturn(chile);
        when(juegoMock.seleccionarPais("Uruguay")).thenReturn(uruguay);
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
        assertThrows(EjercitosInvalidosException.class, () -> ronda.seleccionarPais("Chile"));
    }

    @Test
    public void test04CreoUnaRondaDeAtaqueYReagrupeYPuedoSeleccionarUnPaisPropioLaPrimeraVez() {
        assertEquals("Argentina", ronda.seleccionarPais("Argentina").toString());
    }

    @Test
    public void test05CreoUnaRondaDeAtaqueYReagrupeYNoPuedoSeleccionarUnPaisPropioLaSegundaVez() {
        ronda.seleccionarPais("Argentina");

        assertThrows(AtaqueAPaisPropioException.class , () -> ronda.seleccionarPais("Chile"));
    }

    @Test
    public void test06CreoUnaRondaDeAtaqueYReagrupeYPuedoSeleccionarUnPaisAjenoLaSegundaVez() {
        ronda.seleccionarPais("Argentina");

        assertEquals("Uruguay", ronda.seleccionarPais("Uruguay").toString());
    }

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
        Pais paisAtacante = ronda.seleccionarPais("Argentina");
        Pais paisDefensor = ronda.seleccionarPais("Uruguay");
        paisDefensor.reforzar(5);
        int ejercitosIniciales = paisAtacante.getEjercitos() + paisDefensor.getEjercitos();
        ronda.atacar(3);

        assertEquals(ejercitosIniciales - 3, paisAtacante.getEjercitos() + paisDefensor.getEjercitos());
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
        ronda.empezarTurno(jugador1);
        ronda.terminarAtaque(jugador1);

        assertThrows(SeleccionaPaisAjenoException.class , () -> ronda.seleccionarPais("Uruguay"));
    }

    @Test
    public void test14CreoUnaRondaDeAtaqueYReagrupeYReagrupeTerminoElAtaqueYPuedoSeleccionarUnPaisPropio() {
        ronda.terminarAtaque(jugador1);

        assertEquals("Argentina", ronda.seleccionarPais("Argentina").toString());
    }

    @Test
    public void test15CreoUnaRondaDeAtaqueYReagrupeYReagrupeTerminoElAtaqueSeleccionoUnPaisPropioYLuegoNoPuedoSeleccionarUnPaisAgeno() {
        ronda.terminarAtaque(jugador1);
        ronda.seleccionarPais("Argentina");

        assertThrows(ReagrupeAPaisAjenoException.class, () -> ronda.seleccionarPais("Uruguay"));
    }

    @Test
    public void test16CreoUnaRondaDeAtaqueYReagrupeYReagrupeTerminoElAtaqueSeleccionoUnPaisPropioYLuegoSeleccionoOtroPais() {
        ronda.terminarAtaque(jugador1);
        ronda.seleccionarPais("Argentina");

        assertEquals("Chile", ronda.seleccionarPais("Chile").toString());
    }

    @Test
    public void test17UnPaisConTresEjercitosReagrupaDosHaciaOtroPaisYQuedaCon2Ejercitos() {
        ronda.terminarAtaque(jugador1);
        Pais argentina = ronda.seleccionarPais("Argentina");
        ronda.seleccionarPais("Chile");
        ronda.reagrupar(2);

        assertEquals(2, argentina.getEjercitos());
    }

    @Test
    public void test18UnPaisConTresEjercitosReagrupaDosHaciaOtroPaisConUnEjercitoYEsteQuedaConTres() {
        ronda.terminarAtaque(jugador1);
        ronda.seleccionarPais("Argentina");
        Pais chile = ronda.seleccionarPais("Chile");
        ronda.reagrupar(2);

        assertEquals(chile.getEjercitos(),3);
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

}

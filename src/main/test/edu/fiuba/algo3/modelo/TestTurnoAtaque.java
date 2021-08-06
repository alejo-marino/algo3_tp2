package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.TurnoAtaque.TurnoAtaque;
import edu.fiuba.algo3.modelo.excepciones.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static edu.fiuba.algo3.modelo.Constantes.colorAmarillo;
import static edu.fiuba.algo3.modelo.Constantes.colorNegro;
import static org.junit.jupiter.api.Assertions.*;

public class TestTurnoAtaque {

    private TurnoAtaque turnoAtaque;
    private Jugador jugador1;
    private Jugador jugador2;
    private Pais argentina;
    private Pais uruguay;
    private Pais chile;
    private Pais brasil;
    private Pais china;
    private Pais rusia;

    @BeforeEach
    public void setUp() {
        this.jugador1 = new Jugador(colorNegro, "Jugador 1");
        this.jugador2 = new Jugador(colorAmarillo, "Jugador 2");
        argentina = new Pais("Argentina");
        argentina.asignarDuenio(jugador1);
        uruguay = new Pais("Uruguay");
        uruguay.asignarDuenio(jugador2);
        chile = new Pais("Chile");
        chile.asignarDuenio(jugador1);
        brasil = new Pais("Brasil");
        brasil.asignarDuenio(jugador1);
        china = new Pais("China");
        china.asignarDuenio(jugador2);
        rusia = new Pais("Rusia");
        rusia.asignarDuenio(jugador1);
        argentina.hacerLimitrofe(uruguay);
        uruguay.hacerLimitrofe(argentina);
        argentina.hacerLimitrofe(chile);
        chile.hacerLimitrofe(argentina);
        argentina.hacerLimitrofe(brasil);
        brasil.hacerLimitrofe(argentina);
        argentina.reforzar(3);

        this.turnoAtaque = new TurnoAtaque(jugador1);
    }

    @Test
    public void test01CreoUnTurnoAtaqueYNoEsNull() {
        assertNotNull(turnoAtaque);
    }

    @Test
    public void test02NoPuedoReforzarEnUnTurnoDeAtaque() {
        assertFalse(turnoAtaque.puedoReforzar());
    }

    @Test
    public void test03CreoUnTurnoDeAtaqueYIntentoReforzarYLanzaUnaExcepcion() {
        assertThrows(RefuerzoInvalidoException.class, () -> turnoAtaque.reforzar(3));
    }

    @Test
    public void test04CreoUnTurnoDeAtaqueYNoPuedoReagrupar() {
        assertFalse(turnoAtaque.puedoReagrupar());
    }

    @Test
    public void test05CreoUnTurnoDeAtaqueYIntentoReagruparYLanzaUnaExcepcion() {
        assertThrows(ReagrupeInvalidoException.class, () -> turnoAtaque.reagrupar(3));
    }

    @Test
    public void test06CreoUnTurnoDeAtaqueYNoPuedoAtacarSinSeleccionarAmbosPaises() {
        assertFalse(turnoAtaque.puedoAtacar());
    }

    @Test
    public void test07CreoUnTurnoDeAtaqueYIntentoAtacarYLanzaUnaExcepcion() {
        assertThrows(AtaqueInvalidoException.class, () -> turnoAtaque.atacar(3));
    }

    @Test
    public void test08CreoUnTurnoDeAtaqueYNoPuedoPasarDeTurno() {
        assertFalse(turnoAtaque.puedoPasarDeTurno());
    }

    @Test
    public void test09CreoUnTurnoDeAtaqueYNoPuedoCanjearTarjetas() {
        assertThrows(CanjeNoPermitidoException.class, () -> turnoAtaque.canjearTarjetas(null, null));
    }

    @Test
    public void test10CreoUnTurnoDeAtaqueYNoPuedoActivarTarjetas() {
        assertThrows(ActivacionTarjetaInvalidaException.class, () -> turnoAtaque.activarTarjeta("Argentina", null));
    }

    @Test
    public void test11CreoUnTurnoDeAtaqueYNoPuedoCancelarAccion() {
        assertFalse(turnoAtaque.puedoCancelar());
    }

    @Test
    public void test12CreoUnTurnoDeAtaqueYNoPuedoSeleccionarUnPaisAjeno() {
        assertFalse(turnoAtaque.puedoSeleccionarPais(uruguay));
    }

    @Test
    public void test13CreoUnTurnoDeAtaqueYIntentoSeleccionarUnPaisAjenoYLanzaUnaExcepcion() {
        assertThrows(SeleccionaPaisAjenoException.class, () -> turnoAtaque.seleccionarPais(uruguay));
    }

    @Test
    public void test14CreoUnTurnoDeAtaqueYPuedoSeleccionarUnPaisPropio() {
        turnoAtaque.seleccionarPais(argentina);
    }

    @Test
    public void test15SeleccionoUnPaisPropioYPuedoSeleccionarOtroPaisPropio() {
        chile.reforzar(3);

        turnoAtaque.seleccionarPais(argentina);
        turnoAtaque.seleccionarPais(chile);
    }

    @Test
    public void test16SeleccionoUnPaisPropioYPuedoSeleccionarUnPaisAjenoYLimitrofe() {
        turnoAtaque.seleccionarPais(argentina);
        turnoAtaque.seleccionarPais(uruguay);
    }

    @Test
    public void test17SeleccionoUnPaisPropioYNoPuedoSeleccionarUnPaisAjenoPeroNoLimitrofe() {
        turnoAtaque.seleccionarPais(argentina);
        assertThrows(AtaqueAPaisNoLimitrofeException.class, () -> turnoAtaque.seleccionarPais(china));
    }

    @Test
    public void test18SeleccionoUnPaisPropioYPuedoSeleccionarUnPaisPropioYNoLimitrofe() {
        rusia.reforzar(1);
        turnoAtaque.seleccionarPais(argentina);
        turnoAtaque.seleccionarPais(rusia);
    }

    @Test
    public void test19NoPuedoSeleccionarUnPaisPropioCon1Ejercito() {
        assertFalse(turnoAtaque.puedoSeleccionarPais(rusia));
    }

    @Test
    public void test20IntentoSeleccionarUnPaisPropioCon1EjercitoYLanzaUnaExcepcion() {
        assertThrows(EjercitosInvalidosException.class, () ->turnoAtaque.seleccionarPais(rusia));
    }

    @Test
    public void test21SeleccionoUnPaisPropioYNoPuedoSeleccionarUnPaisPropioCon1Ejercito() {
        turnoAtaque.seleccionarPais(argentina);
        assertFalse(turnoAtaque.puedoSeleccionarPais(rusia));
    }

    @Test
    public void test22SeleccionoUnPaisPropioYIntentoSeleccionarUnPaisPropioCon1EjercitoYLanzaUnaExcepcion() {
        turnoAtaque.seleccionarPais(argentina);
        assertThrows(EjercitosInvalidosException.class, () ->turnoAtaque.seleccionarPais(rusia));
    }

    @Test
    public void test23PuedoSeleccionarTresPaisesPropios() {
        rusia.reforzar(1);
        chile.reforzar(1);

        turnoAtaque.seleccionarPais(argentina);
        turnoAtaque.seleccionarPais(rusia);
        turnoAtaque.seleccionarPais(chile);
    }

    @Test
    public void test24SeleccionoUnPaisPropioYNoPuedoReforzar() {
        turnoAtaque.seleccionarPais(argentina);

        assertFalse(turnoAtaque.puedoReforzar());
    }

    @Test
    public void test25SeleccionoUnPaisPropioYIntentoReforzarYLanzaUnaExcepcion() {
        turnoAtaque.seleccionarPais(argentina);

        assertThrows(RefuerzoInvalidoException.class, () -> turnoAtaque.reforzar(3));
    }

    @Test
    public void test26SeleccionoUnPaisPropioYNoPuedoReagrupar() {
        turnoAtaque.seleccionarPais(argentina);

        assertFalse(turnoAtaque.puedoReagrupar());
    }

    @Test
    public void test27SeleccionoUnPaisPropioYIntentoReagruparYLanzaUnaExcepcion() {
        turnoAtaque.seleccionarPais(argentina);

        assertThrows(ReagrupeInvalidoException.class, () -> turnoAtaque.reagrupar(3));
    }

    @Test
    public void test28SeleccionoUnPaisPropioYNoPuedoAtacarSinSeleccionarPaisDefensor() {
        turnoAtaque.seleccionarPais(argentina);

        assertFalse(turnoAtaque.puedoAtacar());
    }

    @Test
    public void test29SeleccionoUnPaisPropioYIntentoAtacarYLanzaUnaExcepcion() {
        turnoAtaque.seleccionarPais(argentina);

        assertThrows(AtaqueInvalidoException.class, () -> turnoAtaque.atacar(3));
    }

    @Test
    public void test30SeleccionoUnPaisPropioYNoPuedoPasarDeTurno() {
        turnoAtaque.seleccionarPais(argentina);

        assertFalse(turnoAtaque.puedoPasarDeTurno());
    }

    @Test
    public void test31SeleccionoUnPaisPropioYNoPuedoCanjearTarjetas() {
        turnoAtaque.seleccionarPais(argentina);

        assertThrows(CanjeNoPermitidoException.class, () -> turnoAtaque.canjearTarjetas(null, null));
    }

    @Test
    public void test32SeleccionoUnPaisPropioYNoPuedoActivarTarjetas() {
        turnoAtaque.seleccionarPais(argentina);

        assertThrows(ActivacionTarjetaInvalidaException.class, () -> turnoAtaque.activarTarjeta("Argentina", null));
    }

    @Test
    public void test33SeleccionoUnPaisPropioYPuedoCancelarAccion() {
        turnoAtaque.seleccionarPais(argentina);

        turnoAtaque.puedoCancelar();
    }

    @Test
    public void test34SeleccionoUnPaisPropioYCanceloAccionYPuedoVolverASeleccionarlo() {
        turnoAtaque.seleccionarPais(argentina);
        turnoAtaque.cancelarAccion();
        turnoAtaque.seleccionarPais(argentina);
    }

    @Test
    public void test35SeleccionoUnPaisPropioYNoPuedoVolverASeleccionarlo() {
        turnoAtaque.seleccionarPais(argentina);
        assertFalse(turnoAtaque.puedoSeleccionarPais(argentina));
    }

    @Test
    public void test36SeleccionoPaisAtacanteYDefensorYNoPuedoAtacar() {
        turnoAtaque.seleccionarPais(argentina);
        turnoAtaque.seleccionarPais(uruguay);

        assertFalse(turnoAtaque.puedoReforzar());
    }

    @Test
    public void test37SeleccionoPaisAtacanteYDefensorYIntentoReforzarYLanzaUnaExcepcion() {
        turnoAtaque.seleccionarPais(argentina);
        turnoAtaque.seleccionarPais(uruguay);

        assertThrows(RefuerzoInvalidoException.class, () -> turnoAtaque.reforzar(3));
    }

    @Test
    public void test38SeleccionoPaisAtacanteYDefensorYNoPuedoReagrupar() {
        turnoAtaque.seleccionarPais(argentina);
        turnoAtaque.seleccionarPais(uruguay);

        assertFalse(turnoAtaque.puedoReagrupar());
    }

    @Test
    public void test39SeleccionoPaisAtacanteYDefensorYIntentoReagruparYLanzaUnaExcepcion() {
        turnoAtaque.seleccionarPais(argentina);
        turnoAtaque.seleccionarPais(uruguay);

        assertThrows(ReagrupeInvalidoException.class, () -> turnoAtaque.reagrupar(3));
    }

    @Test
    public void test40SeleccionoPaisAtacanteYDefensorYNoPuedoPasarDeTurno() {
        turnoAtaque.seleccionarPais(argentina);
        turnoAtaque.seleccionarPais(uruguay);

        assertFalse(turnoAtaque.puedoPasarDeTurno());
    }

    @Test
    public void test41SeleccionoPaisAtacanteYDefensorYNoPuedoCanjearTarjetas() {
        turnoAtaque.seleccionarPais(argentina);
        turnoAtaque.seleccionarPais(uruguay);

        assertThrows(CanjeNoPermitidoException.class, () -> turnoAtaque.canjearTarjetas(null, null));
    }

    @Test
    public void test42SeleccionoPaisAtacanteYDefensorYNoPuedoActivarTarjetas() {
        turnoAtaque.seleccionarPais(argentina);
        turnoAtaque.seleccionarPais(uruguay);

        assertThrows(ActivacionTarjetaInvalidaException.class, () -> turnoAtaque.activarTarjeta("Argentina", null));
    }

    @Test
    public void test43SeleccionoPaisAtacanteYDefensorYPuedoCancelarAccion() {
        turnoAtaque.seleccionarPais(argentina);
        turnoAtaque.seleccionarPais(uruguay);

        assertTrue(turnoAtaque.puedoCancelar());
    }

    @Test
    public void test44SeleccionoPaisAtacanteYDefensorYCanceloAccion() {
        turnoAtaque.seleccionarPais(argentina);
        turnoAtaque.seleccionarPais(uruguay);

        turnoAtaque.cancelarAccion();
    }

    @Test
    public void test45SeleccionoPaisAtacanteYDefensorYCanceloAccionYPuedoCancelarDeNuevo() {
        turnoAtaque.seleccionarPais(argentina);
        turnoAtaque.seleccionarPais(uruguay);

        turnoAtaque.cancelarAccion();
        assertTrue(turnoAtaque.puedoCancelar());
    }

    @Test
    public void test46SeleccionoPaisAtacanteYDefensorYPuedoAtacar() {
        turnoAtaque.seleccionarPais(argentina);
        turnoAtaque.seleccionarPais(uruguay);

        assertTrue(turnoAtaque.puedoAtacar());
    }

}

package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.TurnoRefuerzo.TurnoRefuerzo;
import edu.fiuba.algo3.modelo.excepciones.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

import static edu.fiuba.algo3.modelo.Constantes.colorAmarillo;
import static edu.fiuba.algo3.modelo.Constantes.colorNegro;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class TestTurnoRefuerzo {

    private TurnoRefuerzo turnoRefuerzo;
    private Jugador jugador1;
    private Jugador jugador2;
    private Pais argentina;
    private Pais uruguay;
    private Pais chile;
    private Pais brasil;
    private Pais china;
    private Pais rusia;
    private Juego juego;
    private ArrayList<String> tarjetasACanjear;

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

        this.juego = mock(Juego.class);
        this.tarjetasACanjear = new ArrayList<>();
        tarjetasACanjear.add("Argentina");
        tarjetasACanjear.add("Uruguay");
        tarjetasACanjear.add("Chile");
        when(juego.canjearTarjetas(tarjetasACanjear, jugador1)).thenReturn(4);

        turnoRefuerzo = new TurnoRefuerzo(jugador1, 5);
    }

    @Test
    public void test01CreoUnTurnoDeRefuerzoYNoEsNull() {
        assertNotNull(turnoRefuerzo);
    }

    @Test
    public void test02CreoUnTurnoDeRefuerzoYNoPuedoReforzar () {
        assertFalse(turnoRefuerzo.puedoReforzar());
    }

    @Test
    public void test03CreoUnTurnoDeRefuerzoYIntentoReforzarYLanzaUnaExcepcion() {
        assertThrows(PaisNoSeleccionadoException.class, () -> turnoRefuerzo.reforzar(3));
    }

    @Test
    public void test04CreoUnTurnoDeRefuerzoYNoPuedoReagrupar() {
        assertFalse(turnoRefuerzo.puedoReagrupar());
    }

    @Test
    public void test05CreoUnTurnoDeRefuerzoYIntentoReagruparYLanzaUnaExcepcion() {
        assertThrows(ReagrupeInvalidoException.class, () -> turnoRefuerzo.reagrupar(3));
    }

    @Test
    public void test06CreoUnTurnoDeRefuerzoYNoPuedoAtacarSinSeleccionarAmbosPaises() {
        assertFalse(turnoRefuerzo.puedoAtacar());
    }

    @Test
    public void test07CreoUnTurnoDeRefuerzoYIntentoAtacarYLanzaUnaExcepcion() {
        assertThrows(AtaqueInvalidoException.class, () -> turnoRefuerzo.atacar(3));
    }

    @Test
    public void test08CreoUnTurnoDeRefuerzoYNoPuedoPasarDeTurno() {
        assertFalse(turnoRefuerzo.puedoPasarDeTurno());
    }

    @Test
    public void test09CreoUnTurnoDeRefuerzoYTengoLosEjercitosCorrectosParaReforzar() {
        assertEquals(5, turnoRefuerzo.getEjercitosParaReforzar());
    }

    @Test
    public void test09CreoUnTurnoDeRefuerzoYPuedoCanjearTarjetas() {
        turnoRefuerzo.canjearTarjetas(tarjetasACanjear, juego);

        assertEquals(9, turnoRefuerzo.getEjercitosParaReforzar());
    }

    @Test
    public void test10CreoUnTurnoDeRefuerzoYNoPuedoCancelarAccion() {
        assertFalse(turnoRefuerzo.puedoCancelar());
    }

    @Test
    public void test11CreoUnTurnoDeRefuerzoYNoPuedoSeleccionarUnPaisAjeno() {
        assertFalse(turnoRefuerzo.puedoSeleccionarPais(uruguay));
    }

    @Test
    public void test12CreoUnTurnoDeRefuerzoYIntentoSeleccionarUnPaisAjenoYLanzaUnaExcepcion() {
        assertThrows(SeleccionaPaisAjenoException.class, () -> turnoRefuerzo.seleccionarPais(uruguay));
    }

    @Test
    public void test13CreoUnTurnoDeRefuerzoYPuedoSeleccionarUnPaisPropio() {
        turnoRefuerzo.seleccionarPais(argentina);
    }
    

}

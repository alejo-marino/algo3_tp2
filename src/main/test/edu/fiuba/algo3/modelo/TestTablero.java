package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;

import static org.junit.jupiter.api.Assertions.*;

public class TestTablero {

    private Jugador jugador1;
    private Tablero tablero;
    private Pais argentina;
    private Pais uruguay;
    private Pais china;

    @BeforeEach
    void setUp() {
        this.jugador1 = new Jugador("000000", "Jugador 1");
        Jugador jugador2 = new Jugador("ffffff", "Jugador 2");
        Jugador jugador3 = new Jugador("ff0000", "Jugador 3");

        argentina = new Pais("Argentina");
        argentina.asignarDuenio(jugador1);
        uruguay = new Pais("Uruguay");
        uruguay.asignarDuenio(jugador2);
        china = new Pais("China");
        china.asignarDuenio(jugador3);
        argentina.hacerLimitrofe(uruguay);
        uruguay.hacerLimitrofe(argentina);
        ArrayList<Pais> paises = new ArrayList<>();
        paises.add(argentina);
        paises.add(uruguay);
        paises.add(china);

        Continente americaDelSur = new Continente("America Del Sur", 3);
        Continente asia = new Continente("Asia", 6);
        americaDelSur.agregarPais(argentina);
        americaDelSur.agregarPais(uruguay);
        asia.agregarPais(china);

        ArrayList<Continente> continentes = new ArrayList<>();
        continentes.add(americaDelSur);
        continentes.add(asia);

        this.tablero = new Tablero(paises, continentes);
    }

    @Test
    public void test01SeCreaUnTableroYNoEsNull (){
        assertNotNull(tablero);
    }

    @Test
    public void test02SeCreaUnTableroYPuedoSeleccionarUnPais () {
        assertEquals("Argentina", tablero.seleccionarPais("Argentina").toString());
    }

    @Test
    public void test03SeCreaUnTableroYNoPuedoSeleccionarUnPaisInexistente () {
        assertThrows(PaisInexistenteException.class, () -> tablero.seleccionarPais("Chile"));
    }

    @Test
    public void test05CreoUnTableroCon1Jugadorcon1PaisYNingunContinenteYTiene3EjercitosParaReforzar (){
        assertEquals(3, tablero.calcularEjercitosDisponibles(jugador1));
    }

    @Test
    public void test06Jugador1Tiene2PaisesYAmericaDelSurYRecibe4EjercitosParaReforzar () {
        argentina.conquistar(uruguay);
        assertEquals(4, tablero.calcularEjercitosDisponibles(jugador1)); //Bonus de sudamerica = 3, mitad de paises conquistados = 1.
    }

    @Test
    public void test07Jugador1Tiene3PaisesYAmericaDelSurYAsiaYRecibe10EjercitosParaReforzar () {
        argentina.conquistar(uruguay);
        argentina.conquistar(china);
        assertEquals(10, tablero.calcularEjercitosDisponibles(jugador1)); //Bonus de sudamerica = 3, Bonus Asia = 6 mitad de paises conquistados(3) = 10.
    }

    @Test
    public void test08Jugador1Tiene1PaisDeAmericaDelSur () {
        assertEquals(1, tablero.paisesConquistadosPorEn(jugador1, "America Del Sur"));
    }

    @Test
    public void test09Jugador1ConquistaYTiene2PaisesDeAmericaDelSur () {
        argentina.conquistar(uruguay);
        assertEquals(2, tablero.paisesConquistadosPorEn(jugador1, "America Del Sur"));
    }

    @Test
    public void test08Jugador1Tiene0PaisesEnAsia () {
        assertEquals(0, tablero.paisesConquistadosPorEn(jugador1, "Asia"));
    }

}

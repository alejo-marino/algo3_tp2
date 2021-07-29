package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.*;

public class TestInicializadorDeDatos {

    private ArrayList<Jugador> jugadores;
    private InicializadorDeDatos inicializador;

    @BeforeEach
    void setUp() {
        this.jugadores = new ArrayList<>();
        jugadores.add(new Jugador("000000"));
        jugadores.add(new Jugador("ffffff"));
        this.inicializador = new InicializadorDeDatos();
    }

    @Test
    public void test01CreoUnInicializadorDeDatosYNoEsNull () {
        assertNotNull(inicializador);
    }

    @Test
    public void test02CreoUnInicializadorDeDatosYVerificoQueHaya50Paises () {
        Map<String, ArrayList> datosInicializados = this.inicializador.inicializarDatos(jugadores);
        Tablero tablero = new Tablero(datosInicializados.get("Paises"), datosInicializados.get("Continentes"));
        assertEquals(50, tablero.size());
    }

    @Test
    public void test03CreoTodosLosPaisesYArgentinaExiste () {
        Map<String, ArrayList> datosInicializados = this.inicializador.inicializarDatos(jugadores);
        Tablero tablero = new Tablero(datosInicializados.get("Paises"), datosInicializados.get("Continentes"));

        Pais argentina = tablero.seleccionarPais("Argentina");

        assertEquals("Argentina", argentina.toString());
    }

    @Test
    public void test11CreoTarjetasYHay50 () {
        Map<String, ArrayList> datosInicializados = this.inicializador.inicializarDatos(jugadores);
        ArrayList<Tarjeta> tarjetas = datosInicializados.get("Tarjetas");

        assertEquals(50, tarjetas.size());
    }

    @Test
    public void test12CreoTarjetasYHayLaCantidadCorrectaDeSimbolos () {
        Map<String, ArrayList> datosInicializados = this.inicializador.inicializarDatos(jugadores);
        ArrayList<Tarjeta> tarjetas = datosInicializados.get("Tarjetas");

        Integer cantidadComodinesEsperada = 2;
        Integer cantidadGlobosEsperada = (tarjetas.size() - cantidadComodinesEsperada) / 3;
        Integer cantidadCanionesEsperada = (tarjetas.size() - cantidadComodinesEsperada) / 3;
        Integer cantidadBarcosEsperada = (tarjetas.size() - cantidadComodinesEsperada) / 3;
        Integer contadorGlobos = 0;
        Integer contadorCaniones = 0;
        Integer contadorBarcos = 0;
        Integer contadorComodines = 0;

        for (Tarjeta tarjeta: tarjetas) {
            switch (tarjeta.getSimbolo()) {
                case "Globo":
                    contadorGlobos++;
                    break;
                case "Cañon":
                    contadorCaniones++;
                    break;
                case "Barco":
                    contadorBarcos++;
                    break;
                case "Comodin":
                    contadorComodines++;
            }
        }

        assertEquals(cantidadGlobosEsperada, contadorGlobos);
        assertEquals(cantidadCanionesEsperada, contadorCaniones);
        assertEquals(cantidadBarcosEsperada, contadorBarcos);
        assertEquals(cantidadComodinesEsperada, contadorComodines);
    }

    @Test
    public void test13CreoMisionesYHayUnaCantidadCorrectaDeMisiones () {
        Map<String, ArrayList> datosInicializados = this.inicializador.inicializarDatos(jugadores);
        ArrayList<Mision> misiones = datosInicializados.get("Misiones");
        Integer cantidadDeMisiones = 14;
        assertEquals(cantidadDeMisiones, misiones.size());
    }

    @Test
    public void test14CreoMisionesYHayUnaCantidadCorrectaDeMisionesDeDestruccion () {
        Map<String, ArrayList> datosInicializados = this.inicializador.inicializarDatos(jugadores);

        ArrayList<Mision> misiones = datosInicializados.get("Misiones");
        Integer cantidadDeMisionesDestruccion = 0;
        Integer cantidadDeMisionesDestruccionEsperada = 6;
        for (Mision mision: misiones) {
            if (mision instanceof MisionDestruccion)
                cantidadDeMisionesDestruccion++;
        }
        assertEquals(cantidadDeMisionesDestruccionEsperada, cantidadDeMisionesDestruccion);
    }

    @Test
    public void test15CreoMisionesYHayUnaCantidadCorrectaDeMisionesDeConquista () {
        Map<String, ArrayList> datosInicializados = this.inicializador.inicializarDatos(jugadores);

        ArrayList<Mision> misiones = datosInicializados.get("Misiones");
        Integer cantidadDeMisionesConquista = 0;
        Integer cantidadDeMisionesDestruccionEsperada = 8;
        for (Mision mision: misiones) {
            if (mision instanceof MisionConquista)
                cantidadDeMisionesConquista++;
        }
        assertEquals(cantidadDeMisionesDestruccionEsperada, cantidadDeMisionesConquista);
    }

}

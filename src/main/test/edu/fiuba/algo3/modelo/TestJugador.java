package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.CanjeConTarjetaAjenaException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TestJugador {

    private final Integer NRO_EJERCITOS_PRIMER_CANJE = 4;
    private final Integer NRO_EJERCITOS_SEGUNDO_CANJE = 7;
    private final Integer NRO_EJERCITOS_TERCER_CANJE = 10;

    private Jugador jugador;
    private Tarjeta tarjetaArgentina;
    private Tarjeta tarjetaUruguay;
    private Tarjeta tarjetaChile;
    private Tarjeta tarjetaBrasil;
    private Tarjeta tarjetaPeru;

    @BeforeEach
    void setUp() {
        this.jugador = new Jugador("000000");
        Jugador otroJugador = new Jugador("ffffff");

        Pais argentina = new Pais("Argentina", jugador);
        Pais uruguay = new Pais("Uruguay", otroJugador);
        Pais chile = new Pais("Chile", otroJugador);
        Pais brasil = new Pais("Brasil", jugador);
        Pais peru = new Pais("Peru", otroJugador);

        this.tarjetaArgentina = new Tarjeta(argentina, "Globo");
        this.tarjetaUruguay = new Tarjeta(uruguay, "Canion");
        this.tarjetaChile = new Tarjeta(chile, "Barco");
        this.tarjetaBrasil = new Tarjeta(brasil, "Globo");
        this.tarjetaPeru = new Tarjeta(peru, "Globo");
    }

    @Test
    public void test01CreoUnJugadorYNoEsNull () {
       assertNotNull(jugador);
    }

    @Test
    public void test02CreoUnJugadorYTieneElNombreCorrecto () {
        String nombreDelJugador = "000000";
        assertEquals(nombreDelJugador, jugador.toString());
    }

    @Test
    public void test03CreoUnJugadorYAgregoUnaTarjetaCorrectamente () {
        jugador.agregarTarjeta(tarjetaArgentina);
        ArrayList<Tarjeta> tarjetas = new ArrayList<>();
        tarjetas.add(tarjetaArgentina);

        assertEquals(tarjetas, jugador.getTarjetas());
    }

    @Test
    public void test04CreoUnJugadorYAgregoDosTarjetasCorrectamente () {
        jugador.agregarTarjeta(tarjetaArgentina);
        jugador.agregarTarjeta(tarjetaUruguay);
        ArrayList<Tarjeta> tarjetas = new ArrayList<>();
        tarjetas.add(tarjetaArgentina);
        tarjetas.add(tarjetaUruguay);

        assertEquals(tarjetas, jugador.getTarjetas());
    }

    @Test
    public void test05AgregoTresTarjetasIgualesYPuedoCanjearCorrectamente () {
        jugador.agregarTarjeta(tarjetaArgentina);
        jugador.agregarTarjeta(tarjetaBrasil);
        jugador.agregarTarjeta(tarjetaPeru);
        ArrayList<Tarjeta> tarjetas = new ArrayList<>();
        tarjetas.add(tarjetaArgentina);
        tarjetas.add(tarjetaBrasil);
        tarjetas.add(tarjetaPeru);

        assertEquals(NRO_EJERCITOS_PRIMER_CANJE, jugador.canjearTarjetas(tarjetas));
    }

    @Test
    public void test06AgregoTresTarjetasDiferentesYPuedoCanjearCorrectamente () {
        jugador.agregarTarjeta(tarjetaArgentina);
        jugador.agregarTarjeta(tarjetaUruguay);
        jugador.agregarTarjeta(tarjetaChile);
        ArrayList<Tarjeta> tarjetas = new ArrayList<>();
        tarjetas.add(tarjetaArgentina);
        tarjetas.add(tarjetaUruguay);
        tarjetas.add(tarjetaChile);

        assertEquals(NRO_EJERCITOS_PRIMER_CANJE, jugador.canjearTarjetas(tarjetas));
    }

    @Test
    public void test07AgregoDosTarjetasIgualesYUnaDiferenteYNoPuedoCanjear () {
        jugador.agregarTarjeta(tarjetaArgentina);
        jugador.agregarTarjeta(tarjetaUruguay);
        jugador.agregarTarjeta(tarjetaBrasil);
        ArrayList<Tarjeta> tarjetas = new ArrayList<>();
        tarjetas.add(tarjetaArgentina);
        tarjetas.add(tarjetaUruguay);
        tarjetas.add(tarjetaBrasil);

        assertEquals(0, jugador.canjearTarjetas(tarjetas));
    }

    @Test
    public void test08CanjeoYNoPuedoUsarLasMismasTarjetasParaCanjearDeNuevo () {
        jugador.agregarTarjeta(tarjetaArgentina);
        jugador.agregarTarjeta(tarjetaUruguay);
        jugador.agregarTarjeta(tarjetaChile);
        ArrayList<Tarjeta> tarjetas = new ArrayList<>();
        tarjetas.add(tarjetaArgentina);
        tarjetas.add(tarjetaUruguay);
        tarjetas.add(tarjetaChile);
        jugador.canjearTarjetas(tarjetas);

        assertThrows(CanjeConTarjetaAjenaException.class, () -> jugador.canjearTarjetas(tarjetas));
    }

    @Test
    public void test09CanjeoDosVecesYDevuelveLaCantidadCorrectaDeEjercitos () {
        ArrayList<Tarjeta> tarjetas = new ArrayList<>();
        tarjetas.add(tarjetaArgentina);
        tarjetas.add(tarjetaUruguay);
        tarjetas.add(tarjetaChile);

        jugador.agregarTarjeta(tarjetaArgentina);
        jugador.agregarTarjeta(tarjetaUruguay);
        jugador.agregarTarjeta(tarjetaChile);
        jugador.canjearTarjetas(tarjetas);
        jugador.agregarTarjeta(tarjetaArgentina);
        jugador.agregarTarjeta(tarjetaUruguay);
        jugador.agregarTarjeta(tarjetaChile);

        assertEquals(NRO_EJERCITOS_SEGUNDO_CANJE, jugador.canjearTarjetas(tarjetas));
    }

    @Test
    public void test10CanjeoTresVecesYDevuelveLaCantidadCorrectaDeEjercitos () {
        ArrayList<Tarjeta> tarjetas = new ArrayList<>();
        tarjetas.add(tarjetaArgentina);
        tarjetas.add(tarjetaUruguay);
        tarjetas.add(tarjetaChile);

        jugador.agregarTarjeta(tarjetaArgentina);
        jugador.agregarTarjeta(tarjetaUruguay);
        jugador.agregarTarjeta(tarjetaChile);
        jugador.canjearTarjetas(tarjetas);
        jugador.agregarTarjeta(tarjetaArgentina);
        jugador.agregarTarjeta(tarjetaUruguay);
        jugador.agregarTarjeta(tarjetaChile);
        jugador.canjearTarjetas(tarjetas);
        jugador.agregarTarjeta(tarjetaArgentina);
        jugador.agregarTarjeta(tarjetaUruguay);
        jugador.agregarTarjeta(tarjetaChile);

        assertEquals(NRO_EJERCITOS_TERCER_CANJE, jugador.canjearTarjetas(tarjetas));
    }

    @Test
    public void test11CanjeoCuatroVecesYDevuelveLaCantidadCorrectaDeEjercitos () {
        ArrayList<Tarjeta> tarjetas = new ArrayList<>();
        tarjetas.add(tarjetaArgentina);
        tarjetas.add(tarjetaUruguay);
        tarjetas.add(tarjetaChile);

        jugador.agregarTarjeta(tarjetaArgentina);
        jugador.agregarTarjeta(tarjetaUruguay);
        jugador.agregarTarjeta(tarjetaChile);
        jugador.canjearTarjetas(tarjetas);
        jugador.agregarTarjeta(tarjetaArgentina);
        jugador.agregarTarjeta(tarjetaUruguay);
        jugador.agregarTarjeta(tarjetaChile);
        jugador.canjearTarjetas(tarjetas);
        jugador.agregarTarjeta(tarjetaArgentina);
        jugador.agregarTarjeta(tarjetaUruguay);
        jugador.agregarTarjeta(tarjetaChile);
        jugador.canjearTarjetas(tarjetas);
        jugador.agregarTarjeta(tarjetaArgentina);
        jugador.agregarTarjeta(tarjetaUruguay);
        jugador.agregarTarjeta(tarjetaChile);

        Integer nroDeEjercitosCuartoCanje = 15;
        assertEquals(nroDeEjercitosCuartoCanje, jugador.canjearTarjetas(tarjetas));
    }

    @Test
    public void test12CanjeoVeinteVecesYDevuelveLaCantidadCorrectaDeEjercitos () {
        ArrayList<Tarjeta> tarjetas = new ArrayList<>();
        tarjetas.add(tarjetaArgentina);
        tarjetas.add(tarjetaUruguay);
        tarjetas.add(tarjetaChile);
        for (int i = 0; i < 14; i++) {
            jugador.agregarTarjeta(tarjetaArgentina);
            jugador.agregarTarjeta(tarjetaUruguay);
            jugador.agregarTarjeta(tarjetaChile);
            jugador.canjearTarjetas(tarjetas);
        }
        jugador.agregarTarjeta(tarjetaArgentina);
        jugador.agregarTarjeta(tarjetaUruguay);
        jugador.agregarTarjeta(tarjetaChile);

        Integer nroDeEjercitosCanjeQuince = 70;
        assertEquals(nroDeEjercitosCanjeQuince, jugador.canjearTarjetas(tarjetas));
    }



}

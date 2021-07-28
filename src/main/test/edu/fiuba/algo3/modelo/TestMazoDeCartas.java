package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.CanjeConTarjetaAjenaException;
import edu.fiuba.algo3.modelo.excepciones.CanjeInvalidoException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestMazoDeCartas {

    private final Integer NRO_EJERCITOS_PRIMER_CANJE = 4;
    private final Integer NRO_EJERCITOS_SEGUNDO_CANJE = 7;
    private final Integer NRO_EJERCITOS_TERCER_CANJE = 10;

    private Jugador jugador;
    private Jugador otroJugador;
    private Tarjeta tarjetaArgentina;
    private Tarjeta tarjetaUruguay;
    private Tarjeta tarjetaChile;
    private Tarjeta tarjetaBrasil;
    private Tarjeta tarjetaPeru;
    private MazoDeTarjetas mazo;

    @BeforeEach
    void setUp() {
        this.jugador = new Jugador("000000");
        this.otroJugador = new Jugador("ffffff");

        Pais argentina = new Pais("Argentina", jugador);
        Pais uruguay = new Pais("Uruguay", otroJugador);
        Pais chile = new Pais("Chile", otroJugador);
        Pais brasil = new Pais("Brasil", jugador);
        Pais peru = new Pais("Peru", otroJugador);

        ArrayList<Tarjeta> tarjetas = new ArrayList<>();
        this.tarjetaArgentina = new Tarjeta(argentina, "Globo");
        this.tarjetaUruguay = new Tarjeta(uruguay, "Canion");
        this.tarjetaChile = new Tarjeta(chile, "Barco");
        this.tarjetaBrasil = new Tarjeta(brasil, "Globo");
        this.tarjetaPeru = new Tarjeta(peru, "Globo");
        tarjetas.add(tarjetaArgentina);
        tarjetas.add(tarjetaUruguay);
        tarjetas.add(tarjetaChile);
        tarjetas.add(tarjetaBrasil);
        tarjetas.add(tarjetaPeru);

        this.mazo = new MazoDeTarjetas(tarjetas);
    }

    @Test
    public void test03CreoUnJugadorYAgregoUnaTarjetaCorrectamente () {
        mazo.darTarjetaPredeterminado(jugador, tarjetaArgentina.toString());
        ArrayList<String> tarjetas = new ArrayList<>();
        tarjetas.add(tarjetaArgentina.toString());

        assertEquals(tarjetas, mazo.obtenerNombreTarjetasDe(jugador));
    }

    @Test
    public void test04CreoUnJugadorYAgregoDosTarjetasCorrectamente () {
        mazo.darTarjetaPredeterminado(jugador, tarjetaArgentina.toString());
        mazo.darTarjetaPredeterminado(jugador, tarjetaUruguay.toString());
        ArrayList<String> tarjetas = new ArrayList<>();
        tarjetas.add(tarjetaArgentina.toString());
        tarjetas.add(tarjetaUruguay.toString());

        assertEquals(tarjetas, mazo.obtenerNombreTarjetasDe(jugador));
    }

    @Test
    public void test05AgregoTresTarjetasIgualesYPuedoCanjearCorrectamente () {
        mazo.darTarjetaPredeterminado(jugador, tarjetaArgentina.toString());
        mazo.darTarjetaPredeterminado(jugador, tarjetaBrasil.toString());
        mazo.darTarjetaPredeterminado(jugador, tarjetaPeru.toString());
        ArrayList<String> tarjetas = new ArrayList<>();
        tarjetas.add(tarjetaArgentina.toString());
        tarjetas.add(tarjetaBrasil.toString());
        tarjetas.add(tarjetaPeru.toString());

        assertEquals(NRO_EJERCITOS_PRIMER_CANJE, mazo.canjearTarjetas(tarjetas, jugador));
    }

    @Test
    public void test06AgregoTresTarjetasDiferentesYPuedoCanjearCorrectamente () {
        mazo.darTarjetaPredeterminado(jugador, tarjetaArgentina.toString());
        mazo.darTarjetaPredeterminado(jugador, tarjetaUruguay.toString());
        mazo.darTarjetaPredeterminado(jugador, tarjetaChile.toString());
        ArrayList<String> tarjetas = new ArrayList<>();
        tarjetas.add(tarjetaArgentina.toString());
        tarjetas.add(tarjetaUruguay.toString());
        tarjetas.add(tarjetaChile.toString());

        assertEquals(NRO_EJERCITOS_PRIMER_CANJE, mazo.canjearTarjetas(tarjetas, jugador));
    }

    @Test
    public void test07AgregoDosTarjetasIgualesYUnaDiferenteYNoPuedoCanjear () {
        mazo.darTarjetaPredeterminado(jugador, tarjetaArgentina.toString());
        mazo.darTarjetaPredeterminado(jugador, tarjetaUruguay.toString());
        mazo.darTarjetaPredeterminado(jugador, tarjetaBrasil.toString());
        ArrayList<String> tarjetas = new ArrayList<>();
        tarjetas.add(tarjetaArgentina.toString());
        tarjetas.add(tarjetaUruguay.toString());
        tarjetas.add(tarjetaBrasil.toString());

        assertEquals(0, mazo.canjearTarjetas(tarjetas, jugador));
    }

    @Test
    public void test08CanjeoYNoPuedoUsarLasMismasTarjetasParaCanjearDeNuevo () {
        mazo.darTarjetaPredeterminado(jugador, tarjetaArgentina.toString());
        mazo.darTarjetaPredeterminado(jugador, tarjetaUruguay.toString());
        mazo.darTarjetaPredeterminado(jugador, tarjetaChile.toString());
        ArrayList<String> tarjetas = new ArrayList<>();
        tarjetas.add(tarjetaArgentina.toString());
        tarjetas.add(tarjetaUruguay.toString());
        tarjetas.add(tarjetaChile.toString());
        mazo.canjearTarjetas(tarjetas, jugador);

        assertThrows(CanjeInvalidoException.class, () -> mazo.canjearTarjetas(tarjetas, jugador));
    }

    @Test
    public void test09CanjeoDosVecesYDevuelveLaCantidadCorrectaDeEjercitos () {
        ArrayList<String> tarjetas = new ArrayList<>();
        tarjetas.add(tarjetaArgentina.toString());
        tarjetas.add(tarjetaUruguay.toString());
        tarjetas.add(tarjetaChile.toString());

        mazo.darTarjetaPredeterminado(jugador, tarjetaArgentina.toString());
        mazo.darTarjetaPredeterminado(jugador, tarjetaUruguay.toString());
        mazo.darTarjetaPredeterminado(jugador, tarjetaChile.toString());
        mazo.canjearTarjetas(tarjetas, jugador);
        mazo.darTarjetaPredeterminado(jugador, tarjetaArgentina.toString());
        mazo.darTarjetaPredeterminado(jugador, tarjetaUruguay.toString());
        mazo.darTarjetaPredeterminado(jugador, tarjetaChile.toString());

        assertEquals(NRO_EJERCITOS_SEGUNDO_CANJE, mazo.canjearTarjetas(tarjetas, jugador));
    }

    @Test
    public void test10CanjeoTresVecesYDevuelveLaCantidadCorrectaDeEjercitos () {
        ArrayList<String> tarjetas = new ArrayList<>();
        tarjetas.add(tarjetaArgentina.toString());
        tarjetas.add(tarjetaUruguay.toString());
        tarjetas.add(tarjetaChile.toString());

        mazo.darTarjetaPredeterminado(jugador, tarjetaArgentina.toString());
        mazo.darTarjetaPredeterminado(jugador, tarjetaUruguay.toString());
        mazo.darTarjetaPredeterminado(jugador, tarjetaChile.toString());
        mazo.canjearTarjetas(tarjetas, jugador);
        mazo.darTarjetaPredeterminado(jugador, tarjetaArgentina.toString());
        mazo.darTarjetaPredeterminado(jugador, tarjetaUruguay.toString());
        mazo.darTarjetaPredeterminado(jugador, tarjetaChile.toString());
        mazo.canjearTarjetas(tarjetas, jugador);
        mazo.darTarjetaPredeterminado(jugador, tarjetaArgentina.toString());
        mazo.darTarjetaPredeterminado(jugador, tarjetaUruguay.toString());
        mazo.darTarjetaPredeterminado(jugador, tarjetaChile.toString());

        assertEquals(NRO_EJERCITOS_TERCER_CANJE, mazo.canjearTarjetas(tarjetas, jugador));
    }

    @Test
    public void test11CanjeoCuatroVecesYDevuelveLaCantidadCorrectaDeEjercitos () {
        ArrayList<String> tarjetas = new ArrayList<>();
        tarjetas.add(tarjetaArgentina.toString());
        tarjetas.add(tarjetaUruguay.toString());
        tarjetas.add(tarjetaChile.toString());

        mazo.darTarjetaPredeterminado(jugador, tarjetaArgentina.toString());
        mazo.darTarjetaPredeterminado(jugador, tarjetaUruguay.toString());
        mazo.darTarjetaPredeterminado(jugador, tarjetaChile.toString());
        mazo.canjearTarjetas(tarjetas, jugador);
        mazo.darTarjetaPredeterminado(jugador, tarjetaArgentina.toString());
        mazo.darTarjetaPredeterminado(jugador, tarjetaUruguay.toString());
        mazo.darTarjetaPredeterminado(jugador, tarjetaChile.toString());
        mazo.canjearTarjetas(tarjetas, jugador);
        mazo.darTarjetaPredeterminado(jugador, tarjetaArgentina.toString());
        mazo.darTarjetaPredeterminado(jugador, tarjetaUruguay.toString());
        mazo.darTarjetaPredeterminado(jugador, tarjetaChile.toString());
        mazo.canjearTarjetas(tarjetas, jugador);
        mazo.darTarjetaPredeterminado(jugador, tarjetaArgentina.toString());
        mazo.darTarjetaPredeterminado(jugador, tarjetaUruguay.toString());
        mazo.darTarjetaPredeterminado(jugador, tarjetaChile.toString());

        Integer nroDeEjercitosCuartoCanje = 15;
        assertEquals(nroDeEjercitosCuartoCanje, mazo.canjearTarjetas(tarjetas, jugador));
    }

    @Test
    public void test12CanjeoQuinceVecesYDevuelveLaCantidadCorrectaDeEjercitos () {
        ArrayList<String> tarjetas = new ArrayList<>();
        tarjetas.add(tarjetaArgentina.toString());
        tarjetas.add(tarjetaUruguay.toString());
        tarjetas.add(tarjetaChile.toString());
        for (int i = 0; i < 14; i++) {
            mazo.darTarjetaPredeterminado(jugador, tarjetaArgentina.toString());
            mazo.darTarjetaPredeterminado(jugador, tarjetaUruguay.toString());
            mazo.darTarjetaPredeterminado(jugador, tarjetaChile.toString());
            mazo.canjearTarjetas(tarjetas, jugador);
        }
        mazo.darTarjetaPredeterminado(jugador, tarjetaArgentina.toString());
        mazo.darTarjetaPredeterminado(jugador, tarjetaUruguay.toString());
        mazo.darTarjetaPredeterminado(jugador, tarjetaChile.toString());

        Integer nroDeEjercitosCanjeQuince = 70;
        assertEquals(nroDeEjercitosCanjeQuince, mazo.canjearTarjetas(tarjetas, jugador));
    }

}

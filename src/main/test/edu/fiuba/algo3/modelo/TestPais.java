package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import edu.fiuba.algo3.modelo.excepciones.*;

public class TestPais {


        @Test
        public void test01CreoUnPaisYNoEsNull (){
            Jugador jugador = new Jugador("000000");
            Pais pais = new Pais("Argentina", jugador);

            assertNotNull(pais);
        }

        @Test
        public void test02CreoUnPaisYLeAsignoDuenio (){
            Jugador jugador = new Jugador("000000");
            Pais pais = new Pais("Argentina", jugador);

            assertEquals(pais.getPaisOcupadoPor(), jugador);
        }

        @Test
        public void test03CreoUnPaisYTieneUnEjercito (){
            Jugador jugador = new Jugador("000000");
            Pais pais = new Pais("Argentina", jugador);
            assertEquals(pais.getEjercitos(), 1);
        }

        @Test
        public void test04CreoUnPaisYTieneUnEjercitoConElCualNoPuedeAtacar (){
            Jugador jugador = new Jugador("000000");
            Pais pais = new Pais("Argentina", jugador);
            assertThrows(EjercitosInsuficientesException.class, () -> pais.getEjercitosParaAtacar());
        }

        @Test
        public void test05CreoUnPaisYLoRefuerzoConDosEjercitosYAhoraTieneTresEjercitos (){
            Jugador jugador = new Jugador("000000");
            Pais pais = new Pais("Argentina", jugador);
            pais.reforzar(jugador,2);
            assertEquals(pais.getEjercitos(), 3);
        }

        @Test
        public void test06CreoUnPaisYLoRefuerzoConDosEjercitosYAhoraTieneDosEjercitosParaAtacar (){
            Jugador jugador = new Jugador("000000");
            Pais pais = new Pais("Argentina", jugador);
            pais.reforzar(jugador, 2);
            assertEquals(pais.getEjercitosParaAtacar(), 2);
        }

        @Test
        public void test07CreoUnPaisYLoRefuerzoConDiezEjercitosYAhoraTieneTresEjercitosParaAtacar(){
            Jugador jugador = new Jugador("000000");
            Pais pais = new Pais("Argentina", jugador);
            pais.reforzar(jugador,10);
            assertEquals(pais.getEjercitosParaAtacar(), 3);
        }

        @Test
        public void test08Pais1ConquistaAPais2YPais2EsAliadoDePais1(){
            Jugador jugador1 = new Jugador("000000");
            Jugador jugador2 = new Jugador("ffffff");

            Pais pais1 = new Pais("Argentina",jugador1);
            Pais pais2 = new Pais("Uruguay", jugador2);
            pais1.conquistar(pais2);
            assertTrue(pais1.esAliado(pais2));
        }

        @Test
        public void test09DosPaisesDeUnJugadorSonAliados(){
            Jugador jugador1 = new Jugador("000000");
            Pais pais1 = new Pais("Argentina",jugador1);
            Pais pais2 = new Pais("Uruguay", jugador1);
            assertTrue(pais1.esAliado(pais2));
        }
    }

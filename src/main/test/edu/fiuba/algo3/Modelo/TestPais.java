package edu.fiuba.algo3.Modelo;

public class TestPais {
    public class pruebasPais {
        @Test
        public void test01CreoUnPaisYNoEsNull (){
            Pais pais = new Pais;

            assertNotNull(pais);
        }

        @Test
        public void test02CreoUnPaisYLeAsignoDuenio (){
            Jugador jugador = new Jugador("000000");
            Pais pais = new Pais;
            pais.asignarDueño(jugador);

            assertNotNull(pais.ObtenerDuenio);
        }

        @Test
        public void test03CreoUnPaisYTieneUnEjercito (){
            Jugador jugador = new Jugador("000000");
            Pais pais = new Pais(jugador);
            assertEquals(pais.getEjercitos(), 1);
        }

        @Test
        public void test04CreoUnPaisYTieneUnEjercitoConElCualNoPuedeAtacar (){
            Jugador jugador = new Jugador("000000");
            Pais pais = new Pais(jugador);
            assertThrows(EjercitosInsuficientesException.class, () -> pais.getEjercitosParaAtacar());
        }

        @Test
        public void test04CreoUnPaisYLoRefuerzoConDosEjercitosYAhoraTieneTresEjercitos (){
            Jugador jugador = new Jugador("000000");
            Pais pais = new Pais(jugador);
            pais.reforzar(2);
            assertEquals(pais.getEjercitos(), 3);
        }

        @Test
        public void test04CreoUnPaisYLoRefuerzoConDosEjercitosYAhoraTieneDosEjercitosParaAtacar (){
            Jugador jugador = new Jugador("000000");
            Pais pais = new Pais(jugador);
            pais.reforzar(2);
            assertEquals(pais.getEjercitosParaAtacar(), 2);
        }

        @Test
        public void test05CreoUnPaisYLoRefuerzoConDiezEjercitosYAhoraTieneTresEjercitosParaAtacar{
            Jugador jugador = new Jugador("000000");
            Pais pais = new Pais(jugador);
            pais.reforzar(10);
            assertEquals(pais.getEjercitosParaAtacar(), 3);
        }

        // agregar checkeo de correcto funcionamiento de pais1.conquistar(pais2)
}

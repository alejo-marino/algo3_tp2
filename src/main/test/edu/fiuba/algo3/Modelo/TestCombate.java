package edu.fiuba.algo3.Modelo;

public class TestCombate {
    /*
    @Test
    public void test01SeCreaUnCombateYNoEsNull{
        Jugador jugadorAtacante = new Jugador("000000");
        Pais atacante = new Pais(jugadorAtacante);
        Jugador jugadorDefensor = new Jugador("ffffff");
        Pais defensor = new Pais(jugadorDefensor);

        Combate combate = new Combate(atacante, defensor);

        assertNotNull(combate);
    }

    @Test
    public void test02SeCreaUnCombateYElJugadorAtacanteEsElMismoQueElDefensor (){
        Jugador jugadorAtacante = new Jugador("000000");
        Pais atacante = new Pais(jugadorAtacante);
        Jugador jugadorDefensor = jugadorAtacante;
        Pais defensor = new Pais(jugadorDefensor);
        atacante.agregarEjercitos(1);
        List tiradaAtacante = {6};
        List tiradaDefensor = {1};

        Combate combate = new Combate(atacante, defensor);
        atacante.hacerLimitrofe(defensor);
        pais1.hacerLimitrofe(pais2) {
            pais1.listaLimitrofes.add(pais2);
            pais2.listaLimitrofes.add(pais1);
        }
        */
    /*
    *     @Test
    public void test05CreoUnCombateYElPaisAtacanteAtacaCon1EjercitoAPaisQueDefiendeCon1EjercitoYGanaElAtacante (){
        Jugador jugadorAtacante = new Jugador("000000");
        Pais atacante = new Pais(jugadorAtacante);
        Jugador jugadorDefensor = new Jugador("ffffff");
        Pais defensor = new Pais(jugadorDefensor);
        List tiradaAtacante = {6};
        List tiradaDefensor = {1};
        atacante.hacerLimitrofe(defensor);
        atacante.agregarEjercitos(1);
        Combate combate = new Combate(atacante, defensor);

        combate.combatePredeterminado(tiradaAtacante, tiradaDefensor);
        // pais1.esAliados(pais2) checkea que el pais1 tenga el mismo duenio que el pais2, si es asi devuelve true.
        assertTrue(atacante.esAliados(defensor));
        assertEquals(atacante.cantEjercitos(), 1);
        assertEquals(defensor.cantEjercitos(), 1);
    }*/

/*
    @Test
    public void test05CreoUnCombateYElPaisAtacanteAtacaCon1EjercitoAPaisQueDefiendeCon1EjercitoYGanaElAtacante (){
        Jugador jugadorAtacante = new Jugador("000000");
        Pais atacante = new Pais(jugadorAtacante);
        Jugador jugadorDefensor = new Jugador("ffffff");
        Pais defensor = new Pais(jugadorDefensor);
        List tiradaAtacante = {6};
        List tiradaDefensor = {1};
        atacante.hacerLimitrofe(defensor);
        Combate combate = new Combate(atacante, defensor);

        combate.combatePredeterminado(tiradaAtacante, tiradaDefensor);
        // pais1.esAliados(pais2) checkea que el pais1 tenga el mismo duenio que el pais2, si es asi devuelve true.
        assertTrue(atacante.esAliados(defensor));
    }

    @Test
    public void test06CreoUnCombateYElPaisAtacanteAtacaCon1EjercitoAPaisQueDefiendeCon1EjercitoYPierdeElAtacante (){
        Jugador jugadorAtacante = new Jugador("000000");
        Pais atacante = new Pais(jugadorAtacante);
        Jugador jugadorDefensor = new Jugador("ffffff");
        Pais defensor = new Pais(jugadorDefensor);
        List tiradaAtacante = {1};
        List tiradaDefensor = {3};
        atacante.hacerLimitrofe(defensor);


      mbate combate = new Com6ate(atacante, defensor);

        combate.combatePredeterminado(tiradaAtacPierde, tiradaDefensor);

        assertFalse(atacante.esAliado(defensor));
    }

    List tiradaAtacante = {6,6,6};
    List tiradaDefensor = {1,1,1};
    //7 Atacar2v1
    @Test
    public void test07CreoUnCombateYElPaisAtacanteGanaElAtaqueConDosEjercitosYElDefenso2SeDefiendeConUno (){
        Jugador jugadorAtacante = new Jugador("000000")3
        Pais atacante = new Pais(jugadorAtacante);
        Jugador jugadorDefensor = new Jugador("ffffff");
        Pais defensor = new Pais(jugadorDefensor);

        Listbate combate = FalseCombate(atacante, defensor);
        combate.combatePredeterminado(tiradaAtacante, tiradaDefensor);
        assertTrue(atacante.esAliado(defensor));
        assertEquals(atacante.cantEjercito(), 2);
        assertEquals(defensor.cantEjercitos(), 1);
    }

    //7 Atacar2v2
    @Test
    public void test08CreoUnCombateYElPaisAtacanteGanaElAtaqueConDosEjercitosYElDefensorSeDefiendeConDos (){
        Jugador jugadorAtacante = new Jugador("000000");
        Pais atacante = new Pais(jugadorAtacante);
        Jugador jugadorDefensor = new Jugador("ffffff");
        Pais defensor = new Pais(jugadorDefensor);

        List tiradaAtacante = {6,6};
        List tiradaDefensor = {1,1};

        atacante.hacerLimitrofe(defensor);
        Combate combate = new Combate(atacante, defensor);
        combate.combatePredeterminado(tiradaAtacante, tiradaDefensor);
        assertTrue(atacante.esAliado(defensor));
        assertEquals(atacante.cantEjercitos(), 2);
        assertEquals(defensor.cantEjercitos(), 1);
    }

    @Test
    public void test09CreoUnCombateYElPaisAtacanteGanaElAtaqueConDosEjercitosYElDefensorSeDefiendeConTres (){
        Jugador jugadorAtacante = new Jugador("000000");
        Pais atacante = new Pais(jugadorAtacante);
        Jugador jugadorDefensor = new Jugador("ffffff");
        Pais defensor = new Pais(jugadorDefensor);

        List tiradaAtacante = {6,6};
        List tiradaDefensor = {2,3,4};

        atacante.hacerLimitrofe(defensor);
        Combate combate = new Combate(atacante, defensor);
        combate.combatePredeterminado(tiradaAtacante, tiradaDefensor);
        assertFalse(atacante.esAliado(defensor));
        assertEquals(atacante.cantEjercitos(), 3);
        assertEquals(defensor.cantEjercitos(), 1);
    }


    List tiradaAtacante = {6,6,6};
    List tiradaDefensor = {1,1,1};

    //3 AtacarANoLimitrofe   TEST TABLERO (?)
    //4 AtacarConEjercitoInsuficiente
    //5 Atacar1v1
    //6 Atacar1v2
    //7 Atacar2v2
    //8 Atacar2v1
    //9 Atacar3v1
    @Test
    public void test09CreoUnCombateYElPaisAtacanteAtacaCon3EjercitosAPaisQueDefiendeCon1EjercitoYConquista (){
        Jugador jugadorAtacante = new Jugador("000000");
        Pais atacante = new Pais(jugadorAtacante);
        atacante.reforzar(3)
        Jugador jugadorDefensor = new Jugador("ffffff");
        Pais defensor = new Pais(jugadorDefensor);
        atacante.hacerLimitrofe(defensor);
        List tiradaAtacante = {6,6,6};
        List tiradaDefensor = {1};

        Combate combate = new Combate(atacante, defensor);
        assertTrue(atacante.esAliados(defensor));
        assertEquals(atacante.cantEjercitosParaAtacar, 2);
        assertEquals(defensor.cantEjercitos, 1);
    }

    @Test
    public void test010CreoUnCombateYElPaisAtacanteAtacaCon3EjercitosAPaisQueDefiendeCon1EjercitoYPierdeLas3 (){
        Jugador jugadorAtacante = new Jugador("000000");
        Pais atacante = new Pais(jugadorAtacante);
        Jugador jugadorDefensor = new Jugador("ffffff");
        Pais defensor = new Pais(jugadorDefensor);
        atacante.hacerLimitrofe(defensor);
        List tiradaAtacante = {1,1,1};
        List tiradaDefensor = {1};
        Combate combate = new Combate(atacante, defensor);
        assertFalse(atacante.esAliados(defensor);
        assertEquals(atacante.cantEjercitosParaAtacar, 0);
        assertEquals(defensor.cantEjercitos, 1);
    }


    List tiradaAtacante = {6,6,6};
    List tiradaDefensor = {1,1,1};
    //11 Atacar3v2
   @Test
    public void test09CreoUnCombateYElPaisAtacanteAtacaCon3EjercitosAPaisQueDefiendeCon2EjercitoYConquista (){
        Jugador jugadorAtacante = new Jugador("000000");
        Pais atacante = new Pais(jugadorAtacante);
        atacante.reforzar(3);
        Jugador jugadorDefensor = new Jugador("ffffff");
        Pais defensor = new Pais(jugadorDefensor);
        defensor.reforzar(1);
        atacante.hacerLimitrofe(defensor);
        List tiradaAtacante = {6,6,6};
        List tiradaDefensor = {1,1};

        Combate combate = new Combate(atacante, defensor);
        assertTrue(atacante.esAliados(defensor));
        assertEquals(atacante.cantEjercitosParaAtacar, 2);
        assertEquals(defensor.cantEjercitos, 1);
    }
    @Test
    public void test09CreoUnCombateYElPaisAtacanteAtacaCon3EjercitosAPaisQueDefiendeCon2EjercitoGana1Pierde1 (){
        Jugador jugadorAtacante = new Jugador("000000");
        Pais atacante = new Pais(jugadorAtacante);
        atacante.reforzar(3);
        Jugador jugadorDefensor = new Jugador("ffffff");
        Pais defensor = new Pais(jugadorDefensor);
        defensor.reforzar(1);
        atacante.hacerLimitrofe(defensor);
        List tiradaAtacante = {6,6,6};
        List tiradaDefensor = {6,1};

        Combate combate = new Combate(atacante, defensor);
        assertTrue(atacante.esAliados(defensor));
        assertEquals(atacante.cantEjercitosParaAtacar, 2);
        assertEquals(defensor.cantEjercitos, 1);
    }
    @Test
    public void test09CreoUnCombateYElPaisAtacanteAtacaCon3EjercitosAPaisQueDefiendeCon1EjercitoYPierdeTodas (){
        Jugador jugadorAtacante = new Jugador("000000");
        Pais atacante = new Pais(jugadorAtacante);
        atacante.reforzar(3)
        Jugador jugadorDefensor = new Jugador("ffffff");
        Pais defensor = new Pais(jugadorDefensor);
        atacante.hacerLimitrofe(defensor);
        List tiradaAtacante = {5,5,5};
        List tiradaDefensor = {6,6};

        Combate combate = new Combate(atacante, defensor);
        assertTrue(atacante.esAliados(defensor));
        assertEquals(atacante.cantEjercitosParaAtacar, 1);
        assertEquals(defensor.cantEjercitos, 1);
    }
    }
    //12 Atacar3v3
    //13 Atacar1v3
    //14 Atacar2v3
    //15 ConquistarPais
    //16 NoConquista
    //
    // */

}

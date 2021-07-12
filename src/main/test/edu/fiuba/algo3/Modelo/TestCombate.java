package edu.fiuba.algo3.Modelo;

public class TestCombate {}
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
        Pais atacamte = new Pais(jugadorAtacante);
        Jugador JugadorDefensor = jugadorAtacante;
        Pais defr = new Pais(jugadorDefensor);
        atacante.agregarEjercitos(1);
        List tiradaAtacante = {6};
        List tiradaDefensor = {1};

        Combate combate = new Combate(atacante, defensor);
        atacante.haceerLimitrofe(defensor);
        /* pais1erLimitrofe(pais2) {
            pais1.listaLimitrofes.add(pais2);
            pais2.listaLimitrofes.add(pais1);
        }     */
    //assertThrows(AtaqueAPaisPropioException.class, () -> combate.combatePredeterminado(tiradaAtacante, tiradaDefensor}

    /*
    @Test
    public void test03CreoUnCombateYElPaisAtacadoNoEsLimitrofe(){
        Jugador jugadorAtacante = new Jugador("000000");
        Pais atacante = new Pais(jugadorAtacante);
        Jugador jugadorDefensor = new Jugador("ffffff");
        Pais defensor = new Pais(jugadorDefensor);

        Combate combate = new Combate(atacante, defensor);
        assertThrows(AtaqueAPaisNoLimitrofeException.class, () -> combate.combatePredeterminado(tiradaAtacante, tiradaDefensor));
    }

    @Test
    public void test04CreoUnCombateYElPaisAtacanteIntentaAtacarPeroNoTieneEjercitosSuficientes (){
        Jugador jugadorAtacante = new Jugador("000000");
        Pais atacante = new Pais(jugadorAtacante);
        Jugador jugadorDefensor = new Jugador("ffffff");
        Pais defensor = new Pais(jugadorDefensor);
        List tiradaAtacante = {6};
        List tiradaDefensor = {1};

        Combate combate = new Combate(atacante, defensor);

        assertThrows(cantidadEjercitosInsuficienteParaAtacarException.class, () -> combate.combatePredeterminado(tiradaAtacante, tiradaDefensor));
    }
    // 1v1 conquista
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
        assertEquals(atacante.cantEjercitos, 1);
        assertEquals(defensor.cantEjercitos, 1);
    }*/

/*
    // 1v1 pierde atacante
    @Test
    public void test06CreoUnCombateYElPaisAtacanteAtacaCon1EjercitoAPaisQueDefiendeCon1EjercitoYPierdeElAtacante (){
        Jugador jugadorAtacante = new Jugador("000000");
        Pais atacante = new Pais(jugadorAtacante);
        Jugador jugadorDefensor = new Jugador("ffffff");
        Pais defensor = new Pais(jugadorDefensor);
        List tiradaAtacante = {1};
        List tiradaDefensor = {3};
        atacante.hacerLimitrofe(defensor);
        Combate combate = new Combate(atacante, defensor);

        combate.combatePredeterminado(tiradaAtacante, tiradaDefensor);

        assertFalse(atacante.esAliado(defensor));
        assertEquals(atacante.cantEjercitos, 1);
        assertEquals(defensor.cantEjercitos, 1);
    }

    // 2v1 conquista
    @Test
    public void test07CreoUnCombateYElPaisAtacanteAtacaCon2EjercitosAPaisQueDefiendeCon1EjercitoYGanaElAtacante (){
        Jugador jugadorAtacante = new Jugador("000000");
        Pais atacante = new Pais(jugadorAtacante);
        Jugador jugadorDefensor = new Jugador("ffffff");
        Pais defensor = new Pais(jugadorDefensor);
        List tiradaAtacante = {6,6};
        List tiradaDefensor = {1};
        atacante.hacerLimitrofe(defensor);
        Combate combate = new Combate(atacante, defensor);

        combate.combatePredeterminado(tiradaAtacante, tiradaDefensor);

        assertTrue(atacante.esAliado(defensor));
        assertEquals(atacante.cantEjercitos, 2);
        assertEquals(defensor.cantEjercitos, 1);
    }

    // 2v1 pierde atacante
    @Test
    public void test08CreoUnCombateYElPaisAtacanteAtacaCon2EjercitosAPaisQueDefiendeCon1EjercitoYPierdeElAtacante (){
        Jugador jugadorAtacante = new Jugador("000000");
        Pais atacante = new Pais(jugadorAtacante);
        Jugador jugadorDefensor = new Jugador("ffffff");
        Pais defensor = new Pais(jugadorDefensor);
        List tiradaAtacante = {1,3};
        List tiradaDefensor = {3};
        atacante.hacerLimitrofe(defensor);
        Combate combate = new Combate(atacante, defensor);

        combate.combatePredeterminado(tiradaAtacante, tiradaDefensor);

        assertFalse(atacante.esAliado(defensor));
        assertEquals(atacante.cantEjercitos, 2);
        assertEquals(defensor.cantEjercitos, 1);
    }

    // 2v2 conquista
    @Test
    public void test09CreoUnCombateYElPaisAtacanteAtacaCon2EjercitosAPaisQueDefiendeCon2EjercitosYGanaElAtacante (){
        Jugador jugadorAtacante = new Jugador("000000");
        Pais atacante = new Pais(jugadorAtacante);
        Jugador jugadorDefensor = new Jugador("ffffff");
        Pais defensor = new Pais(jugadorDefensor);
        List tiradaAtacante = {6,2};
        List tiradaDefensor = {1,1};
        atacante.hacerLimitrofe(defensor);
        Combate combate = new Combate(atacante, defensor);

        combate.combatePredeterminado(tiradaAtacante, tiradaDefensor);

        assertTrue(atacante.esAliado(defensor));
        assertEquals(atacante.cantEjercitos, 2);
        assertEquals(defensor.cantEjercitos, 1);
    }

    // 2v2 pierde atacante
    @Test
    public void test10CreoUnCombateYElPaisAtacanteAtacaCon2EjercitosAPaisQueDefiendeCon2EjercitosYPierdeElAtacante (){
        Jugador jugadorAtacante = new Jugador("000000");
        Pais atacante = new Pais(jugadorAtacante);
        Jugador jugadorDefensor = new Jugador("ffffff");
        Pais defensor = new Pais(jugadorDefensor);
        List tiradaAtacante = {1,2};
        List tiradaDefensor = {2,2};
        atacante.hacerLimitrofe(defensor);
        Combate combate = new Combate(atacante, defensor);

        combate.combatePredeterminado(tiradaAtacante, tiradaDefensor);

        assertFalse(atacante.esAliado(defensor));
        assertEquals(atacante.cantEjercitos, 1);
        assertEquals(defensor.cantEjercitos, 2);
    }

    @Test
    public void test11CreoUnCombateYElPaisAtacanteGanaElAtaqueConDosEjercitosYElDefensorSeDefiendeConTres (){
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

    // Atacar3v1 Conquista
    @Test
    public void test12CreoUnCombateYElPaisAtacanteAtacaCon3EjercitosAPaisQueDefiendeCon1EjercitoYConquista (){
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
    // Atacar3v1 Pierde
    @Test
    public void test13CreoUnCombateYElPaisAtacanteAtacaCon3EjercitosAPaisQueDefiendeCon1EjercitoYPierde (){
        Jugador jugadorAtacante = new Jugador("000000");
        Pais atacante = new Pais(jugadorAtacante);
        Jugador jugadorDefensor = new Jugador("ffffff");
        Pais defensor = new Pais(jugadorDefensor);
        atacante.hacerLimitrofe(defensor);
        List tiradaAtacante = {1,1,1};
        List tiradaDefensor = {1};
        Combate combate = new Combate(atacante, defensor);
        assertFalse(atacante.esAliados(defensor);
        assertEquals(atacante.cantEjercitosParaAtacar, 2);
        assertEquals(defensor.cantEjercitos, 1);
    }

    //11 Atacar3v2 Conquista
   @Test
    public void test14CreoUnCombateYElPaisAtacanteAtacaCon3EjercitosAPaisQueDefiendeCon2EjercitoYConquista (){
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
        assertEquals(atacante.cantEjercitos, 3);
        assertEquals(defensor.cantEjercitos, 1);
    }

    //Atacar3v2 Gana1Pierde1
    @Test
    public void test15CreoUnCombateYElPaisAtacanteAtacaCon3EjercitosAPaisQueDefiendeCon2EjercitoGana1Pierde1 (){
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
        assertEquals(atacante.cantEjercitos, 3);
        assertEquals(defensor.cantEjercitos, 1);
    }

    //Ataque3v2 Pierde
    @Test
    public void test16CreoUnCombateYElPaisAtacanteAtacaCon3EjercitosAPaisQueDefiendeCon1EjercitoYPierdeTodas (){
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
        assertEquals(atacante.cantEjercitos, 2);
        assertEquals(defensor.cantEjercitos, 2);
    }

 */


// Atacar3v3 Conquista
    /*
    @Test
    public void test17CreoUnCombateYElPaisAtacanteAtacaCon3EjercitosAPaisQueDefiendeCon3EjercitoYConquista (){
        Jugador jugadorAtacante = new Jugador("000000");
        Pais atacante = new Pais(jugadorAtacante);
        atacante.reforzar(3)
        Jugador jugadorDefensor = new Jugador("ffffff");
        Pais defensor = new Pais(jugadorDefensor);
        defensor.reforzar(2);
        atacante.hacerLimitrofe(defensor);
        List tiradaAtacante = {6,6,6};
        List tiradaDefensor = {1,1,1};

        Combate combate = new Combate(atacante, defensor);
        assertTrue(atacante.esAliados(defensor));
        assertEquals(atacante.cantEjercitos, 3);
        assertEquals(defensor.cantEjercitos, 1);
    }

    // Atacar 3v3 Gana2Pierde1
    public void test18CreoUnCombateYElPaisAtacanteAtacaCon3EjercitosAPaisQueDefiendeCon3EjercitoYGana2Pierde1(){
        Jugador jugadorAtacante = new Jugador("000000");
        Pais atacante = new Pais(jugadorAtacante);
        atacante.reforzar(3)
        Jugador jugadorDefensor = new Jugador("ffffff");
        Pais defensor = new Pais(jugadorDefensor);
        defensor.reforzar(2);
        atacante.hacerLimitrofe(defensor);
        List tiradaAtacante = {6,6,1};
        List tiradaDefensor = {1,1,1};

        Combate combate = new Combate(atacante, defensor);
        assertFalse(atacante.esAliados(defensor));
        assertEquals(atacante.cantEjercitos, 2);
        assertEquals(defensor.cantEjercitos, 1);
    }

    // Atacar 3v3 Gana1Pierde2
    public void test19CreoUnCombateYElPaisAtacanteAtacaCon3EjercitosAPaisQueDefiendeCon3EjercitoYGana1Pierde2(){
        Jugador jugadorAtacante = new Jugador("000000");
        Pais atacante = new Pais(jugadorAtacante);
        atacante.reforzar(3)
        Jugador jugadorDefensor = new Jugador("ffffff");
        Pais defensor = new Pais(jugadorDefensor);
        defensor.reforzar(2);
        atacante.hacerLimitrofe(defensor);
        List tiradaAtacante = {6,1,1};
        List tiradaDefensor = {1,1,1};

        Combate combate = new Combate(atacante, defensor);
        assertFalse(atacante.esAliados(defensor));
        assertEquals(atacante.cantEjercitos, 2);
        assertEquals(defensor.cantEjercitos, 2);
    }

    // Atacar3v3 Pierde3
     public void test20CreoUnCombateYElPaisAtacanteAtacaCon3EjercitosAPaisQueDefiendeCon3EjercitoYPierdeTodas(){
        Jugador jugadorAtacante = new Jugador("000000");
        Pais atacante = new Pais(jugadorAtacante);
        atacante.reforzar(3)
        Jugador jugadorDefensor = new Jugador("ffffff");
        Pais defensor = new Pais(jugadorDefensor);
        defensor.reforzar(2);
        atacante.hacerLimitrofe(defensor);
        List tiradaAtacante = {1,1,1};
        List tiradaDefensor = {1,1,1};

        Combate combate = new Combate(atacante, defensor);
        assertFalse(atacante.esAliados(defensor));
        assertEquals(atacante.cantEjercitosParaAtacar, 1);
        assertEquals(defensor.cantEjercitos, 3);
     }

    //13 Atacar1v3 Gana
    public void test21CreoUnCombateYElPaisAtacanteAtacaCon1EjercitoAPaisQueDefiendeCon3EjercitoYGana(){
        Jugador jugadorAtacante = new Jugador("000000");
        Pais atacante = new Pais(jugadorAtacante);
        atacante.reforzar(1);
        Jugador jugadorDefensor = new Jugador("ffffff");
        Pais defensor = new Pais(jugadorDefensor);
        defensor.reforzar(2);
        atacante.hacerLimitrofe(defensor);
        List tiradaAtacante = {6};
        List tiradaDefensor = {1,1,1};

        Combate combate = new Combate(atacante, defensor);
        assertFalse(atacante.esAliados(defensor));
        assertEquals(atacante.cantEjercitosParaAtacar, 1);
        assertEquals(defensor.cantEjercitos, 2);
    }

    //Atacar 1v3 Pierde
    public void test22CreoUnCombateYElPaisAtacanteAtacaCon1EjercitoAPaisQueDefiendeCon3EjercitoYGana(){
        Jugador jugadorAtacante = new Jugador("000000");
        Pais atacante = new Pais(jugadorAtacante);
        atacante.reforzar(1);
        Jugador jugadorDefensor = new Jugador("ffffff");
        Pais defensor = new Pais(jugadorDefensor);
        defensor.reforzar(2);
        atacante.hacerLimitrofe(defensor);
        List tiradaAtacante = {1};
        List tiradaDefensor = {1,1,1};

        Combate combate = new Combate(atacante, defensor);
        assertFalse(atacante.esAliados(defensor));
        assertEquals(atacante.cantEjercitos, 1);
        assertEquals(defensor.cantEjercitos, 3);
    }

    // Atacar2v3 Gana
    public void test23CreoUnCombateYElPaisAtacanteAtacaCon2EjercitosAPaisQueDefiendeCon3EjercitoYGana(){
        Jugador jugadorAtacante = new Jugador("000000");
        Pais atacante = new Pais(jugadorAtacante);
        atacante.reforzar(2);
        Jugador jugadorDefensor = new Jugador("ffffff");
        Pais defensor = new Pais(jugadorDefensor);
        defensor.reforzar(2);
        atacante.hacerLimitrofe(defensor);
        List tiradaAtacante = {6,6};
        List tiradaDefensor = {1,1,1};

        Combate combate = new Combate(atacante, defensor);
        assertFalse(atacante.esAliados(defensor));
        assertEquals(atacante.cantEjercitos, 3);
        assertEquals(defensor.cantEjercitos, 1);
    }

    //Atacar2v3 Gana1Pierde1
     public void test24CreoUnCombateYElPaisAtacanteAtacaCon2EjercitosAPaisQueDefiendeCon3EjercitoYGana1Pierde1(){
        Jugador jugadorAtacante = new Jugador("000000");
        Pais atacante = new Pais(jugadorAtacante);
        atacante.reforzar(2);
        Jugador jugadorDefensor = new Jugador("ffffff");
        Pais defensor = new Pais(jugadorDefensor);
        defensor.reforzar(2);
        atacante.hacerLimitrofe(defensor);
        List tiradaAtacante = {1,1};
        List tiradaDefensor = {1,1,1};

        Combate combate = new Combate(atacante, defensor);
        assertFalse(atacante.esAliados(defensor));
        assertEquals(atacante.cantEjercitos, 2);
        assertEquals(defensor.cantEjercitos, 2);
    }

    //Atacar2v3 Pierde2
    public void test25CreoUnCombateYElPaisAtacanteAtacaCon2EjercitosAPaisQueDefiendeCon3EjercitoYGana(){
        Jugador jugadorAtacante = new Jugador("000000");
        Pais atacante = new Pais(jugadorAtacante);
        atacante.reforzar(2);
        Jugador jugadorDefensor = new Jugador("ffffff");
        Pais defensor = new Pais(jugadorDefensor);
        defensor.reforzar(2);
        atacante.hacerLimitrofe(defensor);
        List tiradaAtacante = {6,6};
        List tiradaDefensor = {1,1,1};

        Combate combate = new Combate(atacante, defensor);
        assertFalse(atacante.esAliados(defensor));
        assertEquals(atacante.cantEjercitos, 1);
        assertEquals(defensor.cantEjercitos, 3);
    }
}*/
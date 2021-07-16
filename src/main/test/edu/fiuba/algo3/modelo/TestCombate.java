package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import edu.fiuba.algo3.modelo.excepciones.*;

public class TestCombate {

    @Test
    public void test01SeCreaUnCombateYNoEsNull() {
        Jugador jugadorAtacante = new Jugador("000000");
        Pais atacante = new Pais("Argentina", jugadorAtacante);
        Jugador jugadorDefensor = new Jugador("ffffff");
        Pais defensor = new Pais("Uruguay", jugadorDefensor);

        Combate combate = new Combate(atacante, defensor);

        assertNotNull(combate);
    }

    @Test
    public void test04CreoUnCombateYElPaisAtacanteIntentaAtacarPeroNoTieneEjercitosSuficientes (){
        Jugador jugadorAtacante = new Jugador("000000");
        Pais atacante = new Pais("Argentina", jugadorAtacante);
        Jugador jugadorDefensor = new Jugador("ffffff");
        Pais defensor = new Pais("Uruguay", jugadorDefensor);
        defensor.hacerLimitrofe(atacante);
        atacante.hacerLimitrofe(defensor);
        Combate combate = new Combate(atacante, defensor);

        assertThrows(EjercitosInsuficientesException.class, () -> combate.combatir());
    }

    // 1v1 conquista
    @Test
    public void test05CreoUnCombateYElPaisAtacanteAtacaCon1EjercitoAPaisQueDefiendeCon1EjercitoYGanaElAtacante (){
        Jugador jugadorAtacante = new Jugador("000000");
        Pais atacante = new Pais("Argentina", jugadorAtacante);
        Jugador jugadorDefensor = new Jugador("ffffff");
        Pais defensor = new Pais("Uruguay", jugadorDefensor);
        atacante.reforzar(jugadorAtacante, 1);
        ArrayList tiradaAtacante = new ArrayList<Integer>();
        tiradaAtacante.add(6);
        ArrayList tiradaDefensor = new ArrayList<Integer>();
        tiradaDefensor.add(1);
        atacante.hacerLimitrofe(defensor);
        Combate combate = new Combate(atacante, defensor);

        combate.combatePredeterminado(tiradaAtacante, tiradaDefensor);
        // pais1.esAliados(pais2) checkea que el pais1 tenga el mismo duenio que el pais2, si es asi devuelve true.
        assertTrue(atacante.esAliado(defensor));
        assertEquals(1, defensor.getEjercitos());
        assertEquals(1, atacante.getEjercitos());
    }


    // 1v1 pierde atacante
    @Test
    public void test06CreoUnCombateYElPaisAtacanteAtacaCon1EjercitoAPaisQueDefiendeCon1EjercitoYPierdeElAtacante (){
        Jugador jugadorAtacante = new Jugador("000000");
        Pais atacante = new Pais("Argentina", jugadorAtacante);
        Jugador jugadorDefensor = new Jugador("ffffff");
        Pais defensor = new Pais("Uruguay", jugadorDefensor);
        atacante.reforzar(jugadorAtacante, 1);
        ArrayList tiradaAtacante = new ArrayList<Integer>();
        tiradaAtacante.add(1);
        ArrayList tiradaDefensor = new ArrayList<Integer>();
        tiradaDefensor.add(3);
        atacante.hacerLimitrofe(defensor);
        Combate combate = new Combate(atacante, defensor);

        combate.combatePredeterminado(tiradaAtacante, tiradaDefensor);

        assertFalse(atacante.esAliado(defensor));
        assertEquals(1, atacante.getEjercitos());
        assertEquals(1, defensor.getEjercitos());
    }

    // 2v1 conquista
    @Test
    public void test07CreoUnCombateYElPaisAtacanteAtacaCon2EjercitosAPaisQueDefiendeCon1EjercitoYGanaElAtacante () {
        Jugador jugadorAtacante = new Jugador("000000");
        Pais atacante = new Pais("Argentina", jugadorAtacante);
        Jugador jugadorDefensor = new Jugador("ffffff");
        Pais defensor = new Pais("Uruguay", jugadorDefensor);
        atacante.reforzar(jugadorAtacante, 2);
        ArrayList tiradaAtacante = new ArrayList<Integer>();
        tiradaAtacante.add(6);
        tiradaAtacante.add(6);
        ArrayList tiradaDefensor = new ArrayList<Integer>();
        tiradaDefensor.add(1);
        atacante.hacerLimitrofe(defensor);
        Combate combate = new Combate(atacante, defensor);

        combate.combatePredeterminado(tiradaAtacante, tiradaDefensor);

        assertTrue(atacante.esAliado(defensor));
        assertEquals(2, atacante.getEjercitos());
        assertEquals(1, defensor.getEjercitos());

    }

    // 2v1 pierde atacante
    @Test
    public void test08CreoUnCombateYElPaisAtacanteAtacaCon2EjercitosAPaisQueDefiendeCon1EjercitoYPierdeElAtacante (){
        Jugador jugadorAtacante = new Jugador("000000");
        Pais atacante = new Pais("Argentina", jugadorAtacante);
        Jugador jugadorDefensor = new Jugador("ffffff");
        Pais defensor = new Pais("Uruguay", jugadorDefensor);
        atacante.reforzar(jugadorAtacante, 2);
        ArrayList tiradaAtacante = new ArrayList<Integer>();
        tiradaAtacante.add(1);
        tiradaAtacante.add(1);
        ArrayList tiradaDefensor = new ArrayList<Integer>();
        tiradaDefensor.add(1);
        atacante.hacerLimitrofe(defensor);
        Combate combate = new Combate(atacante, defensor);

        combate.combatePredeterminado(tiradaAtacante, tiradaDefensor);

        assertFalse(atacante.esAliado(defensor));
        assertEquals(2, atacante.getEjercitos());
        assertEquals(1, defensor.getEjercitos());
    }

    // 2v2 conquista
    @Test
    public void test09CreoUnCombateYElPaisAtacanteAtacaCon2EjercitosAPaisQueDefiendeCon2EjercitosYGanaElAtacante (){
        Jugador jugadorAtacante = new Jugador("000000");
        Pais atacante = new Pais("Argentina", jugadorAtacante);
        Jugador jugadorDefensor = new Jugador("ffffff");
        Pais defensor = new Pais("Uruguay", jugadorDefensor);
        atacante.reforzar(jugadorAtacante,2);
        defensor.reforzar(jugadorDefensor,1);
        ArrayList tiradaAtacante = new ArrayList<Integer>();
        tiradaAtacante.add(6);
        tiradaAtacante.add(2);
        ArrayList tiradaDefensor = new ArrayList<Integer>();
        tiradaDefensor.add(1);
        tiradaDefensor.add(1);
        atacante.hacerLimitrofe(defensor);
        Combate combate = new Combate(atacante, defensor);

        combate.combatePredeterminado(tiradaAtacante, tiradaDefensor);

        assertTrue(atacante.esAliado(defensor));
        assertEquals(2, atacante.getEjercitos());
        assertEquals(1, defensor.getEjercitos());
    }

    // 2v2 pierde atacante
    @Test
    public void test10CreoUnCombateYElPaisAtacanteAtacaCon2EjercitosAPaisQueDefiendeCon2EjercitosYPierdeElAtacante (){
        Jugador jugadorAtacante = new Jugador("000000");
        Pais atacante = new Pais("Argentina", jugadorAtacante);
        Jugador jugadorDefensor = new Jugador("ffffff");
        Pais defensor = new Pais("Uruguay", jugadorDefensor);
        atacante.reforzar(jugadorAtacante,2);
        defensor.reforzar(jugadorDefensor,1);
        ArrayList tiradaAtacante = new ArrayList<Integer>();
        tiradaAtacante.add(1);
        tiradaAtacante.add(1);
        ArrayList tiradaDefensor = new ArrayList<Integer>();
        tiradaDefensor.add(2);
        tiradaDefensor.add(2);
        atacante.hacerLimitrofe(defensor);
        Combate combate = new Combate(atacante, defensor);

        combate.combatePredeterminado(tiradaAtacante, tiradaDefensor);

        assertFalse(atacante.esAliado(defensor));
        assertEquals(1, atacante.getEjercitos());
        assertEquals(2, defensor.getEjercitos());
    }

    //Atacar2v3 Pierde2
    @Test
    public void test11CreoUnCombateYElPaisAtacanteGanaElAtaqueConDosEjercitosYElDefensorSeDefiendeConTres (){
        Jugador jugadorAtacante = new Jugador("000000");
        Pais atacante = new Pais("Argentina", jugadorAtacante);
        Jugador jugadorDefensor = new Jugador("ffffff");
        Pais defensor = new Pais("Uruguay", jugadorDefensor);
        atacante.reforzar(jugadorAtacante,2);
        defensor.reforzar(jugadorDefensor,2);

        ArrayList tiradaAtacante = new ArrayList<Integer>();
        tiradaAtacante.add(6);
        tiradaAtacante.add(6);
        ArrayList tiradaDefensor = new ArrayList<Integer>();
        tiradaDefensor.add(1);
        tiradaDefensor.add(1);
        tiradaDefensor.add(1);
        atacante.hacerLimitrofe(defensor);
        Combate combate = new Combate(atacante, defensor);
        combate.combatePredeterminado(tiradaAtacante, tiradaDefensor);
        assertFalse(atacante.esAliado(defensor));
        assertEquals(3, atacante.getEjercitos());
        assertEquals(1, defensor.getEjercitos());
    }

    // Atacar3v1 Conquista
    @Test
    public void test12CreoUnCombateYElPaisAtacanteAtacaCon3EjercitosAPaisQueDefiendeCon1EjercitoYConquista (){
        Jugador jugadorAtacante = new Jugador("000000");
        Pais atacante = new Pais("Argentina", jugadorAtacante);
        Jugador jugadorDefensor = new Jugador("ffffff");
        Pais defensor = new Pais("Uruguay", jugadorDefensor);
        atacante.reforzar(jugadorAtacante,3);
        atacante.hacerLimitrofe(defensor);
        defensor.hacerLimitrofe(atacante);
        ArrayList tiradaAtacante = new ArrayList<Integer>();
        tiradaAtacante.add(6);
        tiradaAtacante.add(6);
        tiradaAtacante.add(6);
        ArrayList tiradaDefensor = new ArrayList<Integer>();
        tiradaDefensor.add(1);

        Combate combate = new Combate(atacante, defensor);
        combate.combatePredeterminado(tiradaAtacante, tiradaDefensor);
        assertTrue(atacante.esAliado(defensor));
        assertEquals(3, atacante.getEjercitos());
        assertEquals(1, defensor.getEjercitos());
    }


    // Atacar3v1 Pierde
    @Test
    public void test13CreoUnCombateYElPaisAtacanteAtacaCon3EjercitosAPaisQueDefiendeCon1EjercitoYPierde (){
        Jugador jugadorAtacante = new Jugador("000000");
        Pais atacante = new Pais("Argentina", jugadorAtacante);
        Jugador jugadorDefensor = new Jugador("ffffff");
        Pais defensor = new Pais("Uruguay", jugadorDefensor);
        atacante.hacerLimitrofe(defensor);
        defensor.hacerLimitrofe(atacante);
        atacante.reforzar(jugadorAtacante, 3);
        ArrayList tiradaAtacante = new ArrayList<Integer>();
        tiradaAtacante.add(1);
        tiradaAtacante.add(1);
        tiradaAtacante.add(1);
        ArrayList tiradaDefensor = new ArrayList<Integer>();
        tiradaDefensor.add(1);
        Combate combate = new Combate(atacante, defensor);
        combate.combatePredeterminado(tiradaAtacante, tiradaDefensor);
        assertFalse(atacante.esAliado(defensor));
        assertEquals(3, atacante.getEjercitos());
        assertEquals(1, defensor.getEjercitos());
    }

    //11 Atacar3v2 Conquista
   @Test
    public void test14CreoUnCombateYElPaisAtacanteAtacaCon3EjercitosAPaisQueDefiendeCon2EjercitoYConquista (){
        Jugador jugadorAtacante = new Jugador("000000");
        Pais atacante = new Pais("Argentina", jugadorAtacante);
        Jugador jugadorDefensor = new Jugador("ffffff");
        Pais defensor = new Pais("Uruguay", jugadorDefensor);
        atacante.hacerLimitrofe(defensor);
        defensor.hacerLimitrofe(atacante);
        atacante.reforzar(jugadorAtacante, 3);
        defensor.reforzar(jugadorDefensor, 1);
        ArrayList tiradaAtacante = new ArrayList<Integer>();
        tiradaAtacante.add(6);
        tiradaAtacante.add(6);
        tiradaAtacante.add(6);
        ArrayList tiradaDefensor = new ArrayList<Integer>();
        tiradaDefensor.add(1);
        tiradaDefensor.add(1);

        Combate combate = new Combate(atacante, defensor);
        combate.combatePredeterminado(tiradaAtacante, tiradaDefensor);
        assertTrue(atacante.esAliado(defensor));
        assertEquals(3, atacante.getEjercitos());
        assertEquals(1, defensor.getEjercitos());
    }

    //Atacar3v2 Gana1Pierde1
    @Test
    public void test15CreoUnCombateYElPaisAtacanteAtacaCon3EjercitosAPaisQueDefiendeCon2EjercitoGana1Pierde1 (){
        Jugador jugadorAtacante = new Jugador("000000");
        Pais atacante = new Pais("Argentina", jugadorAtacante);

        Jugador jugadorDefensor = new Jugador("ffffff");
        Pais defensor = new Pais("Uruguay", jugadorDefensor);
        atacante.reforzar(jugadorAtacante, 3);
        defensor.reforzar(jugadorDefensor, 1);
        atacante.hacerLimitrofe(defensor);
        defensor.hacerLimitrofe(atacante);
        ArrayList tiradaAtacante = new ArrayList<Integer>();
        tiradaAtacante.add(6);
        tiradaAtacante.add(6);
        tiradaAtacante.add(6);
        ArrayList tiradaDefensor = new ArrayList<Integer>();
        tiradaDefensor.add(6);
        tiradaDefensor.add(1);

        Combate combate = new Combate(atacante, defensor);
        combate.combatePredeterminado(tiradaAtacante, tiradaDefensor);
        assertFalse(atacante.esAliado(defensor));
        assertEquals(3, atacante.getEjercitos());
        assertEquals(1, defensor.getEjercitos());
    }

    //Ataque3v2 Pierde
    @Test
    public void test16CreoUnCombateYElPaisAtacanteAtacaCon3EjercitosAPaisQueDefiendeCon1EjercitoYPierdeTodas (){
        Jugador jugadorAtacante = new Jugador("000000");
        Pais atacante = new Pais("Argentina", jugadorAtacante);
        Jugador jugadorDefensor = new Jugador("ffffff");
        Pais defensor = new Pais("Uruguay", jugadorDefensor);
        atacante.hacerLimitrofe(defensor);
        defensor.hacerLimitrofe(atacante);
        atacante.reforzar(jugadorAtacante,3);
        defensor.reforzar(jugadorDefensor,1);
        ArrayList tiradaAtacante = new ArrayList<Integer>();
        tiradaAtacante.add(5);
        tiradaAtacante.add(5);
        tiradaAtacante.add(5);
        ArrayList tiradaDefensor = new ArrayList<Integer>();
        tiradaDefensor.add(6);
        tiradaDefensor.add(6);

        Combate combate = new Combate(atacante, defensor);
        combate.combatePredeterminado(tiradaAtacante, tiradaDefensor);
        assertFalse(atacante.esAliado(defensor));
        assertEquals(2, atacante.getEjercitos());
        assertEquals(2, defensor.getEjercitos());
    }

/*

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
        ArrayList tiradaAtacante = new ArrayList<Integer>();
        tiradaAtacante.add(6);
        tiradaAtacante.add(6);
        tiradaAtacante.add(6);
        ArrayList tiradaDefensor = new ArrayList<Integer>();
        tiradaDefensor.add(1);
        tiradaDefensor.add(1);
        tiradaDefensor.add(1);
        Combate combate = new Combate(atacante, defensor);
        combate.combatePredeterminado(tiradaAtacante, tiradaDefensor);
        assertTrue(atacante.esAliado(defensor));
        assertEquals(3, atacante.getEjercitos());
        assertEquals(0, defensor.getEjercitos());
    }

 */
/*
    // Atacar 3v3 Gana2Pierde1
    public void test18CreoUnCombateYElPaisAtacanteAtacaCon3EjercitosAPaisQueDefiendeCon3EjercitoYGana2Pierde1(){
        Jugador jugadorAtacante = new Jugador("000000");
        Pais atacante = new Pais(jugadorAtacante);
        atacante.reforzar(3)
        Jugador jugadorDefensor = new Jugador("ffffff");
        Pais defensor = new Pais(jugadorDefensor);
        defensor.reforzar(2);
        atacante.hacerLimitrofe(defensor);
         ArrayList tiradaAtacante = new ArrayList<Integer>();
        tiradaAtacante.add(6);
        tiradaAtacante.add(6);
        tiradaAtacante.add(1);
        ArrayList tiradaDefensor = new ArrayList<Integer>();
        tiradaDefensor.add(1);
        tiradaDefensor.add(1);
        tiradaDefensor.add(1);

        Combate combate = new Combate(atacante, defensor);
        combate.combatePredeterminado(tiradaAtacante, tiradaDefensor);
        assertFalse(atacante.esAliados(defensor));
        assertEquals(3, atacante.getEjercitos());
        assertEquals(1, defensor.getEjercitos());
    }
/*
    // Atacar 3v3 Gana1Pierde2
    public void test19CreoUnCombateYElPaisAtacanteAtacaCon3EjercitosAPaisQueDefiendeCon3EjercitoYGana1Pierde2(){
        Jugador jugadorAtacante = new Jugador("000000");
        Pais atacante = new Pais(jugadorAtacante);
        atacante.reforzar(3)
        Jugador jugadorDefensor = new Jugador("ffffff");
        Pais defensor = new Pais(jugadorDefensor);
        defensor.reforzar(2);
        atacante.hacerLimitrofe(defensor);
         ArrayList tiradaAtacante = new ArrayList<Integer>();
        tiradaAtacante.add(6);
        tiradaAtacante.add(1);
        tiradaAtacante.add(1);
        ArrayList tiradaDefensor = new ArrayList<Integer>();
        tiradaDefensor.add(1);
        tiradaDefensor.add(1);
        tiradaDefensor.add(1);
        Combate combate = new Combate(atacante, defensor);
        combate.combatePredeterminado(tiradaAtacante, tiradaDefensor);
        assertFalse(atacante.esAliados(defensor));
        assertEquals(3, atacante.getEjercitos());
        assertEquals(1, defensor.getEjercitos());
    }
/*
    // Atacar3v3 Pierde3
     public void test20CreoUnCombateYElPaisAtacanteAtacaCon3EjercitosAPaisQueDefiendeCon3EjercitoYPierdeTodas(){
        Jugador jugadorAtacante = new Jugador("000000");
        Pais atacante = new Pais(jugadorAtacante);
        atacante.reforzar(3)
        Jugador jugadorDefensor = new Jugador("ffffff");
        Pais defensor = new Pais(jugadorDefensor);
        defensor.reforzar(2);
        atacante.hacerLimitrofe(defensor);
         ArrayList tiradaAtacante = new ArrayList<Integer>();
        tiradaAtacante.add(1);
        tiradaAtacante.add(1);
        tiradaAtacante.add(1);
        ArrayList tiradaDefensor = new ArrayList<Integer>();
        tiradaDefensor.add(1);
        tiradaDefensor.add(1);
        tiradaDefensor.add(1);
        Combate combate = new Combate(atacante, defensor);
        combate.combatePredeterminado(tiradaAtacante, tiradaDefensor);
        assertFalse(atacante.esAliados(defensor));
        assertEquals(3, atacante.getEjercitos());
        assertEquals(1, defensor.getEjercitos());
     }
/*
    //13 Atacar1v3 Gana
    public void test21CreoUnCombateYElPaisAtacanteAtacaCon1EjercitoAPaisQueDefiendeCon3EjercitoYGana(){
        Jugador jugadorAtacante = new Jugador("000000");
        Pais atacante = new Pais(jugadorAtacante);
        atacante.reforzar(1);
        Jugador jugadorDefensor = new Jugador("ffffff");
        Pais defensor = new Pais(jugadorDefensor);
        defensor.reforzar(2);
        atacante.hacerLimitrofe(defensor);
        ArrayList tiradaAtacante = new ArrayList<Integer>();
        tiradaAtacante.add(6);
        ArrayList tiradaDefensor = new ArrayList<Integer>();
        tiradaDefensor.add(1);
        tiradaDefensor.add(1);
        tiradaDefensor.add(1);

        Combate combate = new Combate(atacante, defensor);
        combate.combatePredeterminado(tiradaAtacante, tiradaDefensor);
        assertFalse(atacante.esAliados(defensor));
        assertEquals(3, atacante.getEjercitos());
        assertEquals(1, defensor.getEjercitos());
    }
/*
    //Atacar 1v3 Pierde
    public void test22CreoUnCombateYElPaisAtacanteAtacaCon1EjercitoAPaisQueDefiendeCon3EjercitoYGana(){
        Jugador jugadorAtacante = new Jugador("000000");
        Pais atacante = new Pais(jugadorAtacante);
        atacante.reforzar(1);
        Jugador jugadorDefensor = new Jugador("ffffff");
        Pais defensor = new Pais(jugadorDefensor);
        defensor.reforzar(2);
        atacante.hacerLimitrofe(defensor);
        ArrayList tiradaAtacante = new ArrayList<Integer>();
        tiradaAtacante.add(1);
        ArrayList tiradaDefensor = new ArrayList<Integer>();
        tiradaDefensor.add(1);
        tiradaDefensor.add(1);
        tiradaDefensor.add(1);

        Combate combate = new Combate(atacante, defensor);
        combate.combatePredeterminado(tiradaAtacante, tiradaDefensor);
        assertFalse(atacante.esAliados(defensor));
        assertEquals(3, atacante.getEjercitos());
        assertEquals(1, defensor.getEjercitos());
    }
/*
    // Atacar2v3 Gana
    public void test23CreoUnCombateYElPaisAtacanteAtacaCon2EjercitosAPaisQueDefiendeCon3EjercitoYGana(){
        Jugador jugadorAtacante = new Jugador("000000");
        Pais atacante = new Pais(jugadorAtacante);
        atacante.reforzar(2);
        Jugador jugadorDefensor = new Jugador("ffffff");
        Pais defensor = new Pais(jugadorDefensor);
        defensor.reforzar(2);
        atacante.hacerLimitrofe(defensor);
        ArrayList tiradaAtacante = new ArrayList<Integer>();
        tiradaAtacante.add(6);
        tiradaAtacante.add(6);
        ArrayList tiradaDefensor = new ArrayList<Integer>();
        tiradaDefensor.add(1);
        tiradaDefensor.add(1);
        tiradaDefensor.add(1);
        Combate combate = new Combate(atacante, defensor);
        combate.combatePredeterminado(tiradaAtacante, tiradaDefensor);
        assertFalse(atacante.esAliados(defensor));
        assertEquals(3, atacante.getEjercitos());
        assertEquals(1, defensor.getEjercitos());
    }
/*
    //Atacar2v3 Gana1Pierde1
     public void test24CreoUnCombateYElPaisAtacanteAtacaCon2EjercitosAPaisQueDefiendeCon3EjercitoYGana1Pierde1(){
        Jugador jugadorAtacante = new Jugador("000000");
        Pais atacante = new Pais(jugadorAtacante);
        atacante.reforzar(2);
        Jugador jugadorDefensor = new Jugador("ffffff");
        Pais defensor = new Pais(jugadorDefensor);
        defensor.reforzar(2);
        atacante.hacerLimitrofe(defensor);
        ArrayList tiradaAtacante = new ArrayList<Integer>();
        tiradaAtacante.add(6);
        tiradaAtacante.add(6);
        ArrayList tiradaDefensor = new ArrayList<Integer>();
        tiradaDefensor.add(6);
        tiradaDefensor.add(1);
        tiradaDefensor.add(1);

        Combate combate = new Combate(atacante, defensor);
        combate.combatePredeterminado(tiradaAtacante, tiradaDefensor);
        assertFalse(atacante.esAliados(defensor));
        assertEquals(3, atacante.getEjercitos());
        assertEquals(1, defensor.getEjercitos());
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
        ArrayList tiradaAtacante = new ArrayList<Integer>();
        tiradaAtacante.add(6);
        tiradaAtacante.add(6);
        ArrayList tiradaDefensor = new ArrayList<Integer>();
        tiradaDefensor.add(6);
        tiradaDefensor.add(6);
        tiradaDefensor.add(1);

        Combate combate = new Combate(atacante, defensor);
        combate.combatePredeterminado(tiradaAtacante, tiradaDefensor);
        assertFalse(atacante.esAliados(defensor));
        assertEquals(3, atacante.getEjercitos());
        assertEquals(1, defensor.getEjercitos());
    }
    */
}
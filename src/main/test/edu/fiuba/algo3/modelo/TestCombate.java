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
        Integer cantEjercitosAtacantes = atacante.getEjercitosParaAtacar();

        Combate combate = new Combate(atacante, defensor, cantEjercitosAtacantes);

        assertNotNull(combate);
    }

    // 1v1 conquista
    @Test
    public void test02CreoUnCombateYElPaisAtacanteAtacaCon1EjercitoAPaisQueDefiendeCon1EjercitoYGanaElAtacante (){
        Jugador jugadorAtacante = new Jugador("000000");
        Pais atacante = new Pais("Argentina", jugadorAtacante);
        Jugador jugadorDefensor = new Jugador("ffffff");
        Pais defensor = new Pais("Uruguay", jugadorDefensor);
        atacante.reforzar(1);
        ArrayList<Integer> tiradaAtacante = new ArrayList<>();
        tiradaAtacante.add(6);
        ArrayList<Integer> tiradaDefensor = new ArrayList<>();
        tiradaDefensor.add(1);
        atacante.hacerLimitrofe(defensor);
        Integer cantEjercitosAtacantes = atacante.getEjercitosParaAtacar();
        Combate combate = new Combate(atacante, defensor, cantEjercitosAtacantes);

        combate.combatePredeterminado(tiradaAtacante, tiradaDefensor);
        // pais1.esAliado(pais2) checkea que el pais1 tenga el mismo duenio que el pais2, si es asi devuelve true.
        assertTrue(atacante.esAliado(defensor));
        assertEquals(1, defensor.getEjercitos());
        assertEquals(1, atacante.getEjercitos());
    }


    // 1v1 pierde atacante
    @Test
    public void test03CreoUnCombateYElPaisAtacanteAtacaCon1EjercitoAPaisQueDefiendeCon1EjercitoYPierdeElAtacante (){
        Jugador jugadorAtacante = new Jugador("000000");
        Pais atacante = new Pais("Argentina", jugadorAtacante);
        Jugador jugadorDefensor = new Jugador("ffffff");
        Pais defensor = new Pais("Uruguay", jugadorDefensor);
        atacante.reforzar(1);
        ArrayList<Integer> tiradaAtacante = new ArrayList<>();
        tiradaAtacante.add(1);
        ArrayList<Integer> tiradaDefensor = new ArrayList<>();
        tiradaDefensor.add(3);
        atacante.hacerLimitrofe(defensor);
        Integer cantEjercitosAtacantes = atacante.getEjercitosParaAtacar();
        Combate combate = new Combate(atacante, defensor, cantEjercitosAtacantes);

        combate.combatePredeterminado(tiradaAtacante, tiradaDefensor);

        assertFalse(atacante.esAliado(defensor));
        assertEquals(1, atacante.getEjercitos());
        assertEquals(1, defensor.getEjercitos());
    }

    // 2v1 conquista
    @Test
    public void test04CreoUnCombateYElPaisAtacanteAtacaCon2EjercitosAPaisQueDefiendeCon1EjercitoYGanaElAtacante () {
        Jugador jugadorAtacante = new Jugador("000000");
        Pais atacante = new Pais("Argentina", jugadorAtacante);
        Jugador jugadorDefensor = new Jugador("ffffff");
        Pais defensor = new Pais("Uruguay", jugadorDefensor);
        atacante.reforzar(2);
        ArrayList<Integer> tiradaAtacante = new ArrayList<>();
        tiradaAtacante.add(6);
        tiradaAtacante.add(6);
        ArrayList<Integer> tiradaDefensor = new ArrayList<>();
        tiradaDefensor.add(1);
        atacante.hacerLimitrofe(defensor);
        Integer cantEjercitosAtacantes = atacante.getEjercitosParaAtacar();
        Combate combate = new Combate(atacante, defensor, cantEjercitosAtacantes);

        combate.combatePredeterminado(tiradaAtacante, tiradaDefensor);

        assertTrue(atacante.esAliado(defensor));
        assertEquals(2, atacante.getEjercitos());
        assertEquals(1, defensor.getEjercitos());

    }

    // 2v1 pierde atacante
    @Test
    public void test05CreoUnCombateYElPaisAtacanteAtacaCon2EjercitosAPaisQueDefiendeCon1EjercitoYPierdeElAtacante (){
        Jugador jugadorAtacante = new Jugador("000000");
        Pais atacante = new Pais("Argentina", jugadorAtacante);
        Jugador jugadorDefensor = new Jugador("ffffff");
        Pais defensor = new Pais("Uruguay", jugadorDefensor);
        atacante.reforzar(2);
        ArrayList<Integer> tiradaAtacante = new ArrayList<>();
        tiradaAtacante.add(1);
        tiradaAtacante.add(1);
        ArrayList<Integer> tiradaDefensor = new ArrayList<>();
        tiradaDefensor.add(1);
        atacante.hacerLimitrofe(defensor);
        Integer cantEjercitosAtacantes = atacante.getEjercitosParaAtacar();
        Combate combate = new Combate(atacante, defensor, cantEjercitosAtacantes);

        combate.combatePredeterminado(tiradaAtacante, tiradaDefensor);

        assertFalse(atacante.esAliado(defensor));
        assertEquals(2, atacante.getEjercitos());
        assertEquals(1, defensor.getEjercitos());
    }

    // 2v2 conquista
    @Test
    public void test06CreoUnCombateYElPaisAtacanteAtacaCon2EjercitosAPaisQueDefiendeCon2EjercitosYGanaElAtacante (){
        Jugador jugadorAtacante = new Jugador("000000");
        Pais atacante = new Pais("Argentina", jugadorAtacante);
        Jugador jugadorDefensor = new Jugador("ffffff");
        Pais defensor = new Pais("Uruguay", jugadorDefensor);
        atacante.reforzar(2);
        defensor.reforzar(1);
        ArrayList<Integer> tiradaAtacante = new ArrayList<>();
        tiradaAtacante.add(6);
        tiradaAtacante.add(2);
        ArrayList<Integer> tiradaDefensor = new ArrayList<>();
        tiradaDefensor.add(1);
        tiradaDefensor.add(1);
        atacante.hacerLimitrofe(defensor);
        Integer cantEjercitosAtacantes = atacante.getEjercitosParaAtacar();
        Combate combate = new Combate(atacante, defensor, cantEjercitosAtacantes);

        combate.combatePredeterminado(tiradaAtacante, tiradaDefensor);

        assertTrue(atacante.esAliado(defensor));
        assertEquals(2, atacante.getEjercitos());
        assertEquals(1, defensor.getEjercitos());
    }

    // 2v2 pierde atacante
    @Test
    public void test07CreoUnCombateYElPaisAtacanteAtacaCon2EjercitosAPaisQueDefiendeCon2EjercitosYPierdeElAtacante (){
        Jugador jugadorAtacante = new Jugador("000000");
        Pais atacante = new Pais("Argentina", jugadorAtacante);
        Jugador jugadorDefensor = new Jugador("ffffff");
        Pais defensor = new Pais("Uruguay", jugadorDefensor);
        atacante.reforzar(2);
        defensor.reforzar(1);
        ArrayList<Integer> tiradaAtacante = new ArrayList<>();
        tiradaAtacante.add(1);
        tiradaAtacante.add(1);
        ArrayList<Integer> tiradaDefensor = new ArrayList<>();
        tiradaDefensor.add(2);
        tiradaDefensor.add(2);
        atacante.hacerLimitrofe(defensor);
        Integer cantEjercitosAtacantes = atacante.getEjercitosParaAtacar();
        Combate combate = new Combate(atacante, defensor, cantEjercitosAtacantes);

        combate.combatePredeterminado(tiradaAtacante, tiradaDefensor);

        assertFalse(atacante.esAliado(defensor));
        assertEquals(1, atacante.getEjercitos());
        assertEquals(2, defensor.getEjercitos());
    }

    //Atacar2v3 Pierde2
    @Test
    public void test08CreoUnCombateYElPaisAtacanteGanaElAtaqueConDosEjercitosYElDefensorSeDefiendeConTres (){
        Jugador jugadorAtacante = new Jugador("000000");
        Pais atacante = new Pais("Argentina", jugadorAtacante);
        Jugador jugadorDefensor = new Jugador("ffffff");
        Pais defensor = new Pais("Uruguay", jugadorDefensor);
        atacante.reforzar(2);
        defensor.reforzar(2);

        ArrayList<Integer> tiradaAtacante = new ArrayList<>();
        tiradaAtacante.add(6);
        tiradaAtacante.add(6);
        ArrayList<Integer> tiradaDefensor = new ArrayList<>();
        tiradaDefensor.add(1);
        tiradaDefensor.add(1);
        tiradaDefensor.add(1);
        atacante.hacerLimitrofe(defensor);
        Integer cantEjercitosAtacantes = atacante.getEjercitosParaAtacar();
        Combate combate = new Combate(atacante, defensor, cantEjercitosAtacantes);
        combate.combatePredeterminado(tiradaAtacante, tiradaDefensor);
        assertFalse(atacante.esAliado(defensor));
        assertEquals(3, atacante.getEjercitos());
        assertEquals(1, defensor.getEjercitos());
    }

    // Atacar3v1 Conquista
    @Test
    public void test09CreoUnCombateYElPaisAtacanteAtacaCon3EjercitosAPaisQueDefiendeCon1EjercitoYConquista (){
        Jugador jugadorAtacante = new Jugador("000000");
        Pais atacante = new Pais("Argentina", jugadorAtacante);
        Jugador jugadorDefensor = new Jugador("ffffff");
        Pais defensor = new Pais("Uruguay", jugadorDefensor);
        atacante.reforzar(3);
        atacante.hacerLimitrofe(defensor);
        defensor.hacerLimitrofe(atacante);
        ArrayList<Integer> tiradaAtacante = new ArrayList<>();
        tiradaAtacante.add(6);
        tiradaAtacante.add(6);
        tiradaAtacante.add(6);
        ArrayList<Integer> tiradaDefensor = new ArrayList<>();
        tiradaDefensor.add(1);

        Integer cantEjercitosAtacantes = atacante.getEjercitosParaAtacar();
        Combate combate = new Combate(atacante, defensor, cantEjercitosAtacantes);
        combate.combatePredeterminado(tiradaAtacante, tiradaDefensor);
        assertTrue(atacante.esAliado(defensor));
        assertEquals(3, atacante.getEjercitos());
        assertEquals(1, defensor.getEjercitos());
    }


    // Atacar3v1 Pierde
    @Test
    public void test10CreoUnCombateYElPaisAtacanteAtacaCon3EjercitosAPaisQueDefiendeCon1EjercitoYPierde (){
        Jugador jugadorAtacante = new Jugador("000000");
        Pais atacante = new Pais("Argentina", jugadorAtacante);
        Jugador jugadorDefensor = new Jugador("ffffff");
        Pais defensor = new Pais("Uruguay", jugadorDefensor);
        atacante.hacerLimitrofe(defensor);
        defensor.hacerLimitrofe(atacante);
        atacante.reforzar(3);
        ArrayList<Integer> tiradaAtacante = new ArrayList<>();
        tiradaAtacante.add(1);
        tiradaAtacante.add(1);
        tiradaAtacante.add(1);
        ArrayList<Integer> tiradaDefensor = new ArrayList<>();
        tiradaDefensor.add(1);
        Integer cantEjercitosAtacantes = atacante.getEjercitosParaAtacar();
        Combate combate = new Combate(atacante, defensor, cantEjercitosAtacantes);
        combate.combatePredeterminado(tiradaAtacante, tiradaDefensor);
        assertFalse(atacante.esAliado(defensor));
        assertEquals(3, atacante.getEjercitos());
        assertEquals(1, defensor.getEjercitos());
    }

    //11 Atacar3v2 Conquista
    @Test
    public void test11CreoUnCombateYElPaisAtacanteAtacaCon3EjercitosAPaisQueDefiendeCon2EjercitoYConquista (){
        Jugador jugadorAtacante = new Jugador("000000");
        Pais atacante = new Pais("Argentina", jugadorAtacante);
        Jugador jugadorDefensor = new Jugador("ffffff");
        Pais defensor = new Pais("Uruguay", jugadorDefensor);
        atacante.hacerLimitrofe(defensor);
        defensor.hacerLimitrofe(atacante);
        atacante.reforzar(3);
        defensor.reforzar(1);
        ArrayList<Integer> tiradaAtacante = new ArrayList<>();
        tiradaAtacante.add(6);
        tiradaAtacante.add(6);
        tiradaAtacante.add(6);
        ArrayList<Integer> tiradaDefensor = new ArrayList<>();
        tiradaDefensor.add(1);
        tiradaDefensor.add(1);

        Integer cantEjercitosAtacantes = atacante.getEjercitosParaAtacar();
        Combate combate = new Combate(atacante, defensor, cantEjercitosAtacantes);
        combate.combatePredeterminado(tiradaAtacante, tiradaDefensor);
        assertTrue(atacante.esAliado(defensor));
        assertEquals(3, atacante.getEjercitos());
        assertEquals(1, defensor.getEjercitos());
    }

    //Atacar3v2 Gana1Pierde1
    @Test
    public void test12CreoUnCombateYElPaisAtacanteAtacaCon3EjercitosAPaisQueDefiendeCon2EjercitoGana1Pierde1 (){
        Jugador jugadorAtacante = new Jugador("000000");
        Pais atacante = new Pais("Argentina", jugadorAtacante);

        Jugador jugadorDefensor = new Jugador("ffffff");
        Pais defensor = new Pais("Uruguay", jugadorDefensor);
        atacante.reforzar(3);
        defensor.reforzar(1);
        atacante.hacerLimitrofe(defensor);
        defensor.hacerLimitrofe(atacante);
        ArrayList<Integer> tiradaAtacante = new ArrayList<>();
        tiradaAtacante.add(6);
        tiradaAtacante.add(6);
        tiradaAtacante.add(6);
        ArrayList<Integer> tiradaDefensor = new ArrayList<>();
        tiradaDefensor.add(6);
        tiradaDefensor.add(1);

        Integer cantEjercitosAtacantes = atacante.getEjercitosParaAtacar();
        Combate combate = new Combate(atacante, defensor, cantEjercitosAtacantes);
        combate.combatePredeterminado(tiradaAtacante, tiradaDefensor);
        assertFalse(atacante.esAliado(defensor));
        assertEquals(3, atacante.getEjercitos());
        assertEquals(1, defensor.getEjercitos());
    }

    //Ataque3v2 Pierde
    @Test
    public void test13CreoUnCombateYElPaisAtacanteAtacaCon3EjercitosAPaisQueDefiendeCon1EjercitoYPierdeTodas (){
        Jugador jugadorAtacante = new Jugador("000000");
        Pais atacante = new Pais("Argentina", jugadorAtacante);
        Jugador jugadorDefensor = new Jugador("ffffff");
        Pais defensor = new Pais("Uruguay", jugadorDefensor);
        atacante.hacerLimitrofe(defensor);
        defensor.hacerLimitrofe(atacante);
        atacante.reforzar(3);
        defensor.reforzar(1);
        ArrayList<Integer> tiradaAtacante = new ArrayList<>();
        tiradaAtacante.add(5);
        tiradaAtacante.add(5);
        tiradaAtacante.add(5);
        ArrayList<Integer> tiradaDefensor = new ArrayList<>();
        tiradaDefensor.add(6);
        tiradaDefensor.add(6);

        Integer cantEjercitosAtacantes = atacante.getEjercitosParaAtacar();
        Combate combate = new Combate(atacante, defensor, cantEjercitosAtacantes);
        combate.combatePredeterminado(tiradaAtacante, tiradaDefensor);
        assertFalse(atacante.esAliado(defensor));
        assertEquals(2, atacante.getEjercitos());
        assertEquals(2, defensor.getEjercitos());
    }



// Atacar3v3 Conquista

    @Test
    public void test14CreoUnCombateYElPaisAtacanteAtacaCon3EjercitosAPaisQueDefiendeCon3EjercitoYConquista (){
        Jugador jugadorAtacante = new Jugador("000000");
        Pais atacante = new Pais("Argentina", jugadorAtacante);
        atacante.reforzar(3);
        Jugador jugadorDefensor = new Jugador("ffffff");
        Pais defensor = new Pais("Jugador", jugadorDefensor);
        defensor.reforzar(2);
        atacante.hacerLimitrofe(defensor);
        ArrayList<Integer> tiradaAtacante = new ArrayList<>();
        tiradaAtacante.add(6);
        tiradaAtacante.add(6);
        tiradaAtacante.add(6);
        ArrayList<Integer> tiradaDefensor = new ArrayList<>();
        tiradaDefensor.add(1);
        tiradaDefensor.add(1);
        tiradaDefensor.add(1);

        Integer cantEjercitosAtacantes = atacante.getEjercitosParaAtacar();
        Combate combate = new Combate(atacante, defensor, cantEjercitosAtacantes);
        combate.combatePredeterminado(tiradaAtacante, tiradaDefensor);
        assertTrue(atacante.esAliado(defensor));
        assertEquals(3, atacante.getEjercitos());
        assertEquals(1, defensor.getEjercitos());
    }


    // Atacar 3v3 Gana2Pierde1
    @Test
    public void test15CreoUnCombateYElPaisAtacanteAtacaCon3EjercitosAPaisQueDefiendeCon3EjercitoYGana2Pierde1(){
        Jugador jugadorAtacante = new Jugador("000000");
        Pais atacante = new Pais("Argentina", jugadorAtacante);
        atacante.reforzar(3);
        Jugador jugadorDefensor = new Jugador("ffffff");
        Pais defensor = new Pais("Uruguay", jugadorDefensor);
        defensor.reforzar(2);
        atacante.hacerLimitrofe(defensor);
        ArrayList<Integer> tiradaAtacante = new ArrayList<>();
        tiradaAtacante.add(6);
        tiradaAtacante.add(6);
        tiradaAtacante.add(1);
        ArrayList<Integer> tiradaDefensor = new ArrayList<>();
        tiradaDefensor.add(1);
        tiradaDefensor.add(1);
        tiradaDefensor.add(1);

        Integer cantEjercitosAtacantes = atacante.getEjercitosParaAtacar();
        Combate combate = new Combate(atacante, defensor, cantEjercitosAtacantes);
        combate.combatePredeterminado(tiradaAtacante, tiradaDefensor);
        assertFalse(atacante.esAliado(defensor));
        assertEquals(3, atacante.getEjercitos());
        assertEquals(1, defensor.getEjercitos());
    }

    // Atacar 3v3 Gana1Pierde2
    @Test
    public void test16CreoUnCombateYElPaisAtacanteAtacaCon3EjercitosAPaisQueDefiendeCon3EjercitoYGana1Pierde2(){
        Jugador jugadorAtacante = new Jugador("000000");
        Pais atacante = new Pais("Argentina", jugadorAtacante);
        atacante.reforzar(3);
        Jugador jugadorDefensor = new Jugador("ffffff");
        Pais defensor = new Pais("Uruguay", jugadorDefensor);
        defensor.reforzar(2);
        atacante.hacerLimitrofe(defensor);
        ArrayList<Integer> tiradaAtacante = new ArrayList<>();
        tiradaAtacante.add(6);
        tiradaAtacante.add(1);
        tiradaAtacante.add(1);
        ArrayList<Integer> tiradaDefensor = new ArrayList<>();
        tiradaDefensor.add(1);
        tiradaDefensor.add(1);
        tiradaDefensor.add(1);

        Integer cantEjercitosAtacantes = atacante.getEjercitosParaAtacar();
        Combate combate = new Combate(atacante, defensor, cantEjercitosAtacantes);
        combate.combatePredeterminado(tiradaAtacante, tiradaDefensor);
        assertFalse(atacante.esAliado(defensor));
        assertEquals(2, atacante.getEjercitos());
        assertEquals(2, defensor.getEjercitos());
    }

    // Atacar3v3 Pierde3
    @Test
    public void test17CreoUnCombateYElPaisAtacanteAtacaCon3EjercitosAPaisQueDefiendeCon3EjercitoYPierdeTodas(){
        Jugador jugadorAtacante = new Jugador("000000");
        Pais atacante = new Pais("Argentina", jugadorAtacante);
        atacante.reforzar(3);
        Jugador jugadorDefensor = new Jugador("ffffff");
        Pais defensor = new Pais("Uruguay", jugadorDefensor);
        defensor.reforzar(2);
        atacante.hacerLimitrofe(defensor);
        ArrayList<Integer> tiradaAtacante = new ArrayList<>();
        tiradaAtacante.add(1);
        tiradaAtacante.add(1);
        tiradaAtacante.add(1);
        ArrayList<Integer> tiradaDefensor = new ArrayList<>();
        tiradaDefensor.add(1);
        tiradaDefensor.add(1);
        tiradaDefensor.add(1);

        Integer cantEjercitosAtacantes = atacante.getEjercitosParaAtacar();
        Combate combate = new Combate(atacante, defensor, cantEjercitosAtacantes);
        combate.combatePredeterminado(tiradaAtacante, tiradaDefensor);
        assertFalse(atacante.esAliado(defensor));
        assertEquals(1, atacante.getEjercitos());
        assertEquals(3, defensor.getEjercitos());
    }

    //13 Atacar1v3 Gana
    @Test
    public void test18CreoUnCombateYElPaisAtacanteAtacaCon1EjercitoAPaisQueDefiendeCon3EjercitoYGana(){
        Jugador jugadorAtacante = new Jugador("000000");
        Pais atacante = new Pais("Argentina", jugadorAtacante);
        atacante.reforzar(1);
        Jugador jugadorDefensor = new Jugador("ffffff");
        Pais defensor = new Pais("Uruguay", jugadorDefensor);
        defensor.reforzar(2);
        atacante.hacerLimitrofe(defensor);
        ArrayList<Integer> tiradaAtacante = new ArrayList<>();
        tiradaAtacante.add(6);
        ArrayList<Integer> tiradaDefensor = new ArrayList<>();
        tiradaDefensor.add(1);
        tiradaDefensor.add(1);
        tiradaDefensor.add(1);


        Integer cantEjercitosAtacantes = atacante.getEjercitosParaAtacar();
        Combate combate = new Combate(atacante, defensor, cantEjercitosAtacantes);
        combate.combatePredeterminado(tiradaAtacante, tiradaDefensor);
        assertFalse(atacante.esAliado(defensor));
        assertEquals(2, atacante.getEjercitos());
        assertEquals(2, defensor.getEjercitos());
    }

    //Atacar 1v3 Gana
    @Test
    public void test19CreoUnCombateYElPaisAtacanteAtacaCon1EjercitoAPaisQueDefiendeCon3EjercitoYGana(){
        Jugador jugadorAtacante = new Jugador("000000");
        Pais atacante = new Pais("Argentina", jugadorAtacante);
        atacante.reforzar(1);
        Jugador jugadorDefensor = new Jugador("ffffff");
        Pais defensor = new Pais("Uruguay", jugadorDefensor);
        defensor.reforzar(2);
        atacante.hacerLimitrofe(defensor);
        ArrayList<Integer> tiradaAtacante = new ArrayList<>();
        tiradaAtacante.add(2);
        ArrayList<Integer> tiradaDefensor = new ArrayList<>();
        tiradaDefensor.add(1);
        tiradaDefensor.add(1);
        tiradaDefensor.add(1);
        Integer cantEjercitosAtacantes = atacante.getEjercitosParaAtacar();

        Combate combate = new Combate(atacante, defensor, cantEjercitosAtacantes);
        combate.combatePredeterminado(tiradaAtacante, tiradaDefensor);
        assertFalse(atacante.esAliado(defensor));
        assertEquals(2, atacante.getEjercitos());
        assertEquals(2, defensor.getEjercitos());
    }

    // Atacar2v3 Gana
    @Test
    public void test20CreoUnCombateYElPaisAtacanteAtacaCon2EjercitosAPaisQueDefiendeCon3EjercitoYGana(){
        Jugador jugadorAtacante = new Jugador("000000");
        Pais atacante = new Pais("Argentina", jugadorAtacante);
        atacante.reforzar(2);
        Jugador jugadorDefensor = new Jugador("ffffff");
        Pais defensor = new Pais("Uruguay", jugadorDefensor);
        defensor.reforzar(2);
        atacante.hacerLimitrofe(defensor);
        ArrayList<Integer> tiradaAtacante = new ArrayList<>();
        tiradaAtacante.add(6);
        tiradaAtacante.add(6);
        ArrayList<Integer> tiradaDefensor = new ArrayList<>();
        tiradaDefensor.add(1);
        tiradaDefensor.add(1);
        tiradaDefensor.add(1);

        Integer cantEjercitosAtacantes = atacante.getEjercitosParaAtacar();
        Combate combate = new Combate(atacante, defensor, cantEjercitosAtacantes);
        combate.combatePredeterminado(tiradaAtacante, tiradaDefensor);
        assertFalse(atacante.esAliado(defensor));
        assertEquals(3, atacante.getEjercitos());
        assertEquals(1, defensor.getEjercitos());
    }

    //Atacar2v3 Gana1Pierde1
    @Test
    public void test21CreoUnCombateYElPaisAtacanteAtacaCon2EjercitosAPaisQueDefiendeCon3EjercitoYGana1Pierde1(){
        Jugador jugadorAtacante = new Jugador("000000");
        Pais atacante = new Pais("Argentina", jugadorAtacante);
        atacante.reforzar(2);
        Jugador jugadorDefensor = new Jugador("ffffff");
        Pais defensor = new Pais("Uruguay", jugadorDefensor);
        defensor.reforzar(2);
        atacante.hacerLimitrofe(defensor);
        ArrayList<Integer> tiradaAtacante = new ArrayList<>();
        tiradaAtacante.add(6);
        tiradaAtacante.add(6);
        ArrayList<Integer> tiradaDefensor = new ArrayList<>();
        tiradaDefensor.add(6);
        tiradaDefensor.add(1);
        tiradaDefensor.add(1);
        Integer cantEjercitosAtacantes = atacante.getEjercitosParaAtacar();
        Combate combate = new Combate(atacante, defensor, cantEjercitosAtacantes);
        combate.combatePredeterminado(tiradaAtacante, tiradaDefensor);
        assertFalse(atacante.esAliado(defensor));
        assertEquals(2, atacante.getEjercitos());
        assertEquals(2, defensor.getEjercitos());
    }

    //Atacar2v3 Pierde
    @Test
    public void test22CreoUnCombateYElPaisAtacanteAtacaCon2EjercitosAPaisQueDefiendeCon3EjercitoYPierde(){
        Jugador jugadorAtacante = new Jugador("000000");
        Pais atacante = new Pais("Argentina", jugadorAtacante);
        atacante.reforzar(2);
        Jugador jugadorDefensor = new Jugador("ffffff");
        Pais defensor = new Pais("Uruguay", jugadorDefensor);
        defensor.reforzar(2);
        atacante.hacerLimitrofe(defensor);
        ArrayList<Integer> tiradaAtacante = new ArrayList<>();
        tiradaAtacante.add(6);
        tiradaAtacante.add(6);
        ArrayList<Integer> tiradaDefensor = new ArrayList<>();
        tiradaDefensor.add(6);
        tiradaDefensor.add(6);
        tiradaDefensor.add(1);

        Combate combate = new Combate(atacante, defensor);
        combate.combatePredeterminado(tiradaAtacante, tiradaDefensor);
        assertFalse(atacante.esAliado(defensor));
        assertEquals(1, atacante.getEjercitos());
        assertEquals(3, defensor.getEjercitos());
    }
}
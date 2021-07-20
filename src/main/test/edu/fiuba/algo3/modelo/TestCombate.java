package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class TestCombate {

    private Jugador jugadorAtacante;
    private Jugador jugadorDefensor;
    private Pais atacante;
    private Pais defensor;
    private ArrayList<Integer> tiradaAtacante;
    private ArrayList<Integer> tiradaDefensor;

    @BeforeEach
    public void setUp() {
        this.jugadorAtacante = new Jugador("000000");
        this.jugadorDefensor = new Jugador("ffffff");
        this.atacante = new Pais("Argentina", jugadorAtacante);
        this.defensor = new Pais("Uruguay", jugadorDefensor);
        atacante.hacerLimitrofe(defensor);
        defensor.hacerLimitrofe(atacante);
        this.tiradaAtacante = new ArrayList<>();
        this.tiradaDefensor = new ArrayList<>();
    }

    @Test
    public void test01SeCreaUnCombateYNoEsNull() {
        Integer cantEjercitosAtacantes = atacante.getEjercitosParaAtacar();

        Combate combate = new Combate(atacante, defensor, cantEjercitosAtacantes);
        assertNotNull(combate);
    }

    // 1v1 conquista
    @Test
    public void test02CreoUnCombateYElPaisAtacanteAtacaCon1EjercitoAPaisQueDefiendeCon1EjercitoYGanaElAtacante (){
        atacante.reforzar(1);
        this.tiradaAtacante.add(6);
        this.tiradaDefensor.add(1);
        Integer cantEjercitosAtacantes = atacante.getEjercitosParaAtacar();
        Combate combate = new Combate(atacante, defensor, cantEjercitosAtacantes);

        combate.combatePredeterminado(tiradaAtacante, tiradaDefensor);
        assertTrue(atacante.esAliado(defensor));
        assertEquals(1, defensor.getEjercitos());
        assertEquals(1, atacante.getEjercitos());
    }


    // 1v1 pierde atacante
    @Test
    public void test03CreoUnCombateYElPaisAtacanteAtacaCon1EjercitoAPaisQueDefiendeCon1EjercitoYPierdeElAtacante (){
        atacante.reforzar(1);
        tiradaAtacante.add(1);
        tiradaDefensor.add(3);

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
        atacante.reforzar(2);
        tiradaAtacante.add(6);
        tiradaAtacante.add(6);
        tiradaDefensor.add(1);

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
        atacante.reforzar(2);
        tiradaAtacante.add(1);
        tiradaAtacante.add(1);
        tiradaDefensor.add(1);

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
        atacante.reforzar(2);
        defensor.reforzar(1);
        tiradaAtacante.add(6);
        tiradaAtacante.add(2);
        tiradaDefensor.add(1);
        tiradaDefensor.add(1);

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
        atacante.reforzar(2);
        defensor.reforzar(1);
        tiradaAtacante.add(1);
        tiradaAtacante.add(1);
        tiradaDefensor.add(2);
        tiradaDefensor.add(2);

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
        atacante.reforzar(2);
        defensor.reforzar(2);
        tiradaAtacante.add(6);
        tiradaAtacante.add(6);
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

    // Atacar3v1 Conquista
    @Test
    public void test09CreoUnCombateYElPaisAtacanteAtacaCon3EjercitosAPaisQueDefiendeCon1EjercitoYConquista (){
        atacante.reforzar(3);
        tiradaAtacante.add(6);
        tiradaAtacante.add(6);
        tiradaAtacante.add(6);
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
        atacante.reforzar(3);
        tiradaAtacante.add(1);
        tiradaAtacante.add(1);
        tiradaAtacante.add(1);
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
        atacante.reforzar(3);
        defensor.reforzar(1);
        tiradaAtacante.add(6);
        tiradaAtacante.add(6);
        tiradaAtacante.add(6);
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
        atacante.reforzar(3);
        defensor.reforzar(1);
        tiradaAtacante.add(6);
        tiradaAtacante.add(6);
        tiradaAtacante.add(6);
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
        atacante.reforzar(3);
        defensor.reforzar(1);
        tiradaAtacante.add(5);
        tiradaAtacante.add(5);
        tiradaAtacante.add(5);
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
        atacante.reforzar(3);
        Pais defensor = new Pais("Jugador", jugadorDefensor);
        defensor.reforzar(2);
        tiradaAtacante.add(6);
        tiradaAtacante.add(6);
        tiradaAtacante.add(6);
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
        atacante.reforzar(3);
        defensor.reforzar(2);
        tiradaAtacante.add(6);
        tiradaAtacante.add(6);
        tiradaAtacante.add(1);
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
        atacante.reforzar(3);
        defensor.reforzar(2);
        tiradaAtacante.add(6);
        tiradaAtacante.add(1);
        tiradaAtacante.add(1);
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
        atacante.reforzar(3);
        defensor.reforzar(2);
        tiradaAtacante.add(1);
        tiradaAtacante.add(1);
        tiradaAtacante.add(1);
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
        atacante.reforzar(1);
        defensor.reforzar(2);
        tiradaAtacante.add(6);
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
        atacante.reforzar(1);
        defensor.reforzar(2);
        tiradaAtacante.add(2);
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
        atacante.reforzar(2);
        defensor.reforzar(2);
        tiradaAtacante.add(6);
        tiradaAtacante.add(6);
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
        atacante.reforzar(2);
        defensor.reforzar(2);
        tiradaAtacante.add(6);
        tiradaAtacante.add(6);
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
        atacante.reforzar(2);
        defensor.reforzar(2);
        tiradaAtacante.add(6);
        tiradaAtacante.add(6);
        tiradaDefensor.add(6);
        tiradaDefensor.add(6);
        tiradaDefensor.add(1);

        Integer cantEjercitosAtacantes = atacante.getEjercitosParaAtacar();
        Combate combate = new Combate(atacante, defensor, cantEjercitosAtacantes);
        combate.combatePredeterminado(tiradaAtacante, tiradaDefensor);

        assertFalse(atacante.esAliado(defensor));
        assertEquals(1, atacante.getEjercitos());
        assertEquals(3, defensor.getEjercitos());
    }
}
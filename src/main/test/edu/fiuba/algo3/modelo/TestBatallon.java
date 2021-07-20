package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestBatallon {

    @Test
    public void test01CreoUnBatallonYNoEsNull() {
        Batallon batallon = new Batallon();

        assertNotNull(batallon);
    }

    @Test
    public void test02CreoUnBatallonYSeInicializaCon1 (){
        Batallon batallon = new Batallon();

        assertEquals(batallon.getEjercitos(), 1);
    }

    @Test
    public void test03CreoUnBatallonYAgregoDosEjercitosYTengoTresEjercitos (){
        Batallon batallon = new Batallon();
        batallon.agregarEjercitos(2);
        assertEquals(batallon.getEjercitos(), 3);
    }

    @Test
    public void test04CreoUnBatallonYAgregoDosEjercitosYTengoDosEjercitosParaAtacar (){
        Batallon batallon = new Batallon();
        batallon.agregarEjercitos(2);
        assertEquals(batallon.getEjercitosParaAtacar(), 2);
    }

    @Test
    public void test05CreoUnBatallonYAgregoCuatroEjercitosYTengoTresEjercitosParaAtacar (){
        Batallon batallon = new Batallon();
        batallon.agregarEjercitos(4);
        assertEquals(batallon.getEjercitosParaAtacar(), 3);
    }

    @Test
    public void test06CreoUnBatallonYAgregoCincoEjercitosYTengoSeisEjercitos (){
        Batallon batallon = new Batallon();
        batallon.agregarEjercitos(5);
        assertEquals(batallon.getEjercitos(), 6);
    }

    @Test
    public void test07CreoUnBatallonYAgregoCincoEjercitosYTengo3EjercitosParaAtacar (){
        Batallon batallon = new Batallon();
        batallon.agregarEjercitos(5);
        assertEquals(batallon.getEjercitosParaAtacar(), 3);
    }

    @Test
    public void test08CreoUnBatallonYTengoEjercitos (){
        Batallon batallon = new Batallon();
        assertTrue(batallon.tengoEjercitos());
    }

    @Test
    public void test09CreoUnBatallonYLeSacoTodosSusEjercitosYNoTengoEjercitos (){
        Batallon batallon = new Batallon();
        batallon.disminuirEjercitos(1);
        assertFalse(batallon.tengoEjercitos());
    }

    @Test
    public void test10CreoUnBatallonYLeSacoTodosSusEjercitosYNoTengoEjercitos (){
        Batallon batallon= new Batallon();
        batallon.disminuirEjercitos(1);
        assertFalse(batallon.tengoEjercitos());
    }

    @Test
    public void test11CreoUnBatallonYAgregoCincoEjercitosLeSacoUnEjercitoYTengoTresEjercitosParaAtacar (){
        Batallon batallon = new Batallon();
        batallon.agregarEjercitos(5);
        batallon.disminuirEjercitos(1);
        assertEquals(batallon.getEjercitosParaAtacar(), 3);
    }

    @Test
    public void test12CreoUnBatallonYDisminuyo2EjercitosYTengo0Ejercitos (){
        Batallon batallon = new Batallon();
        batallon.disminuirEjercitos(2);
        assertEquals(batallon.getEjercitos(), 0);
    }

    @Test
    public void test13CreoUnBatallonYAgrego5EjercitosYTengo3EjercitosParaDefender (){
        Batallon batallon = new Batallon();
        batallon.agregarEjercitos(5);
        assertEquals(batallon.getEjercitosParaDefender(), 3);
    }

    @Test
    public void test14CreoUnBatallonYTengo1EjercitoParaDefender (){
        Batallon batallon = new Batallon();
        assertEquals(batallon.getEjercitosParaDefender(), 1);
    }
}

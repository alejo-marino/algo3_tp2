package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestBatallon {

    private Batallon batallon;

    @BeforeEach
    public void setUp() {
        this.batallon = new Batallon();
    }

    @Test
    public void test01CreoUnBatallonYNoEsNull() {
        assertNotNull(batallon);
    }

    @Test
    public void test02CreoUnBatallonYSeInicializaCon1 (){
        assertEquals(batallon.getEjercitos(), 1);
    }

    @Test
    public void test03CreoUnBatallonYAgregoDosEjercitosYTengoTresEjercitos (){
        batallon.agregarEjercitos(2);
        assertEquals(batallon.getEjercitos(), 3);
    }

    @Test
    public void test04CreoUnBatallonYAgregoDosEjercitosYTengoDosEjercitosParaAtacar (){
        batallon.agregarEjercitos(2);
        assertEquals(batallon.getEjercitosParaAtacar(), 2);
    }

    @Test
    public void test05CreoUnBatallonYAgregoCuatroEjercitosYTengoTresEjercitosParaAtacar (){
        batallon.agregarEjercitos(4);
        assertEquals(batallon.getEjercitosParaAtacar(), 3);
    }

    @Test
    public void test06CreoUnBatallonYAgregoCincoEjercitosYTengoSeisEjercitos (){
        batallon.agregarEjercitos(5);
        assertEquals(batallon.getEjercitos(), 6);
    }

    @Test
    public void test07CreoUnBatallonYAgregoCincoEjercitosYTengo3EjercitosParaAtacar (){
        batallon.agregarEjercitos(5);
        assertEquals(batallon.getEjercitosParaAtacar(), 3);
    }

    @Test
    public void test08CreoUnBatallonYTengoEjercitos (){
        assertTrue(batallon.tengoEjercitos());
    }

    @Test
    public void test09CreoUnBatallonYLeSacoTodosSusEjercitosYNoTengoEjercitos (){
        batallon.disminuirEjercitos(1);
        assertFalse(batallon.tengoEjercitos());
    }

    @Test
    public void test10CreoUnBatallonYLeSacoTodosSusEjercitosYNoTengoEjercitos (){
        batallon.disminuirEjercitos(1);
        assertFalse(batallon.tengoEjercitos());
    }

    @Test
    public void test11CreoUnBatallonYAgregoCincoEjercitosLeSacoUnEjercitoYTengoTresEjercitosParaAtacar (){
        batallon.agregarEjercitos(5);
        batallon.disminuirEjercitos(1);
        assertEquals(batallon.getEjercitosParaAtacar(), 3);
    }

    @Test
    public void test12CreoUnBatallonYDisminuyo2EjercitosYTengo0Ejercitos (){
        batallon.disminuirEjercitos(2);
        assertEquals(batallon.getEjercitos(), 0);
    }

    @Test
    public void test13CreoUnBatallonYAgrego5EjercitosYTengo3EjercitosParaDefender (){
        batallon.agregarEjercitos(5);
        assertEquals(batallon.getEjercitosParaDefender(), 3);
    }

    @Test
    public void test14CreoUnBatallonYTengo1EjercitoParaDefender (){
        assertEquals(batallon.getEjercitosParaDefender(), 1);
    }

    @Test
    public void test15CreoUnBatallonYAgrego2EjercitosYTengo1EjercitoParaReagruparEnAtaque() {
        batallon.agregarEjercitos(2);
        assertEquals(1, batallon.getEjercitosParaReagruparEnAtaque());
    }

    @Test
    public void test16CreoUnBatallonYAgrego5EjercitosYTengo2EjercitosParaReagruparEnAtaque() {
        batallon.agregarEjercitos(5);
        assertEquals(2, batallon.getEjercitosParaReagruparEnAtaque());
    }

}

package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.EjercitosInsuficientesException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestEjercito {

    @Test
    public void test01CreoUnEjercitoCorrectamente() {
        Ejercito ejercito = new EjercitoUnitario();
        assertNotNull(ejercito);
    }
    @Test
    public void test02CreoUnEjercitoUnitarioYTieneUnaTropa() {
        Ejercito ejercito = new EjercitoUnitario();
        assertEquals(1, ejercito.getCantidadTropas());
    }
    @Test
    public void test03CreoUnEjercitoRegularCon3Tropas() {
        Ejercito ejercito = new EjercitoRegular(3);
        assertEquals(3, ejercito.getCantidadTropas());
    }
    @Test
    public void test04CreoUnEjercitoGrandeCon5Tropas() {
        Ejercito ejercito = new EjercitoGrande(5);
        assertEquals(5, ejercito.getCantidadTropas());
    }
    @Test
    public void test05CreoUnEjercitoUnitarioNoPuedeAtacar() {
        Ejercito ejercito = new EjercitoUnitario();
        assertThrows(EjercitosInsuficientesException.class, () -> ejercito.obtenerCantidadTropas());
    }
    @Test
    public void test06CreoUnEjercitoRegularCon3TropasYPuedeAtacarConDos() {
        Ejercito ejercito = new EjercitoRegular(3);
        assertEquals(2,  ejercito.obtenerCantidadTropas());
    }
    @Test
    public void test07CreoUnEjercitoGrandeConMasDe4TropasYPuedeAtacarConTres() {
        Ejercito ejercito = new EjercitoGrande(5);
        assertEquals(3,  ejercito.obtenerCantidadTropas());
    }
    @Test
    public void test08CreoUnEjercitoUnitarioLeAgregoUnaTropasYSeConvierteEnEjercitoRegular() {
        Ejercito ejercito = new EjercitoUnitario();
        ejercito = ejercito.agregarTropas(1);
        assertEquals(EjercitoRegular.class,  ejercito.getClass());
    }
    @Test
    public void test09CreoUnEjercitoUnitarioLeAgregoDosTropasYSeConvierteEnEjercitoRegular() {
        Ejercito ejercito = new EjercitoUnitario();
        ejercito = ejercito.agregarTropas(2);
        assertEquals(EjercitoRegular.class,  ejercito.getClass());
    }
    @Test
    public void test09CreoUnEjercitoUnitarioLeAgregoTresTropasYSeConvierteEnEjercitoGrande() {
        Ejercito ejercito = new EjercitoUnitario();
        ejercito = ejercito.agregarTropas(3);
        assertEquals(EjercitoGrande.class,  ejercito.getClass());
    }
    @Test
    public void test10CreoUnEjercitoRegularLeAgregoUnaTropaYSigueSiendoEjercitoRegular() {
        Ejercito ejercito = new EjercitoRegular(2);
        ejercito = ejercito.agregarTropas(1);
        assertEquals(EjercitoRegular.class,  ejercito.getClass());
    }
    @Test
    public void test11CreoUnEjercitoRegularLeAgregoDosTropaYSeTransformaEnEjercitoGrande() {
        Ejercito ejercito = new EjercitoRegular(2);
        ejercito = ejercito.agregarTropas(2);
        assertEquals(EjercitoGrande.class,  ejercito.getClass());
    }
    @Test
    public void test12CreoUnEjercitoRegularLeAgregoTreintaTropaYSeTransformaEnEjercitoGrande() {
        Ejercito ejercito = new EjercitoRegular(2);
        ejercito = ejercito.agregarTropas(30);
        assertEquals(EjercitoGrande.class,  ejercito.getClass());
    }
    @Test
    public void test13CreoUnEjercitoRegularConDosTropasYSiLeSacoUnoQuedaUnitario() {
        Ejercito ejercito = new EjercitoRegular(2);
        ejercito = ejercito.reduccirTropas(1);
        assertEquals(EjercitoUnitario.class,  ejercito.getClass());
    }
    @Test
    public void test14CreoUnEjercitoRegularConTresTropasYSiLeSacoUnoQuedaRegular() {
        Ejercito ejercito = new EjercitoRegular(3);
        ejercito = ejercito.reduccirTropas(1);
        assertEquals(EjercitoRegular.class,  ejercito.getClass());
    }
    @Test
    public void test15CreoUnEjercitoRegularConTresTropasYSiLeSacoUnoQuedaUnitario() {
        Ejercito ejercito = new EjercitoRegular(3);
        ejercito = ejercito.reduccirTropas(2);
        assertEquals(EjercitoUnitario.class,  ejercito.getClass());
    }
    @Test
    public void test16CreoUnEjercitoGrandeConCuatroTropasYSiLeSacoUnoQuedaRegular() {
        Ejercito ejercito = new EjercitoGrande(4);
        ejercito = ejercito.reduccirTropas(1);
        assertEquals(EjercitoRegular.class,  ejercito.getClass());
    }
    @Test
    public void test17CreoUnEjercitoGrandeConCincoTropasYSiLeSacoUnoQuedaGrande() {
        Ejercito ejercito = new EjercitoGrande(5);
        ejercito = ejercito.reduccirTropas(1);
        assertEquals(EjercitoGrande.class,  ejercito.getClass());
    }
    @Test
    public void test16CreoUnEjercitoGrandeConCincoTropasYSiLeSacoTresTengoUnoRegularConDosTropas() {
        Ejercito ejercito = new EjercitoGrande(5);
        ejercito = ejercito.reduccirTropas(3);
        assertEquals(2, ejercito.getCantidadTropas());
    }
    @Test
    public void test16CreoUnEjercitoRegularConTresTropasYSiLeSacoUnaTengoUnoRegularConUnaTropa() {
        Ejercito ejercito = new EjercitoRegular(3);
        ejercito = ejercito.reduccirTropas(1);
        assertEquals(2, ejercito.getCantidadTropas());
    }

}

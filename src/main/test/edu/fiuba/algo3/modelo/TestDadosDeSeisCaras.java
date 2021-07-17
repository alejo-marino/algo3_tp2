package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TestDadosDeSeisCaras {

    @Test
    public void test01CreoUnDadosDeSeisCarasYNoEsNull () {
        DadosDeSeisCaras dados = new DadosDeSeisCaras();
        assertNotNull(dados);
    }
    @Test
    public void test02CreoUnDadosDeSeisCarasYTiroUnDadoYDevuelveUnaListDeUnNumero () {
        DadosDeSeisCaras dados = new DadosDeSeisCaras();
        ArrayList<Integer> tirada = dados.tirarDados(1);
        assertEquals(tirada.size(), 1);
    }

    @Test
    public void test03CreoUnDadosDeSeisCarasYTiroDosDadosYDevuelveUnaListDeDosNumeros () {
        DadosDeSeisCaras dados = new DadosDeSeisCaras();
        ArrayList<Integer> tirada = dados.tirarDados(2);
        assertEquals(tirada.size(), 2);
    }

    @Test
    public void test04CreoUnDadosDeSeisCarasYTiroSieteDadosYDevuelveUnaListDeSieteNumeros () {
        DadosDeSeisCaras dados = new DadosDeSeisCaras();
        ArrayList<Integer> tirada = dados.tirarDados(7);
        assertEquals(tirada.size(), 7);
    }

}

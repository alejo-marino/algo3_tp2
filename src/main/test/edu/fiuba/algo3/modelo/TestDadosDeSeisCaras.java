package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class TestDadosDeSeisCaras {

    private DadosDeSeisCaras dados;

    @BeforeEach
    void setUp() {
        this.dados = new DadosDeSeisCaras();
    }

    @Test
    public void test01CreoUnDadosDeSeisCarasYNoEsNull () {
        assertNotNull(dados);
    }
    @Test
    public void test02CreoUnDadosDeSeisCarasYTiroUnDadoYDevuelveUnaListDeUnNumero () {
        ArrayList<Integer> tirada = dados.tirarDados(1);
        assertEquals(tirada.size(), 1);
    }

    @Test
    public void test03CreoUnDadosDeSeisCarasYTiroDosDadosYDevuelveUnaListDeDosNumeros () {
        ArrayList<Integer> tirada = dados.tirarDados(2);
        assertEquals(tirada.size(), 2);
    }

    @Test
    public void test04CreoUnDadosDeSeisCarasYTiroSieteDadosYDevuelveUnaListDeSieteNumeros () {
        ArrayList<Integer> tirada = dados.tirarDados(7);
        assertEquals(tirada.size(), 7);
    }

}

package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.CantidadErroneaDeJugadoresError;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class JuegoTest {

    @Test
    public void test01QuieroCrearJuegoCon1JugadorYDaError(){

        assertThrows(CantidadErroneaDeJugadoresError.class, () -> new Juego(1));
    }
    @Test
    public void test02QuieroCrearJuegoCon7JugadoresYDaError(){

        assertThrows(CantidadErroneaDeJugadoresError.class, () -> new Juego(7));
    }
}

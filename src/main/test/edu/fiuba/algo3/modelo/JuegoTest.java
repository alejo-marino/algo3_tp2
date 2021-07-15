package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.CantidadErroneaDeJugadoresError;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class JuegoTest {

    @Test
    public void test01QuieroCrearJuegoCon1JugadorYDaError(){
        ArrayList listaJugadores = new ArrayList();
        listaJugadores.add("Juan");
        assertThrows(CantidadErroneaDeJugadoresError.class, () -> new Juego(listaJugadores));
    }
    @Test
    public void test02QuieroCrearJuegoCon7JugadoresYDaError(){
        ArrayList listaJugadores = new ArrayList();
        listaJugadores.add("Juan");
        listaJugadores.add("Juan");
        listaJugadores.add("Juan");
        listaJugadores.add("Juan");
        listaJugadores.add("Juan");
        listaJugadores.add("Juan");
        listaJugadores.add("Juan");
        assertThrows(CantidadErroneaDeJugadoresError.class, () -> new Juego(listaJugadores));
    }
}

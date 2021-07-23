package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Queue;
import java.util.LinkedList;

public class TestInicializadorDeDatos {

    // Paths.get("JSON/", "Fronteras.json")
    private String RUTA_JSON_FRONTERAS = "Fronteras.json";
    private String RUTA_JSON_TARJETAS = "Cartas.json";
    private InicializadorDeDatos inicializador;
    private Queue<Jugador> jugadores;

    @BeforeEach
    void setUp() {
        ParserTEG parser = new ParserTEG();
//        Path rutaFronteras = Paths.get("JSON/", "Fronteras.json");
//        Path rutaTarjetas = Paths.get("JSON/", "Fronteras.json");
        ArrayList aux = parser.parsearTablero(RUTA_JSON_FRONTERAS, RUTA_JSON_TARJETAS);
        Hashtable<String, Hashtable<String, ArrayList<String>>> paisesParseados = (Hashtable<String, Hashtable<String, ArrayList<String>>>) aux.get(0);
        ArrayList<ArrayList<String>> tarjetasParseadas = (ArrayList<ArrayList<String>>) aux.get(1);
        this.inicializador = new InicializadorDeDatos();
        this.jugadores = new LinkedList<>();
        jugadores.add(new Jugador("000000"));
        jugadores.add(new Jugador("ffffff"));
    }

    @Test
    public void test01CreoUnInicializadorDeDatosYNoEsNull () {
        assertNotNull(inicializador);
    }
}

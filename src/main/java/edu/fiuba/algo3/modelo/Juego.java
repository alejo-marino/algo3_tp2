package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.NumeroDeJugadoresInvalidoException;
import edu.fiuba.algo3.modelo.excepciones.NumeroDeJugadoresNoAsignadoException;

import java.lang.reflect.Array;
import java.util.*;

import static edu.fiuba.algo3.modelo.Constantes.*;


public class Juego {

    private final Queue<String> colores;

    private Tablero tablero;
    private SistemaDeTurnos sistemaTurnos;
    private ArrayList<Jugador> listaJugadores;
    private Queue<Tarjeta> mazoDeTarjetas;

    private static Juego instancia = new Juego();
    private ArrayList<Mision> misiones;

    private Juego() {
        this.colores = new LinkedList<>();
        this.colores.add(colorAzul);
        this.colores.add(colorRojo);
        this.colores.add(colorAmarillo);
        this.colores.add(colorVerde);
        this.colores.add(colorRosa);
        this.colores.add(colorNegro);
    }

    public static Juego getInstancia() {
        return instancia;
    }

    public void setearCantidadJugadores(Integer numeroJugadores) {
        if (numeroJugadores < numeroMinimoDeJugadores || numeroJugadores > numeroMaximoDeJugadores) {
            throw new NumeroDeJugadoresInvalidoException();
        }
        this.listaJugadores = new ArrayList<>();
        for (int i = 0; i < numeroJugadores; i++) {
            String color = colores.remove();
            colores.add(color);
            listaJugadores.add(new Jugador(color));
        }
    }

    /* esta funcion seria un setting que permite modificar la cantidad de rondas iniciales y los refuerzos disponibles en cada una de ellas
    ya que no era un requerimiento de la consigna, simplemente la hardcodeamos con {5, 3}, pero podria recibir por parametros el numero
    de rondas y la cantidad en cada una de ellas.
    */
    private Queue<Integer> setearRondasIniciales() {
        Queue<Integer> colaDeNumerosDeRefuerzoPorRonda = new LinkedList<>();
        colaDeNumerosDeRefuerzoPorRonda.add(ejercitosPrimeraRondaInicial);
        colaDeNumerosDeRefuerzoPorRonda.add(ejercitosSegundaRondaInicial);
        return colaDeNumerosDeRefuerzoPorRonda;
    }

    public SistemaDeTurnos iniciarJuego() {
        if (listaJugadores == null)
            throw new NumeroDeJugadoresNoAsignadoException();

        ParserTEG parser = new ParserTEG();
        ArrayList aux = parser.parsearTablero(rutaJsonFronteras, rutaJsonTarjetas);
        Hashtable<String, Hashtable<String, ArrayList<String>>> diccionarioPaisesParseados = (Hashtable<String, Hashtable<String, ArrayList<String>>>) aux.get(0);
        ArrayList<ArrayList<String>> listaTarjetasParseadas = (ArrayList<ArrayList<String>>) aux.get(1);
        InicializadorDeDatos inicializador = new InicializadorDeDatos();
        ArrayList<ArrayList> aux2 = inicializador.inicializarContinentesYPaises(diccionarioPaisesParseados, listaJugadores);
        ArrayList<Pais> listaPaises = aux2.get(0);
        ArrayList<Continente> listaContinente = aux2.get(1);
        this.tablero = new Tablero(listaPaises, listaContinente);
        ArrayList<Tarjeta> listaTarjetas = inicializador.inicializarTarjetas(listaTarjetasParseadas, listaPaises);
        this.mazoDeTarjetas = this.convertirListaDeTarjetasACola(listaTarjetas);
        
        Hashtable<String, ArrayList> diccMisionesParseadas = parser.parsearMisiones(rutaJsonMisiones);
        this.misiones = inicializador.inicializarMisiones(diccMisionesParseadas, listaContinente, listaJugadores);
        Random ran = new Random();
        for (int i = 0; i < listaJugadores.size(); i++) {
            Mision mision = this.misiones.remove(ran.nextInt(misiones.size()));
            if (mision instanceof MisionDestruccion) {
                MisionDestruccion misionDestruccion = (MisionDestruccion) mision;
                if (misionDestruccion.getObjetivo() == null) {
                    Integer indexNuevo = i + 1;
                    if (indexNuevo >= listaJugadores.size()) {
                        indexNuevo = 0;
                    }
                    misionDestruccion.setObjetivo(listaJugadores.get(indexNuevo));
                }
            }
            Jugador jugador = listaJugadores.get(i);
            jugador.agregarMision(mision);
            jugador.agregarMision(new MisionComun(jugador, this, numeroJugadorMisionComun));
        }

        SistemaDeTurnos sistemaDeTurnos = new SistemaDeTurnos(listaJugadores, this, this.setearRondasIniciales());
        return sistemaDeTurnos;
    }

    private Queue<Tarjeta> convertirListaDeTarjetasACola(ArrayList<Tarjeta> tarjetas) {
        Queue<Tarjeta> colaTarjetas = new LinkedList<>();
        for (Tarjeta tarjeta: tarjetas) {
            colaTarjetas.add(tarjeta);
        }
        return colaTarjetas;
    }

    public Pais seleccionarPais(String nombrePais) {
        return this.tablero.seleccionarPais(nombrePais);
    }

    public Integer calcularEjercitosDisponibles(Jugador jugador) {
        return this.tablero.calcularEjercitosDisponibles(jugador);
    }

    public Integer paisesConquistadosPorEn(Jugador jugador, String nombreContinente) {
        return this.tablero.paisesConquistadosPorEn(jugador, nombreContinente);
    }

    public Integer obtenerCantidadPaisesSegunJugador(Jugador jugador) {
        return this.tablero.obtenerCantidadPaisesSegunJugador(jugador);
    }

    public void devolverTarjetas(ArrayList<Tarjeta> tarjetasACanjear) {
        mazoDeTarjetas.addAll(tarjetasACanjear);
    }

    public void darTarjeta(Jugador jugador) {
        jugador.agregarTarjeta(mazoDeTarjetas.remove());
    }

}

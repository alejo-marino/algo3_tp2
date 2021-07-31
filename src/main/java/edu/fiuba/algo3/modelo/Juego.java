package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.NumeroDeJugadoresInvalidoException;
import edu.fiuba.algo3.modelo.excepciones.NumeroDeJugadoresNoAsignadoException;

import java.util.*;

import static edu.fiuba.algo3.modelo.Constantes.*;


public class Juego {

    private final Queue<String> colores;

    private Tablero tablero;
    private ArrayList<Jugador> listaJugadores;
    private MazoDeTarjetas mazoDeTarjetas;

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

    public void setearJugadores(ArrayList<String> nombreJugadores) {
        int numeroJugadores = nombreJugadores.size();
        if (numeroJugadores < numeroMinimoDeJugadores || numeroJugadores > numeroMaximoDeJugadores) {
            throw new NumeroDeJugadoresInvalidoException();
        }
        this.listaJugadores = new ArrayList<>();
        for (String nombreJugador: nombreJugadores) {
            String color = colores.remove();
            colores.add(color);
            listaJugadores.add(new Jugador(color, nombreJugador));
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
        if (listaJugadores == null) {
            throw new NumeroDeJugadoresNoAsignadoException();
        }
        InicializadorDeDatos inicializador = new InicializadorDeDatos();
        Map<String, ArrayList> datosInicializados = inicializador.inicializarDatos(listaJugadores);
        ArrayList<Pais> listaPaisesSinAsignar = datosInicializados.get("Paises");
        ArrayList<Continente> listaContinentes = datosInicializados.get("Continentes");
        ArrayList<Tarjeta> listaTarjetas = datosInicializados.get("Tarjetas");
        this.misiones = datosInicializados.get("Misiones");
        this.darPaises(listaPaisesSinAsignar);
        this.tablero = new Tablero(listaPaisesSinAsignar, listaContinentes);
        mazoDeTarjetas = new MazoDeTarjetas(listaTarjetas);



        this.darMisiones();

        return new SistemaDeTurnos(listaJugadores, this, this.setearRondasIniciales());
    }

    private void darPaises(ArrayList<Pais> paisesSinAsignar) {
        Queue<Jugador> colaJugadores = new LinkedList<>(listaJugadores);
        for (Pais paisSinAsignar: paisesSinAsignar) {
            Jugador jugador = colaJugadores.remove();
            paisSinAsignar.asignarDuenio(jugador);
            colaJugadores.add(jugador);
        }
    }

    private void darMisiones() {
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

    public Integer canjearTarjetas(ArrayList<String> tarjetasACanjear, Jugador duenio) {
        return mazoDeTarjetas.canjearTarjetas(tarjetasACanjear, duenio);
    }

    public void darTarjeta(Jugador jugador) {
        this.mazoDeTarjetas.darTarjeta(jugador);
    }

    public void activarTarjeta(String nombreTarjeta) {
        this.mazoDeTarjetas.activarTarjeta(nombreTarjeta);
    }

    public ArrayList<String> obtenerNombreTarjetasDe(Jugador jugador) {
        return this.mazoDeTarjetas.obtenerNombreTarjetasDe(jugador);
    }

    // TODO: método para tests
    public ArrayList<Jugador> obtenerJugadores() {
        return this.listaJugadores;
    }
}

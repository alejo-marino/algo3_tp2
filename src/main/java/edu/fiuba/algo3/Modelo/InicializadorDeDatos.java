package edu.fiuba.algo3.Modelo;

import java.util.ArrayList;
import java.util.Hashtable;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Pais;
import edu.fiuba.algo3.modelo.Continente;

public class InicializadorDeDatos {
    /*
    Juego, a la hora de juego.inicializarJuego(), llamara primero a ParserTEG con los archivos .json, y los datos que
    devuelva ParserTEG, lo recibira esta clase, creara los objetos pertenecientes al juego con dichos datos para que
    Juego pueda inicializar Tablero con los correspondientes Objetos.
    */

    /* Comente esta funcion porque creo que es mas conveniente que juego llame a cada una de las funciones individualmente
    (no puedo retornar la listaCartas y diccionarioPaises ambas desde la misma funcion a no ser que me ponga a crear una lista)
    public void inicializarDatos(Hashtable<String, String[]> diccPaises, Hashtable<String, ArrayList> diccContinentes, ArrayList<ArrayList> listaCartas) {
        inicializarContinentesYPaises(diccPaises, diccContinentes);
        inicializarCartas(listaCartas);
    }*/

    /* falta implementar en esta funcion el algoritmo que reparta los paises equitativamente dependiendo de la cantidad de Jugadores
    la primera pasada de inicializarContinentesYPaises va a crear solo los paises y meterlos a cada uno en su continente
    correspondiente, luego a esa lista de paises, le aplicare el algoritmos de distribucion equitativa de paises entre jugadores,
    en la segunda pasada, cuando ya todos los paises conozcan a su duenio, recien ahi podre asignar a cada pais los limitrofes que les correspondan.
     */
    public ArrayList inicializarContinentesYPaises(Hashtable<String, Hashtable<String, ArrayList<String>>> diccContinentes, ArrayList<Jugador> listaJugadores) {
        ArrayList<Continente> listaContinentes = new ArrayList<Continente>();
        ArrayList<Pais> listaPaises = new ArrayList<Pais>();
        diccContinentes.forEach((nombreContinente, diccionarioPaisesEnContinente) -> {
            Continente continente = new Continente("nombreContinente");
            listaContinentes.add(continente);
            diccionarioPaisesEnContinente.forEach((nombrePais, listaPaisesLimitrofes) -> {
                Pais pais = new Pais(nombrePais, nombreJugador); // este nombreJugador es un placeholder para cuando tengamos el algoritmo de distribucion de paises seria bueno inicializar con un jugador NULL y luego de la primera pasada pisar el duenio del paiscon el que corresponda
                listaPaises.add(pais);
                continente.agregarPais(pais);
            });
        });

        // algoritmoDeDistribucionDePaises(listaPaises)

        // segunda pasada: agrego limitrofes
        diccContinentes.forEach((nombreContinente, diccionarioPaisesEnContinente) -> {
            diccionarioPaisesEnContinente.forEach((nombrePais, listaPaisesLimitrofes) -> {
                listaPaisesLimitrofes.forEach((paisLimitrofe) -> {
                    for (int i = 0; i < listaPaises.size(); i++) {
                        Pais paisACheckearSiEsLimitrofe = listaPaises.get(i);
                        if ((paisACheckearSiEsLimitrofe.nombre).equals(paisLimitrofe)) {
                            paisACheckearSiEsLimitrofe.hacerLimitrofe();
                        }
                    }
                });
            });
        });

        ArrayList listaADevolver = new ArrayList();
        listaADevolver.add(listaContinentes);
        listaADevolver.add(listaPaises);
        return listaADevolver;
    }

    public ArrayList<Carta> inicializarCartas(ArrayList<ArrayList<String>> listaCartas) {

    }
}

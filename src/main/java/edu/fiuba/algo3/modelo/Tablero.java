package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.AtaqueConPaisAjenoException;
import edu.fiuba.algo3.modelo.excepciones.PaisInexistenteException;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;


public class Tablero {

    private ArrayList<Pais> paises;

    public Tablero(ArrayList<Pais> paises) {
        this.paises = paises;
    }

    public Pais seleccionarPais(String nombrePais) {
        for (Pais pais: paises) {
            if(pais.toString().equals(nombrePais))
                return pais;
        }
        throw new PaisInexistenteException(nombrePais + " no se encuentra en el tablero.");
    }

//    public void atacarConA(Pais atacante, Pais defensor) {
//        Combate combate = new Combate(atacante, defensor);
//        combate.combatir(cantidadEjercitos);
//    }
//
//    public void atacarConAPredeterminado(Pais atacante, Pais defensor, ArrayList tiradaAtacante, ArrayList tiradaDefensor) {
//        Combate combate = new Combate(atacante, defensor);
//        combate.combatePredeterminado(tiradaAtacante, tiradaDefensor);
//    }
//
//    public void reforzar(Pais pais, int cantDeEjercitosAReforzar) {
//        pais.reforzar(cantDeEjercitosAReforzar);
//    }
//
//    public void reforzarPredeterminado(Pais pais, int ejercitos){
//        pais.reforzar(ejercitos);
//    }
}

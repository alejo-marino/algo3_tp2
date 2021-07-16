package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.AtaqueConPaisAjenoException;
import edu.fiuba.algo3.modelo.excepciones.PaisInexistenteException;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;


public class Tablero {
    /*
    private ArrayList<Pais> paises;

    public Tablero(ArrayList<Pais> paises) {
        this.paises = paises;
    }

    public Pais seleccionarPaisPropio(Jugador jugador, String nombrePais) {
        Pais paisPropio = null;
        for (Pais pais: paises) {
            if(pais.toString().equals(nombrePais))
                 paisPropio = pais;
        }
        if (paisPropio == null) {
            throw new PaisInexistenteException(nombrePais + " no se encuentra en el tablero.");
        }
        paisPropio.verificarDuenio(jugador);
        return paisPropio;
    }

    public Pais seleccionarPaisParaAtacar(Jugador jugador, String nombrePais) {
        Pais paisParaAtacar = null;
        for (Pais pais: paises) {
            if(pais.toString().equals(nombrePais))
                paisPropio = pais;
        }
        if (paisPropio == null) {
            throw new PaisInexistenteException(nombrePais + " no se encuentra en el tablero.");
        }
        paisPropio.verificarDuenio(jugador);
        return paisPropio;
    }

    public void atacarConA(Pais atacante, Pais defensor, int cantEjercitos ) {

        Combate combate = new Combate(atacante, defensor);
        combate.combatir(cantEjercitos);
    }

    public void atacarConAPredeterminado(Jugador jugador, Pais atacante, Pais defensor, int cantEjercitos, ArrayList tiradaAtacante, ArrayList tiradaDefensor) {
        Combate combate = new Combate(atacante, defensor);
        combate.combatePredeterminado(tiradaAtacante, tiradaDefensor);
    }

    public void reforzar(Jugador jugador) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pais a reforzar: ");
        Pais pais = this.seleccionarPais(scanner.nextLine());
        System.out.println("Con ejercitos: ");
        int ejercitos = scanner.nextInt();
        pais.reforzar(jugador, ejercitos);
    }

    public void reforzarPredeterminado(Jugador jugador, String nombrePais, int ejercitos){
        Pais pais = this.seleccionarPais(nombrePais);
        pais.reforzar(jugador,ejercitos);
    }
}

package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.AtaqueConPaisAjenoException;
import edu.fiuba.algo3.modelo.excepciones.PaisInexistenteException;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;

public class Tablero {

    private ArrayList<Pais> paises;

    public Tablero(ArrayList<Pais> paises) {
        this.paises = paises;
    }

    public Pais seleccionarPais(String nombrePais) {
        Pais pais;
        for (int i = 0; i < this.paises.size(); i++) {
            pais = this.paises.get(i);
            if(pais.toString().equals(nombrePais))
                return pais;
        }
        throw new PaisInexistenteException(nombrePais + " no se encuentra en el tablero.");
    }

    public void atacarConA(Jugador jugador) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pais atacante: ");
        String nombrePaisAtacante = scanner.nextLine();
        Pais atacante = this.seleccionarPais(nombrePaisAtacante);
        System.out.println("Pais defensor: ");
        String nombrePaisDefensor = scanner.nextLine();
        Pais defensor = this.seleccionarPais(nombrePaisDefensor);
        if(atacante.getPaisOcupadoPor()  != jugador){
            throw new AtaqueConPaisAjenoException("Este país no te pertenece");
        }
        Combate combate = new Combate(atacante, defensor);
        combate.combatir();
    }

    public void atacarConAPredeterminado(Jugador jugador, String nombrePaisAtacante, String nombrePaisDefensor, ArrayList tiradaAtacante, ArrayList tiradaDefensor) {
        Pais atacante = this.seleccionarPais(nombrePaisAtacante);
        Pais defensor = this.seleccionarPais(nombrePaisDefensor);
        if (atacante.getPaisOcupadoPor() != jugador) {
            throw new AtaqueConPaisAjenoException("Este país no te pertenece");
        }
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

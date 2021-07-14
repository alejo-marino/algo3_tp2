package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import edu.fiuba.algo3.modelo.excepciones.*;



public class Combate {
    private Pais atacante;
    private Pais defensor;
    private Tirada tirada;

    public Combate(Pais paisAtacante, Pais paisDefensor){
        this.atacante = paisAtacante;
        this.defensor = paisDefensor;
        this.tirada = new Tirada(this);
    }
    //Ssi es así,
    // dos tiradas de dados, el algoritmo que calcule cuántos ejércitos pierde cada uno dependiendo de las tiradas, remover ejércitos, preguntar si ahora es
    // conquistable el país defensor
    public void combatir() {

        int cantEjercitosAtacante = this.atacante.getEjercitosParaAtacar();
        int cantEjercitosDefensor = this.defensor.getEjercitos();

        tirada.tirar(cantEjercitosAtacante, cantEjercitosDefensor);
        defensor.serConquistadoPor(atacante);
    }

    public void combatePredeterminado( ArrayList tiradaAtacante, ArrayList tiradaDefensor) {
        tirada.tirarPredeterminado(tiradaAtacante, tiradaDefensor);
        defensor.serConquistadoPor(atacante);
    }

    public void modificarEjercitosAtacante(int tropasPerdidas) {
        atacante.disminuirEjercitos(tropasPerdidas);
    }

    public void modificarEjercitosDefensor(int tropasPerdidas) {
        defensor.disminuirEjercitos(tropasPerdidas);
    }
}

package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import edu.fiuba.algo3.modelo.excepciones.*;



public class Combate {
    private final Pais atacante;
    private final Pais defensor;

    public Combate(Pais paisAtacante, Pais paisDefensor){
        this.atacante = paisAtacante;
        this.defensor = paisDefensor;
    }
    //Ssi es así,
    // dos tiradas de dados, el algoritmo que calcule cuántos ejércitos pierde cada uno dependiendo de las tiradas, remover ejércitos, preguntar si ahora es
    // conquistable el país defensor
    public void combatir() {

        int cantEjercitosAtacante = this.atacante.getEjercitosParaAtacar();
        int cantEjercitosDefensor = this.defensor.getEjercitos();

        DadosDeSeisCaras dados = new DadosDeSeisCaras();
        ArrayList<Integer> tiradaAtacante = dados.tirarDados(cantEjercitosAtacante);
        ArrayList<Integer> tiradaDefensor = dados.tirarDados(cantEjercitosDefensor);

        determinarGanador(tiradaAtacante, tiradaDefensor);
    }

    public void combatePredeterminado( ArrayList<Integer> tiradaAtacante, ArrayList<Integer> tiradaDefensor) {
        determinarGanador(tiradaAtacante, tiradaDefensor);

    }
}

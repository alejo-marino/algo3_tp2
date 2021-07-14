package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import edu.fiuba.algo3.modelo.excepciones.*;



public class Combate {
    private Pais atacante;
    private Pais defensor;

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
        ArrayList tiradaAtacante = dados.tirarDados(cantEjercitosAtacante);
        ArrayList tiradaDefensor = dados.tirarDados(cantEjercitosDefensor);

        int encuentros = Math.min(tiradaAtacante.size(), tiradaDefensor.size());
        int ganaAtacante = 0;
        int ganaDefensor = 0;
        for (int i = 0; i < encuentros; i++) {
            if ((int) tiradaAtacante.get(i) < (int) tiradaDefensor.get(i)) {
                ganaAtacante++;
            } else {
                ganaDefensor++;
            }
        }

        this.atacante.disminuirEjercitos(ganaDefensor);
        this.defensor.disminuirEjercitos(ganaAtacante);
        defensor.serConquistadoPor(atacante);
    }

    public void combatePredeterminado( ArrayList tiradaAtacante, ArrayList tiradaDefensor) {
        int encuentros = Math.min((tiradaAtacante.size()), (tiradaDefensor.size()));
        int ganaAtacante = 0;
        int ganaDefensor = 0;
        for (int i = 0; i < encuentros; i++) {
            if ( (int) tiradaDefensor.get(i) < (int) tiradaAtacante.get(i)){
                ganaAtacante++;
            }
            else{
                ganaDefensor++;
            }
        }
        this.atacante.disminuirEjercitos(ganaDefensor);
        this.defensor.disminuirEjercitos(ganaAtacante);
        defensor.serConquistadoPor(atacante);
    }
}

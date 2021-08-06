package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
//import edu.fiuba.algo3.modelo.excepciones.*;



public class Combate {
    private final Pais atacante;
    private final Pais defensor;
    private final Integer cantEjercitosAtacantes;

    public Combate(Pais paisAtacante, Pais paisDefensor, Integer cantEjercitosAtacantes){
        this.atacante = paisAtacante;
        this.defensor = paisDefensor;
        this.cantEjercitosAtacantes = cantEjercitosAtacantes;
    }
    //Ssi es así,
    // dos tiradas de dados, el algoritmo que calcule cuántos ejércitos pierde cada uno dependiendo de las tiradas, remover ejércitos, preguntar si ahora es
    // conquistable el país defensor
    public void combatir() {

        int cantEjercitosDefensores = this.defensor.getEjercitosParaDefender();

        ArrayList<Integer> tiradaAtacante = obtenerTirada(cantEjercitosAtacantes);
        ArrayList<Integer> tiradaDefensor = obtenerTirada(cantEjercitosDefensores);

        determinarGanador(tiradaAtacante, tiradaDefensor);
    }

    private ArrayList<Integer> obtenerTirada (Integer cantidadDados) {
        DadosDeSeisCaras dados = new DadosDeSeisCaras();
        return dados.tirarDados(cantidadDados);
    }

    public void combatePredeterminado( ArrayList<Integer> tiradaAtacante, ArrayList<Integer> tiradaDefensor) {
        determinarGanador(tiradaAtacante, tiradaDefensor);

    }

    private void determinarGanador(ArrayList<Integer> tiradaAtacante, ArrayList<Integer> tiradaDefensor) {
        int encuentros = Math.min((tiradaAtacante.size()), (tiradaDefensor.size()));
        int ganaAtacante = 0;
        int ganaDefensor = 0;

        for (int i = 0; i < encuentros; i++) {
            if ( ganadorTirada( tiradaDefensor.get(i), tiradaAtacante.get(i))){
                ganaAtacante++;
            }
            else{
                ganaDefensor++;
            }
        }
        this.atacante.disminuirEjercitos(ganaDefensor);
        this.defensor.disminuirEjercitos(ganaAtacante);
        if (!defensor.tengoEjercitos()) {
            atacante.conquistar(defensor);
        }

    }

    private boolean ganadorTirada(int tiradaDefensor, int tiradaAtacante) {
        return tiradaDefensor < tiradaAtacante;
    }
}

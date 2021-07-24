package edu.fiuba.algo3.modelo;

import java.util.Queue;

public class FaseInicial extends Fase {

    public FaseInicial(Queue<Integer> colaDeNumerosDeRefuerzoPorRonda, Juego juego) {
        super(new RondaInicial(colaDeNumerosDeRefuerzoPorRonda, juego));   // {5, 3}
    }

    public Fase siguienteRonda() {
        RondaInicial rondaInicial = (RondaInicial) super.getRonda();
        if (rondaInicial.puedeContinuar()) {
            rondaInicial.siguienteRonda();
            return this;
        }

        return new FaseDeJuego(rondaInicial.pedirJuego());
    }

    @Override
    public String getFaseActual(){
        return "Fase inicial";
    }

    public String getRondaActual() {
        RondaInicial rondaInicial = (RondaInicial) super.getRonda();
        return rondaInicial.getRondaActual();
    }

}

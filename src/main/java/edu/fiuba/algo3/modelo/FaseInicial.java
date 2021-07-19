package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.NoPuedeColocarTantosEjercitosException;
import edu.fiuba.algo3.modelo.excepciones.NoReforzoTodosLosEjercitosException;

import java.util.NoSuchElementException;
import java.util.Queue;

public class FaseInicial implements Fase {

    RondaInicial rondaInicial;
    Tablero tablero;
    Integer ejercitosAColocar;

    public FaseInicial(Queue<Integer> colaDeNumerosDeRefuerzoPorRonda, Tablero referenciaTablero) {   // {5, 3}
        this.rondaInicial = new RondaInicial(colaDeNumerosDeRefuerzoPorRonda);
        this.tablero = referenciaTablero;
        this.ejercitosAColocar = rondaInicial.cantidadRefuerzo();
    }




    public Fase siguienteRonda() {
        if (this.rondaInicial.puedeContinuar()) {
            rondaInicial.siguienteRonda();
            this.ejercitosAColocar = ejercitosAColocar();
            return this;
        }

        return new FaseDeJuego();
    }


    public Integer ejercitosAColocar() {
        return rondaInicial.cantidadRefuerzo();
    }

    @Override
    public String getFaseActual(){
        return "Fase inicial";
    }

    public void siguienteTurno(){
        if (this.ejercitosAColocar > 0) {
            throw new NoReforzoTodosLosEjercitosException();
        }
        ejercitosAColocar = rondaInicial.cantidadRefuerzo();
    }


    public String getRondaActual() {
        return rondaInicial.getRondaActual();
    }

    public void reforzar(Pais pais, int cantidadEjercitos) {
        if (this.ejercitosAColocar < cantidadEjercitos) {
            throw new NoPuedeColocarTantosEjercitosException("Solo disponde de " + ejercitosAColocar + " fichas.");
        }
        this.ejercitosAColocar -= cantidadEjercitos;
        pais.reforzar(cantidadEjercitos);
    }
    // this.fase = fase.siguiente();
}

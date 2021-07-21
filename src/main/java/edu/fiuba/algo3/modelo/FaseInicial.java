package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Queue;

public class FaseInicial implements Fase {

    RondaInicial rondaInicial;


    public FaseInicial(Queue<Integer> colaDeNumerosDeRefuerzoPorRonda, Tablero referenciaTablero) {   // {5, 3}
        this.rondaInicial = new RondaInicial(colaDeNumerosDeRefuerzoPorRonda, referenciaTablero);
    }

    public Fase siguienteRonda() {
        if (this.rondaInicial.puedeContinuar()) {
            rondaInicial.siguienteRonda();
            return this;
        }

        return new FaseDeJuego(rondaInicial.pedirTablero());
    }



    @Override
    public String getFaseActual(){
        return "Fase inicial";
    }

    public void empezarTurno(Jugador jugador) {
        this.rondaInicial.empezarTurno(jugador);
    }


    public String getRondaActual() {
        return rondaInicial.getRondaActual();
    }

    @Override
    public void reforzar(int cantidadEjercitos) {
        this.rondaInicial.reforzar( cantidadEjercitos);
    }

    @Override
    public Pais seleccionarPais(String nombrePais, Jugador jugador) {
        return rondaInicial.seleccionarPais(nombrePais, jugador);
    }

    @Override
    public void atacar( int cantidadEjercitos) {
        rondaInicial.atacar(cantidadEjercitos);
    }

    @Override
    public void reagrupar(int cantidadEjercitos) {
        rondaInicial.reagrupar( cantidadEjercitos);
    }

    @Override
    public void canjearTarjetas(ArrayList<Tarjeta> tarjetasACanjear) {
        rondaInicial.canjearTarjetas(tarjetasACanjear);
    }
}

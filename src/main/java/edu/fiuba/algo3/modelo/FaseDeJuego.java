package edu.fiuba.algo3.modelo;

public class FaseDeJuego extends Fase {

    public FaseDeJuego (Juego juego) {
        super(new RondaDeAtaqueYReagrupe(juego));
    }

    @Override
    public Fase siguienteRonda() {
        Ronda ronda = super.getRonda();
        ronda = ronda.siguienteRonda();
        super.setRonda(ronda);
        return this;
    }

    @Override
    public String getFaseActual() {
        return "Fase de juego";
    }

}

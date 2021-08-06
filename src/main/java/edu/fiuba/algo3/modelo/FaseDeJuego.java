package edu.fiuba.algo3.modelo;

public class FaseDeJuego extends Fase {

    public FaseDeJuego (Juego juego) {
        super(new RondaDeAtaqueYReagrupe(juego));
    }

    @Override
    public void siguienteRonda() {
        Ronda ronda = super.getRonda();
        ronda = ronda.siguienteRonda();
        super.setRonda(ronda);
    }

    @Override
    public String getNombreDeFaseActual() {
        return "Fase de juego";
    }

}

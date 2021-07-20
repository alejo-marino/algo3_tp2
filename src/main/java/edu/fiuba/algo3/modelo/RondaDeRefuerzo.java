package edu.fiuba.algo3.modelo;

public class RondaDeRefuerzo implements TipoDeRonda {

    private final Tablero tablero;

    public RondaDeRefuerzo(Tablero tablero) {
        this.tablero = tablero;
    }

    @Override
    public void atacar(int cantidadEjercitos) {}

    @Override
    public void reagrupar(int cantidadEjercitos) {}

    @Override
    public void reforzar(Integer ejercitosAReforzar) { }

    @Override
    public Pais seleccionarPais(String nombrePais, Jugador jugador)  {
        return null;
    }

    @Override
    public void cancelarAccion() {}

    @Override
    public TipoDeRonda siguienteRonda() {
        return null;
    }

    @Override
    public void siguienteTurno() {}
}

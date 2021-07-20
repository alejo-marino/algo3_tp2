package edu.fiuba.algo3.modelo;

public class RondaDeRefuerzo implements TipoDeRonda {

    private final Tablero tablero;
    private final EstadoTurno estadoturno;

    public RondaDeRefuerzo(Tablero tablero) {
        this.tablero = tablero;
        estadoturno = new TurnoRefuerzo(tablero);
    }

    @Override
    public void atacar(int cantidadEjercitos) {this.estadoturno.atacar(cantidadEjercitos);}

    @Override
    public void reagrupar(int cantidadEjercitos) {this.estadoturno.reforzar(cantidadEjercitos);}

    @Override
    public void reforzar(Integer ejercitosAReforzar) {this.estadoturno.reforzar(ejercitosAReforzar); }

    @Override
    public Pais seleccionarPais(String nombrePais, Jugador jugador)  {
        return this.estadoturno.seleccionarPais(nombrePais,jugador);
    }

    @Override
    public void cancelarAccion() {
        this.estadoturno.cancelarAccion();
    }

    @Override
    public TipoDeRonda siguienteRonda() {
        return new RondaDeAtaqueYReagrupe(tablero);
    }

    @Override
    public void siguienteTurno(){

        estadoturno.cambiarEstado();
    }
}

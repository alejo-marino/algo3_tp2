package edu.fiuba.algo3.modelo;

public interface EstadoTurno {

    public EstadoTurno cambiarEstado();

    public void atacar(int cantidadEjercitosAtacantes);

    public Pais seleccionarPais(String nombrePais, Jugador jugador);

    public void cancelarAccion();

    public void reagrupar(int cantidadEjercitos);

    public void reforzar(int cantidadEjercitosAReforzar);
}

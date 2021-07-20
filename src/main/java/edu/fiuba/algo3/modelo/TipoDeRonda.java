package edu.fiuba.algo3.modelo;

public interface TipoDeRonda {

    public void atacar(int cantidadEjercitos);

    public void reagrupar(int cantidadEjercitos);

    public void reforzar(Integer ejercitosAReforzar);

    public Pais seleccionarPais(String nombrePais, Jugador jugador);
}

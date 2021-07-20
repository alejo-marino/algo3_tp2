package edu.fiuba.algo3.modelo;

public class RondaDeRefuerzo implements TipoDeRonda {
    public void atacar(int cantidadEjercitos) {}

    @Override
    public void reagrupar(int cantidadEjercitos) {}

    @Override
    public void reforzar(Integer ejercitosAReforzar) { }

    @Override
    public Pais seleccionarPais(String nombrePais, Jugador jugador)  {
        return null;
    }
}

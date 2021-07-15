package edu.fiuba.algo3.modelo;

public class EjercitoRegular extends Ejercito {

    public EjercitoRegular(int cantidadTropas) {
        super();
        this.cantidadTropas = cantidadTropas;
    }


    @Override
    public int obtenerCantidadTropasAtaque() {
        return cantidadTropas - 1;
    }


}

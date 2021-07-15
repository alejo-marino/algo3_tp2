package edu.fiuba.algo3.modelo.ejercito;

import edu.fiuba.algo3.modelo.ejercito.Ejercito;

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

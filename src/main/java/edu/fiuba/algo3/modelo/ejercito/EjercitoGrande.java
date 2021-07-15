package edu.fiuba.algo3.modelo.ejercito;

import edu.fiuba.algo3.modelo.ejercito.Ejercito;

public class EjercitoGrande extends Ejercito {

    private int NUMERO_MAX_TROPAS = 3;

    public EjercitoGrande(int cantidadTropas) {
        super();
        this.cantidadTropas = cantidadTropas;
    }

    @Override
    public int obtenerCantidadTropasAtaque() {
        return NUMERO_MAX_TROPAS;
    }

    @Override
    public Ejercito agregarTropas(int cantidadTropas) {
        this.cantidadTropas += cantidadTropas;
        return this;
    }
}

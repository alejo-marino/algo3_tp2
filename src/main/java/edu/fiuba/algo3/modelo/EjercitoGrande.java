package edu.fiuba.algo3.modelo;

public class EjercitoGrande extends Ejercito {

    private int NUMERO_MAX_TROPAS = 3;

    public EjercitoGrande(int cantidadTropas) {
        super();
        this.cantidadTropas = cantidadTropas;
    }

    @Override
    public int obtenerCantidadTropas() {
        return NUMERO_MAX_TROPAS;
    }

    @Override
    public Ejercito agregarTropas(int cantidadTropas) {
        this.cantidadTropas += cantidadTropas;
        return this;
    }

    @Override
    public Ejercito reduccirTropas(int cantidadTropas) {
        this.cantidadTropas -= cantidadTropas;
        if (this.cantidadTropas <= 1) {
            return new EjercitoUnitario();
        }
        else if (this.cantidadTropas < 4) {
            return new EjercitoRegular(this.cantidadTropas);
        }
        return this;
    }
}

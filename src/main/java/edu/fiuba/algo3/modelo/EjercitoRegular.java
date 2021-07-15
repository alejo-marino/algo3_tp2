package edu.fiuba.algo3.modelo;

public class EjercitoRegular extends Ejercito {

    public EjercitoRegular(int cantidadTropas) {
        super();
        this.cantidadTropas = cantidadTropas;
    }


    @Override
    public int obtenerCantidadTropas() {
        return cantidadTropas - 1;
    }

    @Override
    public Ejercito agregarTropas(int cantidadTropas) {
        this.cantidadTropas += cantidadTropas;
        if (this.tieneCuatroOMasTropas(this.cantidadTropas)) {
            return new EjercitoGrande(this.cantidadTropas);
        }
        return this;
    }

    @Override
    public Ejercito reduccirTropas(int cantidadTropas) {
        this.cantidadTropas -= cantidadTropas;
        if (this.cantidadTropas <= 1) {
            return new EjercitoUnitario();
        }
        return this;
    }
}

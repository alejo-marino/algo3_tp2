package edu.fiuba.algo3.modelo;

public abstract class Ejercito {
    int cantidadTropas;

    public  int getCantidadTropas(){
        return cantidadTropas;
    }

    public abstract int obtenerCantidadTropasAtaque();

    public  Ejercito agregarTropas(int cantidadTropas) {
        this.cantidadTropas += cantidadTropas;
        if (this.cantidadTropas >= 4) {
            return new EjercitoGrande(this.cantidadTropas);
        }
        else if (this.cantidadTropas > 1) {
            return new EjercitoRegular(this.cantidadTropas);
        }
        return new EjercitoUnitario();
    }

    public boolean tieneCuatroOMasTropas(int cantidadTropas) {
        return cantidadTropas >= 4;
    };

    public boolean tengoTropas() {return true;}

    public Ejercito reduccirTropas(int cantidadTropas){
        this.cantidadTropas -= cantidadTropas;
        if (this.cantidadTropas == 1) {
            return new EjercitoUnitario();
        }
        else if (this.cantidadTropas < 1) {
            return new EjercitoNulo();
        }
        else if (this.cantidadTropas < 4) {
            return new EjercitoRegular(this.cantidadTropas);
        }
        return new EjercitoGrande(this.cantidadTropas);
    }
}

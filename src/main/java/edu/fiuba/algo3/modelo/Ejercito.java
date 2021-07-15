package edu.fiuba.algo3.modelo;

public abstract class Ejercito {
    int cantidadTropas;

    public  int getCantidadTropas(){
        return cantidadTropas;
    }
    public abstract int obtenerCantidadTropas();

    public abstract Ejercito agregarTropas(int cantidadTropas);

    public boolean tieneCuatroOMasTropas(int cantidadTropas) {
        return cantidadTropas >= 4;
    };

    public boolean tengoTropas() {return true;};

    public abstract Ejercito reduccirTropas(int cantidadTropas);
}

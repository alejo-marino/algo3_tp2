package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.EjercitosInsuficientesException;

public class EjercitoUnitario extends Ejercito {

    public EjercitoUnitario(){
        this.cantidadTropas = 1;
    }

    @Override
    public int obtenerCantidadTropas() {
        throw new EjercitosInsuficientesException("No hay suficientes ejércitos para atacar");
    }

    @Override
    public Ejercito agregarTropas(int cantidadTropas) {
        this.cantidadTropas += cantidadTropas;
        if (this.tieneCuatroOMasTropas(this.cantidadTropas)) {
            return new EjercitoGrande(this.cantidadTropas);
        }
        System.out.println("fef");
        return new EjercitoRegular(this.cantidadTropas);
    }

    @Override
    public Ejercito reduccirTropas(int cantidadTropas) {
        return this;
    }
}

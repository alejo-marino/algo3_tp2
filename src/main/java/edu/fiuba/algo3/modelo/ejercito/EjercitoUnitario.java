package edu.fiuba.algo3.modelo.ejercito;

import edu.fiuba.algo3.modelo.ejercito.Ejercito;
import edu.fiuba.algo3.modelo.excepciones.EjercitosInsuficientesException;

public class EjercitoUnitario extends Ejercito {

    public EjercitoUnitario(){
        this.cantidadTropas = 1;
    }

    @Override
    public int obtenerCantidadTropasAtaque() {
        throw new EjercitosInsuficientesException("No hay suficientes ejércitos para atacar");
    }


}

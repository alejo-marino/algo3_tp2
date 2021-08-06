package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.modelo.SistemaDeTurnos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;

import java.util.Observable;
import java.util.Observer;

public class BotonCancelarAccion implements Observer {

    private final Button botonAtacar;
    private final SistemaDeTurnos sistema;

    public BotonCancelarAccion(Button botonCancelar, SistemaDeTurnos sistema) {
        this.botonAtacar = botonCancelar;
        this.sistema = sistema;
    }

    @Override
    public void update(Observable o, Object arg) {
        if (sistema.puedoCancelar()) {
            botonAtacar.setDisable(false);
        } else {
            botonAtacar.setDisable(true);
        }
    }

}

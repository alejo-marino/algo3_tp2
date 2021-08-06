package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.modelo.SistemaDeTurnos;
import javafx.scene.control.Button;

import java.util.Observable;
import java.util.Observer;

public class BotonSiguienteTurno implements Observer {

    private final Button botonSiguienteTurno;
    private final SistemaDeTurnos sistema;

    public BotonSiguienteTurno(Button botonSiguienteTurno, SistemaDeTurnos sistema) {
        this.botonSiguienteTurno = botonSiguienteTurno;
        this.sistema = sistema;
    }

    @Override
    public void update(Observable o, Object arg) {
        if (sistema.puedoPasarDeTurno()) {
            botonSiguienteTurno.setDisable(false);
        } else {
            botonSiguienteTurno.setDisable(true);
        }
    }

}

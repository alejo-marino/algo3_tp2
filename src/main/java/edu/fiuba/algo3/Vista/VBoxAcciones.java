package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.modelo.SistemaDeTurnos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.util.Observable;
import java.util.Observer;

public class VBoxAcciones implements Observer {

    private final VBox vBoxAcciones;
    private final SistemaDeTurnos sistema;

    public VBoxAcciones(VBox vBoxAcciones, SistemaDeTurnos sistema) {
        this.vBoxAcciones = vBoxAcciones;
        this.sistema = sistema;
    }

    @Override
    public void update(Observable o, Object arg) {
        String color = sistema.getColorTurnoActual();
        vBoxAcciones.setStyle("-fx-background-color:" + color +"; ");
    }

}

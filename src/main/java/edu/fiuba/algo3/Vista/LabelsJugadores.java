package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.modelo.SistemaDeTurnos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class LabelsJugadores implements Observer {

    private final ArrayList<Label> labelsJugadores;
    private final SistemaDeTurnos sistema;

    public LabelsJugadores(ArrayList<Label> labelsJugadores, SistemaDeTurnos sistema) {
        this.labelsJugadores = labelsJugadores;
        this.sistema = sistema;
    }

    @Override
    public void update(Observable o, Object arg) {
        for (Label labelJugador: labelsJugadores) {
            labelJugador.setDisable(true);
            labelJugador.setStyle("-fx-font-weight: normal");
            if (sistema.nombreTurnoDe().equals(labelJugador.getText())) {
                labelJugador.setDisable(false);
                labelJugador.setStyle("-fx-font-weight: bold");
            }
        }
    }

}

package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.modelo.SistemaDeTurnos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;

import java.util.Observable;
import java.util.Observer;

public class BotonReagrupe implements Observer {

    private final Button botonReagrupe;
    private final SistemaDeTurnos sistema;
    private final ChoiceBox<Integer> choiceBoxReagrupe;

    public BotonReagrupe(Button botonReagrupe, ChoiceBox<Integer> choiceBoxReagrupe, SistemaDeTurnos sistema) {
        this.botonReagrupe = botonReagrupe;
        this.choiceBoxReagrupe = choiceBoxReagrupe;
        this.sistema = sistema;
    }

    @Override
    public void update(Observable o, Object arg) {
        if (sistema.puedoReagrupar()) {
            botonReagrupe.setDisable(false);
            choiceBoxReagrupe.setDisable(false);
            for (int i = 1; i <= sistema.getEjercitosParaAtacar(); i++) {
                choiceBoxReagrupe.getItems().add(i);
            }
        } else {
            botonReagrupe.setDisable(true);
            choiceBoxReagrupe.setDisable(true);
        }
    }

}

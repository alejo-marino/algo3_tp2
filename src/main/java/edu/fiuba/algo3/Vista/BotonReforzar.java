package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.modelo.SistemaDeTurnos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;

import java.util.Observable;
import java.util.Observer;

public class BotonReforzar implements Observer {

    private final Button botonReforzar;
    private final SistemaDeTurnos sistema;
    private final ChoiceBox<Integer> choiceBoxReforzar;

    public BotonReforzar(Button botonReforzar, ChoiceBox<Integer> choiceBoxReforzar, SistemaDeTurnos sistema) {
        this.botonReforzar = botonReforzar;
        this.choiceBoxReforzar = choiceBoxReforzar;
        this.sistema = sistema;
    }

    @Override
    public void update(Observable o, Object arg) {
        if (sistema.puedoReforzar()) {
            botonReforzar.setDisable(false);
            choiceBoxReforzar.setDisable(false);
            choiceBoxReforzar.getItems().clear();
            for (int i = 1; i <= sistema.getEjercitosParaReforzar(); i++) {
                choiceBoxReforzar.getItems().add(i);
            }
            choiceBoxReforzar.getSelectionModel().selectLast();
        } else {
            botonReforzar.setDisable(true);
            choiceBoxReforzar.setDisable(true);
        }
    }

}

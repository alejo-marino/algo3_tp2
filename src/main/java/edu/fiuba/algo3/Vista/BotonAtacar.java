package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.modelo.SistemaDeTurnos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;

import java.util.Observable;
import java.util.Observer;

public class BotonAtacar implements Observer {

    private final Button botonAtacar;
    private final SistemaDeTurnos sistema;
    private final ChoiceBox<Integer> choiceBoxAtacar;
    private final Button botonTerminarAtaque;

    public BotonAtacar(Button botonAtacar, ChoiceBox<Integer> choiceBoxAtacar, Button botonTerminarAtaque, SistemaDeTurnos sistema) {
        this.botonAtacar = botonAtacar;
        this.botonTerminarAtaque = botonTerminarAtaque;
        this.choiceBoxAtacar = choiceBoxAtacar;
        this.sistema = sistema;
    }

    @Override
    public void update(Observable o, Object arg) {
        if (sistema.puedoAtacar()) {
            botonAtacar.setDisable(false);
            choiceBoxAtacar.setDisable(false);
            choiceBoxAtacar.getItems().clear();
            for (int i = 1; i <= sistema.getEjercitosParaAtacar(); i++) {
                choiceBoxAtacar.getItems().add(i);
            }
            choiceBoxAtacar.getSelectionModel().selectFirst();
        } else {
            botonAtacar.setDisable(true);
            choiceBoxAtacar.setDisable(true);
            this.botonTerminarAtaque.setDisable(true);
        }
        if (sistema.estoyEnTurnoAtaque()) {
            this.botonTerminarAtaque.setDisable(false);
        }

    }

}

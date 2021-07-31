package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.Vista.SeleccionNombreJugadores;
import edu.fiuba.algo3.modelo.Juego;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

import static java.lang.Integer.parseInt;

public class cantidadJugadoresController implements Initializable {

    @FXML
    private ChoiceBox<String> cantidadJugadoresChoiceBox;

    public void handleChoiceBoxCantidaJugadores(MouseEvent mouseEvent) {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cantidadJugadoresChoiceBox.getItems().addAll("2", "3","4","5","6");
    }

    public void handleBotonSiguienteCantJugadores(ActionEvent actionEvent) {
        int cantJugadores = parseInt(cantidadJugadoresChoiceBox.getSelectionModel().getSelectedItem());
        SeleccionNombreJugadores.display(cantJugadores);
    }
}

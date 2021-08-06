package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.Vista.SeleccionCantidadJugadores;
import edu.fiuba.algo3.Vista.SeleccionNombreJugadores;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;

import java.net.URL;
import java.util.ResourceBundle;

import static edu.fiuba.algo3.modelo.Constantes.cantidadJugadoresMaxima;
import static edu.fiuba.algo3.modelo.Constantes.cantidadJugadoresMinima;

public class cantidadJugadoresController implements Initializable {

    @FXML
    private ChoiceBox<Integer> cantidadJugadoresChoiceBox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for (int i = cantidadJugadoresMinima; i <= cantidadJugadoresMaxima; i++) {
            cantidadJugadoresChoiceBox.getItems().add(i);
        }
        cantidadJugadoresChoiceBox.getSelectionModel().selectFirst();
    }

    public void handleBotonSiguienteCantJugadores(ActionEvent actionEvent) {
        int cantJugadores = cantidadJugadoresChoiceBox.getSelectionModel().getSelectedItem();
        SeleccionNombreJugadores.display(cantJugadores);
    }
}

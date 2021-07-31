package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.Vista.ReglasJuego;
import edu.fiuba.algo3.Vista.SeleccionCantidadJugadores;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.event.ActionEvent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;

public class menuController implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void handleBotonEmpezarJuego(ActionEvent event) throws IOException {
        System.out.println("Tocaste el boton comenzar juego");
        SeleccionCantidadJugadores.display();
    }

    public void handleBotonReglas(ActionEvent actionEvent) {
        System.out.println("Tocaste el boton de Reglas");
        ReglasJuego.display("Reglas");
    }

    public void handleBotonSalir(ActionEvent actionEvent) {
        System.out.println("Tocaste el boton de salir");
        System.exit(0);
    }


}

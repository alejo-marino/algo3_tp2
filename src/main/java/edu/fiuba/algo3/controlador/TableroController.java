package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.Vista.Inicio;
import edu.fiuba.algo3.modelo.Juego;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;


import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TableroController implements Initializable {

    public ArrayList<String> nombreJugadores;
    public Label ejercitosCanada;
    private final ArrayList<String> coloresJugadores = new ArrayList<>();

    public VBox infoJugadores;


    public void initialize(URL location, ResourceBundle resources) {
        this.nombreJugadores = Inicio.jugadores;
        coloresJugadores.add("#0077bb");
        coloresJugadores.add("#cc3311");
        coloresJugadores.add("#ee7733");
        coloresJugadores.add("#009988");
        coloresJugadores.add("#ee3377");
        coloresJugadores.add("#000000");
        int contador = 0;
        for (String nombreJugador: this.nombreJugadores) {
            Label label = new Label(nombreJugador);
            label.setTextFill(Color.web(this.coloresJugadores.get(contador)));
            infoJugadores.getChildren().addAll(label);
            contador++;
        }
        int contador2 = 0;
        for (Button boton: Inicio.botonesPaises) {
            boton.setText("hola");
            contador2++;
        }

    }

    public void handleBotonPais(ActionEvent actionEvent) {
        Button botonApretado = (Button) actionEvent.getSource();
        Juego.getInstancia().seleccionarPais(botonApretado.getText());
        System.out.println(botonApretado.getText());
    }
}

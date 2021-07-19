package edu.fiuba.algo3.controlador;

import javafx.fxml.Initializable;
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
    private ArrayList<String> coloresJugadores = new ArrayList<>();

    public VBox infoJugadores;

    public TableroController(ArrayList<String> nombreJugadores) {
        this.nombreJugadores = nombreJugadores;
        coloresJugadores.add("#0077bb");
        coloresJugadores.add("#cc3311");
        coloresJugadores.add("#ee7733");
        coloresJugadores.add("#009988");
        coloresJugadores.add("#ee3377");
        coloresJugadores.add("#000000");

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        int contador = 0;
        for (String nombreJugador: this.nombreJugadores) {
            Label label = new Label(nombreJugador);
            label.setTextFill(Color.web(this.coloresJugadores.get(contador)));
            infoJugadores.getChildren().addAll(label);
            contador++;
        }

    }
}

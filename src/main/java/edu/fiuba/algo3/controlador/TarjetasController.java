package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.SistemaDeTurnos;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TarjetasController {

    public VBox vBoxTarjetas;
    public Button botonCanjear;
    private SistemaDeTurnos sistema;

    public void inicializar(SistemaDeTurnos sistema) {
        this.sistema = sistema;
        ArrayList<String> tarjetas = sistema.obtenerNombreTarjetas();
        if (tarjetas.size() > 0) {
            for (String tarjeta: tarjetas) {
                HBox hBoxTarjeta = new HBox();
                hBoxTarjeta.setPadding(new Insets(10));
                hBoxTarjeta.setSpacing(30);
                hBoxTarjeta.getChildren().add(new RadioButton());
                hBoxTarjeta.getChildren().add(new Label(tarjeta));
                hBoxTarjeta.getChildren().add(new Button("Activar"));
                vBoxTarjetas.getChildren().add(hBoxTarjeta);
            }
        } else {
            Label sinTarjetas = new Label("No tenés tarjetas.");
            vBoxTarjetas.getChildren().add(sinTarjetas);
        }

    }
}

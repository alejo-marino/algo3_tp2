package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.SistemaDeTurnos;
import edu.fiuba.algo3.modelo.excepciones.ActivacionTarjetaInvalidaException;
import edu.fiuba.algo3.modelo.excepciones.CanjeInvalidoException;
import edu.fiuba.algo3.modelo.excepciones.TarjetaEnMazoException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TarjetasController implements Initializable {

    public VBox vBoxTarjetas;
    public Button botonCanjear;
    private SistemaDeTurnos sistema;
    private ArrayList<HBox> hBoxes;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.sistema = Juego.getInstancia().getSistema();
        hBoxes = new ArrayList<>();
        ArrayList<String> tarjetas = sistema.obtenerNombreTarjetas();
        if (tarjetas.size() > 0) {
            for (String tarjeta: tarjetas) {
                HBox hBoxTarjeta = new HBox();
                hBoxTarjeta.setPadding(new Insets(10));
                hBoxTarjeta.setAlignment(Pos.CENTER);
                hBoxTarjeta.setSpacing(30);
                hBoxTarjeta.getChildren().add(new RadioButton());
                Label labelTarjeta = new Label(tarjeta);

                hBoxTarjeta.getChildren().add(labelTarjeta);
                Button botonActivar = new Button("Activar");
                botonActivar.setOnAction(x -> {
                    try {
                        sistema.activarTarjeta(labelTarjeta.getText());
                    } catch (ActivacionTarjetaInvalidaException | TarjetaEnMazoException e) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setContentText(e.getMessage());
                        alert.initModality(Modality.APPLICATION_MODAL);
                        alert.show();
                    }

                });
                hBoxTarjeta.getChildren().add(botonActivar);
                vBoxTarjetas.getChildren().add(hBoxTarjeta);
                hBoxes.add(hBoxTarjeta);
            }
        } else {
            Label sinTarjetas = new Label("No tenés tarjetas.");
            vBoxTarjetas.getChildren().add(sinTarjetas);
        }
    }

    public void handleBotonCanjear(ActionEvent actionEvent) {
        ArrayList<String> nombreTarjetas = new ArrayList<>();
        ArrayList<HBox> hBoxesSeleccionadas = new ArrayList<>();
        for (HBox hBox: hBoxes) {
            RadioButton radioButton = (RadioButton) hBox.getChildren().get(0);
            if (radioButton.isSelected()) {
                Label labelTarjeta = (Label) hBox.getChildren().get(1);
                nombreTarjetas.add(labelTarjeta.getText());
                hBoxesSeleccionadas.add(hBox);
            }
        }
        try {
            sistema.canjearTarjetas(nombreTarjetas);
            vBoxTarjetas.getChildren().removeAll(hBoxesSeleccionadas);
        } catch (CanjeInvalidoException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.getMessage());
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.show();
        }

    }
}

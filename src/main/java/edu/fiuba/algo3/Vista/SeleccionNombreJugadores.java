package edu.fiuba.algo3.Vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;


import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;

public class SeleccionNombreJugadores {

    public static void display(int cantidadJugadores) {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Nombre Jugadores");

        VBox layout = new VBox(20);
        ArrayList nombreJugadores = new ArrayList<>();
        for ( int x = 0; x < cantidadJugadores; x++) {
            TextField  nombreJugador = new TextField();
            String label = "Nombre Jugador " + x;
            nombreJugador.setPadding(new Insets(10));
            nombreJugador.setMaxWidth(300);
            nombreJugador.setText(label);
            nombreJugadores.add(nombreJugador);
        }

        Button empezar = new Button("Empezar");
        empezar.setOnAction(event -> Inicio.display(nombreJugadores));

        layout.getChildren().addAll(nombreJugadores);
        layout.getChildren().add(empezar);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 350, 400);
        window.setOnCloseRequest(e -> {
            e.consume();
            window.close();
        });
        window.setScene(scene);
        window.showAndWait();

    }
}

package edu.fiuba.algo3.Vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;

public class SeleccionNombreJugadores {
    static Stage window;

    public static void display(String title, int cantidadJugadores) {
        window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(300);

        ArrayList<TextField> listaJugadores = new ArrayList<>();
        for (int i = 0; i < cantidadJugadores; i++) {
            TextField jugador1 = new TextField("Nombre jugador " + i);
            listaJugadores.add(jugador1);
        }

        Button botonInicio = new Button("Iniciar Juego");

        VBox layout = new VBox(10);
        layout.getChildren().addAll(listaJugadores);
        layout.getChildren().add(botonInicio);
        layout.setPadding(new Insets(20,20,20,20));


        Scene scene = new Scene(layout);
        window.setOnCloseRequest(e -> {
            e.consume();
            window.close();
        });
        window.setScene(scene);
        window.showAndWait();
    }

}

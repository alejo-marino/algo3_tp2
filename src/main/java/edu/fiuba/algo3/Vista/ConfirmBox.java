package edu.fiuba.algo3.Vista;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmBox {
    static boolean respuesta;

    public static Boolean display(String title) {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(300);


        Button botonNo= new Button("No");
        Button botonSi = new Button("Si");

        botonSi.setOnAction(e -> {
            respuesta = true;
            window.close();
        });
        botonNo.setOnAction(e -> {
            respuesta = false;
            window.close();
        });
        VBox layout = new VBox(10);
        layout.getChildren().addAll(botonSi, botonNo);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setOnCloseRequest(e -> {
            e.consume();
            window.close();
        });
        window.setScene(scene);
        window.showAndWait();
        return respuesta;
    }
}

package edu.fiuba.algo3.Vista;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Button;


public class AlertBox {

    static Stage window;

    public static void display(String title, String message) {
        window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(300);

        Label label = new Label(message);

        Button closeButton = new Button("Cerrar esta ventana");
        closeButton.setOnAction(e -> cerrarPrograma());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, closeButton);
        label.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setOnCloseRequest(e -> {
            e.consume();
            cerrarPrograma();
        });
        window.setScene(scene);
        window.showAndWait();
    }
    public static void cerrarPrograma() {
        Boolean respuesta = ConfirmBox.display("Desea Salir?");
        if (respuesta) {
            window.close();
        }
    }

}

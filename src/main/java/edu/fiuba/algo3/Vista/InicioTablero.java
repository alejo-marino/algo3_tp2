package edu.fiuba.algo3.Vista;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Stack;

public class InicioTablero {

    static Stage window;

    public static void display(ArrayList<TextField> nombreJugadores) {
        window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("TEG");
        window.setMinWidth(300);

        ArrayList<String> listaJugadores = new ArrayList<>();
        for (int i = 0; i < nombreJugadores.size(); i++) {
            String jugador = nombreJugadores.get(i).getText();
            listaJugadores.add(jugador);
        }
        ArrayList<Label> jug = new ArrayList<>();
        for (String jugador: listaJugadores) {
            Label jugadores = new Label(jugador);
            jug.add(jugadores);
        }

        VBox layout = new VBox(10);
        layout.getChildren().addAll(jug);
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

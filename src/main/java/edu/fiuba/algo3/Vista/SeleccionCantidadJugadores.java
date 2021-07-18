package edu.fiuba.algo3.Vista;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class SeleccionCantidadJugadores {

    public static void display() throws IOException {
        URL url = new File("src/main/resources/vistas/seleccionCantidadJugadores.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);


        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Cantidad Jugadores");
        stage.show();
    }
}

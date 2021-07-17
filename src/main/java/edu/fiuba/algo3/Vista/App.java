package edu.fiuba.algo3.Vista;

//import com.sun.org.apache.xpath.internal.operations.Bool;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.excepciones.CantidadErroneaDeJugadoresError;
import javafx.application.Application;
//import javafx.event.EventHandler;
//import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.Scene;
//import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * JavaFX App
 */
public class App extends Application{
    Stage window;
    Button button;

    Scene escenaCantidadJugadores, escenaInicial;

    @Override
    public void start(Stage stage) throws Exception {
        URL url = new File("src/main/resources/vistas/menuInicio.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);


        Scene scene = new Scene(root);
        stage.setOnCloseRequest(e -> cerrarPrograma());
        stage.setScene(scene);
        stage.show();

    }

    public void cerrarPrograma() {
        Boolean respuesta = ConfirmBox.display("Desea Salir?");
        if (!respuesta) {
            window.close();
        }
    }
    public static void main(String[] args) {
        launch(args);
    }

}
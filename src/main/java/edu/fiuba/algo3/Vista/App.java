package edu.fiuba.algo3.Vista;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.File;
import java.net.URL;

/**
 * JavaFX App
 */
public class App extends Application{
    static Stage window;

    @Override
    public void start(Stage stage) throws Exception {
        URL url = new File("src/main/resources/vistas/menuInicio.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);

        Scene scene = new Scene(root);
        window = stage;
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

    public static void close () {
        window.close();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
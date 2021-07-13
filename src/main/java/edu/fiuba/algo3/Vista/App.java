package edu.fiuba.algo3.Vista;

import com.sun.org.apache.xpath.internal.operations.Bool;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application{
    Stage window;
    Button button;

    Scene escenaCantidadJugadores, escenaInicial;

    @Override
    public void start(Stage stage) {
        window = stage;
    // Escena 1


        button = new Button("Empezar Juego");
        button.setOnAction(e -> window.setScene(escenaCantidadJugadores));

        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        escenaInicial = new Scene(layout, 300, 300);

    //Escena 2

        Button button2 = new Button("Cantidad Jugadores");
        button2.setOnAction(e ->AlertBox.display("Cantidad De Jugadores", "Se permite un minimo de 2 y maximo de 6 jugadores."));

        StackPane layout2 = new StackPane();
        layout2.getChildren().add(button2);
        escenaCantidadJugadores = new Scene(layout2, 300, 300);

        // Config ventana inicial
        window.setOnCloseRequest(e -> {
            e.consume();
            cerrarPrograma();
        });
        window.setScene(escenaInicial);
        window.setTitle("ALGO-TEG");
        window.show();
    }

    public void cerrarPrograma() {
        Boolean respuesta = ConfirmBox.display("Desea Salir?");
        if (respuesta) {
            window.close();
        }
    }
    public static void main(String[] args) {
        launch(args);
    }

}
package edu.fiuba.algo3.Vista;

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
public class App extends Application {

    Button button;
    @Override
    public void start(Stage stage) {
        stage.setTitle("ALGO-TEG");

        button = new Button("Empezar Juego");

        StackPane layout = new StackPane();
        layout.getChildren().add(button);

        Scene scene = new Scene(layout, 300, 300);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
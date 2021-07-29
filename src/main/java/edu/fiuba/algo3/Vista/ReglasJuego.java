package edu.fiuba.algo3.Vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;


import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReglasJuego {
    private static Stage window;

    public static void display(String title)   {


        String url_open ="https://docs.google.com/document/d/1PjCq13vbov-G1jLi2rk5b9ABhPaoxxKCu3qHpK9RTD0/edit";
        try {
            java.awt.Desktop.getDesktop().browse(java.net.URI.create(url_open));

        } catch (IOException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }


    }
}

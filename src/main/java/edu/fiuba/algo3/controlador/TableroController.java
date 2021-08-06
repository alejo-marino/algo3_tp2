package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.Vista.*;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.SistemaDeTurnos;
import edu.fiuba.algo3.modelo.excepciones.*;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class TableroController implements Initializable {

    public ArrayList<String> nombreJugadores;
    public Dictionary<String, String> colorPorJugador = new Hashtable<>();
    public Label labelCanada;
    private final ArrayList<String> coloresJugadores = new ArrayList<>();

    public VBox infoJugadores;
    public Button botonReforzar;
    public ChoiceBox<Integer> choiceBoxReforzar;
    public Button botonAtacar;
    public ChoiceBox<Integer> choiceBoxAtacar;
    public Button botonTerminarAtaque;
    public Button botonReagrupar;
    public ChoiceBox<Integer> choiceBoxReagrupar;
    public Button botonSiguienteTurno;
    public Button botonCancelarAccion;
    public Button botonMisiones;

    public Button botonCanada;
    public Button botonOregon;
    public Button botonBrasil;
    public Button botonRusia;
    public Button botonArgentina;
    public Button botonAlaska;
    public Button botonGroenlandia;
    public Button botonYukon;
    public Button botonLabrador;
    public Button botonTerranova;
    public Button botonNuevaYork;
    public Button botonCalifornia;
    public Button botonMexico;
    public Button botonColombia;
    public Button botonPeru;
    public Button botonUruguay;
    public Button botonChile;
    public Button botonEspania;
    public Button botonFrancia;
    public Button botonAlemania;
    public Button botonPolonia;
    public Button botonItalia;
    public Button botonSuecia;
    public Button botonGranBretania;
    public Button botonIslandia;
    public Button botonKamtchatka;
    public Button botonChina;
    public Button botonAral;
    public Button botonIran;
    public Button botonGobi;
    public Button botonMongolia;
    public Button botonTurquia;
    public Button botonIsrael;
    public Button botonArabia;
    public Button botonSiberia;
    public Button botonTartaria;
    public Button botonTaymir;
    public Button botonIndia;
    public Button botonMalasia;
    public Button botonJapon;
    public Button botonJava;
    public Button botonAustralia;
    public Button botonSumatra;
    public Button botonBorneo;
    public Button botonSahara;
    public Button botonEgipto;
    public Button botonZaire;
    public Button botonSudafrica;
    public Button botonMadagascar;
    public Button botonEtiopia;
    public Label labelAlaska;
    public Label labelMexico;
    public Label labelCalifornia;
    public Label labelOregon;
    public Label labelNuevaYork;
    public Label labelYukon;
    public Label labelColombia;
    public Label labelBrasil;
    public Label labelUruguay;
    public Label labelArgentina;
    public Label labelChile;
    public Label labelPeru;
    public Label labelTerranova;
    public Label labelLabrador;
    public Label labelGroenlandia;
    public Label labelIslandia;
    public Label labelSuecia;
    public Label labelRusia;
    public Label labelAlemania;
    public Label labelFrancia;
    public Label labelGranBretania;
    public Label labelEspania;
    public Label labelItalia;
    public Label labelPolonia;
    public Label labelAral;
    public Label labelTartaria;
    public Label labelKamtchatka;
    public Label labelJapon;
    public Label labelChina;
    public Label labelGobi;
    public Label labelMongolia;
    public Label labelIran;
    public Label labelTurquia;
    public Label labelIsrael;
    public Label labelArabia;
    public Label labelSumatra;
    public Label labelIndia;
    public Label labelMalasia;
    public Label labelJava;
    public Label labelBorneo;
    public Label labelAustralia;
    public Label labelMadagascar;
    public Label labelSahara;
    public Label labelEtiopia;
    public Label labelEgipto;
    public Label labelZaire;
    public Label labelSudafrica;
    public Button botonTarjetas;
    public VBox menuAcciones;
    private SistemaDeTurnos sistema;
    private ArrayList<Label> labelJugadores;


    public void initialize(URL location, ResourceBundle resources) {
        this.nombreJugadores = Inicio.jugadores;
        coloresJugadores.add("#0077bb");
        coloresJugadores.add("#cc3311");
        coloresJugadores.add("#ee7733");
        coloresJugadores.add("#009988");
        coloresJugadores.add("#ee3377");
        coloresJugadores.add("#000000");
        int contador = 0;
        this.labelJugadores = new ArrayList<>();
        for (String nombreJugador: this.nombreJugadores) {
            Label label = new Label(nombreJugador);
            this.labelJugadores.add(label);
            label.setTextFill(Color.web(this.coloresJugadores.get(contador)));
            colorPorJugador.put(nombreJugador, this.coloresJugadores.get(contador));
            infoJugadores.getChildren().addAll(label);
            contador++;
        }

        Map<String, ArrayList<Observer>> diccionarioObserversPais = crearDiccionarioDeObserversPais();

        this.sistema = Juego.getInstancia().iniciarJuego(diccionarioObserversPais);
        ArrayList<Observer> turnosObservers = crearListaObserversTurnos();
        agregarObserversASistema(turnosObservers);
        this.sistema.empezarTurno();
    }

    private void agregarObserversASistema(ArrayList<Observer> turnosObservers) {
        for (Observer observer: turnosObservers) {
            sistema.addObserver(observer);
        }
    }

    private Map<String, ArrayList<Observer>> crearDiccionarioDeObserversPais() {
       Map<String, Label> diccionarioLabels = crearDiccionarioLabelsPais();
       Map<String, ArrayList<Observer>> diccionarioObserver = new HashMap<>();

       diccionarioLabels.forEach((nombre, label) -> diccionarioObserver.put(nombre, new ArrayList<>()));

       diccionarioLabels.forEach((nombre, label) -> diccionarioObserver.get(nombre).add(new LabelPais(label, nombre)));

       return diccionarioObserver;
    }



    private ArrayList<Observer> crearListaObserversTurnos(){
        ArrayList<Observer> turnosObservers = new ArrayList<>();
        turnosObservers.add(new BotonAtacar(botonAtacar, choiceBoxAtacar, botonTerminarAtaque, sistema));
        turnosObservers.add(new BotonReforzar(botonReforzar, choiceBoxReforzar, sistema));
        turnosObservers.add(new BotonCancelarAccion(botonCancelarAccion, sistema));
        turnosObservers.add(new BotonSiguienteTurno(botonSiguienteTurno, sistema));
        turnosObservers.add(new LabelsJugadores(labelJugadores, sistema));
        turnosObservers.add(new BotonReagrupe(botonReagrupar, choiceBoxReagrupar, sistema));
        turnosObservers.add(new VBoxAcciones(menuAcciones, sistema));

        turnosObservers.add(new BotonPais(botonCanada, sistema));
        turnosObservers.add(new BotonPais(botonOregon, sistema));
        turnosObservers.add(new BotonPais(botonBrasil, sistema));
        turnosObservers.add(new BotonPais(botonRusia, sistema));
        turnosObservers.add(new BotonPais(botonArgentina, sistema));
        turnosObservers.add(new BotonPais(botonAlaska, sistema));
        turnosObservers.add(new BotonPais(botonGroenlandia, sistema));
        turnosObservers.add(new BotonPais(botonYukon, sistema));
        turnosObservers.add(new BotonPais(botonLabrador, sistema));
        turnosObservers.add(new BotonPais(botonTerranova, sistema));
        turnosObservers.add(new BotonPais(botonNuevaYork, sistema));
        turnosObservers.add(new BotonPais(botonCalifornia, sistema));
        turnosObservers.add(new BotonPais(botonMexico, sistema));
        turnosObservers.add(new BotonPais(botonColombia, sistema));
        turnosObservers.add(new BotonPais(botonPeru, sistema));
        turnosObservers.add(new BotonPais(botonUruguay, sistema));
        turnosObservers.add(new BotonPais(botonChile, sistema));
        turnosObservers.add(new BotonPais(botonEspania, sistema));
        turnosObservers.add(new BotonPais(botonFrancia, sistema));
        turnosObservers.add(new BotonPais(botonAlemania, sistema));
        turnosObservers.add(new BotonPais(botonPolonia, sistema));
        turnosObservers.add(new BotonPais(botonItalia, sistema));
        turnosObservers.add(new BotonPais(botonSuecia, sistema));
        turnosObservers.add(new BotonPais(botonGranBretania, sistema));
        turnosObservers.add(new BotonPais(botonIslandia, sistema));
        turnosObservers.add(new BotonPais(botonKamtchatka, sistema));
        turnosObservers.add(new BotonPais(botonChina, sistema));
        turnosObservers.add(new BotonPais(botonAral, sistema));
        turnosObservers.add(new BotonPais(botonIran, sistema));
        turnosObservers.add(new BotonPais(botonGobi, sistema));
        turnosObservers.add(new BotonPais(botonMongolia, sistema));
        turnosObservers.add(new BotonPais(botonTurquia, sistema));
        turnosObservers.add(new BotonPais(botonIsrael, sistema));
        turnosObservers.add(new BotonPais(botonArabia, sistema));
        turnosObservers.add(new BotonPais(botonSiberia, sistema));
        turnosObservers.add(new BotonPais(botonTartaria, sistema));
        turnosObservers.add(new BotonPais(botonTaymir, sistema));
        turnosObservers.add(new BotonPais(botonIndia, sistema));
        turnosObservers.add(new BotonPais(botonMalasia, sistema));
        turnosObservers.add(new BotonPais(botonJapon, sistema));
        turnosObservers.add(new BotonPais(botonJava, sistema));
        turnosObservers.add(new BotonPais(botonAustralia, sistema));
        turnosObservers.add(new BotonPais(botonSumatra, sistema));
        turnosObservers.add(new BotonPais(botonBorneo, sistema));
        turnosObservers.add(new BotonPais(botonSahara, sistema));
        turnosObservers.add(new BotonPais(botonEgipto, sistema));
        turnosObservers.add(new BotonPais(botonZaire, sistema));
        turnosObservers.add(new BotonPais(botonSudafrica, sistema));
        turnosObservers.add(new BotonPais(botonMadagascar, sistema));
        turnosObservers.add(new BotonPais(botonEtiopia, sistema));

        return turnosObservers;
    }

    public void handleBotonPais(ActionEvent actionEvent) {
        Button botonApretado = (Button) actionEvent.getSource();
        try {
            sistema.seleccionarPais(botonApretado.getText());
        } catch (SeleccionaPaisAjenoException | AtaqueAPaisNoLimitrofeException | AtaqueAPaisPropioException
                | ReagrupeAPaisAjenoException | ReagrupeAPaisNoLimitrofeException | EjercitosInvalidosException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText(e.getMessage());
            alert.show();
        }
    }

    public void handleBotonReforzar(ActionEvent actionEvent) {
        sistema.reforzar(choiceBoxReforzar.getSelectionModel().getSelectedItem());
    }

    public void handleBotonSiguienteTurno(ActionEvent actionEvent) {
        try {
            sistema.empezarTurno();
        } catch(NoReforzoTodosLosEjercitosException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("No reforzó todos los ejércitos.");
            alert.show();
        }
    }

    public void handleBotonAtacar(ActionEvent actionEvent) {
        try {
            sistema.atacar(choiceBoxAtacar.getSelectionModel().getSelectedItem());
        } catch (JugadorGanoException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText(e.getMessage());
            alert.show();
        } catch (AtaqueInvalidoException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.getMessage());
            alert.show();
        }

    }

    public void handleBotonReagrupar(ActionEvent actionEvent) {
        try {
            sistema.reagrupar(choiceBoxReagrupar.getSelectionModel().getSelectedItem());
        } catch (PaisNoSeleccionadoException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.getMessage());
            alert.show();
        }

    }

    public void handleBotonCancelarAccion(ActionEvent actionEvent) {
        sistema.cancelarAccion();
    }


    public void handleBotonTerminarAtaque(ActionEvent actionEvent) {
        sistema.terminarAtaque();
    }

    public void handleVerMisiones(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(sistema.verMisiones());
        alert.show();
    }

    public void handleTarjetas(ActionEvent actionEvent) {
        try {
            MenuTarjetas.display(sistema);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Map<String, Label> crearDiccionarioLabelsPais() {
        Map<String, Label> diccionarioLabels = new HashMap<>();
        diccionarioLabels.put("Alaska", labelAlaska);
        diccionarioLabels.put("Mexico", labelMexico);
        diccionarioLabels.put("California", labelCalifornia);
        diccionarioLabels.put("Oregon", labelOregon);
        diccionarioLabels.put("Nueva York", labelNuevaYork);
        diccionarioLabels.put("Yukon", labelYukon);
        diccionarioLabels.put("Colombia", labelColombia);
        diccionarioLabels.put("Brasil", labelBrasil);
        diccionarioLabels.put("Uruguay", labelUruguay);
        diccionarioLabels.put("Argentina", labelArgentina);
        diccionarioLabels.put("Chile", labelChile);
        diccionarioLabels.put("Peru", labelPeru);
        diccionarioLabels.put("Terranova", labelTerranova);
        diccionarioLabels.put("Labrador", labelLabrador);
        diccionarioLabels.put("Groenlandia", labelGroenlandia);
        diccionarioLabels.put("Islandia", labelIslandia);
        diccionarioLabels.put("Suecia", labelSuecia);
        diccionarioLabels.put("Rusia", labelRusia);
        diccionarioLabels.put("Alemania", labelAlemania);
        diccionarioLabels.put("Francia", labelFrancia);
        diccionarioLabels.put("Gran Bretaña", labelGranBretania);
        diccionarioLabels.put("España", labelEspania);
        diccionarioLabels.put("Italia", labelItalia);
        diccionarioLabels.put("Polonia", labelPolonia);
        diccionarioLabels.put("Aral", labelAral);
        diccionarioLabels.put("Tartaria", labelTartaria);
        diccionarioLabels.put("Kamtchatka", labelKamtchatka);
        diccionarioLabels.put("Japon", labelJapon);
        diccionarioLabels.put("China", labelChina);
        diccionarioLabels.put("Gobi", labelGobi);
        diccionarioLabels.put("Mongolia", labelMongolia);
        diccionarioLabels.put("Iran", labelIran);
        diccionarioLabels.put("Turquia", labelTurquia);
        diccionarioLabels.put("Israel", labelIsrael);
        diccionarioLabels.put("Arabia", labelArabia);
        diccionarioLabels.put("Sumatra", labelSumatra);
        diccionarioLabels.put("India", labelIndia);
        diccionarioLabels.put("Malasia", labelMalasia);
        diccionarioLabels.put("Java", labelJava);
        diccionarioLabels.put("Borneo", labelBorneo);
        diccionarioLabels.put("Australia", labelAustralia);
        diccionarioLabels.put("Madagascar", labelMadagascar);
        diccionarioLabels.put("Sahara", labelSahara);
        diccionarioLabels.put("Etiopia", labelEtiopia);
        diccionarioLabels.put("Egipto", labelEgipto);
        diccionarioLabels.put("Zaire", labelZaire);
        diccionarioLabels.put("Sudafrica", labelSudafrica);
        diccionarioLabels.put("Canada", labelCanada);
        return diccionarioLabels;
    }

}

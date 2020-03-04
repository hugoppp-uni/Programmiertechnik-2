package praktikum.aufgabe3.darstellung;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import praktikum.aufgabe3.ISimObjekt;

import java.util.ArrayList;
import java.util.List;

/**
 * Eine einfache Darstellung für die Simulation einer Fähre mit Autos.
 */
public class Piratensimulation extends Application {

    @Override
    public void start(Stage primaryStage) {
        StackPane wurzel = new StackPane();
        Scene szene = new Scene(wurzel, 600, 300);
        Darstellungscanvas darstellungscanvas = new Darstellungscanvas(600, 300, objekteAnlegen());
        wurzel.getChildren().add(darstellungscanvas);
        primaryStage.setTitle("Piratensimulation");
        primaryStage.setScene(szene);
        primaryStage.show();
    }

    /**
     * Hier werden die Simulationsobjekte angelegt.
     */
    public List<ISimObjekt> objekteAnlegen() {
        // TODO: Objekte anlegen, starten und in Liste zurückgeben.
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

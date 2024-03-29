/**
 * Diese Datei ist Teil der Vorgabe zur Lehrveranstaltung Programmiermethodik 2
 * im Studiengang ITS der Hochschule für Angewandte Wissenschaften Hamburg von
 * Prof. Philipp Jenke (Informatik)
 */

package praktikum.aufgabe3F.darstellung;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import praktikum.aufgabe3F.ISimObjekt;
import praktikum.aufgabe3F.Pirat;
import praktikum.aufgabe3F.Schiff;
import praktikum.aufgabe3F.Zustand;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Eine einfache Darstellung für die Simulation einer Fähre mit Autos.
 */
public class Piratensimulation extends Application {

    @Override
    public void start(Stage primaryStage) {
        StackPane wurzel = new StackPane();
        Scene szene = new Scene(wurzel, 600, 400);
        Darstellungscanvas darstellungscanvas = new Darstellungscanvas(600,
          400, objekteAnlegen());
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
        Schiff schiff = new Schiff("FlyingDutchman", 3);
        List<ISimObjekt> liste = Arrays.asList(schiff, new Pirat("Hook",
          schiff), new Pirat("Peter", schiff), new Pirat("Karsten",
          schiff), new Pirat("Mike", schiff), new Pirat("Frank", schiff));
        for(ISimObjekt listElement : liste){
            new Thread(listElement).start();
        }
        return liste;
    }

    public static void main(String[] args) {
        launch(args);
    }
}

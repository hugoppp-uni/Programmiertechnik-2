/**
 * Diese Datei ist Teil der Vorgabe zur Lehrveranstaltung Programmiermethodik 2 im Studiengang ITS der Hochschule
 * für Angewandte Wissenschaften Hamburg von Prof. Philipp Jenke (Informatik)
 */

package praktikum.aufgabe4;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Eine GUI für den Herr-Der-Ringe-Datensatz
 */
public class HerrDerRingeGUI extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Herr der Ringe");
        VBox wurzel = new VBox();
        Scene szene = new Scene(wurzel, 600, 400, Color.WHITE);
        primaryStage.setScene(szene);
        primaryStage.show();
    }

    /**
     * Programmstart
     */
    public static void main(String[] args) {
        Application.launch();
    }
}

/**
 * Diese Datei ist Teil der Vorgabe zur Lehrveranstaltung Programmiermethodik 2 im Studiengang ITS der Hochschule
 * für Angwandte Wissenschaften Hamburg von Prof. Philipp Jenke (Informatik)
 */

package vorlesungsuebungen.vorlesung09.uebung7;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * Ein JavaFX-Fenster mit zwei Knöpfen.
 */
public class FensterMitZweiKnoepfen extends Application {

    @Override
    public void start(Stage primaryStage) {
        HBox root = new HBox();
        Button knopf1 = new Button("Knopf 1");
        root.getChildren().add(knopf1);
        Button knopf2 = new Button("Knopf 2");
        root.getChildren().add(knopf2);

        // Hier Event-Handler registrieen


        primaryStage.setScene(new Scene(root, 150, 50));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

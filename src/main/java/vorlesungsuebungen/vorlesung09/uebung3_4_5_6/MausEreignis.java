/**
 * Diese Datei ist Teil der Vorgabe zur Lehrveranstaltung Programmiermethodik 2 im Studiengang ITS der Hochschule
 * für Angewandte Wissenschaften Hamburg von Prof. Philipp Jenke (Informatik)
 */

package vorlesungsuebungen.vorlesung09.uebung3_4_5_6;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;

/**
 * Ein Fenster in JavaFX mit einem Label.
 *
 * @author Philipp Jenke
 */
public class MausEreignis extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        StackPane root = new StackPane();
        Label label = new Label("Hier die Maus bewegen!");
        root.getChildren().add(label);

        label.addEventHandler(MouseEvent.MOUSE_MOVED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println(event.getSceneX() + ", " + event.getSceneY());
            }
        });

        primaryStage.setScene(new Scene(root, 200, 100));
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}


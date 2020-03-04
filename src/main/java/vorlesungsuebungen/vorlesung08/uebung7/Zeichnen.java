package vorlesungsuebungen.vorlesung08.uebung7;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

/**
 * Hier die Übung 8.7 bearbeiten
 */
public class Zeichnen extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        StackPane wurzel = new StackPane();
        Canvas canvas = new Canvas(200, 200);
        wurzel.getChildren().add(canvas);
        primaryStage.setScene(new Scene(wurzel, 300, 250));
        primaryStage.show();

        // Hier zeichnen

    }
}

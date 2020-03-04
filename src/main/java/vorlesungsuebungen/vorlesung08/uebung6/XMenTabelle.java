package vorlesungsuebungen.vorlesung08.uebung6;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.Arrays;

public class XMenTabelle extends Application {

    private static final ObservableList<Person> personen =
            FXCollections.<Person>observableArrayList(Arrays.asList(
                    new Person("Professor X", "Charles", "Xavier"),
                    new Person("Wolverine", "James", "Howlett"),
                    new Person("Cyclops", "Scott", "Summers"),
                    new Person("Storm", "Ororo", "Munroe"),
                    new Person("Magneto", "Max", "Eisenhardt"),
                    new Person("Juggernaut", "Cain", "Marko"),
                    new Person("Mystique", "Raven", "Darkhölme"),
                    new Person("Sabretooth", "Victor", "Creed")));

    @Override
    public void start(Stage primaryStage) throws Exception {
        StackPane wurzel = new StackPane();

        // Hier Code einfügen

        primaryStage.setScene(new Scene(wurzel, 300, 250));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

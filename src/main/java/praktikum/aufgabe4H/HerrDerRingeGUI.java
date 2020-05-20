/**
 * Diese Datei ist Teil der Vorgabe zur Lehrveranstaltung Programmiermethodik
 * 2 im Studiengang ITS der Hochschule
 * für Angewandte Wissenschaften Hamburg von Prof. Philipp Jenke (Informatik)
 */

package praktikum.aufgabe4H;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import praktikum.aufgabe2H.Figur;
import praktikum.aufgabe2H.Film;
import praktikum.aufgabe2H.HerrDerRingeDaten;
import praktikum.aufgabe2H.Zitat;

/**
 * Eine GUI für den Herr-Der-Ringe-Datensatz
 */
public class HerrDerRingeGUI extends Application {

  @Override
  public void start(Stage primaryStage) {
    HerrDerRingeDaten herrDerRingeDaten = new HerrDerRingeDaten();

    primaryStage.setTitle("Herr der Ringe");

    TextField textField = new TextField();

    TableView<Figur> tableViewFigur =
      new TableView<>(FXCollections.observableArrayList(herrDerRingeDaten.getFiguren()));
    TableColumn<Figur, String> vornameTableColumnColumn = new TableColumn<>("Name");
    vornameTableColumnColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
    TableColumn<Figur, String> typTableColumn = new TableColumn<>("Typ");
    typTableColumn.setCellValueFactory(new PropertyValueFactory<>("typ"));
    TableColumn<Figur, String> geschlechtTableColumn = new TableColumn<>("Geschlecht");

    geschlechtTableColumn.setCellValueFactory(new PropertyValueFactory<>("geschlecht"));
    tableViewFigur.getColumns()
                  .setAll(vornameTableColumnColumn, typTableColumn, geschlechtTableColumn);

    TableView<Film> tableViewFilm =
      new TableView<>(FXCollections.observableArrayList(herrDerRingeDaten.getFilme()));
    TableColumn<Film, String> titelTableColumn = new TableColumn<>("Titel");
    titelTableColumn.setCellValueFactory(new PropertyValueFactory<>("titel"));
    TableColumn<Film, String> laufzeitTableColumn = new TableColumn<>("Laufzeit");
    laufzeitTableColumn.setCellValueFactory(new PropertyValueFactory<>("laufzeit"));

    tableViewFilm.getColumns().setAll(titelTableColumn, laufzeitTableColumn);

    TableView<Zitat> tableViewZitat =
      new TableView<>(FXCollections.observableArrayList(herrDerRingeDaten.getZitate()));
    TableColumn<Zitat, String> zitateTableColumn = new TableColumn<>("Zitate");
    zitateTableColumn.setCellValueFactory(new PropertyValueFactory<>("dialog"));

    tableViewZitat.getColumns().setAll(zitateTableColumn);

    SplitPane horizontalSplitPaneFigurFilm = new SplitPane(tableViewFigur, tableViewFilm);
    SplitPane verticalSplitPaneFigurfilmZitat = new SplitPane(horizontalSplitPaneFigurFilm, tableViewZitat);
    verticalSplitPaneFigurfilmZitat.setOrientation(Orientation.VERTICAL);
    VBox wurzel = new VBox(textField, verticalSplitPaneFigurfilmZitat);




    Scene szene = new Scene(wurzel, 1000, 600, Color.WHITE);
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

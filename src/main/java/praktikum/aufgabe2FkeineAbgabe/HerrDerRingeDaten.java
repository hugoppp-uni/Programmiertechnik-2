package praktikum.aufgabe2FkeineAbgabe;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static praktikum.aufgabe2FkeineAbgabe.ReadingJSON.*;

public class HerrDerRingeDaten {
    private final ObservableList<FigurWrapper> figurenListe;
    private final ObservableList<FilmWrapper> filmListe;
    private final ObservableList<Zitat> zitatListe;

    public HerrDerRingeDaten() {
        figurenListe = createListFiguren();
        filmListe = createListFilm();
        zitatListe = createListZitat();
    }

    public static ObservableList<FigurWrapper> createListFiguren() {
        JSONArray j = einlesen("src/main/resources/json/figuren.json");
        ObservableList<FigurWrapper> figurenListe =
          FXCollections.observableArrayList();
        for (int i = 0; i < j.length(); i++) {
            JSONObject figur = (JSONObject) j.get(i);
            FigurWrapper f = (FigurWrapper) Figur.fromJson(figur);
            figurenListe.add(f);
        }
        return figurenListe;
    }

    public static ObservableList<Zitat> createListZitat() {
        JSONArray j = einlesen("src/main/resources/json/zitate.json");
        ObservableList<Zitat> zitatListe = FXCollections.observableArrayList();
        for (int i = 0; i < j.length(); i++) {
            JSONObject zitat = (JSONObject) j.get(i);
            Zitat z = Zitat.fromJson(zitat);
            zitatListe.add(z);
        }
        return zitatListe;
    }

    public static ObservableList<FilmWrapper> createListFilm() {
        JSONArray j = einlesen("src/main/resources/json/filme.json");
        ObservableList<FilmWrapper> filmListe = FXCollections.observableArrayList();
        for (int i = 0; i < j.length(); i++) {
            JSONObject film = (JSONObject) j.get(i);
            FilmWrapper f = (FilmWrapper) Film.fromJson(film);
            filmListe.add(f);
        }
        return filmListe;
    }

    public void ausgebenMaiar(ObservableList<FigurWrapper> figurenListe) {
        Stream<FigurWrapper> s = figurenListe.stream();
        s.filter(figur -> figur.getTyp() == Typ.MAIAR)
          .sorted()
          .forEach(System.out::println);
    }

    public void ausgebenHobbit(ObservableList<FigurWrapper> figurenListe) {
        Stream<FigurWrapper> s = figurenListe.stream();
        s.filter(f -> f.getTyp() == Typ.HOBBIT && f.getGroesse() != 0)
          .sorted((o1, o2) -> {
              FigurenComparator f = new FigurenComparator();
              return f.compare(o1, o2);
          })
          .forEach(System.out::println);
    }

    public Figur findFigur(String name, ObservableList<FigurWrapper> figurList) {
        Optional<FigurWrapper> s = figurList.stream()
          .filter(fName -> (fName.getName()).equals(name)).findAny();
        return s.orElse(null);
    }

    public Stream<Zitat> zitatZuFigur(String name) {
        Figur figur = findFigur(name, figurenListe);
        return zitatListe.stream().filter(z -> z.getFigurId()
          .equals(figur.getId()));
    }
}

package praktikum.aufgabe2FkeineAbgabe;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static praktikum.aufgabe2FkeineAbgabe.ReadingJSON.*;

public class HerrDerRingeDaten {
    private final List<Figur> figurenListe;
    private final List<Film> filmListe;
    private final List<Zitat> zitatListe;

    public HerrDerRingeDaten(){
        figurenListe = createListFiguren();
        filmListe = createListFilm();
        zitatListe = createListZitat();
    }

    public List<Figur> createListFiguren() {
        JSONArray j = einlesen("src/main/resources/json/figuren.json");
        List<Figur> figurenListe = new ArrayList<>();
        for (int i = 0; i < j.length(); i++) {
            JSONObject figur = (JSONObject) j.get(i);
            Figur f = Figur.fromJson(figur);
            figurenListe.add(f);
        }
        return figurenListe;
    }

    public List<Zitat> createListZitat() {
        JSONArray j = einlesen("src/main/resources/json/zitate.json");
        List<Zitat> zitatListe = new ArrayList<>();
        for (int i = 0; i < j.length(); i++) {
            JSONObject zitat = (JSONObject) j.get(i);
            Zitat z = Zitat.fromJson(zitat);
            zitatListe.add(z);
        }
        return zitatListe;
    }

    public List<Film> createListFilm() {
        JSONArray j = einlesen("src/main/resources/json/filme.json");
        List<Film> filmListe = new ArrayList<>();
        for (int i = 0; i < j.length(); i++) {
            JSONObject film = (JSONObject) j.get(i);
            Film f = Film.fromJson(film);
            filmListe.add(f);
        }
        return filmListe;
    }

    public void ausgebenMaiar(List<Figur> figurenListe) {
        Stream<Figur> s = figurenListe.stream();
        s.filter(figur -> figur.getTyp() == Typ.MAIAR)
          .sorted()
          .forEach(System.out::println);
    }

    public void ausgebenHobbit(List<Figur> figurenListe) {
        Stream<Figur> s = figurenListe.stream();
        s.filter(f -> f.getTyp() == Typ.HOBBIT && f.getGroesse() != 0)
          .sorted((o1, o2) -> {
              FigurenComparator f = new FigurenComparator();
              return f.compare(o1, o2);
          })
          .forEach(System.out::println);
    }

    public Figur findFigur(String name, List<Figur> figurList) {
        Optional<Figur> s = figurList.stream()
          .filter(fName -> (fName.getName()).equals(name)).findAny();
        return s.orElse(null);
    }

    public Stream<Zitat> zitatZuFigur(String name){
        Figur figur = findFigur(name, figurenListe);
        return zitatListe.stream().filter(z -> z.getFigurId()
          .equals(figur.getId()));
    }
}

package praktikum.aufgabe2F;

import java.util.List;

import static praktikum.aufgabe2F.ReadingJSON.*;

public class HerrDerRingeDaten {
    private List<Figur> figurenListe;
    private List<Film> filmListe;
    private List<Zitat> zitatListe;

    public HerrDerRingeDaten(String file){
        this.figurenListe = createListFiguren(einlesen(file));
        this.filmListe = createListFilm(einlesen(file));
        this.zitatListe = createListZitat(einlesen(file));
    }
}

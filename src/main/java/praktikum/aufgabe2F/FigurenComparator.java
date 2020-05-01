package praktikum.aufgabe2F;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FigurenComparator extends Figur {

    public Figur compareFiguren(Figur eins, Figur zwei) {
        if (eins.getGroesse() < zwei.getGroesse()) {
            return zwei;
        }
        return eins;
    }

    public void ausgebenMaiar(List<Figur> figurenliste) {
        List<Figur> fListe = new ArrayList<>();
        for (Figur figur : figurenliste) {
            if (figur.getTyp() == Typ.MAIAR) {
                fListe.add(figur);
            }
        }
        Stream<Figur> s = fListe.stream();
        s.sorted().forEach(System.out::println);
    }
}

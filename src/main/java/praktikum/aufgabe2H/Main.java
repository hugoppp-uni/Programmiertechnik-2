package praktikum.aufgabe2H;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    HerrDerRingeDaten daten = new HerrDerRingeDaten("./src/main/resources/json/");
    daten.printZitate(daten.getFiguren());
    daten.findFigur("Frodo Baggins").iterator().forEachRemaining(System.out::println);


    ArrayList<Object[]> objects = new ArrayList<>();

    System.out.println("\n");
    daten.getZitateMap(daten.getFiguren())
        .forEach((name, zitateList) -> objects.add(new Object[] {zitateList.size(), name}));
    objects.sort(Comparator.comparingInt(o -> (-(int) o[0])));
    objects.forEach(o -> System.out.println(o[1] + ": " + o[0]));


    printHobbit(daten).forEach(System.out::println);
    System.out.println("\n\n");
    printMaiar(daten).forEach(System.out::println);

  }

  private static List<Figur> printMaiar(HerrDerRingeDaten daten) {
    return daten.getFiguren().stream()
        .filter(figur -> figur.getTyp().equals(Typ.MAIAR))
        .sorted()
        .collect(Collectors.toCollection(ArrayList::new));
  }

  private static List<Figur> printHobbit(HerrDerRingeDaten daten) {
    return daten.getFiguren().stream()
        .filter(figur -> figur.getTyp().equals(Typ.HOBBIT))
        .filter(figur -> figur.getGroesse() > 0)
        .sorted(new FigurComparator())
        .collect(Collectors.toCollection(ArrayList::new));
  }
}

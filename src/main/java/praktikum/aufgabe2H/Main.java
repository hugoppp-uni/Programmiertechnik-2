package praktikum.aufgabe2H;

import java.util.ArrayList;
import java.util.Comparator;

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


    printHobbit(daten);
    System.out.println("\n\n");
    printMaiar(daten);

  }

  private static void printMaiar(HerrDerRingeDaten daten) {
    daten.getFiguren().stream()
        .filter(figur -> figur.getTyp().equals(Typ.MAIAR))
        .sorted()
        .forEach(System.out::println);
  }

  private static void printHobbit(HerrDerRingeDaten daten) {
    FigurComparator figurComparator = new FigurComparator();
    daten.getFiguren().stream()
        .filter(figur -> figur.getTyp().equals(Typ.HOBBIT))
        .filter(figur -> figur.getGroesse() > 0)
        .sorted(figurComparator)
        .forEach(System.out::println);
  }
}

package praktikum.aufgabe2H;

public class Main {
  public static void main(String[] args) {
    HerrDerRingeDaten daten = new HerrDerRingeDaten();
//    System.out.println(daten.findFigur("Bill Ferny"));
//    System.out.println(daten.findFigur("noooooope"));
//    daten.getZitateOf("").forEach(System.out::println);
    daten.printZitate(daten.getFiguren());
    daten.findFigur("Frodo Baggins").iterator().forEachRemaining(System.out::println);
  }
}

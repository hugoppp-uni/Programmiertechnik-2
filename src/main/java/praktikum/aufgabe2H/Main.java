package praktikum.aufgabe2H;

public class Main {
  public static void main(String[] args) {
    HerrDerRingeDaten herrDerRingeDaten = new HerrDerRingeDaten();
    System.out.println(herrDerRingeDaten.findFigur("Bill Ferny"));
    System.out.println(herrDerRingeDaten.findFigur("noooooope"));
    herrDerRingeDaten
        .getFiguren()
        .stream()
        .map(Figur::getName)
        .map(o -> herrDerRingeDaten.getZitateOf(o))
        .forEach(System.out::println);

  }
}

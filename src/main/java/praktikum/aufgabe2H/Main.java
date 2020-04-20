package praktikum.aufgabe2H;

public class Main {
  public static void main(String[] args) {
    String relPath = "./src/main/resources/json/";
    var ls = Figur.generateFromJson(relPath + "figuren.json");
    ls.forEach(e -> System.out.println(e.toString() + "\n"));

  }
}

package praktikum.aufgabe2H;

import java.util.List;

public interface XmlLoadable<T> {
  List<T> loadFromXml(String path);
}

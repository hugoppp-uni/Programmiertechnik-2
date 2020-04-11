package praktikum.aufgabe1.F;

import java.util.*;

public class PM2Map<K, V> implements Map<K, V> {
  private MapPaar<K, V>[] paare = new MapPaar[0];

  public PM2Map() {
  }

  void einfuegen(String kategorie, Person person) {
    if (put((K) kategorie, (V) person).equals(null)) ;
    Map<String, List<Person>> m = new HashMap<>();
    
  }


  @Override
  public int size() {
    return this.paare.length;
  }

  @Override
  public boolean isEmpty() {
    return this.paare == null || this.paare.length == 0;
  }

  @Override
  public boolean containsKey(Object o) {
    for (MapPaar<K, V> p : this.paare) {
      if (p.key.equals(o)) {
        return true;
      }
    }
    return false;
  }

  @Override
  public boolean containsValue(Object o) {
    for (MapPaar<K, V> p : this.paare) {
      if (p.value.equals(o)) {
        return true;
      }
    }
    return false;
  }

  @Override
  public V get(Object key) {
    if (containsKey(key)) {
      for (MapPaar<K, V> m : paare) {
        if (m.key.equals(key)) {
          return m.value;
        }
      }
    }
    return null;
  }

  @Override
  public V put(K k, V v) {
    if (containsKey(k)) {
      for (MapPaar<K, V> m : paare) {
        if (m.key.equals(k)) {
          m.value = v;
          return v;
        }
      }
    }
    int newLength = paare.length + 1;
    paare = Arrays.copyOf(paare, paare.length + 1);
    paare[newLength - 1] = new MapPaar<>(k, v);
    return v;
  }

  @Override
  public V remove(Object key) {
    for (int i = 0; i <= paare.length - 1; i++) {
      if (paare[i].key.equals(key)) {
        V v = paare[i].value;
        MapPaar<K, V>[] newArray = Arrays.copyOf(paare,paare.length-1);
        if (paare.length >= 2) {
          System.arraycopy(paare, i + 1, newArray, i, paare.length - (i + 1));
        }
        paare = newArray;
        return v;
      }
    }
    return null;
  }

  @Override
  public void putAll(Map<? extends K, ? extends V> m) {
    m.forEach(this::put);
  }

  @Override
  public void clear() {
    for (MapPaar<K, V> m : this.paare) {
      remove(m.getKey());
    }
  }

  @Override
  public Set<K> keySet() {
    Set<K> set = new HashSet<K>();
    for (MapPaar<K, V> m : paare) {
      set.add(m.getKey());
    }
    return set;
  }

  @Override
  public Collection<V> values() {
    Collection<V> c = new HashSet<>();
    for (MapPaar<K, V> m : paare) {
      c.add(m.getValue());
    }
    return c;
  }

  @Override
  public Set<Entry<K, V>> entrySet() {
    Set<Entry<K, V>> set = new HashSet<>();
    set.addAll(Arrays.asList(paare));
    return set;
  }

  public static class MapPaar<K, V> implements Map.Entry<K, V> {
    private K key;
    private V value;

    public MapPaar(K key, V value) {
      this.key = key;
      this.value = value;
    }

    @Override
    public K getKey() {
      return this.key;
    }

    @Override
    public V getValue() {
      return this.value;
    }

    @Override
    public V setValue(V v) {
      V oldValue = this.value;
      this.value = v;
      return oldValue;
    }
  }
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (var paar : paare) {
      sb.append(paar.getKey()).append(" -> ").append(paar.getValue()).
        append('\n');
    }
    return sb.toString();
  }
}

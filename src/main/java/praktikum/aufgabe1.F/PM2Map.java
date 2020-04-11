package praktikum.aufgabe1.F;

import java.util.*;

public class PM2Map<K, V> implements Map<K, V> {
  private MapPaar<K, V>[] paare = new MapPaar[0];

  public PM2Map() {
  }

  void einfuegen(String kategorie, Person person) {
    //TODO
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
    } else {
      int newLength = paare.length + 1;
      MapPaar<K, V>[] newArray = new MapPaar[newLength];
      System.arraycopy(paare, 0, newArray, 0, paare.length);
      paare = newArray;
      paare[newLength - 1] = new MapPaar<>(k, v);
      return v;
    }
    return null;
  }

  @Override
  public V remove(Object key) {
    for (int i = 0; i <= paare.length - 1; i++) {
      if (paare[i].key.equals(key)) {
        V v = paare[i].value;
        MapPaar<K, V>[] newArray = new MapPaar[paare.length - 1];
        if (paare.length >= 2) {
          System.arraycopy(paare, 0, newArray, 0, i);
          System.arraycopy(paare, i + 1, newArray, i, paare.length - (i + 1));
        }
        paare = newArray;
        return v;
      }
    }
    return null;
  }

  /**
   * Copies all of the mappings from the specified map to this map (optional
   * operation).  The effect of this call is equivalent to that of calling
   * {@link #put(Object, Object) put(k, v)} on this map once for each mapping
   * from key {@code k} to value {@code v} in the specified map.  The behavior
   * of this operation is undefined if the specified map is modified while the
   * operation is in progress.
   *
   * @param m mappings to be stored in this map
   * @throws UnsupportedOperationException if the {@code putAll} operation is
   *                                       not supported by this map
   * @throws ClassCastException            if the class of a key or value in the
   *                                       specified map prevents it from being
   *                                       stored in this map
   * @throws NullPointerException          if the specified map is null, or if
   *                                       this map does not permit null keys or
   *                                       values, and the specified map
   *                                       contains null keys or values
   * @throws IllegalArgumentException      if some property of a key or value in
   *                                       the specified map prevents it from
   *                                       being stored in this map
   */
  @Override
  public void putAll(Map<? extends K, ? extends V> m) {
    m.forEach(this::put);
  }

  /**
   * Removes all of the mappings from this map (optional operation). The map
   * will be empty after this call returns.
   *
   * @throws UnsupportedOperationException if the {@code clear} operation is not
   *                                       supported by this map
   */
  @Override
  public void clear() {
    for (MapPaar<K, V> m : this.paare) {
      remove(m.getKey());
    }
  }

  /**
   * Returns a {@link Set} view of the keys contained in this map. The set is
   * backed by the map, so changes to the map are reflected in the set, and
   * vice-versa.  If the map is modified while an iteration over the set is in
   * progress (except through the iterator's own {@code remove} operation), the
   * results of the iteration are undefined.  The set supports element removal,
   * which removes the corresponding mapping from the map, via the {@code
   * Iterator.remove}, {@code Set.remove}, {@code removeAll}, {@code retainAll},
   * and {@code clear} operations.  It does not support the {@code add} or
   * {@code addAll} operations.
   *
   * @return a set view of the keys contained in this map
   */
  @Override
  public Set<K> keySet() {
    Set<K> set = new HashSet<K>();
    for (MapPaar<K, V> m : paare) {
      set.add(m.getKey());
    }
    return set;
  }

  /**
   * Returns a {@link Collection} view of the values contained in this map. The
   * collection is backed by the map, so changes to the map are reflected in the
   * collection, and vice-versa.  If the map is modified while an iteration over
   * the collection is in progress (except through the iterator's own {@code
   * remove} operation), the results of the iteration are undefined.  The
   * collection supports element removal, which removes the corresponding
   * mapping from the map, via the {@code Iterator.remove}, {@code
   * Collection.remove}, {@code removeAll}, {@code retainAll} and {@code clear}
   * operations.  It does not support the {@code add} or {@code addAll}
   * operations.
   *
   * @return a collection view of the values contained in this map
   */
  @Override
  public Collection<V> values() {
    Collection<V> c = new HashSet<>();
    for (MapPaar<K, V> m : paare) {
      c.add(m.getValue());
    }
    return (Collection<V>) c;
  }

  /**
   * Returns a {@link Set} view of the mappings contained in this map. The set
   * is backed by the map, so changes to the map are reflected in the set, and
   * vice-versa.  If the map is modified while an iteration over the set is in
   * progress (except through the iterator's own {@code remove} operation, or
   * through the {@code setValue} operation on a map entry returned by the
   * iterator) the results of the iteration are undefined.  The set supports
   * element removal, which removes the corresponding mapping from the map, via
   * the {@code Iterator.remove}, {@code Set.remove}, {@code removeAll}, {@code
   * retainAll} and {@code clear} operations.  It does not support the {@code
   * add} or {@code addAll} operations.
   *
   * @return a set view of the mappings contained in this map
   */
  @Override
  public Set<Entry<K, V>> entrySet() {
    return null;
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
}

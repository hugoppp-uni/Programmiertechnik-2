package praktikum.aufgabe1.F;

import java.util.*;

/**
 * Implementation einer Map,
 * akzeptiert keine Null - Keys
 */

//TODO Hashcode vor Equals
//TODO Verdoppeln vom Array statt +1
public class PM2Map<K, V> implements Map<K, V> {
    private Object[] paare;
    private int anzElemente;

    public PM2Map() {
        this.paare = new MapPaar[0];
    }

    @Override
    public int size() {
        return anzElemente;
    }

    @Override
    public boolean isEmpty() {
        return anzElemente == 0;
    }

    @Override
    public boolean containsKey(Object o) {
        var andererKey = ((MapPaar<K, V>) o).getKey();
        for (int i = 0; i < anzElemente; i++) {
            var aktuellerKey = ((MapPaar<K, V>) paare[i]).getKey();
            if (aktuellerKey.hashCode() == andererKey.hashCode() &&
              aktuellerKey.equals(andererKey)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(Object o) {

        var andererValue = ((MapPaar<K, V>) o).getValue();
        for (int i = 0; i < anzElemente; i++) {
            var aktuellerValue = ((MapPaar<K, V>) paare[i]).getValue();
            if (aktuellerValue.hashCode() == andererValue.hashCode() &&
              aktuellerValue.equals(andererValue)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public V get(Object o) {
        var keyZuFinden = ((MapPaar<K, V>) o).getKey();
        for (int i = 0; i < anzElemente; i++) {
            var aktuellerKey = ((MapPaar<K, V>) paare[i]).getKey();
            if (aktuellerKey.hashCode() == keyZuFinden.hashCode() &&
              aktuellerKey.equals(keyZuFinden)) {
                return ((MapPaar<K, V>) paare[i]).getValue();
            }
        }
        return null;
    }

    @Override
    public V put(K k, V v) {
        if (containsKey(k)) {
            var keyZuFinden = ((MapPaar<K, V>) k).getKey();
            for (int i = 0; i < anzElemente; i++) {
                var aktuellerKey = ((MapPaar<K, V>) paare[i]).getKey();
                if (aktuellerKey.hashCode() == keyZuFinden.hashCode() &&
                  aktuellerKey.equals(keyZuFinden)) {
                    var alterValue = ((MapPaar<K, V>) paare[i]).getValue();
                    ((MapPaar<K, V>) paare[i]).setValue(v);
                    return alterValue;
                }
            }


        }
        if (anzElemente == paare.length) verdoppeln();
        paare[anzElemente + 1] = new MapPaar<>(k, v);
        return null;
    }

    @Override
    public V remove(Object key) {
        for (int i = 0; i < paare.length; i++) {
            if (paare[i].getKey().equals(key)) {
                V v = paare[i].getValue();
                MapPaar<K, V>[] newArray = Arrays.copyOf(paare,
                  paare.length - 1);
                if (paare.length >= 2) {
                    System.arraycopy(paare, i + 1, newArray, i,
                      paare.length - (i + 1));
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
        Set<K> set = new HashSet<>();
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
        return new HashSet<>(Arrays.asList(paare));
    }

    public static class MapPaar<K, V> implements Map.Entry<K, V> {
        private final K key;
        private V value;

        public MapPaar(K key, V value) {
            if (key == null) {
                throw new IllegalArgumentException("Key darf nicht null sein");
            }
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

    private void verdoppeln() {
        paare = Arrays.copyOf(paare, paare.length * 2);
    }
}

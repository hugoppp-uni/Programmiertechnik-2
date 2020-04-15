package praktikum.aufgabe1.F;

import java.util.*;

/**
 * Implementation einer Map,
 * akzeptiert keine Null - Keys
 */

@SuppressWarnings({"unchecked", "NullableProblems"})
public class PM2Map<K, V> implements Map<K, V> {
    private Object[] paare;
    private int anzElemente;

    public PM2Map() {
        this.paare = new MapPaar[4];
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
    public boolean containsKey(Object k) {
        for (int i = 0; i < anzElemente; i++) {
            var aktuellerKey = ((MapPaar<K, V>) paare[i]).getKey();
            if (aktuellerKey.hashCode() == k.hashCode() &&
                aktuellerKey.equals(k)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(Object v) {
        for (int i = 0; i < anzElemente; i++) {
            var aktuellerValue = ((MapPaar<K, V>) paare[i]).getValue();
            if (aktuellerValue.hashCode() == v.hashCode() &&
                aktuellerValue.equals(v)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public V get(Object v) {
        for (int i = 0; i < anzElemente; i++) {
            var aktuellerKey = ((MapPaar<K, V>) paare[i]).getKey();
            if (aktuellerKey.hashCode() == v.hashCode() &&
                aktuellerKey.equals(v)) {
                return ((MapPaar<K, V>) paare[i]).getValue();
            }
        }
        return null;
    }

    @Override
    public V put(K k, V v) {
        if (containsKey(k)) {
            for (int i = 0; i < anzElemente; i++) {
                var aktuellerKey = ((MapPaar<K, V>) paare[i]).getKey();
                if (aktuellerKey.hashCode() == k.hashCode() &&
                    aktuellerKey.equals(k)) {
                    var alterValue = ((MapPaar<K, V>) paare[i]).getValue();
                    ((MapPaar<K, V>) paare[i]).setValue(v);
                    return alterValue;
                }
            }
        }
        if (anzElemente == paare.length) verdoppeln();
        paare[anzElemente] = new MapPaar<>(k, v);
        anzElemente++;
        return null;
    }

    @Override
    public V remove(Object k) {
        for (int i = 0; i < anzElemente; i++) {
            var aktuellerKey = ((MapPaar<K, V>) paare[i]).getKey();
            if (aktuellerKey.hashCode() == k.hashCode() &&
                aktuellerKey.equals(k)) {
                var alterValue = ((MapPaar<K, V>) paare[i]).getValue();
                var temp = Arrays.copyOf(paare, paare.length - 1);
                System.arraycopy(paare, i + 1, temp, i, paare.length - i - 1);
                paare = temp;
                anzElemente--;
                return alterValue;
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
        paare = new MapPaar[4];
        anzElemente = 0;
    }

    @Override
    public Set<K> keySet() {
        Set<K> set = new HashSet<>();
        for (int i = 0; i < anzElemente; i++) {
            var aktuellerKey = ((MapPaar<K, V>) paare[i]).getKey();
            set.add(aktuellerKey);
        }
        return set;
    }

    @Override
    public Collection<V> values() {

        Collection<V> c = new HashSet<>();
        for (int i = 0; i < anzElemente; i++) {
            var aktuellerValue = ((MapPaar<K, V>) paare[i]).getValue();
            c.add(aktuellerValue);
        }
        return c;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return new HashSet<>(Arrays.asList(Arrays.copyOf((MapPaar<K, V>[]) paare, anzElemente)));
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
            sb.append(((MapPaar<K, V>) paar).getKey()).append(" -> ").append(((MapPaar<K, V>) paar).getValue()).
              append('\n');
        }
        return sb.toString();
    }

    private void verdoppeln() {
        paare = Arrays.copyOf(paare, paare.length * 2);
    }
}

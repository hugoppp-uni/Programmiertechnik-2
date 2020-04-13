package praktikum.aufgabe1;

import java.util.*;

public class PM2Map<K, V> implements Map<K, V> {
    private int size = 0;
    private final Set<Entry<K, V>> entries = new HashSet<>();
    private final Set<K> keySet = new HashSet<>();
    private final Set<V> valueSet = new HashSet<>();

    private static class MapPaar<K, V> implements Map.Entry<K, V> {
        private final K key;
        private V value;

        public MapPaar(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        return keySet().contains(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return values().contains(value);
    }

    @Override
    public V get(Object key) {
        if (key == null) {
            throw new NullPointerException("can't be null");
        }
        for (Entry<K, V> entry : entries) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        V oldValue;
        for (Iterator<Entry<K, V>> it = entries.iterator(); it.hasNext(); ) {
            Entry<K, V> entry = it.next();
            if (entry.getKey().equals(key)) {
                oldValue = entry.getValue();
                entry.setValue(value);
                return oldValue;
            }
        }
        entries.add(new MapPaar<>(key, value));
        size++;
        return null;
    }

    @Override
    public V remove(Object key) {
        for (Iterator<Entry<K, V>> it = entries.iterator(); it.hasNext(); ) {
            Entry<K, V> entry = it.next();
            if (entry.getKey().equals(key)) {
                it.remove();
                size--;
                return entry.getValue();
            }
        }
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        for (Entry<? extends K, ? extends V> entry : m.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }

    }

    @Override
    public void clear() {
        entries.clear();
        keySet.clear();
        values().clear();
        size = 0;
    }

    @Override
    public Set<K> keySet() {
        for (Entry<K, V> entry : entries) {
            keySet.add(entry.getKey());
        }
        return keySet;
    }

    @Override
    public Collection<V> values() {
        for (Entry<K, V> entry : entries) {
            valueSet.add(entry.getValue());
        }
        return valueSet;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return entries;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Entry<K, V> entry : entries) {
            sb.append(entry.getKey()).append(" -> ").append(entry.getValue()).
              append('\n');
        }
        return sb.toString();
    }
}


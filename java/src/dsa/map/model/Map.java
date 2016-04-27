package dsa.map.model;

import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Created by JoseLlorens on 20/04/2016.
 */
public interface Map<K,V> {
    void clear();

    boolean containsKey(K key);

    boolean containsValue(V value);

    Set<MapEntry<K,V>> entrySet();

    boolean equals(Map other);

    V get(K key);

    int hashCode();

    boolean isEmpty();

    Set<K> keySet();

    V put(K key, V value);

    void putAll(Map<K,V> m);

    V remove (K key);

    int size();

    Collection<V> values();

    interface Factory{
        List<String> create();
    }


}


package com.generics.basics;

/**
 * İki tip parametreli generic sınıf: anahtar-değer çifti.
 * Clean code: K = key, V = value konvansiyonu.
 */
public class Pair<K, V> {
    private final K key;
    private final V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Pair{key=" + key + ", value=" + value + "}";
    }
}

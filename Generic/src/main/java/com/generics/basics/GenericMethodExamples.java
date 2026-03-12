package com.generics.basics;

import java.util.List;

/**
 * Generic metot örnekleri.
 * Clean code: Sadece metotta generic gerekiyorsa sınıfı generic yapmıyoruz.
 */
public final class GenericMethodExamples {

    private GenericMethodExamples() {
    }

    /**
     * Listenin ilk elemanını döner. T, metot düzeyinde tanımlı.
     */
    public static <T> T getFirst(List<T> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    /**
     * İki değeri bir Pair içinde döner.
     */
    public static <K, V> Pair<K, V> of(K key, V value) {
        return new Pair<>(key, value);
    }

    /**
     * Kutunun değerini döner; boşsa defaultValue.
     */
    public static <T> T getOrDefault(Box<T> box, T defaultValue) {
        return box != null && !box.isEmpty() ? box.get() : defaultValue;
    }
}

package com.generics.bounded;

/**
 * Çoklu bound örneği: T hem Number hem Comparable&lt;T&gt; olmalı.
 * Clean code: Sadece gerçekten ihtiyaç varsa çoklu bound kullan.
 */
public class BoundedExample<T extends Number & Comparable<T>> {

    public boolean isGreaterThan(T a, T b) {
        return a.compareTo(b) > 0;
    }

    public T max(T a, T b) {
        return a.compareTo(b) >= 0 ? a : b;
    }
}

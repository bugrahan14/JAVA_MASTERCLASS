package com.generics.bestpractices;

import java.util.ArrayList;
import java.util.List;

/**
 * Type erasure sonucu: List&lt;String&gt; ve List&lt;Integer&gt; runtime'da aynı sınıf.
 * Bkz. docs/05-type-erasure.md
 */
public class TypeErasureDemo {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        List<Integer> ints = new ArrayList<>();

        System.out.println("strings.getClass(): " + strings.getClass());
        System.out.println("ints.getClass(): " + ints.getClass());
        System.out.println("Aynı mı? " + (strings.getClass() == ints.getClass()));

        // Generic tip bilgisi runtime'da yok; sadece raw List görünür.
    }
}

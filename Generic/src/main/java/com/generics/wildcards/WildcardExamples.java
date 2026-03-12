package com.generics.wildcards;

import java.util.List;

/**
 * Unbounded ve upper bounded wildcard örnekleri.
 * Bkz. docs/04-wildcards-pecs.md
 */
public final class WildcardExamples {

    private WildcardExamples() {
    }

    /**
     * Unbounded wildcard: sadece okuma (size). Listeye eleman eklenemez.
     */
    public static void printSize(List<?> list) {
        System.out.println("Size: " + (list != null ? list.size() : 0));
    }

    /**
     * Upper bounded: List<? extends Number> — producer, sayıları okuruz.
     */
    public static double sum(List<? extends Number> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return 0.0;
        }
        double total = 0;
        for (Number n : numbers) {
            total += n.doubleValue();
        }
        return total;
    }

    /**
     * Lower bounded: List<? super Integer> — consumer, Integer yazarız.
     */
    public static void addNumbers(List<? super Integer> list) {
        if (list != null) {
            list.add(1);
            list.add(2);
            list.add(3);
        }
    }
}

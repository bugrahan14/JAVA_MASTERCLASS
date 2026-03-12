package com.generics.bounded;

/**
 * Sadece Number ve alt sınıflarıyla çalışan kutu.
 * T extends Number ile intValue(), doubleValue() gibi metotlar kullanılabilir.
 * Bkz. docs/03-bounded-types.md
 */
public class NumberBox<T extends Number> {
    private final T value;

    public NumberBox(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public int intValue() {
        return value.intValue();
    }

    public double doubleValue() {
        return value.doubleValue();
    }
}

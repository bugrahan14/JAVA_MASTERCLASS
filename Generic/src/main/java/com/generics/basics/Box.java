package com.generics.basics;

/**
 * Generic bir kutu: herhangi bir tipi (T) tutar.
 * Clean code: Anlamlı tip parametresi ismi (T = type).
 */
public class Box<T> {
    private T value;

    public void set(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }

    public boolean isEmpty() {
        return value == null;
    }
}

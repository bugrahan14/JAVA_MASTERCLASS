package com.generics.bestpractices;

import com.generics.basics.Box;

import java.util.function.Supplier;

/**
 * new T() yapılamaz (type erasure). Bunun yerine factory (Supplier&lt;T&gt;) kullanımı.
 * Bkz. docs/05-type-erasure.md
 */
public class FactoryPatternWithGenerics {

    /**
     * Verilen factory ile yeni bir kutu oluşturur.
     * T runtime'da bilinmediği için Supplier ile örnek alıyoruz.
     */
    public static <T> Box<T> createBox(Supplier<T> factory) {
        Box<T> box = new Box<>();
        box.set(factory.get());
        return box;
    }

    public static void main(String[] args) {
        Box<String> box = createBox(() -> "Hello");
        System.out.println(box.get());
    }
}

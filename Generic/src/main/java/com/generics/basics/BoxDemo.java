package com.generics.basics;

import java.util.ArrayList;
import java.util.List;

/**
 * Box&lt;T&gt; ve tip güvenli kullanım örneği.
 * Bkz. docs/01-why-generics.md, docs/02-basics.md
 */
public class BoxDemo {
    public static void main(String[] args) {
        Box<String> stringBox = new Box<>();
        stringBox.set("Merhaba");
        String s = stringBox.get();
        System.out.println("Box<String>: " + s);

        Box<Integer> intBox = new Box<>();
        intBox.set(42);
        Integer n = intBox.get();
        System.out.println("Box<Integer>: " + n);

        Pair<String, Integer> pair = new Pair<>("yaş", 25);
        System.out.println("Pair: " + pair);

        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        String first = GenericMethodExamples.getFirst(list);
        System.out.println("İlk eleman: " + first);
    }
}

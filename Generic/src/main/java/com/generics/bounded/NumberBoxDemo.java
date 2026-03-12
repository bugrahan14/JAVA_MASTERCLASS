package com.generics.bounded;

/**
 * NumberBox ve BoundedExample kullanım örneği.
 */
public class NumberBoxDemo {
    public static void main(String[] args) {
        NumberBox<Integer> ib = new NumberBox<>(42);
        System.out.println("intValue: " + ib.intValue());

        NumberBox<Double> db = new NumberBox<>(3.14);
        System.out.println("doubleValue: " + db.doubleValue());

        BoundedExample<Integer> comp = new BoundedExample<>();
        System.out.println("isGreaterThan(10, 5): " + comp.isGreaterThan(10, 5));
        System.out.println("max(10, 5): " + comp.max(10, 5));
    }
}

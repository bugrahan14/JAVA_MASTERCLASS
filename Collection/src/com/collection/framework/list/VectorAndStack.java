package com.collection.framework.list;

import java.util.*;

/**
 * VECTOR & STACK - TARİHİ YAPILAR
 * -------------------------------
 * Vector: ArrayList'e benzer ama thread-safe (synchronized). Güncel kodda genelde
 * ArrayList + gerekiyorsa Collections.synchronizedList veya ConcurrentHashMap vb. tercih edilir.
 *
 * Stack extends Vector: LIFO. Güncel kullanımda Deque (örn. ArrayDeque) ile
 * push/pop kullanmak önerilir: "Deque<Integer> stack = new ArrayDeque<>();"
 *
 * Clean code: Yeni projede Vector/Stack yerine ArrayList ve ArrayDeque kullan.
 */
public class VectorAndStack {

    public static void main(String[] args) {
        vectorBasics();
        stackLegacy();
        modernStackWithDeque();
    }

    private static void vectorBasics() {
        System.out.println("=== VECTOR TEMEL ===\n");
        Vector<String> v = new Vector<>();
        v.add("a");
        v.add("b");
        v.addElement("c"); // Vector'e özgü (add ile aynı)
        System.out.println("Vector: " + v);
        System.out.println("capacity (varsayılan büyüme 2x): " + v.capacity());
    }

    private static void stackLegacy() {
        System.out.println("\n=== STACK (LEGACY) ===\n");
        Stack<String> stack = new Stack<>();
        stack.push("1");
        stack.push("2");
        stack.push("3");
        System.out.println("pop: " + stack.pop());
        System.out.println("peek: " + stack.peek());
        System.out.println("kalan: " + stack);
    }

    private static void modernStackWithDeque() {
        System.out.println("\n=== MODERN STACK: ArrayDeque ===\n");
        Deque<String> stack = new ArrayDeque<>();
        stack.push("1");
        stack.push("2");
        stack.push("3");
        System.out.println("pop: " + stack.pop());
        System.out.println("peek: " + stack.peek());
        System.out.println("kalan: " + stack);
    }
}

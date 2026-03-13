package com.generics.wildcards;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * PECS (Producer Extends, Consumer Super) kullanım örneği.
 */
public class PECSDemo {
    public static void main(String[] args) {
        List<Integer> ints = Arrays.asList(1, 2, 3);
        List<Double> doubles = Arrays.asList(1.0, 2.0, 3.0);

        System.out.println("sum(ints): " + WildcardExamples.sum(ints));
        System.out.println("sum(doubles): " + WildcardExamples.sum(doubles));

        List<Number> numbers = new ArrayList<>();
        WildcardExamples.addNumbers(numbers);
        System.out.println("addNumbers -> " + numbers);

        List<Integer> dest = new ArrayList<>();
        CopyLikeUtility.copy(dest, ints);
        System.out.println("copy: " + dest);
    }
}

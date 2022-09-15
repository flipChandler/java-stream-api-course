package com.amigoscode.examples;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

public class MinMax {

    @Test
    public void min() {
        List<Integer> numbers = List.of(1, 2, 3, 100, 23, 93, 99);

        Integer min = numbers.stream()
                .min(Integer::compareTo)
                .get();
        System.out.println(min);

        Integer min2 = numbers.stream()
                .min(Comparator.naturalOrder())
                .get();
        System.out.println(min2);   // 1
    }

    @Test
    public void max() {
        List<Integer> numbers = List.of(1, 2, 3, 100, 23, 93, 99);

        Integer max = numbers.stream()
                .max(Integer::compareTo)
                .get();
        System.out.println(max);

        Integer max2 = numbers.stream()
                .max(Comparator.naturalOrder())
                .get();
        System.out.println(max2);   // 100
    }
}

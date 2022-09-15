package com.amigoscode.examples;


import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class DistinctAndSets {

    @Test
    public void distinct() {
        List<Integer> numbers = List.of(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 9, 9, 9);

        List<Integer> distincts = numbers.stream()
                .distinct()
                .collect(Collectors.toList());

        distincts.forEach(System.out::println);

        assertThat(distincts).hasSize(9);
    }

    @Test
    public void distinctWithSet() {
        List<Integer> numbers = List.of(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 9, 9, 9);

        Set<Integer> distincts = numbers.stream()
                .collect(Collectors.toSet());
        distincts.forEach(System.out::println);

        Set<Integer> distincts2 = new HashSet<>(numbers);

        assertThat(distincts).hasSize(9);
        assertThat(distincts2).hasSize(9);
    }
}

package com.amigoscode.examples;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TransformationsWithFlatMap {

    private static final List<List<String>> arrayListOfNames = List.of(
            List.of("Mariam", "Alex", "Ismail"),
            List.of("John", "Alesha", "Andre"),
            List.of("Susy", "Ali")
    );

    @BeforeEach
    void setUp() {
        System.out.println(arrayListOfNames);
    }

    @Test
    public void withoutFlatMap() throws Exception {
        // [Mariam, Alex, Ismail, John, Alesha, Andre, Susy, Ali]
        List<String> names = new ArrayList<>();

        arrayListOfNames.forEach(names::addAll);

        System.out.println(names);
    }

    @Test
    public void withFlatMap() throws Exception {
        // [Mariam, Alex, Ismail, John, Alesha, Andre, Susy, Ali]
        Function<List<String>, Stream<? extends String>> stream = list -> list.stream();

        List<String> names = arrayListOfNames.stream()
                .flatMap(stream)
                .collect(Collectors.toList());

        List<String> names2 = arrayListOfNames.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());

        System.out.println(names);
        System.out.println(names2);
    }

    @Test
    public void flatMapWithOptionals() {
        List<Optional<String>> optionals = List.of(
                Optional.of("Amigos"),
                Optional.of("Code")
        );

        Function<Optional<String>, Stream<? extends String>> stream = optional -> optional.stream();

        List<String> list = optionals.stream()
                .flatMap(stream)
                .collect(Collectors.toList());

        List<String> list2 = optionals.stream()
                .flatMap(Optional::stream)
                .collect(Collectors.toList());

        System.out.println(list);
        System.out.println(list2);
    }

    @Test
    public void flatMapWithSet() {
        Set<Set<String>> setListOfNames = Set.of(
                Set.of("Amigos", "Code"),
                Set.of("Get", "Arrays"));

        Function<Set<String>, Stream<? extends String>> stream = set -> set.stream();

        List<String> list = setListOfNames.stream()
                .flatMap(stream)
                .collect(Collectors.toList());

        Set<String> set = setListOfNames.stream()
                .flatMap(Set::stream)
                .collect(Collectors.toSet());

        System.out.println(list);
        System.out.println(set);
    }
}


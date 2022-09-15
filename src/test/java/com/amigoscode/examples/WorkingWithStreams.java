package com.amigoscode.examples;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WorkingWithStreams {

    @Test
    void streams() {
        List<String> names = List.of("Amigoscode", "Alex", "Zara");
        Stream<String> stream = names.stream();

        Stream<String> stream2 = Stream.of("Amigoscode", "Alex", "Zara");

        List<Object> objects = stream
                .limit(2).map(null).sorted(null).dropWhile(null).filter(null).flatMap(null) // intermediate operator
                .collect(Collectors.toList());// final operator | count() | average() | findFirst()

        String[] namesArray = {};
        Arrays.stream(namesArray);
    }
}

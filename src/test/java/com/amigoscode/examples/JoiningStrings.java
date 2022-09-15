package com.amigoscode.examples;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

public class JoiningStrings {

    @Test
    public void joiningStrings() {
        List<String> names = List.of("anna", "john", "marcos", "helena", "yasmin");

        StringBuilder nameConcat = new StringBuilder();
        for (String name : names) {
            nameConcat.append(name.substring(0, 1).toUpperCase())
                    .append(name.substring(1))
                    .append(", ");
        }

        // System.out.println(nameConcat.replace(nameConcat.length() - 2, nameConcat.length(), ""));
        System.out.println(nameConcat.substring(0, nameConcat.length() - 2));   // "Anna, John, Marcos, Helena, Yasmin"
    }

    @Test
    public void joiningStringsWithStream() {
        List<String> names = List.of("anna", "john", "marcos", "helena", "yasmin");

        String nameConcat = names.stream()
                .map(name -> {
                    StringBuilder nameBuilder = new StringBuilder();
                    return nameBuilder
                            .append(name.substring(0, 1).toUpperCase())
                            .append(name.substring(1));
                })
                .collect(Collectors.joining(", "));

        System.out.println(nameConcat); // "Anna, John, Marcos, Helena, Yasmin"
    }
}

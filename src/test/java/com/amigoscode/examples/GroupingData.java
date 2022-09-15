package com.amigoscode.examples;


import com.amigoscode.beans.Car;
import com.amigoscode.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupingData {

    @Test
    public void simpleGrouping() throws Exception {
        List<Car> list = MockData.getCars();

        Map<String, List<Car>> map = list.stream()
                .collect(Collectors.groupingBy(Car::getMake));

        map.forEach((make, cars) -> {
            System.out.println("Make " + make);
            cars.forEach(System.out::println);
            System.out.println("-----------------------------------");
        });
    }
    @Test
    public void groupingAndCounting() throws Exception {
        List<String> names = List.of(
                "John",
                "John",
                "Mariam",
                "Alex",
                "Mohammado",
                "Mohammado",
                "Vincent",
                "Alex",
                "Alex"
        );

        Map<String, Long> map = names.stream()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()));
        System.out.println(map);

        Map<String, Long> map2 = names.stream()
                .collect(Collectors.groupingBy(name -> name, Collectors.counting()));

        map2.forEach((name, count) -> {
            System.out.println(name + " = " + count);
        });
    }
}
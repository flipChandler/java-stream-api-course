package com.amigoscode.examples;

import com.amigoscode.beans.Car;
import com.amigoscode.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Filtering {

    @Test
    public void filter() throws Exception {
        List<Car> cars = MockData.getCars();

        Predicate<Car> carPredicate = car -> car.getPrice() < 20_000.00;
        Predicate<Car> yellow = car -> car.getColor().equals("Yellow");

        List<Car> carsLessThan20k = cars.stream()
                .filter(carPredicate)
                .filter(yellow)
                .collect(Collectors.toList());

        carsLessThan20k.forEach(System.out::println);
    }

    @Test
    public void dropWhile() {
        System.out.println("using filter");
        Stream.of(2, 4, 6, 8, 9, 10, 12)
                .filter(number -> number % 2 == 0)
                .forEach(number -> System.out.print(number + " ")); // 2 4 6 8 10 12

        System.out.println();
        System.out.println("using dropWhile");
        Stream.of(2, 4, 6, 8, 9, 10, 12)
                .dropWhile(number -> number % 2 == 0)
                .forEach(number -> System.out.print(number + " ")); // 9 10 12 | drop values until 9, then print the rest
    }

    @Test
    public void takeWhile() {
        // using filter
        System.out.println("using filter");
        Stream.of(2, 4, 6, 8, 9, 10, 12)
                .filter(number -> number % 2 == 0)
                .forEach(number -> System.out.print(number + " ")); // 2 4 6 8 10 12

        System.out.println();
        System.out.println("using take while");
        Stream.of(2, 4, 6, 8, 9, 10, 12)
                .takeWhile(number -> number % 2 == 0)
                .forEach(number -> System.out.print(number + " ")); // 2 4 6 8 | skip values after 9, cause it's not even
    }

    @Test
    public void findFirst() {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int result = Arrays.stream(numbers)
                .filter(number -> number == 9)
                .findFirst()
                .orElse(-1);    // default value

        System.out.println(result);
    }

    @Test
    public void findAny() {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 10};

        int result = Arrays.stream(numbers)
                .filter(number -> number == 9)
                .findAny()
                .orElse(-1);    // default value

        System.out.println(result);
    }

    @Test
    public void allMatch() {
        int[] evenNumbers = {2, 4, 6, 8, 10};

        boolean allMatch = Arrays.stream(evenNumbers)
                .allMatch(number -> number % 2 == 0);

        System.out.println(allMatch);   // true
    }

    @Test
    public void anyMatch() {
        int[] allEvenAndOneOdd = {2, 4, 6, 8, 10, 11};

        boolean anyMatch = Arrays.stream(allEvenAndOneOdd)
                .anyMatch(number -> number % 2 != 0);

        System.out.println(anyMatch);   // true
    }

    @Test
    public void noneMatch() {
        int[] allOdd = {1, 3, 5, 7, 9, 11};

        boolean noneMatch = Arrays.stream(allOdd)
                .noneMatch(number -> number % 2 == 0);

        System.out.println(noneMatch);   // true
    }
}




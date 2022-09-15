package com.amigoscode.examples;


import com.amigoscode.beans.Person;
import com.amigoscode.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.*;

public class IntStreams {

    @Test
    public void range() {
        System.out.println("loop with for");
        for (int i = 0; i < 11; i++) {
            System.out.println(i);
        }

        System.out.println("loop with stream exclusive");
        IntStream.range(0, 10).forEach(System.out::println); // 0 .. 9

        System.out.println("loop with stream inclusive");
        IntStream.rangeClosed(0, 10).forEach(System.out::println); // 0 .. 10
    }

    // Loop through people using IntStream
    @Test
    public void rangeIteratingLists() throws Exception {
        List<Person> people = MockData.getPeople();
        IntStream.range(0, people.size())
                .forEach(index -> {
                    System.out.println(people.get(index));
                });
    }

    @Test
    public void intStreamIterate()  {
        IntStream.iterate(1, value -> value + 1) // 1; 1 + 1; 2 + 1; 3 + 1
                .limit(10)
                .forEach(System.out::println); // 1.. 10

        DoubleStream.iterate(1.0, value -> value * 3)   // 1; 1 * 3; 3 * 3; 9 * 3
                .limit(11)
                .forEach(System.out::println); // 1.0, 3.0 .. 59049.0
    }

    @Test
    public void intStreamWithBoxed() {
        List<Integer> result = IntStream
                .rangeClosed(1, 10)
                .boxed()    // to convert in a list
                .collect(Collectors.toList());

        System.out.println(result);
    }

    @Test
    public void streamWithArray() {
        List<Integer> list = IntStream
                .rangeClosed(1, 10)
                .boxed()    // to convert in a list
                .collect(Collectors.toList());
        System.out.println(list);   // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

        int[] array = list
                .stream()
                .mapToInt(a -> a)
                .toArray();

        System.out.println(array[3]);           // 4
        System.out.println(array.toString());   // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    }

    @Test
    public void intStreamOfWithArray() {
        int[] age = {50, 20, 30, 15, 60};
        OptionalDouble average1 = IntStream.of(age).average();
        System.out.println("average age: "+ average1.getAsDouble());

        System.out.println("--------");

        IntStream ageStream = Arrays.stream(age);
        OptionalDouble average2 = ageStream.average();
        System.out.println("average age: "+ average2.getAsDouble());
    }

    @Test
    public void intStreamOfWithMin() {
        OptionalInt min = IntStream.of(1, 2, 3, 4, 5).min();
        System.out.println(min.getAsInt()); // 1
    }

    @Test
    public void intStreamOfWithMax() {
        OptionalInt max = IntStream.of(1, 2, 3, 4, 5).max();
        System.out.println(max.getAsInt()); // 5
    }

    @Test
    public void intStreamOfWithSum() {
        int sum = IntStream.of(1, 2, 3, 4, 5).sum();
        System.out.println(sum); // 15
    }

    @Test
    public void intStreamOfWithToArray() {
        int[] array = IntStream.of(1, 2, 3, 4, 5).toArray();
        System.out.println(Arrays.toString(array)); // [1, 2, 3, 4, 5]
    }

    @Test
    public void intStreamOfWithAsLongStream() {
        int[] id = {12, 345, 566, 33};
        LongStream longStream = IntStream.of(id).asLongStream();
        longStream.forEach(number -> System.out.print(number + " "));  // 12 345 566 33
    }

    @Test
    public void intStreamWithChar() {
        char[] chars = {'a', 'b', 'c', 'a'};

        Stream<Character> charStream = IntStream.rangeClosed(0, chars.length - 1)
                .mapToObj(a -> chars[a]);

        charStream.distinct()
                .forEach(character -> System.out.print(character + " "));  // a b c
    }
}

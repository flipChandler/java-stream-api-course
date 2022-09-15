package com.amigoscode.examples;

import com.amigoscode.beans.Person;
import com.amigoscode.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UnderstandingStreams {

    @Test
    void collect() throws IOException {
        List<String> emails = MockData.getPeople()
                .stream()
                .map(Person::getEmail)
                .collect(
                        () -> new ArrayList<>(),                // Supplier<List<String>> supplier
                        (list, element) -> list.add(element),   // BiConsumer<List<String>, ? super String> accumulator | how we add to our list
                        (list1, list2) -> list1.addAll(list2)   // BiConsumer<List<String>, List<String>> combiner  | given 2 lists how we combine this 2 lists together
                );
        emails.forEach(System.out::println);
    }

    @Test
    void collect2() throws IOException {
        List<String> emails = MockData.getPeople()
                .stream()
                .map(Person::getEmail)
                .collect(
                        ArrayList::new,
                        ArrayList::add,
                        ArrayList::addAll
                );                      // Collectors.toList()
        emails.forEach(System.out::println);
    }

    @Test
    public void lazy() throws Exception {
        System.out.println(
                MockData.getCars()
                        .stream()
                        .filter(car -> {
                            System.out.println("filter car " + car);
                            return car.getPrice() < 10000;
                        })
                        .map(car -> {
                            System.out.println("mapping car " + car);
                            return car.getPrice();
                        })
                        .map(price -> {
                            System.out.println("mapping price " + price);
                            return price + (price * .14);
                        })
                        .collect(Collectors.toList())
        );
    }
}

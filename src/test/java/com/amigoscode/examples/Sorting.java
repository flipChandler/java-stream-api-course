package com.amigoscode.examples;

import com.amigoscode.beans.Car;
import com.amigoscode.beans.Person;
import com.amigoscode.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Sorting {

    @Test
    public void sortingStreamOfElements() throws IOException {
        List<Person> people = MockData.getPeople();

        List<String> sortedByFirstName = people.stream()
                .map(Person::getFirstName)
                .sorted()
                .collect(Collectors.toList());

        sortedByFirstName.forEach(System.out::println);
    }

    @Test
    public void sortingStreamOfElementsReverse() throws IOException {
        List<Person> people = MockData.getPeople();

        Comparator<String> comparator = Comparator.reverseOrder();

        List<String> sortedByFirstName = people.stream()
                .map(Person::getFirstName)
                .sorted(comparator)
                .collect(Collectors.toList());

        sortedByFirstName.forEach(System.out::println);
    }

    @Test
    public void sortingStreamOfObjets() throws IOException {
        List<Person> people = MockData.getPeople();

        List<Person> sortedPeople = people.stream()
                .sorted(Comparator.comparing(Person::getFirstName)
                        .thenComparing(Person::getEmail)
                        .reversed())
                .collect(Collectors.toList());

        sortedPeople.forEach(System.out::println);
    }

    @Test
    public void topTenMostExpensiveBlueCars() throws IOException {
        List<Car> cars = MockData.getCars();

        List<Car> top10MostExpensiveBlueCars = cars.stream()
                .filter(car -> car.getColor().equalsIgnoreCase("blue"))
                .sorted(Comparator.comparing(Car::getPrice)
                        .reversed())
                .limit(10)
                .collect(Collectors.toList());

        top10MostExpensiveBlueCars.forEach(System.out::println);
    }

}

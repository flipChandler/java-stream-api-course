package com.amigoscode.examples;

import com.amigoscode.beans.Car;
import com.amigoscode.beans.Person;
import com.amigoscode.beans.PersonDTO;
import com.amigoscode.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class TransformationsMapAndReduce {

    @Test
    void yourFirstTransformationWithMap() throws IOException {
        List<Person> people = MockData.getPeople();

        Function<Person, PersonDTO> dtoFunction = person -> new PersonDTO(
                person.getId(),
                person.getFirstName(),
                person.getAge());

        List<PersonDTO> dtos = people.stream()
                .filter(person -> person.getAge() > 18)
                .map(dtoFunction)
                .collect(Collectors.toList());

        List<PersonDTO> dtos2 = people.stream()
                .filter(person -> person.getAge() > 18)
                .map(PersonDTO::of)
                .collect(Collectors.toList());

        dtos.forEach(System.out::println);
        dtos2.forEach(System.out::println);
    }

    @Test
    void mapToDoubleAndFindAverageCarPrice() throws IOException {
        List<Car> cars = MockData.getCars();

        double averageCarPrice = cars.stream()
                .mapToDouble(car -> car.getPrice())
                .average()
                .getAsDouble();

        System.out.println(averageCarPrice);

        double averageYellowCarPrice = cars.stream()
                .filter(car -> car.getColor().equalsIgnoreCase("yellow"))
                .mapToDouble(Car::getPrice)
                .average()
                .orElse(0.0);

        System.out.println("average yellow car price: " + averageYellowCarPrice);

        List<Car> yellowCars = cars.stream()
                .filter(car -> car.getColor().equalsIgnoreCase("yellow"))
                        .collect(Collectors.toList());

        yellowCars.forEach(System.out::println);
    }

    @Test
    public void reduce() {
        int[] integers = {1, 2, 3, 4, 99, 100, 121, 1302, 199};

        int reduceSum = Arrays.stream(integers).reduce(0, (a, b) -> a + b);
        int reduceSum2 = Arrays.stream(integers).reduce(0, Integer::sum);
        int reduceSub = Arrays.stream(integers).reduce(0, (a, b) -> a - b);
        int reduceMult = Arrays.stream(integers).reduce(1, (a, b) -> a * b);

        System.out.println(reduceSum);
        System.out.println(reduceSum2);
        System.out.println(reduceSub);
        System.out.println(reduceMult);
    }
}


package com.amigoscode.examples;

import com.amigoscode.beans.Car;
import com.amigoscode.beans.Person;
import com.amigoscode.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class Collect {

    @Test
    void addCarInAListUsingAddGenericObjectMethod() throws Exception {
        List<Car> list = MockData.getCars();

        Car car = new Car(1001,
                "Ford",
                "Ka",
                "Black",
                2020,
                35_000.00);

        addGenericObject(list, Stream.of(car));

        assertThat(list.get(1000))
                .extracting("id", "make", "model", "color", "price", "year")
                .containsExactly(1001, "Ford", "Ka", "Black", 35_000.00, 2020);

    }

    @Test
    void addPersonInAListUsingAddGenericObjectMethod() throws Exception {
        List<Person> list = MockData.getPeople();

        Person person = new Person(1001,
                "Chris",
                "Cornell",
                "chris@gmail.com",
                "male",
                35);

        addGenericObject(list, Stream.of(person));

        assertThat(list.get(1000))
                .extracting("id", "firstName", "lastName", "email", "gender", "age")
                .containsExactly(1001, "Chris", "Cornell", "chris@gmail.com", "male", 35);

    }

    private <T> void addGenericObject(List<T> list, Stream<T> streamObject) {
        streamObject.collect(Collectors.toCollection(() -> list));
    }
}

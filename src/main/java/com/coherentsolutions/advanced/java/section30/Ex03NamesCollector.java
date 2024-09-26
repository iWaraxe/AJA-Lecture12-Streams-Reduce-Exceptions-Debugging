package com.coherentsolutions.advanced.java.section30;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Demonstrates collecting names from a list of Person objects into a List.
 */
public class Ex03NamesCollector {

    /**
     * Main method to execute the names collector example.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // List of people
        List<Person> people = Arrays.asList(
                new Person("Alice"),
                new Person("Bob"),
                new Person("Charlie")
        );

        // Collect names into a list
        List<String> names = people.stream()
                .map(Person::getName)              // Extract names using method reference
                .collect(Collectors.toList());     // Collect names into a List

        // Output the result
        System.out.println("Names: " + names);
    }
}

/**
 * Represents a person with a name.
 */
class Person {
    private String name;

    /**
     * Constructs a new Person with the given name.
     *
     * @param name The name of the person.
     */
    public Person(String name) {
        this.name = name;
    }

    /**
     * Retrieves the name of the person.
     *
     * @return The person's name.
     */
    public String getName() {
        return name;
    }
}

// Topic: The Stream API
// Demonstrates: Stream operations, lambda expressions, filter/map/reduce/collect/sorted

import java.util.*;
import java.util.stream.*;

public class StreamAPIDemo {

    record Person(String name, int age, String city) {}

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
            new Person("Alice",   30, "Delhi"),
            new Person("Bob",     25, "Mumbai"),
            new Person("Charlie", 35, "Delhi"),
            new Person("Diana",   28, "Pune"),
            new Person("Eve",     22, "Mumbai"),
            new Person("Frank",   40, "Delhi")
        );

        // filter + map + collect
        System.out.println("=== Names of Delhi residents over 28 ===");
        List<String> delhiAdults = people.stream()
            .filter(p -> p.city().equals("Delhi") && p.age() > 28)
            .map(Person::name)
            .sorted()
            .collect(Collectors.toList());
        System.out.println(delhiAdults);

        // count
        long mumbaiCount = people.stream()
            .filter(p -> p.city().equals("Mumbai"))
            .count();
        System.out.println("\nMumbai residents: " + mumbaiCount);

        // average age
        OptionalDouble avgAge = people.stream()
            .mapToInt(Person::age)
            .average();
        System.out.println("Average age: " + avgAge.orElse(0));

        // min and max
        Optional<Person> youngest = people.stream()
            .min(Comparator.comparingInt(Person::age));
        Optional<Person> oldest   = people.stream()
            .max(Comparator.comparingInt(Person::age));
        System.out.println("Youngest: " + youngest.map(Person::name).orElse("None"));
        System.out.println("Oldest  : " + oldest.map(Person::name).orElse("None"));

        // groupingBy
        System.out.println("\n=== Group by City ===");
        Map<String, List<Person>> byCity = people.stream()
            .collect(Collectors.groupingBy(Person::city));
        byCity.forEach((city, persons) -> {
            System.out.println(city + ": " +
                persons.stream().map(Person::name).collect(Collectors.joining(", ")));
        });

        // reduce
        int sumAges = people.stream()
            .mapToInt(Person::age)
            .reduce(0, Integer::sum);
        System.out.println("\nSum of ages: " + sumAges);

        // distinct, limit, skip
        System.out.println("\n=== Distinct cities ===");
        people.stream()
            .map(Person::city)
            .distinct()
            .sorted()
            .forEach(System.out::println);

        // Number stream example
        System.out.println("\n=== Numbers 1-10: squares of evens ===");
        IntStream.rangeClosed(1, 10)
            .filter(n -> n % 2 == 0)
            .map(n -> n * n)
            .forEach(n -> System.out.print(n + " "));
        System.out.println();

        // String joining
        String joined = people.stream()
            .map(Person::name)
            .collect(Collectors.joining(", ", "[", "]"));
        System.out.println("\nAll names: " + joined);
    }
}

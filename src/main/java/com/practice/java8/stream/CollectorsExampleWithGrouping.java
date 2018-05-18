package com.practice.java8.stream;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by rsinghal on 5/10/2018.
 */
public class CollectorsExampleWithGrouping {

    public static void main(String arr[]) throws IOException {
        groupAndSortingSimple();
        //groupbySingleFieldsSimpleGroupCount();
        /*groupbySingleFields();
        groupbyMultipleFields();
        groupbyMultipleFieldsAndCollectingIntoSet();*/
        //groupbyMultipleFieldsAndSummarizing();
        // groupbyMultipleFieldsAndCollectingIntoSetWithSpecificField();

        groupbySingleFields1();
    }

    public static void groupAndSortingSimple() {
        List<String> items =
                Arrays.asList("apple", "apple", "banana",
                        "apple", "orange", "banana", "papaya");

        Map<String, Long> result =
                items.stream().collect(
                        Collectors.groupingBy(
                                Function.identity(), Collectors.counting()
                        )
                );

        Map<String, Long> finalMap = new LinkedHashMap<>();

        //like this or below
        result.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getValue,Comparator.reverseOrder())).forEach(e->{
            finalMap.put(e.getKey(), e.getValue());
        });
        System.out.println(finalMap);

        //Sort a map and add to finalMap
        result.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));

        System.out.println(finalMap);

    }

    public static void groupbySingleFieldsSimpleGroupCount() throws IOException {
        try (Stream<String> line = Files.lines(Paths.get("C:\\Users\\rsinghal\\IdeaProjects\\Java8\\src\\main\\resources\\TextFile"))) {
            Map<String, Long> counting = line
                    .map(name -> {
                        String[] tokens = name.split("\\s+");
                        return new Employee(tokens[0], Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]));
                    })
                    .collect(Collectors.groupingBy(Employee::getName, Collectors.counting()));

            System.out.println(counting);
        }
    }

    public static void groupbySingleFields() throws IOException {
        try (Stream<String> line = Files.lines(Paths.get("C:\\Users\\rsinghal\\IdeaProjects\\Java8\\src\\main\\resources\\TextFile"))) {
            Map<String,Long> counting = line
                    .map(name -> {
                        String[] tokens = name.split("\\s+");
                        return new Employee(tokens[0], Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]));
                    })
                    .collect(Collectors.groupingBy(Employee::getName,Collectors.counting()));

            System.out.println(counting);
        }
    }



    public static void groupbyMultipleFields() throws IOException {
        try (Stream<String> line = Files.lines(Paths.get("C:\\Users\\rsinghal\\IdeaProjects\\Java8\\src\\main\\resources\\TextFile"))) {
            Map<List<String>, List<Employee>> counting = line
                    .map(name -> {
                        String[] tokens = name.split("\\s+");
                        return new Employee(tokens[0], Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]));
                    })
                    .collect(Collectors.groupingBy(e -> {
                        return new ArrayList<String>(Arrays.asList(String.valueOf(e.getAge()), String.valueOf(e.getSalary())));
                    }));

            System.out.println(counting);
        }
    }

    public static void groupbyMultipleFieldsAndCollectingIntoSet() throws IOException {
        try (Stream<String> lines = Files.lines(Paths.get("C:\\Users\\rsinghal\\IdeaProjects\\Java8\\src\\main\\resources\\TextFile"))) {
            Map<List<String>, Set<Employee>> counting = lines
                    .map(line -> {
                        String[] tokens = line.split("\\s+");
                        return new Employee(tokens[0], Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]));
                    })
                    .collect(Collectors.groupingBy(e -> {
                        return new ArrayList<String>(
                                Arrays.asList(
                                        String.valueOf(e.getAge()),
                                        String.valueOf(e.getSalary())
                                )
                        );
                    }, Collectors.toSet()));
            System.out.println(counting);
        }
    }

    public static void groupbyMultipleFieldsAndCollectingIntoSetWithSpecificField() throws IOException {
        try (Stream<String> lines = Files.lines(Paths.get("C:\\Users\\rsinghal\\IdeaProjects\\Java8\\src\\main\\resources\\TextFile"))) {
            Map<List<String>, Set<String>> counting = lines
                    .map(line -> {
                        String[] tokens = line.split("\\s+");
                        return new Employee(tokens[0], Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]));
                    })
                    .collect(Collectors.groupingBy(e -> {
                        return new ArrayList<String>(
                                Arrays.asList(
                                        String.valueOf(e.getAge()),
                                        String.valueOf(e.getSalary())
                                )
                        );
                    }, Collectors.mapping(Employee::getName, Collectors.toSet())));
            System.out.println(counting);
        }
    }

    public static void groupbyMultipleFieldsAndSummarizing() throws IOException {
        try (Stream<String> lines = Files.lines(Paths.get("C:\\Users\\rsinghal\\IdeaProjects\\Java8\\src\\main\\resources\\TextFile"))) {
            Map<List<String>, Integer> counting = lines
                    .map(line -> {
                        String[] tokens = line.split("\\s+");
                        return new Employee(tokens[0], Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]));
                    })
                    .collect(Collectors.groupingBy(e -> {
                        return new ArrayList<String>(
                                Arrays.asList(
                                        String.valueOf(e.getAge()),
                                        String.valueOf(e.getSalary())
                                )
                        );
                    }, Collectors.summingInt(Employee::getSalary)));
            System.out.println(counting);
        }
    }


    public static void groupbySingleFields1() throws IOException {
        try (Stream<String> line = Files.lines(Paths.get("C:\\Users\\rsinghal\\IdeaProjects\\Java8\\src\\main\\resources\\TextFile"))) {
            Map<List<String>,Set<String>> m =
                    line.map(l->{
                        String[] tokens = l.split("\\s+");
                        return new Employee(tokens[0], Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]));
                    }) .collect(Collectors.groupingBy(e -> {
                        return new ArrayList<String>(
                                Arrays.asList(
                                        String.valueOf(e.getAge()),
                                        String.valueOf(e.getSalary())
                                )
                        );
                    }, Collectors.mapping(Employee::getName, Collectors.toSet())));
            System.out.println(m);
        }
    }

}

class Employee {
    String name;
    int age;
    int salary;
    int exp;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public Employee(String name, int age, int salary, int exp) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.exp = exp;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", exp=" + exp +
                '}';
    }
}
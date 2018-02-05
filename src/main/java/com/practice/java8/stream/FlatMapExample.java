package com.practice.java8.stream;

/**
 * Created by rsinghal on 2/5/2018.
 */

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * The flatMap() method takes each element in the stream and makes any elements it contains
 * top-level elements in a single stream i.e take element and make it first element of other steam
 *
 */

public class FlatMapExample {

    public static void main(String[] args) {

        List<String> zero = Arrays.asList();
        List<String> one = Arrays.asList("Bonobo");
        List<String> two = Arrays.asList("Mama Gorilla", "Baby Gorilla");
        Stream<List<String>> animals = Stream.of(zero, one, two);
        animals.flatMap(l -> l.stream()).forEach(System.out::println);

    }
}

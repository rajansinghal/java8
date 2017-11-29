package com.practice.java8.stream;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by rsinghal on 11/23/2017.
 */
public class Example4 {
    public static void main(String[] args) {
        Stream.generate(() -> "1")
        .limit(10)
        .peek(System.out::println)
        .filter(x -> x.length() > 1)
        .forEach(System.out::println);

        Stream.iterate(1, x -> x++).limit(5).map(x -> x).forEach(System.out::println);//.collect(Collectors.joining());

    }
}

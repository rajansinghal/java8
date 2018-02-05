package com.practice.java8.stream;

import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Created by rsinghal on 2/4/2018.
 */
public class InfinteStreamWithSupplier {

    public static void main(String[] args) {

        Stream<String> infinite = Stream.generate(() -> "chimp");
        infinite.findAny().ifPresent(System.out::println); // chimp
    }

}

class InfinteStreamWithPredicate {


    public static void main(String[] args) {
        Stream<String> infinite = Stream.generate(() -> "chimp");
        Predicate<String> pred = x -> Character.isLetter(x.charAt(0));
        System.out.println(infinite.anyMatch(pred)); // true
    }

}
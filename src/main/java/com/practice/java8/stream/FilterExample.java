package com.practice.java8.stream;

import java.util.stream.Stream;

/**
 * Created by rsinghal on 2/5/2018.
 */
public class FilterExample {

    public static void main(String[] args) {
        Stream<String> s = Stream.of("monkey", "gorilla", "bonobo");
        s.filter(x -> x.startsWith("m")).forEach(System.out::print);




    }

}

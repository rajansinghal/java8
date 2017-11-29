package com.practice.java8.stream;

import java.util.stream.Stream;

/**
 * Created by rsinghal on 11/22/2017.
 */
public class Example1 {
    public static void main(String[] args) {
        Stream<String> stream = Stream.iterate("", (s) -> s + "1");
        System.out.println(stream.limit(2).map(x -> x + "2"));
    }
}

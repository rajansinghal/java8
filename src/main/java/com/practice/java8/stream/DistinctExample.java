package com.practice.java8.stream;

import java.util.stream.Stream;

/**
 * Created by rsinghal on 2/5/2018.
 */
public class DistinctExample {

    public static void main(String[] args) {
        Stream<String> s = Stream.of("duck", "duck", "duck", "goose");
        s.distinct().forEach(System.out::print); // duckgoose
    }
}

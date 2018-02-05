package com.practice.java8.stream;

import java.util.stream.Stream;

/**
 * Created by rsinghal on 2/5/2018.
 */

//<R> Stream<R> map(Function<? super T, ? extends R> mapper)
public class MapExample {

    public static void main(String[] args) {
        Stream<String> s = Stream.of("monkey", "gorilla", "bonobo");
        s.map(String::length).forEach(System.out::print); // 676
    }
}

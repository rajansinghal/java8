package com.practice.java8.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by rsinghal on 11/23/2017.
 */
public class Example8 {
    public static void main(String[] args) {
        List<Integer> l = IntStream.range(1, 6)
                .mapToObj(i -> i).collect(Collectors.toList());
        l.forEach(System.out::println);
    }
}

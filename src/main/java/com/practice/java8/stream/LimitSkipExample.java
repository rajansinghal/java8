package com.practice.java8.stream;

import java.util.stream.Stream;

/**
 * Created by rsinghal on 2/5/2018.
 */
public class LimitSkipExample {

    public static void main(String[] args) {
        Stream<Integer> s = Stream.iterate(1, n -> n + 1);
        s.skip(5).limit(2).forEach(System.out::print); // 67
    }
}

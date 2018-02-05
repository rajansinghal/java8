package com.practice.java8.stream;

import java.util.stream.Stream;

/**
 * Created by rsinghal on 2/4/2018.
 */
public class IterationOverStream {

    public static void main(String[] args) {
        Stream s = Stream.of(1);
       // for (Integer i: s) {} // DOES NOT COMPILE
        //Streams  cannot use a traditional for loop to run because they don’t implement the Iterable interface.
    }
}

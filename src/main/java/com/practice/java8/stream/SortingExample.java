package com.practice.java8.stream;

import java.util.Comparator;
import java.util.stream.Stream;

/**
 * Created by rsinghal on 2/5/2018.
 */

//The sorted() method returns a stream with the elements sorted. Just like sorting arrays,
 /*
 Stream<T> sorted();
 Stream<T> sorted(Comparator<? super T> comparator);*/
public class SortingExample {

    public static void main(String[] args) {
        Stream<String> s = Stream.of("brown-", "bear-");
        s.sorted().forEach(System.out::print); // bear-brown


        Stream<String> s1 = Stream.of("brown bear-", "grizzly-");
        s1.sorted(Comparator.reverseOrder()).forEach(System.out::print); // grizzly-brown bear-

        // s.sorted(Comparator::reverseOrder); // DOES NOT COMPILE

      /*  Take a look at the method signatures again. Comparator is a functional interface.
        This means that we can use method references or lambdas to implement it. The
        Comparator interface implements one method that takes two String parameters and
        returns an int . However, Comparator::reverseOrder doesn’t do that. It is a reference
        to a function that takes zero parameters and returns a Comparator . This is not compatible
        with the interface. This means that we have to use a method and not a method
        reference. */
    }
}

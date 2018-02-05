package com.practice.java8.stream;

/**
 * Created by rsinghal on 2/4/2018.
 */

import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * special type of reduction call mutable reduction
 *
 *  <R>   R collect(Supplier<R> supplier, BiConsumer<R, ? super T> accumulator, BiConsumer<R, R> combiner)
 *  <R,A> R collect(Collector<? super T, A,R> collector)
 */
public class CollectExample {

    public static void main(String[] args) {

        Stream<String> stream = Stream.of("w", "o", "l", "f");
        StringBuilder output = stream.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
        System.out.println(output); // [w,o,l,f]


        Stream<String> stream1 = Stream.of("w", "o", "l", "f");
        String output1 =  stream1.reduce("" ,(m,n)-> m + n);
        System.out.println(output1); // [w,o,l,f]

        Stream<String> stream2 = Stream.of("w", "o", "l", "f");
        TreeSet<String> output2 = stream2.collect(TreeSet::new, TreeSet::add, TreeSet::addAll);
        System.out.println(output2); // [f, l, o, w]

        //Rewriting the above snippet as below using an common interface for the collectors
        Stream<String> stream3 = Stream.of("w", "o", "l", "f");
        TreeSet<String> output3 = stream3.collect(Collectors.toCollection(TreeSet::new));
        System.out.println(output3); // [f, l, o, w]

        //If we didn’t need the set to be sorted, we could make the code even shorter:
        Stream<String> stream4 = Stream.of("w", "o", "l", "f");
        Set<String> output4 = stream4.collect(Collectors.toSet());
        System.out.println(output4); // [f, w, l, o]
    }
}

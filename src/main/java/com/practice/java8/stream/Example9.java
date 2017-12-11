package com.practice.java8.stream;

import java.util.Comparator;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

/**
 * Created by rsinghal on 12/5/2017.
 */
public class Example9 {
    public static void main(String[] args) {

        Stream<String> stream = Stream.of("abc","ab");
        System.out.println(stream.max((s1,s2) -> Integer.compare(s2.length(), s1.length())).get());

        DoubleStream stream_d = DoubleStream.of(2.0, 4.1, 6.0, 1.4);
        System.out.println(stream_d.skip(1).limit(3).findFirst());

        Stream<String> stream1 = Stream.of("A","B","C");
        System.out.println(stream1.limit(1).skip(1).findAny());
        //Optional.empty


        Optional<String> ops = Optional.of("1");
        OptionalInt op = ops.map( Integer::parseInt);

        //this is the new method introduced
       // Comparator.comparing(e -> e.length);

      //  To perform a computation, stream operations are composed into a stream pipeline. A stream pipeline consists of:
     //   A source (which might be an array, a Collection, a generator function, an I/O channel, etc.)



        //The forEach method of the map interface expects BiConsumer, so form the given options only first options' lambada represents a BiConsumer.
       // (k,v)->System.out.println(v)
        //The forEach method of the map interface expects BiConsumer, so form the given options only first options' lambada represents a BiConsumer.
    }

}


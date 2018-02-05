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

       /* Stream<String> stream = Stream.of("abc","ab");
        System.out.println(stream.max((s1,s2) -> Integer.compare(s2.length(), s1.length())).get());*/

        /*DoubleStream stream_d = DoubleStream.of(2.0, 4.1, 6.0, 1.4);
        System.out.println(stream_d.skip(1).limit(3).findFirst());*/

        /*Stream<String> stream1 = Stream.of("A","B","C");
        System.out.println(stream1.limit(1).skip(1).findAny());
        Optional.empty*/


       /* Optional<String> ops = Optional.of("1");
        OptionalInt op = ops.map( Integer::parseInt);*/

        //this is the new method introduced
       // Comparator.comparing(e -> e.length);

      //  To perform a computation, stream operations are composed into a stream pipeline. A stream pipeline consists of:
     //   A source (which might be an array, a Collection, a generator function, an I/O channel, etc.)


       // Optional<String> ops = Optional.of("1");
      //  OptionalInt op = ops.map( Integer::parseInt);
      //  Option E is correct since the map method of the Optional class returns optional with the generic type but not primitive version of the Optional. So here trying to assign optional to an optionalInt results a compile time error due to line 7.


       // Here the reference given is null so we need to create optional which supports null values. For such cases we need to use ofNullable method which returns an Optional describing the specified value, if non-null, otherwise returns an empty Optional. So here we can use only statement given in option B.

        //The forEach method of the map interface expects BiConsumer, so form the given options only first options' lambada represents a BiConsumer.
       // (k,v)->System.out.println(v)
        //The forEach method of the map interface expects BiConsumer, so form the given options only first options' lambada represents a BiConsumer.

        Stream<String> ints = Stream.of("A","B","C","D");
       long i =  ints.peek(System.out::print).skip(2).count();
        System.out.println(i);


        //public boolean removeIf(Predicate<? super E> filter)
       // http://docs.oracle.com/javase/tutorial/collections



        //https://learning.whizlabs.com/mod/quiz/review.php?attempt=753781&page=22


    }

}


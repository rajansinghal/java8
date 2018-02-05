package com.practice.java8.stream;

import java.util.stream.Stream;

/**
 * Created by rsinghal on 2/4/2018.
 */
public class ReduceExample {


  /*
    T reduce(T identity, BinaryOperator<T> accumulator)
    Optional<T> reduce(BinaryOperator<T> accumulator)
    <U> U reduce(U identity, BiFunction<U,? super T,U> accumulator, BinaryOperator<U> combiner)

    The third method signature is used when we are processing collections in parallel. It
    allows Java to create intermediate reductions and then combine them at the end. In our
    example, it looks similar. While we aren’t actually using a parallel stream here,

   */
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("w", "o", "l", "f");
        String word = stream.reduce("", (s, c) -> s + c);
        System.out.println(word); // wolf

        Stream<String> stream1 = Stream.of("w", "o", "l", "f");
        String wordMetodRef = stream1.reduce("", String::concat);
        System.out.println(wordMetodRef); // wolf

        Stream<Integer> streamNo = Stream.of(3, 5, 6);
        System.out.println(streamNo.reduce(1, (a, b) -> a*b)); //90
        System.out.println(streamNo.reduce( (a, b) -> a*b)); //Optional[90]
    }
}

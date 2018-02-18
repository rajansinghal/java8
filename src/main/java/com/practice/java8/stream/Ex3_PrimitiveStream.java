package com.practice.java8.stream;

import java.util.IntSummaryStatistics;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by rsinghal on 2/18/2018.
 */
public class Ex3_PrimitiveStream {

    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1, 2, 3);
        System.out.println(stream.reduce(0, (s, n) -> s + n));


        Stream<Integer> stream1 = Stream.of(1, 2, 3);
        System.out.println(stream1.mapToInt(x -> x).sum());


        IntStream intStream = IntStream.of(1, 2, 3);
        OptionalDouble avg = intStream.average();
        System.out.println(avg.getAsDouble());


      /*  IntStream: Used for the primitive types int, short, byte, and char
        LongStream: Used for the primitive type long
        DoubleStream: Used for the primitive types double and float*/

        DoubleStream oneValue = DoubleStream. of (3.14);
        DoubleStream varargs = DoubleStream. of (1.0, 1.1, 1.2);
        oneValue.forEach(System.out::println);
        varargs.forEach(System.out::println);

        DoubleStream random = DoubleStream. generate (Math::random);
        DoubleStream fractions = DoubleStream. iterate (.5, d -> d / 2);

        random.limit(3).forEach(System.out::println);
        System.out.println();
        fractions.limit(3).forEach(System.out::println);


        IntStream count = IntStream.iterate(1, n -> n+1).limit(5);
        count.forEach(System.out::println);

        IntStream range = IntStream.range(1, 6);
        range.forEach(System.out::println);

        IntStream rangeClosed = IntStream.rangeClosed(1, 5);
        rangeClosed.forEach(System.out::println);
    }


  /*  We can’t run two terminal operations against the same stream. Luckily, this is a common problem
    and the primitive streams solve it for us with summary statistics. Statistic is just a big
    word for a number that was calculated from data.*/
    private static int range(IntStream ints) {
        IntSummaryStatistics stats = ints.summaryStatistics();
        if (stats.getCount() == 0) throw new RuntimeException();
        return stats.getMax()- stats.getMin();
    }

}

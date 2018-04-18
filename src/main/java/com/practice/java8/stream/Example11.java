package com.practice.java8.stream;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by rsinghal on 2/18/2018.
 */
public class Example11 {

    public static void main(String[] args) {

       String  str =  RandomStringUtils.randomAlphanumeric(3);
        System.out.println(str.toUpperCase() + "--->");
        //example1();
        //example3();
    }

    public static void example1(){
        Stream<String> stream = Stream.iterate("", (s) -> s + "1");
        System.out.println(stream.limit(2).map(x -> x + "2"));  //output java.util.stream.ReferencePipeline$3@3d075dc0
        stream.limit(2).map(x -> x + "2").forEach(System.out::println); //output 2 12

    }

    public static void example2(){
        Predicate<? super String> predicate = s -> s.startsWith("g");
        Stream<String> stream1 = Stream.generate(() -> "growl! ");
        Stream<String> stream2 = Stream.generate(() -> "growl! ");
        boolean b1 = stream1.anyMatch(predicate);
        boolean b2 = stream2.allMatch(predicate);
        System.out.println(b1 + " " + b2);
    }

    public static void example3() {
        Predicate<? super String> predicate = s -> s.length() > 3;
        Stream<String> stream = Stream.iterate("-", (s) -> s + s);
        boolean b1 = stream.noneMatch(predicate);
        boolean b2 = stream.anyMatch(predicate);
        System.out.println(b1 + " " + b2);
    }


    public static void example4(){
        Stream.generate(() -> "1")
                .filter(x -> x.length() > 1)
                .peek(System.out::println)
                .limit(10)
                .forEach(System.out::println);
    }


    public static void example5(){

        Stream.iterate(1, x -> x++).limit(5).map(x -> "" + x).collect(Collectors.joining());
    }

}

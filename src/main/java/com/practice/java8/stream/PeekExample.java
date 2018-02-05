package com.practice.java8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by rsinghal on 2/5/2018.
 */

//Stream<T> peek(Consumer<? super T> action)
//The peek() method is useful for seeing how a stream pipeline works behind the scenes.
public class PeekExample {

    public static void main(String[] args) {
        Stream<String> stream = Stream.of("black bear", "brown bear", "grizzly");
        long count = stream.filter(s -> s.startsWith("g")).peek(System.out::println).count(); // grizzly
        System.out.println(count);

        //Remember that peek() is intended to perform an operation without changing the result.
        List<Integer> numbers = new ArrayList<>();
        List<Character> letters = new ArrayList<>();
        numbers.add(1);
        letters.add('a');
        Stream<List<?>> stream1 = Stream.of(numbers, letters);
        stream1.map(List::size).forEach(System.out::print); // 11


        StringBuilder builder = new StringBuilder();
        Stream<List<?>> good = Stream.of(numbers, letters);
        good.peek(l -> builder.append(l)).map(List::size).forEach(System.out::print); // 11
        System.out.println(builder); // [1][a]


        Stream<List<?>> bad = Stream.of(numbers, letters);
        bad.peek(l -> l.remove(0)).map(List::size).forEach(System.out::print); // 00
    }
}

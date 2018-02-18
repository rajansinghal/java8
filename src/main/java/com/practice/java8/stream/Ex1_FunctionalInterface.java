package com.practice.java8.stream;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.function.*;

/**
 * Created by rsinghal on 2/18/2018.
 */
public class Ex1_FunctionalInterface {

    public static void main(String[] args) {

        System.out.println("Functional interface example..");
        supplierTutorial();
        consumerTutorial();
        predicateTutorial();
        functionTutorial();
        operatorTutorial();
    }

    public static void supplierTutorial(){

       /*
           @FunctionalInterface public class Supplier<T> {
                public T get();
            }
        */

       //Ex:1
        Supplier<LocalDate> s1 = LocalDate::now;
        Supplier<LocalDate> s2 = () -> LocalDate.now();
        LocalDate d1 = s1.get();
        LocalDate d2 = s2.get();
        System.out.println(d1);
        System.out.println(d2);


        //Ex:2
        BooleanSupplier b1 = () -> true;
        BooleanSupplier b2 = () -> Math.random() > .5;
        System.out.println(b1.getAsBoolean());
        System.out.println(b2.getAsBoolean());

    }

    public static void consumerTutorial(){

        /*
        * @FunctionalInterface public class Consumer<T> {
                void accept(T t);
            }

            @FunctionalInterface public class BiConsumer<T, U> {
                void accept(T t, U u);
            }
        * */
        //Ex:1
        Consumer<String> c1 = System.out::println;
        Consumer<String> c2 = x -> System.out.println(x);
        c1.accept("Annie");
        c2.accept("Annie");

        //Ex:2
        Map<String, Integer> map = new HashMap<>();
        BiConsumer<String, Integer> b1 = map::put;
        BiConsumer<String, Integer> b2 = (k, v) -> map.put(k, v);
        b1.accept("chicken", 7);
        b2.accept("chick", 1);
    }


    public static void predicateTutorial(){
        /**
         * @FunctionalInterface public class Predicate<T> {
                boolean test(T t);
            }
          @FunctionalInterface public class BiPredicate<T, U> {
                boolean test(T t, U u);
             }

          POINT_TO_REMEMBER :

          When you see a boolean returned, think Predicate unless the generics specify a Boolean return type.
          _____ <String, String> ex3 = (s1, s2) -> false;

         above is an example of bipredicate not function
         */

        //EX:1
        Predicate<String> p1 = String::isEmpty;
        Predicate<String> p2 = x -> x.isEmpty();
        System.out.println(p1.test(""));
        System.out.println(p2.test(""));

        //EX:2
        BiPredicate<String, String> b1 = String::startsWith;
        BiPredicate<String, String> b2 = (string, prefix) -> string.startsWith(prefix);
        System.out.println(b1.test("chicken", "chick"));
        System.out.println(b2.test("chicken", "chick"));

        //EX:3
        Predicate<String> egg = s -> s.contains("egg");
        Predicate<String> brown = s -> s.contains("brown");

        Predicate<String> brownEggs = s -> s.contains("egg") && s.contains("brown");
        Predicate<String> otherEggs = s -> s.contains("egg") && ! s.contains("brown");

        Predicate<String> brownEggs_ = egg.and(brown);
        Predicate<String> otherEggs_ = egg.and(brown.negate());
    }


    public static void functionTutorial() {

        /**
          @FunctionalInterface public class Function<T, R> {
                 R apply(T t);
            }

         @FunctionalInterface public class BiFunction<T, U, R> {
                R apply(T t, U u);
             }


         Interface TriFunction<T,U,V,R> {
                 R apply(T t, U u, V v);
             }
         */

        //Ex:1
        Function<String, Integer> f1 = String::length;
        Function<String, Integer> f2 = x -> x.length();
        System.out.println(f1.apply("cluck")); // 5
        System.out.println(f2.apply("cluck")); // 5


        //Ex:2
        BiFunction<String, String, String> b1 = String::concat;
        BiFunction<String, String, String> b2 = (string, toAdd) -> string.concat(toAdd);
        System.out.println(b1.apply("baby ", "chick")); // baby chick
        System.out.println(b2.apply("baby ", "chick")); // baby chick
    }


    public static void operatorTutorial() {

        /**
         * @FunctionalInterface public class UnaryOperator<T>   extends Function<T, T> { }
         @FunctionalInterface public class BinaryOperator<T>   extends BiFunction<T, T, T> { }

         ie
         T apply(T t);
         T apply(T t1, T t2);  [both the params must be same]
         */
        //Ex:1
        UnaryOperator<String> u1 = String::toUpperCase;
        UnaryOperator<String> u2 = x -> x.toUpperCase();
        System.out.println(u1.apply("chirp"));
        System.out.println(u2.apply("chirp"));

        //Ex:2
        BinaryOperator<String> b1 = String::concat;
        BinaryOperator<String> b2 = (string, toAdd) -> string.concat(toAdd);
        System.out.println(b1.apply("baby ", "chick")); // baby chick
        System.out.println(b2.apply("baby ", "chick")); // baby chick
    }
}

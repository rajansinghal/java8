package com.practice.java8.stream;

import java.util.Optional;

/**
 * Created by rsinghal on 2/18/2018.
 */
public class Ex2_Optional {

    public static void main(String[] args) {
        String value = "";
        Optional o = (value== null) ? Optional.empty(): Optional.of(value);
        //short hand to this
        Optional o_ = Optional.ofNullable(value);

        Optional<Double> opt = average(90, 100);
        opt.ifPresent(System.out::println);
        System.out.println(opt.orElse(Double.NaN));
        System.out.println(opt.orElseGet(() -> Math.random()));
     //   System.out.println(opt.orElseGet(() -> new IllegalStateException())); // DOES NOT COMPILE
        // opt is an Optional<Double>. This means the Supplier must return a Double. Since this
        //supplier returns an exception, the type does not match.


        System.out.println(opt.orElseThrow(() -> new IllegalStateException()));
        //Exception in thread "main" java.lang.IllegalStateException
        //at optional.Average.lambda$3(Average.java:56)


    }

    public static Optional<Double> average(int... scores) {
        if (scores.length == 0)
            return Optional.empty();
        int sum = 0;
        for (int score: scores)
            sum += score;
        return Optional.of((double) sum / scores.length);
    }
}

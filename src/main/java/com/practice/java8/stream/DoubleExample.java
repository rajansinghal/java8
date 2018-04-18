package com.practice.java8.stream;

import java.math.BigDecimal;

/**
 * Created by rsinghal on 2/4/2018.
 */

public class DoubleExample {
    public static void main(String[] args) {
        Double d = new Double("2.0");
        Double d1 = new Double("2.00");
        BigDecimal b = new BigDecimal("2.0");
        BigDecimal b1 = new BigDecimal("2.00");
        System.out.println(d.equals(d1) + "," + b.equals(b1));
    }
}

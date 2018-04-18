package com.practice.java8.stream;

import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Created by rsinghal on 11/22/2017.
 */

public class Example2{

    public static void main(String args[]){
        Move.print();
    }

    interface Move {
        public static void main(String []args) {
            System.out.println("Move");
        }
        public static void print(){}
    }
}
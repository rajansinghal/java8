package com.practice.java8.stream;

import java.util.function.Predicate;
import java.util.stream.Stream;

interface I{
    public default void print(){
        System.out.print("I");
    }

    static void method(){
        System.out.print("Static");
    }
}



public class Example3{
    public static void main(String [] args){
        I i =  new I(){};
        i.print();
        I.method();
    }
}
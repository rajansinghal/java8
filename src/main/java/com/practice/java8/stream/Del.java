package com.practice.java8.stream;

import java.text.NumberFormat;
import java.util.Arrays;

/**
 * Created by rsinghal on 2/4/2018.
 */
public class Del {
/*
   private String x = "do";
   void doStuff(){

       System.out.println("----");
       String z = "local" ;
        class  Inner{
            public void seeOuter(){

                System.out.println(x);
                System.out.println(z);
            }

            Inner i = new Inner();

        }
   }

    public static void main(String[] args) {
        new Del().new Inner().see
    }*/

  /*  public static void main(String[] args) {
        Arrays.stream(new int[]{1,2,3,4}).map(n->3 * n +1)
                .filter(i -> i > 10).average().ifPresent(System.out::println);
    }*/

    public static void main(String[] args) throws Exception {
        Object ob = new Object();

        synchronized (Thread.currentThread()){
            ob.wait();
            ob.notify();
        }
    }
}



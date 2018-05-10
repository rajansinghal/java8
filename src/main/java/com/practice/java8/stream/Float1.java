package com.practice.java8.stream;

import java.util.Date;
import java.util.LinkedList;

/**
 * Created by rsinghal on 5/2/2018.
 */
public class Float1 {

    public static void main(String[] args) {
        /*float f[] = new float[5];
        Object obj = f;
        System.out.println(f[0]);*/


        /*LinkedList<String> string = new LinkedList<>();
        string.iterator()*/

        StringBuffer a = new StringBuffer("A");
        StringBuffer b = new StringBuffer("B");
        operate(a,b);
        System.out.println(a  +""+ b);


    }

    public static void  operate(StringBuffer x, StringBuffer y){
        x.append(y);
        y = x.append("C");
        y.append("D");
    }
//becoz no equal method overridder
}


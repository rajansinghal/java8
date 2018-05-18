package com.practice.java8.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by rsinghal on 11/22/2017.
 */
public class Example1 {
    public static void main(String[] args) {
        example5();

    }
    public static void example1() {
        Stream<String> stream = Stream.iterate("", (s) -> s + "1");
        System.out.println(stream.limit(2).map(x -> x + "2"));
    }

    public static void example2() {
        Stream<String> stream = Stream.of("A", "AB", "ABC", "ABCD", "AB");
        String out = stream.filter(s -> s.length() > 2).
                filter(s -> s.indexOf("C") > -1).findAny().orElse("None");
        System.out.println(out);
    }

    public static void example3() {
        Stream<Integer> stream = Stream.of(4, 10, 8, 3);
        System.out.println(stream.peek(System.out::print).anyMatch(x -> x >= 10));
        /*
        we are using the anyMatch method to check whether there is any element in the stream which matches the passed predicate.
        Since this is terminal operation till it finds a match the peek method will be invoked so
        here peek method will print all elements till 10 since once element 10 is checked the all match method stops operation and returns true.
        */
    }

    public static void example4() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "A");
        map.put(2, "B");
        map.put(3, "C");
        map.put(4, "D");
        map.remove("A");
        map.remove(3, "C");
        map.remove(4, "B");
        map.values().forEach(System.out::print);
    }

    public static void example5() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "A");
        map.put(2, "B");
        map.put(3, "C");
        map.put(4, "D");
        map.compute(3, (k, v) -> v.equals("C") ? null : "A");
        map.keySet().forEach(System.out::print);
        System.out.println(map);

        /*
        Above code uses following newly introduced method from Java SE 8, understanding how that method works is necessary to solve this question.
        default V compute(K key, BiFunction<? super K,? super V,? extends V> remappingFunction)
        This method attempts to compute a mapping for the specified key and its current mapped value
        (or null if there is no current mapping).The default implementation is equivalent to performing the
        following steps for this map, then returning the current value or null if absent:
         V oldValue = map.get(key);
         V newValue = remappingFunction.apply(key, oldValue);
         if (oldValue != null ) {
                if (newValue != null)
                    map.put(key, newValue);
                else
                    map.remove(key);
         } else {
                 if (newValue != null)
                 map.put(key, newValue);
                 else
                 return null;
         }*/
    }


  /*  public static void example6(String[] args) throws IOException {
        Stream<String> stream = Files.readAllLines(Paths.get("input.txt"));
        stream.skip(1).forEach(System.out::print);
    }*/


    /*public static void example7(String[] args){
        Stream<String> stream = Stream.of("Java","OCAJP","OCPJP");
        IntStream ins = stream.map(s ->s.length());
        ins.forEach(System.out::print);
    }*/

    public static void example8() {
        double[] arr = {1.1,2.2,3.3,4.4,5.5};
        DoubleStream dbs = Arrays.stream(arr, 3, 5);
        System.out.println(dbs.sum());
    }

   /* public static void example9(){
        double [ ] dbls = {1.0,2.0,3.0,2.0};
        DoubleStream ds = Arrays.stream(dbls);
        int count = ds.distinct().skip(1).count();
        System.out.println(count);
    }*/


   /* public static void example10() {
        IntStream ins = IntStream.of(10,20,30,40);
        IntSummaryStatistics stat = ins.summaryStatistics();
        stat.accept(stat.getCount());
        System.out.println(stat.getSum());
    }*/


    public static void example11() {
        Predicate<? super String> predicate = s -> s.startsWith("g");
        Stream<String> stream1 = Stream.generate(() -> "growl! ");
        Stream<String> stream2 = Stream.generate(() -> "growl! ");
        boolean b1 = stream1.anyMatch(predicate);
        boolean b2 = stream2.allMatch(predicate);
        System.out.println(b1 + " " + b2);
    }


    public static void example12() {
        Predicate<? super String> predicate = s -> s.length() > 3;
        Stream<String> stream = Stream.iterate("-", (s) -> s + s);
        boolean b1 = stream.noneMatch(predicate);
        boolean b2 = stream.anyMatch(predicate);
        System.out.println(b1 + " " + b2);
    }

  /*  public static void example13() {
         List<Integer> list = Arrays.asList(new Integer[] { 3, 4, 5, 6, 7, 8, 9 });
         HashMap<Integer, List<Integer>> map =
         list.stream().collect(Collectors.groupingByConcurrent(in -> in%2==0));
         System.out.println(map.get(true));
    }
*/

    public static void example14(){
        String[] list = {"1","2","3"};
        Arrays.parallelSetAll(list,x->Integer.toString(x)+list[x]);
        System.out.println(list[0]);
    }
   /* Intermediate operations are further divided into stateless and stateful operations.
    Stateless operations, such as filter and map, retain no state from previously seen element when processing a new element -- each element
     can be processed independently of operations on other elements.
    The stateful operations, such as distinct and sorted, may incorporate state from previously seen elements when processing new elements
    */
}

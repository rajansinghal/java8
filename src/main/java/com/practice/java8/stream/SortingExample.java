package com.practice.java8.stream;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Stream;

/**
 * Created by rsinghal on 2/5/2018.
 */

//The sorted() method returns a stream with the elements sorted. Just like sorting arrays,
 /*
 Stream<T> sorted();
 Stream<T> sorted(Comparator<? super T> comparator);*/
public class SortingExample {

    public static void main(String[] args) {
       /* simpleSorting();
        simpleSortingReverse();*/
        //simpleSortingWithComparator();
       // simpleSortingWithComparatorReversed();
        //sortingWithComparatorMultipleCondition();
        //sortMap();
    }

    public static void simpleSorting(){
        Stream<String> s = Stream.of("brown-", "bear-");
        s.sorted().forEach(System.out::print); // bear-brown
    }

    public static void simpleSortingReverse(){
        Stream<String> s1 = Stream.of("brown bear-", "grizzly-");
        s1.sorted(Comparator.reverseOrder()).forEach(System.out::print); // grizzly-brown bear-

        // s.sorted(Comparator::reverseOrder); // DOES NOT COMPILE

       /*Take a look at the method signatures again. Comparator is a functional interface.
        This means that we can use method references or lambdas to implement it. The
        Comparator interface implements one method that takes two String parameters and
        returns an int . However, Comparator::reverseOrder doesn’t do that. It is a reference
        to a function that takes zero parameters and returns a Comparator . This is not compatible
        with the interface. This means that we have to use a method and not a method
        reference. */
    }

    public static void simpleSortingWithComparator(){

        Comparator<Developer> byNameComparator =(Developer o1, Developer o2)->o1.getName().compareTo(o2.getName());
        List<Developer> developers = getDeveloperList();
        developers.sort(byNameComparator);
        developers.forEach((developer)->System.out.println(developer));
    }

    public static void simpleSortingWithComparatorReversed(){

        Comparator<Developer> byNameComparator =(Developer o1, Developer o2)->o1.getName().compareTo(o2.getName());
        List<Developer> developers = getDeveloperList();
        List<Developer> developers1 = getDeveloperList();
        //on list

        developers.sort(byNameComparator.reversed());
        developers.forEach((developer)->System.out.println(developer));

        //on stream
        developers1.stream().sorted(byNameComparator.reversed()).forEach(System.out::println);
    }

    public static void sortingWithComparatorMultipleCondition(){

        List<Developer> developers = getDeveloperList();
        developers.stream().sorted(Comparator.comparing(Developer::getName).thenComparing(Developer::getAge)).forEach(System.out::println);
    }


    public static void sortMap(){
        Comparator<Student> byNameComparator =(Student o1, Student o2)->o1.getName().compareTo(o2.getName());

        Map<Integer, Student> studentMap = getStudents();
        studentMap
                .entrySet()
                .stream()
                //either provide a explicit comparator or
                //.sorted(Comparator.comparing(Map.Entry::getValue,byNameComparator))
                //or implement comparable so that jvm come to know how to sort on the basis of value which is student in that case
                .sorted(Comparator.comparing(Map.Entry::getValue))
                .forEach(e -> {
                    Integer key = (Integer)e.getKey();
                    Student std = (Student)e.getValue();
                    System.out.println("Key: " + key +", value: ("+ std.getId() +", "+ std.getName()+", "+ std.getAge()+")");
                });
    }



    public static List<Developer> getDeveloperList(){
        List<Developer> developerList = Arrays.asList(  new Developer("mayank", new BigDecimal("70000"), 33),
                new Developer("mayank", new BigDecimal("70000"), 36),
                new Developer("mayank", new BigDecimal("70000"), 35),
                new Developer("alvin", new BigDecimal("80000"), 20),
                new Developer("jason", new BigDecimal("100000"), 10),
                new Developer("iris", new BigDecimal("170000"), 55)
        );
        return developerList;
    }

    public static Map<Integer, Student> getStudents(){
        Map<Integer, Student> map = new HashMap<>();
        map.put(1, new Student(1, "Mahesh", 12));
        map.put(2, new Student(2, "Suresh", 15));
        map.put(3, new Student(3, "Nilesh", 10));
        return map;
    }
}

class Student implements Comparable<Student>{
    int id;
    String name;
    int age;

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public  int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Student ob) {
        return name.compareTo(ob.getName());
    }
    @Override
    public boolean equals(final Object obj) {
        if (obj == null) {
            return false;
        }
        final Student std = (Student) obj;
        if (this == std) {
            return true;
        } else {
            return (this.name.equals(std.name) && (this.age == std.age));
        }
    }
    @Override
    public int hashCode() {
        int hashno = 7;
        hashno = 13 * hashno + (name == null ? 0 : name.hashCode());
        return hashno;
    }
}
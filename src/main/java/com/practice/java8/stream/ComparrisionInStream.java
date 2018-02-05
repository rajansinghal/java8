package com.practice.java8.stream;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Stream;

/**
 * Created by rsinghal on 2/4/2018.
 */
public class ComparrisionInStream {

    public static void main(String[] args) {

       Developer d1= new Developer("mkyong", new BigDecimal("70000"), 33);
       Developer d2= new Developer("alvin", new BigDecimal("80000"), 20);
       Developer d3= new Developer("jason", new BigDecimal("100000"), 10);
       Developer d4= new Developer("iris", new BigDecimal("170000"), 55);

       Stream<Developer> s = Stream.of(d1,d2,d3,d4);
       Optional<Developer> min = s.min((s1, s2) -> s1.getAge() - s2.getAge());
       min.ifPresent(System.out::println);
    }



}

class ComparrisionLegacyApproach {

    public static void main(String[] args) {

        List<Developer> listDevs = getDevelopers();

        System.out.println("Before Sort");
        for (Developer developer : listDevs) {
            System.out.println(developer);
        }

        //sort by age
        Collections.sort(listDevs, new Comparator<Developer>() {
            @Override
            public int compare(Developer o1, Developer o2) {
                return o1.getAge() - o2.getAge();
            }
        });

        System.out.println("After Sort");
        for (Developer developer : listDevs) {
            System.out.println(developer);
        }

    }

    private static List<Developer> getDevelopers() {

        List<Developer> result = new ArrayList<Developer>();

        result.add(new Developer("mkyong", new BigDecimal("70000"), 33));
        result.add(new Developer("alvin", new BigDecimal("80000"), 20));
        result.add(new Developer("jason", new BigDecimal("100000"), 10));
        result.add(new Developer("iris", new BigDecimal("170000"), 55));

        return result;

    }

}
  class Developer {

    private String name;
    private BigDecimal salary;
    private int age;

    public Developer(String name, BigDecimal salary, int age) {
        this.name = name;
        this.salary = salary;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

      @Override
      public String toString() {
          return "Developer{" +
                  "name='" + name + '\'' +
                  ", salary=" + salary +
                  ", age=" + age +
                  '}';
      }
  }
package com.practice.java8.stream;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class NestedSortingJava {

    public static void main(String[] args) {
        List<Employeee> employeeeList = new ArrayList<>();
        employeeeList.add(new Employeee("1",22,2000));
        employeeeList.add(new Employeee("2",23,2000));
        employeeeList.add(new Employeee("3",24,2000));
        employeeeList.add(new Employeee("4",22,2500));
        employeeeList.add(new Employeee("5",23,1800));
        employeeeList.add(new Employeee("6",24,1500));
        employeeeList.add(new Employeee("7",22,2800));


        employeeeList.stream().sorted(Comparator.comparing(Employeee::getAge).thenComparing(Employeee::getSalary,Comparator.reverseOrder())).forEach(x-> System.out.println(x));
    }
}


class Employeee {
    private String name;
    private int age;
    private int salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Employeee(String name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}

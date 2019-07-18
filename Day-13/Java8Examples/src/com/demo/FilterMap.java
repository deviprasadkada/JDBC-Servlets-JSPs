package com.demo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterMap {

    public static void main(String[] args) {

        List<Person> persons = Arrays.asList(
                new Person("nanda", 30),
                new Person("jack", 20),
                new Person("lawrence", 40)
        );

        String name = persons.stream()
                .filter(x -> "jack1".equals(x.getName()))
                .map(Person::getName)                        //convert stream to String
                .findAny()
                .orElse("NONE");

        System.out.println("name : " + name);

        List<String> collect = persons.stream()
                .map(Person::getName)
                .collect(Collectors.toList());

        collect.forEach(System.out::println);

    }

}

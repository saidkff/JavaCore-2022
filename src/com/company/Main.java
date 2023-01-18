package com.company;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        IntStream.iterate(0, it->it+1)
                .limit(100)
                .mapToObj(val->"HelloWorld")
                .forEach(System.out::println);
    }
}

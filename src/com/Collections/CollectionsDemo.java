package com.Collections;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionsDemo {
    public static void main(String[] args) {
        Person ivan = new Person(1, "Ivan", "Ivanov");
        Person nicolay = new Person(2, "Nicolay", "Nicolayyeev");
        Person andrey = new Person(3, "Andrey", "Andreev");
        Person sasha = new Person(4, "Sasha", "Kosnicov");
        Person murod = new Person(5, "Murod", "Rakhmetov");
        Person bakhodir = new Person(6, "Bakhodir", "Bilalov");
        Person vladimer = new Person(7, "Vladimer", "Putin");

        HashMap<Integer, Person> map = new HashMap<>();
        map.put(bakhodir.getID(), bakhodir);
        map.put(murod.getID(), murod);
        map.put(ivan.getID(), ivan);
        map.put(nicolay.getID(), nicolay);
        map.put(andrey.getID(), andrey);
        map.put(vladimer.getID(), vladimer);
        map.put(sasha.getID(), sasha);


        
    }
}

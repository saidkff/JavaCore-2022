package com.company;

public class Cat extends Animal{
    public Cat(String name, double weight) {
        super(name, weight);
    }

    public void voice(){
        System.out.println(name);
    }
}


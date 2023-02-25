package com.company;

import java.util.Optional;

public class Main{
    public static void main(String[] args) {
        Person person = new Person("Bob", null);

        String orElse = person.getLastName().orElse("Jameson");
        System.out.println(orElse);
    }
}

class Person {
    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Optional<String> getLastName() {
        return Optional.ofNullable(lastName);
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
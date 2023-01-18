package com.Collections;

import java.util.Objects;

public class Person {
    private int ID;
    private String FirstName;
    private String LastName;

    public Person(int ID, String firstName, String lastName) {
        this.ID = ID;
        FirstName = firstName;
        LastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return ID == person.ID && Objects.equals(FirstName, person.FirstName) && Objects.equals(LastName, person.LastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, FirstName, LastName);
    }

    @Override
    public String toString() {
        return "Person{" +
                "ID=" + ID +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                '}';
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public int getID() {
        return ID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }
}

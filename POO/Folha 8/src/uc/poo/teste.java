package uc.poo;

import java.io.*;

class Person implements Serializable {
    String name;
    int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Name:" + name + "\nAge: " + age;
    }
}

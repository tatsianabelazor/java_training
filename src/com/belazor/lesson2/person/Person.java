package com.belazor.lesson2.person;

/**
 * Created by Tatsiana_Belazor on 18-Jan-18.
 */
public class Person {

    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void displayWhoIAm() {
        System.out.println("My name is " + name);
    }// меня зовут так-то
}

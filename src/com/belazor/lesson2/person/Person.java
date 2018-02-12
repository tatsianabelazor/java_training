package com.belazor.lesson2.person;

/**
 * Created by Tatsiana_Belazor on 18-Jan-18.
 */
public abstract class Person implements OperationsWithLimit {

    private String name;

    /**
     *
     * @param name
     */
    public Person(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * This method display the name of a person
     */
    public void displayWhoIAm() {
        System.out.println("My name is " + name);
    }

    public abstract void displayRole();
}

package com.belazor.lesson2.award;

public class Award {

    static {
        System.out.println("Static initialization of Award class");
    }

    {
        System.out.println("Instance initialization " + this.getValue());
    }


    private final int value;
    private String currency = "USD";
    private double soli;

    public Award(int value) {
        this.value = value;
    }

    public Award(String currency, int value) {
        this.currency = currency;
        this.value = value;
        System.out.println(String.format("constructor initialisation %d %s", this.value, this.currency));
    }

    public Award(double soli, int value) {
        this.soli = soli;
        this.value = value;
    }

    public double getSoli() {
        return soli;
    }

    public void setSoli(double soli) {
        this.soli = soli;
    }

    public String getCurrency() {
        return currency;
    }

    public int getValue() {
        return value;
    }

}
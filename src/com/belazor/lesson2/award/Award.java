package com.belazor.lesson2.award;

import java.util.Objects;

public class Award {

    static {
        System.out.println("Static initialization of Award class");
    }

    {
        System.out.println("Instance initialization " + this.getValue());
    }


    private final int value;
    private String currency = "USD";
    private float soli;
    private AwardType type;
    private long id;

    public Award(int value) {
        this.value = value;
    }

    public Award(String currency, int value) {
        this.currency = currency;
        this.value = value;
        System.out.println(String.format("constructor initialisation %d %s", this.value, this.currency));
    }

    public Award(float soli, int value) {
        this.soli = soli;
        this.value = value;
    }

    public double getSoli() {
        return soli;
    }

    public void setSoli(float soli) {
        this.soli = soli;
    }

    public String getCurrency() {
        return currency;
    }

    public int getValue() {
        return value;
    }

    public Award(int value, String currency, long id, AwardType type) {
        this.value = value;
        this.currency = currency;
        this.id = id;
        this.type = type;
    }

    public AwardType getType() {
        return type;
    }

    public void setType(AwardType type) {
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Award{" +
                "value=" + value +
                ", currency='" + currency + '\'' +
                ", soli=" + soli +
                ", type=" + type +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Award award = (Award) o;
        return value == award.value &&
                Float.compare(award.soli, soli) == 0 &&
                id == award.id &&
                Objects.equals(currency, award.currency) &&
                type == award.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, currency, soli, type, id);
    }
}
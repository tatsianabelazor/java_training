package com.belazor.lesson2.nominee;

import com.belazor.lesson2.award.Award;

import java.util.Random;

public class Nominee {

    private String Name;

    public String getName() {
        return Name;
    }

    private int nomineeAwardQuantityLimit;

    private double nomineeAwardAmountLimit;

    public Nominee(String name) {
        Name = name;
    }

    public Nominee(String name, int nomineeAwardQuantityLimit, double nomineeAwardAmountLimit) {
        Name = name;
        this.nomineeAwardQuantityLimit = nomineeAwardQuantityLimit;
        this.nomineeAwardAmountLimit = nomineeAwardAmountLimit;
    }

    public int getNomineeAwardQuantityLimit() {
        return nomineeAwardQuantityLimit;
    }

    public double getNomineeAwardAmountLimit() {
        return nomineeAwardAmountLimit;
    }

    public void setNomineeAwardQuantityLimit(int nomineeAwardQuantityLimit) {
        this.nomineeAwardQuantityLimit = nomineeAwardQuantityLimit;
    }

    public void setNomineeAwardAmountLimit(double nomineeAwardAmountLimit) {
        this.nomineeAwardAmountLimit = nomineeAwardAmountLimit;
    }

    public double receiveAward(Award myAward) {
        double result = myAward.getValue();
        if (myAward.getSoli() > 0) {
            result = myAward.getSoli() * myAward.getValue();
            System.out.println(String.format("Award with soli = %s", result, myAward.getSoli()));
            System.out.println("Award is decreased in " + (result/myAward.getValue()* 100) + "%");
        } else {
            result = calculation(myAward);
            System.out.println(String.format("Award without soli + %s", result));
        }
        return result;

    }

    public double calculation(Award award) {
        System.out.println("Award before calculation " +  award.getValue());
        final Random random = new Random ();
        double c = random.nextDouble();
        //System.out.println("c=" + c);
        int population = 5;
        int z = random.nextInt();
        //System.out.println("z=" + z);
        double p = award.getValue();

        double a = ((((Math.pow(z,2))*(p)*(1-p)))/(Math.pow(c,2)));
       // System.out.println("Formula");
        double calculation = a/(1+((a-1)/population));
        //System.out.println("Award after calculation " + calculation);
        return calculation;
    }

}




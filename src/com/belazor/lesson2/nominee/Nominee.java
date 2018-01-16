package com.belazor.lesson2.nominee;

import com.belazor.lesson2.award.Award;

import java.util.Random;

public class Nominee {

    private String name;

    /**
     * @return
     */

    public String getName() {
        return name;
    }

    private int AwardQuantityLimit;

    private double AwardAmountLimit;

    /**
     * @param name
     */
    public Nominee(String name) {
        this.name = name;
    }

    public int getAwardQuantityLimit() {
        return AwardQuantityLimit;
    }

    public double getAwardAmountLimit() {
        return AwardAmountLimit;
    }

    public void setAwardQuantityLimit(int awardQuantityLimit) {
        this.AwardQuantityLimit = awardQuantityLimit;
    }

    public void setAwardAmountLimit(float awardAmountLimit) {
        this.AwardAmountLimit = awardAmountLimit;
    }

    /**
     * @param myAward
     * @return
     */
    public double receiveAward(Award myAward) {
        double result = myAward.getValue();
        if (myAward.getSoli() > 0) {
            result = myAward.getSoli() * myAward.getValue();
            //System.out.println(String.format("Award with soli = %s", result, myAward.getSoli()));
            //System.out.println("Award is decreased in " + (result / myAward.getValue() * 100) + "%");
        } else {
            result = calculation(myAward);
            //System.out.println(String.format("Award without soli + %s", result));
        }
        return result;

    }

    /**
     * @param myAward award object
     * @return
     */
    public double calculation(Award myAward) {
        int population = 5;
        return calculation(myAward, population);
    }

    /**
     * @param award
     * @param population
     * @return
     */
    public double calculation(Award award, int population) {
        //System.out.println("Award before calculation " + award.getValue());
        final Random random = new Random();
        double c = random.nextDouble();
        //System.out.println("c=" + c);
        int z = random.nextInt();
        //System.out.println("z=" + z);
        double p = award.getValue();

        double a = ((((Math.pow(z, 2)) * (p) * (1 - p))) / (Math.pow(c, 2)));
        // System.out.println("Formula");
        double calculation = a / (1 + ((a - 1) / population));
        //System.out.println("Award after calculation " + calculation);
        return calculation;
    }
}




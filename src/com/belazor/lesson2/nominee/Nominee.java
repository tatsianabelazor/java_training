package com.belazor.lesson2.nominee;

import com.belazor.lesson2.award.Award;
import com.belazor.lesson2.person.Person;
import com.belazor.lesson2.utils.NominationHelper;

public class Nominee extends Person {

    private float awardAmountlimit;
    private int awardQuantityLimit;
    private double awardAmountLimit;

    /**
     * @param name Nominee name
     */
    public Nominee(String name) {
        super(name);
    }

    public Nominee(String name, int AwardQuantityLimit, float AwardAmountLimit) {
        this(name);
        this.awardQuantityLimit = AwardQuantityLimit;
        this.awardAmountlimit = AwardAmountLimit;
    }

    public int getAwardQuantityLimit() {
        return awardQuantityLimit;
    }

    public double getAwardAmountLimit() {
        return awardAmountLimit;
    }

    /**
     * @param awardQuantityLimit
     */
    public void setAwardQuantityLimit(int awardQuantityLimit) {
        this.awardQuantityLimit = awardQuantityLimit;
    }

    /**
     * @param awardAmountLimit
     */
    public void setAwardAmountLimit(float awardAmountLimit) {
        this.awardAmountLimit = awardAmountLimit;
    }



    /**
     * This method is used to receive award
     *
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
            result = NominationHelper.calculation(myAward);
            //System.out.println(String.format("Award without soli + %s", result));
        }
        return result;
    }

    @Override
    public void displayWhoIAm() {
        super.displayWhoIAm();
        System.out.printf("I am %s%n", getName());
    }

    @Override
    public void displayRole() {
        System.out.println("I am a nominee");
    }

    @Override
    public boolean isLimitReached(int currentAmount, int amountToAdd) {
        return currentAmount + amountToAdd > awardQuantityLimit;
    }

    @Override
    public boolean isLimitReached(double currentAmount, double amountToAdd) {
        return currentAmount + amountToAdd > awardQuantityLimit;
    }
}





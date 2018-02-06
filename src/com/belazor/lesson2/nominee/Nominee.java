package com.belazor.lesson2.nominee;

import com.belazor.lesson2.award.Award;
import com.belazor.lesson2.person.Person;
import com.belazor.lesson2.utils.NominationHelper;

public class Nominee extends Person {

    private int awardQuantityLimit;
    private double awardAmountLimit;

    /**
     * @param name Nominee name
     */
    public Nominee(String name) {
        super(name);
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
        System.out.println("I am a nominee");
    }

    @Override
    public boolean isLimitReached(int currentAmount, int amountToAdd) {
        if (currentAmount + amountToAdd > awardQuantityLimit) {
        }
        return !isLimitReached(currentAmount, amountToAdd);
    }

    @Override
    public boolean isLimitReached(double currentAmount, double amountToAdd) {
        if (currentAmount + amountToAdd > awardQuantityLimit) {
        }
        return !isLimitReached(currentAmount, amountToAdd);
    }
}





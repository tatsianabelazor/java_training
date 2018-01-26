package com.belazor.lesson2.nominee;

import com.belazor.lesson2.award.Award;
import com.belazor.lesson2.person.Person;
import com.belazor.lesson2.utils.NominationHelper;

public class Nominee extends Person {

    private int AwardQuantityLimit;
    private double AwardAmountLimit;

    /**
     * @param name Nominee name
     */
    public Nominee(String name) {
        super (name);
    }

    public int getAwardQuantityLimit() {
        return AwardQuantityLimit;
    }

    public double getAwardAmountLimit() {
        return AwardAmountLimit;
    }

    /**
     *
     * @param awardQuantityLimit
     */
    public void setAwardQuantityLimit(int awardQuantityLimit) {
        this.AwardQuantityLimit = awardQuantityLimit;
    }

    /**
     *
     * @param awardAmountLimit
     */
    public void setAwardAmountLimit(float awardAmountLimit) {
        this.AwardAmountLimit = awardAmountLimit;
    }

    /**
     * This method is used to receive award
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
}




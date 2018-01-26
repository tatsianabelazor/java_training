package com.belazor.lesson2.nominee;

import com.belazor.lesson2.award.Award;
import com.belazor.lesson2.utils.NominationHelper;

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


}




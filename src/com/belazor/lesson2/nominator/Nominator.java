package com.belazor.lesson2.nominator;


import com.belazor.lesson2.award.Award;
import com.belazor.lesson2.nominee.Nominee;
import com.belazor.lesson2.person.Person;

import java.util.List;


public class Nominator extends Person {

    private int awardQuantityLimit;
    private double awardAmountlimit;

    public Nominator(String name) {
        super(name);
    }

    public Nominator(String name, int AwardQuantityLimit, float AwardAmountLimit) {
        this(name);
        this.awardQuantityLimit = AwardQuantityLimit;
        this.awardAmountlimit = AwardAmountLimit;
    }

    public int getAwardQuantityLimit() {
        return awardQuantityLimit;
    }

    public double getAwardamountlimit() {
        return awardAmountlimit;
    }

    public void setAwardQuantityLimit(int awardQuantityLimit) {
        this.awardQuantityLimit = awardQuantityLimit;
    }

    public void setAwardamountlimit(float awardamountlimit) {
        this.awardAmountlimit = awardamountlimit;
    }

    public void nominate(Nominee nominee, Award testAward) {
        nominee.receiveAward(testAward);
        System.out.println(String.format("The recipient %s received %d %s award", nominee.getName(), testAward.getValue(), testAward.getCurrency()));
    }

    public void nominate(List<Nominee> nominees, Award testAward) {
        for (Nominee nominee : nominees) {
            nominee.receiveAward(testAward);
            System.out.println(String.format("The recipient %s received %d %s award", nominee.getName(), testAward.getValue(), testAward.getCurrency()));
        }
    }

    public void nominate(Nominee nominee, List<Award> givenAwards) {
        for (Award award : givenAwards) {
            nominee.receiveAward(award);
        }
    }

    /**
     * This method is used to display nominator's name
     */
    @Override
    public void displayWhoIAm() {
        super.displayWhoIAm();
        System.out.println("I am a nominator");
    }

    @Override
    public boolean isLimitReached(int currentAmount, int amountToAdd) {
        if (currentAmount + amountToAdd > awardQuantityLimit) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isLimitReached(double currentAmount, double amountToAdd) {
        if (currentAmount + amountToAdd > awardQuantityLimit) {
            return true;
        } else {
            return false;
        }
    }

}
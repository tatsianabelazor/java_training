package com.belazor.lesson2.nominator;


import com.belazor.lesson2.award.Award;
import com.belazor.lesson2.nominee.Nominee;

import java.util.List;


public class Nominator {

    private String name;

    public String getName() {
        return name;
    }

    private int AwardQuantityLimit;

    private double AwardAmountLimit;

    public Nominator(String name) {
        this.name = name;
    }

    public Nominator(String name, int AwardQuantityLimit, float AwardAmountLimit) {
        this.name = name;
        this.AwardQuantityLimit = AwardQuantityLimit;
        this.AwardAmountLimit = AwardAmountLimit;
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

}
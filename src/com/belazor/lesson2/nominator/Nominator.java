package com.belazor.lesson2.nominator;


import com.belazor.lesson2.award.Award;
import com.belazor.lesson2.nominee.Nominee;

import java.util.List;


public class Nominator {

    private String name;

    private int nominatorAwardQuantityLimit;

    private double nominatorAwardAmountLimit;

    public Nominator(String name) {
        this.name = name;
    }

    public Nominator(String name, int nominatorAwardQuantityLimit, double nominatorAwardAmountLimit) {
        this.name = name;
        this.nominatorAwardQuantityLimit = nominatorAwardQuantityLimit;
        this.nominatorAwardAmountLimit = nominatorAwardAmountLimit;
    }

    public int getNominatorAwardQuantityLimit() {
        return nominatorAwardQuantityLimit;
    }

    public double getNominatorAwardAmountLimit() {
        return nominatorAwardAmountLimit;
    }

    public void setNominatorAwardQuantityLimit(int nominatorAwardQuantityLimit) {
        this.nominatorAwardQuantityLimit = nominatorAwardQuantityLimit;
    }

    public void setNominatorAwardAmountLimit(double nominatorAwardAmountLimit) {
        this.nominatorAwardAmountLimit = nominatorAwardAmountLimit;
    }

    public void nominate(Nominee nominee,  Award testAward) {
        nominee.receiveAward(testAward);
        System.out.println(String.format("The recipient %s received %d %s award", nominee.getName(), testAward.getValue(), testAward.getCurrency()));
    }

    public void nominate(List<Nominee> nominees, Award testAward) {
        for (Nominee nominee: nominees) {
            nominee.receiveAward(testAward);
            System.out.println(String.format("The recipient %s received %d %s award", nominee.getName(), testAward.getValue(), testAward.getCurrency()));
                    }

    }

    public void maxNominatorQuantity (Nominee nominee, Award award) {

        for(int a=0; a < )

    }



}


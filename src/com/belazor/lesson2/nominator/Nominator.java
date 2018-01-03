package com.belazor.lesson2.nominator;


import com.belazor.lesson2.award.Award;
import com.belazor.lesson2.nominee.Nominee;

import java.util.List;


public class Nominator {

    private String name;

    private int nominatorAwardQuantityLimit;

    private float nominatorAwardAmountLimit;

    public Nominator(String name) {
        this.name = name;
    }

    public Nominator(String name, int nominatorAwardQuantityLimit, float nominatorAwardAmountLimit) {
        this.name = name;
        this.nominatorAwardQuantityLimit = nominatorAwardQuantityLimit;
        this.nominatorAwardAmountLimit = nominatorAwardAmountLimit;
    }

    public int getNominatorAwardQuantityLimit() {
        return nominatorAwardQuantityLimit;
    }

    public float getNominatorAwardAmountLimit() {
        return nominatorAwardAmountLimit;
    }

    public void setNominatorAwardQuantityLimit(int nominatorAwardQuantityLimit) {
        this.nominatorAwardQuantityLimit = nominatorAwardQuantityLimit;
    }

    public void setNominatorAwardAmountLimit(float nominatorAwardAmountLimit) {
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

    //public void maxNominatorQuantity (Nominee nominee, Award award) {


    public void nominateTillNomineeAwardQuantityLimit(Nominee nominee, Award award) {
        for (int i = 1; i <= nominee.getNomineeAwardQuantityLimit() + 1; i++) {

            if (i < nominee.getNomineeAwardQuantityLimit()) {
                nominee.receiveAward(award);
                System.out.println(name + " gives award " + i + " to " + nominee.getName());

            } else if (i == nominee.getNomineeAwardQuantityLimit()) {
                nominee.receiveAward(award);
                System.out.println(name + " gives award " + i + " to " + nominee.getName());

            } else {
                System.out.println("Award quantity limit " + nominee.getNomineeAwardQuantityLimit() + " is reached for recipient " + nominee.getName() + " for awards quantity");

                System.out.println("Total number of received awards is " + nominee.getNomineeAwardQuantityLimit());
            }
        }
    }


    public void nominateTillNominatorAwardQuantityLimit(Nominee nominee, Award award) {
        int nominationsCount = 1;
        int count = 0;
        do {
            nominee.receiveAward(award);
            count++;
            System.out.println(name + " gives award " + nominationsCount + " to " + nominee.getName());
            nominationsCount++;
        } while (nominationsCount <= getNominatorAwardQuantityLimit());

        System.out.println("Award quantity limit " + getNominatorAwardQuantityLimit() + " is reached for nominator " + name + " for quantity of awards");
        System.out.println("Total number of given awards is " + count);
    }


    public void nominateTillNominatorAwardAmountLimit(Nominee nominee, Award award) {
        int totalAwardAmountForNominator = 0;
        int count = 0;
        while (totalAwardAmountForNominator + award.getValue() <= getNominatorAwardAmountLimit()) {
            totalAwardAmountForNominator += award.getValue();
            nominee.receiveAward(award);
            count++;
            System.out.println(name + " gives award for " + award.getValue() + " to " + nominee.getName());
        }
        System.out.println("Award amount limit " + getNominatorAwardAmountLimit() + " is reached for nominator " + name + " for total amount of awards");
        System.out.println("Total number of given awards is " + count);
    }

    public void nominateTillNomineeAwardAmountLimit1(Nominee nominee, Award award) {
        int totalAwardAmountForNominee = 0;
        int count = 0;
        while (totalAwardAmountForNominee + award.getValue() <= nominee.getNomineeAwardAmountLimit()) {
            if (totalAwardAmountForNominee + award.getValue() < nominee.getNomineeAwardAmountLimit()) {
                totalAwardAmountForNominee += award.getValue();
                nominee.receiveAward(award);
                count++;
                System.out.println(name + " gives award for " + award.getValue() + " to " + nominee.getName() + ". No restrictions");
            }
            if (totalAwardAmountForNominee + award.getValue() == nominee.getNomineeAwardAmountLimit()) {
                totalAwardAmountForNominee += award.getValue();
                nominee.receiveAward(award);
                count++;
                System.out.println(name + " gives award for " + award.getValue() + " to " + nominee.getName() + ". This is last award before restriction");
            }
        }
        System.out.println("Award amount limit " + nominee.getNomineeAwardAmountLimit() + " is reached for nominee " + name + " for total amount of awards");
        System.out.println("Total number of given awards is " + count);


    }

    public void nominateTillNomineeAwardAmountLimit(Nominee nominee, Award award) {
        Integer totalAwardAmountForNominee = 0;
        Double currentAwardAmount = (double) (totalAwardAmountForNominee + award.getValue());
        Double amountLimit = nominee.getNomineeAwardAmountLimit();
        int comparison = currentAwardAmount.compareTo(amountLimit);

        while (currentAwardAmount <= nominee.getNomineeAwardAmountLimit()) {
            switch (comparison) {
                case -1:
                    System.out.println("Give award");
                    currentAwardAmount += award.getValue();
                    break;
                case 0:
                    System.out.println("Last award");
                    currentAwardAmount += award.getValue();
                    break;
                case 1:
                    System.out.println("No award");
                    break;
                default:
                    System.out.println("Nothing");

            }
        }
        System.out.println("Total amount of given awards is " + currentAwardAmount);


    }


}


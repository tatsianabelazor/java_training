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

    public void nominate(Nominee nominee, List<Award> givenAwards) {
        for (Award award: givenAwards) {
            nominee.receiveAward(award);
        }

    }
    /*
    3.1 Nominator дает авадру Nominee пока не достигнет nominatorAwardQuantityLimit
     */

    public void nominateTillNominatorAwardQuantityLimit(Nominee nominee, Award award) {
        int nominationCounts = 1;
        int a = 0;
        do {
            nominee.receiveAward(award);
            a++;
            System.out.println(String.format("%s gives %s award to %s.", name, award.getValue(), nominee.getName()));
            nominationCounts++;
        } while (nominationCounts <= getNominatorAwardQuantityLimit());

        System.out.println(String.format("Total number of given awards is %s", a));
    }

    /*
    3.2 Nominator дает авадру Nominee пока не достигнет nominatorAwardAmountLimit test
     */

    public void nominateTillNominatorAwardAmountLimit(Nominee nominee, Award award) {
        int nominatorAwardAmount = 0;
        int b = 0;
        while (nominatorAwardAmount + award.getValue() <= getNominatorAwardAmountLimit()) {
            nominatorAwardAmount += award.getValue();
            nominee.receiveAward(award);
            b++;
            System.out.println(String.format("%s gives %s EUR to %s.", name, award.getValue(), nominee.getName()));
        }
        System.out.println(String.format("Total number of given awards is %s", b));
    }

    /*
    3.3 Nominator дает авадру Nominee пока не достигнет nomineeAwardQuantityLimit
     */


    public void nominateTillNomineeAwardQuantityLimit(Nominee nominee, Award award) {
        for (int i = 1; i <= nominee.getNomineeAwardQuantityLimit(); i++) {
            nominee.receiveAward(award);
            System.out.println(String.format("%s gives %s award", name, i));
        }
    }

    /*
    3.4 Nominator дает авадру Nominee пока не достигнет nomineeAwardAmountLimit
     */

    public void nominateTillNomineeAwardAmountLimit(Nominee nominee, Award award) {
        int nomineeAwardAmount = 0;
        int с = 0;
        while (nomineeAwardAmount + award.getValue() <= nominee.getNomineeAwardAmountLimit()) {
            nominee.receiveAward(award);
            с++;
           System.out.println(String.format("Total number of given awards is %s", с));

        }
    }

}


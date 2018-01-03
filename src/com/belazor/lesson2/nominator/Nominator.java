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

    /*
    3.1 Nominator дает авадру Nominee пока не достигнет nominatorAwardQuantityLimit
     */

    public void nominateTillNominatorAwardQuantityLimit(Nominee nominee, Award award) {
        int nominationsCount = 1;
        int count = 0;
        do {
            nominee.receiveAward(award);
            count++;
            System.out.println(String.format("%s gives %s EUR to %s. Without restrictions", name, award.getValue(), nominee.getName()));
            nominationsCount++;
        } while (nominationsCount <= getNominatorAwardQuantityLimit());

        System.out.println(String.format("Total number of given awards is %s", count));
    }

    /*
    3.2 Nominator дает авадру Nominee пока не достигнет nominatorAwardAmountLimit
     */

    public void nominateTillNominatorAwardAmountLimit(Nominee nominee, Award award) {
        int totalAwardAmountForNominator = 0;
        int count = 0;
        while (totalAwardAmountForNominator + award.getValue() <= getNominatorAwardAmountLimit()) {
            totalAwardAmountForNominator += award.getValue();
            nominee.receiveAward(award);
            count++;
            System.out.println(String.format("%s gives %s EUR to %s. Without restrictions", name, award.getValue(), nominee.getName()));
        }
        System.out.println(String.format("Total number of given awards is %s", count));
    }

    /*
    3.3 Nominator дает авадру Nominee пока не достигнет nomineeAwardQuantityLimit
     */


    public void nominateTillNomineeAwardQuantityLimit(Nominee nominee, Award award) {
        for (int i = 1; i <= nominee.getNomineeAwardQuantityLimit() + 1; i++) {

            if (i < nominee.getNomineeAwardQuantityLimit()) {
                nominee.receiveAward(award);
                System.out.println(String.format("%s gives %s award to %s", name, i, nominee.getName()));

            } else if (i == nominee.getNomineeAwardQuantityLimit()) {
                nominee.receiveAward(award);
                System.out.println(String.format("%s gives %s award to %s", name, i, nominee.getName()));

            } else {
                System.out.println(String.format("Award quantity limit %s", nominee.getNomineeAwardQuantityLimit()));

                System.out.println(String.format("Number of received awards is %s", nominee.getNomineeAwardQuantityLimit()));
            }
        }
    }

    /*
    3.4 Nominator дает авадру Nominee пока не достигнет nomineeAwardAmountLimit
     */

    public void nominateTillNomineeAwardAmountLimit(Nominee nominee, Award award) {
        int totalAwardAmountForNominee = 0;
        int count = 0;
        while (totalAwardAmountForNominee + award.getValue() <= nominee.getNomineeAwardAmountLimit()) {
            if (totalAwardAmountForNominee + award.getValue() < nominee.getNomineeAwardAmountLimit()) {
                totalAwardAmountForNominee += award.getValue();
                nominee.receiveAward(award);
                count++;
                System.out.println(String.format("%s gives %s EUR to %s. Without restrictions", name, award.getValue(), nominee.getName()));
            }
            if (totalAwardAmountForNominee + award.getValue() == nominee.getNomineeAwardAmountLimit()) {
                totalAwardAmountForNominee += award.getValue();
                nominee.receiveAward(award);
                count++;
                System.out.println(String.format("%s gives %s EUR to %s. Restrictions", name, award.getValue(), nominee.getName()));
            }
        }
        System.out.println(String.format("Award amount limit is %s", nominee.getNomineeAwardAmountLimit()));
        System.out.println(String.format("Total number of given awards is %s", count));


    }

}


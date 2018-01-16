package com.belazor.lesson2;

import com.belazor.lesson2.award.Award;
import com.belazor.lesson2.nominator.Nominator;
import com.belazor.lesson2.nominee.Nominee;

/**
 * Created by Tatsiana_Belazor on 11-Jan-18.
 */
public class LimitsCheck {


    /**
     * Nominator gives an award to Nominee till reach nominatorAwardQuantityLimit
     * @param nominee award recipient
     * @param nominator award nominator
     * @param award award object
     */
    public void nominateTillNominatorAwardQuantityLimit(Nominee nominee, Nominator nominator, Award award) {
        int awardQuantity = 0;//TODO

        do {
            nominee.receiveAward(award);
            awardQuantity++;
            System.out.println(String.format("%s gives %s award to %s.", nominator.getName(), award.getValue(), nominee.getName()));
            awardQuantity++;
        } while (awardQuantity <= nominator.getAwardQuantityLimit());

        System.out.println(String.format("Total number of given awards is %s", awardQuantity));
    }

    /**
     * Nominator gives an award to Nominee till reach nominatorAwardAmountLimit
     * @param nominee award recipient
     * @param nominator award nominator
     * @param award award object
     */
    public void nominateTillNominatorAwardAmountLimit(Nominee nominee, Nominator nominator, Award award) {
        int nominatorAwardAmount = 0;
        int awardAmount = 0;
        while (nominatorAwardAmount + award.getValue() <= nominator.getAwardAmountLimit()) {
            nominatorAwardAmount += award.getValue();
            nominee.receiveAward(award);
            awardAmount++;
            System.out.println(String.format("%s gives %s EUR to %s.", nominator.getName(), award.getValue(), nominee.getName()));
        }
        System.out.println(String.format("Total number of given awards is %s", awardAmount)); //todo +amount
    }

    /**
     * Nominator gives an award to Nominee till reach nomineeAwardQuantityLimit
     * @param nominee award recipient
     * @param nominator award nominator
     * @param award award object
     */
    public void nominateTillNomineeAwardQuantityLimit(Nominee nominee, Nominator nominator, Award award) {
        for (int i = 1; i <= nominee.getAwardQuantityLimit(); i++) {
            nominee.receiveAward(award);
            System.out.println(String.format("%s gives %s award", nominator.getName(), i));
        }
    }

    /**
     * Nominator gives an award to Nominee till reach nomineeAwardAmountLimit
     * @param nominee award recipient
     * @param nominator award nominator
     * @param award award object
     */
    public void nominateTillNomineeAwardAmountLimit(Nominee nominee, Nominator nominator, Award award) {
        int nomineeAwardAmount = 0;
        int awardAmount = 0;
        while (nomineeAwardAmount + award.getValue() <= nominee.getAwardAmountLimit()) {
            nominee.receiveAward(award);
            awardAmount++;

            System.out.println(String.format("Nominator is %s", nominator.getName()));
            System.out.println(String.format("Total number of given awards is %s", awardAmount));

        }
    }

}

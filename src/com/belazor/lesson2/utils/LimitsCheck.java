package com.belazor.lesson2.utils;

import com.belazor.lesson2.award.Award;
import com.belazor.lesson2.nominator.Nominator;
import com.belazor.lesson2.nominee.Nominee;

/**
 * Created by Tatsiana_Belazor on 11-Jan-18.
 */
public class LimitsCheck {

    private static final int NOMINATOR_AWARD_QUANTITY_LIMIT_CONSTANT = 1;
    private static final int NOMINATOR_AWARD_AMOUNT_LIMIT_CONSTANT = 2;
    private static final int NOMINEE_AWARD_QUANTITY_LIMIT_CONSTANT = 3;
    private static final int NOMINEE_AWARD_AMOUNT_LIMIT_CONSTANT = 4;


    /**
     * Nominator gives an award to Nominee till reach nominatorAwardQuantityLimit
     *
     * @param nominee   award recipient
     * @param nominator award nominator
     * @param award     award object
     */
    public void nominateTillNominatorAwardQuantityLimit(Nominee nominee, Nominator nominator, Award award) {

        int awardQuantity = 0;
        do {
            nominee.receiveAward(award);
            awardQuantity++;
            System.out.println(String.format("%s gives %s award to %s.", nominator.getName(), award.getValue(), nominee.getName()));
            awardQuantity++;
        } while (awardQuantity <= nominator.getAwardQuantityLimit());

        displayLimit(NOMINATOR_AWARD_QUANTITY_LIMIT_CONSTANT);
        System.out.println(String.format("Total number of given awards is %s", awardQuantity));
    }

    /**
     * Nominator gives an award to Nominee till reach nominatorAwardAmountLimit
     *
     * @param nominee   award recipient
     * @param nominator award nominator
     * @param award     award object
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

        displayLimit(NOMINATOR_AWARD_AMOUNT_LIMIT_CONSTANT);
        System.out.println(String.format("Total number of given awards is %s", awardAmount)); //todo +amount
    }

    /**
     * Nominator gives an award to Nominee till reach nomineeAwardQuantityLimit
     *
     * @param nominee   award recipient
     * @param nominator award nominator
     * @param award     award object
     */
    public void nominateTillNomineeAwardQuantityLimit(Nominee nominee, Nominator nominator, Award award) {
        for (int i = 1; i <= nominee.getAwardQuantityLimit(); i++) {
            nominee.receiveAward(award);
            System.out.println(String.format("%s gives %s award", nominator.getName(), i));
        }
        displayLimit(NOMINEE_AWARD_QUANTITY_LIMIT_CONSTANT);
    }

    /**
     * Nominator gives an award to Nominee till reach nomineeAwardAmountLimit
     *
     * @param nominee   award recipient
     * @param nominator award nominator
     * @param award     award object
     */
    public void nominateTillNomineeAwardAmountLimit(Nominee nominee, Nominator nominator, Award award) {
        int nomineeAwardAmount = 0;
        int awardAmount = 0;
        while (nomineeAwardAmount + award.getValue() <= nominee.getAwardAmountLimit()) {
            nominee.receiveAward(award);
            nomineeAwardAmount += award.getValue();
            awardAmount++;
            System.out.println(String.format("Nominator is %s", nominator.getName()));
            System.out.println(String.format("Total number of given awards is %s", awardAmount));

        }
        displayLimit(NOMINEE_AWARD_AMOUNT_LIMIT_CONSTANT);
    }

    private void displayLimit(int limitType) {
        switch (limitType) {
            case 1:
                System.out.println(String.format("NominatorAwardQuantityLimit"));
                break;
            case 2:
                System.out.println(String.format("NominatorAwardQuantityLimit"));
                break;
            case 3:
                System.out.println(String.format("NomineeAwardQuantityLimit"));
                break;
            case 4:
                System.out.println(String.format("NomineeAwardAmountLimit"));
                break;
            default:
                System.out.println("Not supported limit");
        }
    }
}



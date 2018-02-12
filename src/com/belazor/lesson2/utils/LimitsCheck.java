package com.belazor.lesson2.utils;

import com.belazor.lesson2.award.Award;
import com.belazor.lesson2.nominee.Nominee;
import com.belazor.lesson2.person.Person;

/**
 * Created by Tatsiana_Belazor on 11-Jan-18.
 */
public class LimitsCheck {

    /**
     * Create constants
     */
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
    public void nominateTillNominatorAwardQuantityLimit(Person nominee, Person nominator, Award award) throws ValidationException {

        int awardQuantity = 0;
        do {
            awardQuantity++;
            System.out.println(String.format("%s gives %s award to %s.", nominator.getName(), award.getValue(), nominee.getName()));
            awardQuantity++;
        } while (nominator.isLimitReached(awardQuantity, 1));

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
    public void nominateTillNominatorAwardAmountLimit(Person nominee, Person nominator, Award award) throws ValidationException {
        int nominatorAwardAmount = 0;
        int awardAmount = 0;
        //while (nominatorAwardAmount + award.getValue() <= nominator.getAwardamountlimit()) {
        while (nominator.isLimitReached(awardAmount, award.getValue())) {
            nominatorAwardAmount += award.getValue();
            //nominee.receiveAward(award);
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
     * Приведение типов
     */
    public void nominateTillNomineeAwardQuantityLimit(Person nominee, Person nominator, Award award) {
        Nominee nom = (Nominee) nominee;//TODO read instance of
        for (int i = 1; i <= nom.getAwardQuantityLimit(); i++) {
            nom.receiveAward(award);
            System.out.println(String.format("%s gives %s award", nominator.getName(), i));
        }
        try {
            displayLimit(NOMINEE_AWARD_QUANTITY_LIMIT_CONSTANT);
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Nominator gives an award to Nominee till reach nomineeAwardAmountLimit
     *
     * @param nominee   award recipient
     * @param nominator award nominator
     * @param award     award object
     *  Throw exception
     */
    public void nominateTillNomineeAwardAmountLimit(Person nominee, Person nominator, Award award) throws ValidationException {
        int nomineeAwardAmount = 0;
        int awardAmount = 0;
        while (nominee.isLimitReached(nomineeAwardAmount, award.getValue())) {
            nomineeAwardAmount += award.getValue();
            awardAmount++;
            System.out.println(String.format("Nominator is %s", nominator.getName()));
            System.out.println(String.format("Total number of given awards is %s", awardAmount));
        }
        displayLimit(NOMINEE_AWARD_AMOUNT_LIMIT_CONSTANT);
    }

    private void displayLimit(int limitType) throws ValidationException {
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
                throw new ValidationException("Not supported limit");
        }
    }
}



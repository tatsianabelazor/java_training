package com.belazor.lesson2;

import com.belazor.lesson2.award.Award;
import com.belazor.lesson2.award.AwardType;
import com.belazor.lesson2.nominator.Nominator;
import com.belazor.lesson2.nominee.Nominee;
import com.belazor.lesson2.person.Person;
import com.belazor.lesson2.utils.LimitsCheck;
import com.belazor.lesson2.utils.NominationHelper;
import com.belazor.lesson2.utils.ValidationException;

import javax.management.relation.Role;

/**
 * Created by Tatsiana_Belazor on 10-Jan-18.
 */


public class HomeworkLimits {

    public static void main(String args[]) {

        Person nominator = new Nominator("Greg");
        Person nominee1 = new Nominee("Pete");
        Person nominee2 = new Nominee("Jack");

        LimitsCheck awardLimitCheck = new LimitsCheck();

        Person limitNominator = new Nominator("Jack", 10, 500);
        limitNominator.displayWhoIAm();
        limitNominator.displayRole();

        Person limitNominee = new Nominee("John", 5, 400);
        limitNominee.displayWhoIAm();
        limitNominee.displayRole();

        Award limitAward = new Award(5, "USD", 1, AwardType.CASH);



        System.out.println(String.format("Nominator of the award is %s", limitNominator.getName()));
        System.out.println(String.format("Recipient of the award is %s", limitNominee.getName()));
        System.out.println(String.format("The award is %s", limitAward.getValue()));

        awardLimitCheck.nominateTillNomineeAwardQuantityLimit(limitNominee, limitNominator, limitAward);
        try {
            awardLimitCheck.nominateTillNominatorAwardQuantityLimit(limitNominee, limitNominator, limitAward);
            awardLimitCheck.nominateTillNominatorAwardAmountLimit(limitNominee, limitNominator, limitAward);
            awardLimitCheck.nominateTillNomineeAwardAmountLimit(limitNominee, limitNominator, limitAward);
        } catch (ValidationException e) {
            System.out.println(e.getMessage());

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }
}


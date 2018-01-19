package com.belazor.lesson2;

import com.belazor.lesson2.award.Award;
import com.belazor.lesson2.nominator.Nominator;
import com.belazor.lesson2.nominee.Nominee;
import com.belazor.lesson2.utils.LimitsCheck;

/**
 * Created by Tatsiana_Belazor on 10-Jan-18.
 */


public class HomeworkLimits {

    public static void main(String args[]) {

        LimitsCheck awardLimitCheck = new LimitsCheck();

        Nominator limitNominator = new Nominator("Jack");
        limitNominator.setAwardQuantityLimit(10);
        limitNominator.setAwardAmountLimit(500);

        Nominee limitNominee = new Nominee("John");
        limitNominee.setAwardQuantityLimit(5);
        limitNominee.setAwardAmountLimit(400);

        Award limitAward = new Award(5);

        System.out.println(String.format("Nominator of the award is %s", limitNominator.getName()));
        System.out.println(String.format("Recipient of the award is %s", limitNominee.getName()));
        System.out.println(String.format("The award is %s", limitAward.getValue()));

        awardLimitCheck.nominateTillNominatorAwardQuantityLimit(limitNominee, limitNominator, limitAward);
        awardLimitCheck.nominateTillNominatorAwardAmountLimit(limitNominee, limitNominator, limitAward);
        awardLimitCheck.nominateTillNomineeAwardQuantityLimit(limitNominee, limitNominator, limitAward);
        awardLimitCheck.nominateTillNomineeAwardAmountLimit(limitNominee, limitNominator, limitAward);
    }

}



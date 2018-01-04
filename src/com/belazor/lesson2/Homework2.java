package com.belazor.lesson2;

import com.belazor.lesson2.award.Award;
import com.belazor.lesson2.nominator.Nominator;
import com.belazor.lesson2.nominee.Nominee;

import java.util.ArrayList;
import java.util.List;

public class Homework2 {


    public static void main(String[] args) {

        Award myAward1 = new Award(10);
        Award myAward2 = new Award("EUR", 25);
        Award myAward3 = new Award("EUR", 35);
        Award awardWithSoli = new Award(20, 1000);
        Nominee myNominee = new Nominee("Boss");
        Nominee myNominee1 = new Nominee("John");
        Nominator myNominator1 = new Nominator("Adam", 3, 200);
        Nominee myNominee2 = new Nominee("Jack", 2, 100);

        System.out.println(String.format("Recipient of the award is %s", myNominee.getName()));
        System.out.println(String.format("Recipient of the award is %s", myNominee1.getName()));
        System.out.println(String.format("The amount of the award 1 = %d %s", myAward1.getValue(), myAward1.getCurrency()));
        System.out.println(String.format("The amount of the award 2 = %d %s", myAward2.getValue(), myAward2.getCurrency()));


        Nominator myNominator = new Nominator("Manager");


        myNominator.nominate(myNominee, awardWithSoli);
        myNominator.nominate(myNominee, myAward2);

        List<Nominee> nomineesName = new ArrayList<>();
        nomineesName.add(new Nominee("John"));
        nomineesName.add(new Nominee("Pete"));
        nomineesName.add(new Nominee("Ben"));

        myNominator.nominate(nomineesName, myAward1);

        //myNominee.calculation(myAward1);
        //myNominee1.calculation(myAward1);
        //myNominee2.calculation(myAward1);


        double nominee1CalcRes1 = myNominee.calculation(myAward1);
        System.out.println(String.format("First quantity is %s", nominee1CalcRes1));

        double nominee2CalcRes2 = myNominee1.calculation(myAward2);
        System.out.println(String.format("Second quantity is %s", nominee2CalcRes2));

        double nominee3CalcRes3 = myNominee2.calculation(myAward3);
        System.out.println(String.format("Third quantity is %s", nominee3CalcRes3));


        if (nominee1CalcRes1 < nominee2CalcRes2) {
            System.out.println(String.format("%s's award is smaller than %s's award", myNominee.getName(), myNominee1.getName()));
        }
        if (nominee1CalcRes1 >= nominee2CalcRes2) {
            System.out.println(String.format("%s award is bigger or equal to %s award", myNominee.getName(), myNominee1.getName()));
        }
        if (nominee1CalcRes1 != nominee2CalcRes2) {
            System.out.println(String.format("%s award is not equal to %s award", myNominee.getName(), myNominee1.getName()));
        }
        if (nominee1CalcRes1 < nominee2CalcRes2 && nominee1CalcRes1 < nominee3CalcRes3) {
            System.out.println(String.format("%s award is the smallest", myNominee.getName()));
        }


        myNominator1.nominateTillNominatorAwardQuantityLimit(myNominee2, myAward2);
        myNominator1.nominateTillNominatorAwardAmountLimit(myNominee2, myAward2);
        myNominator1.nominateTillNomineeAwardQuantityLimit(myNominee2, myAward2);
        myNominator1.nominateTillNomineeAwardAmountLimit(myNominee2, myAward2);


    }


}

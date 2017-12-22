package com.belazor.lesson2;

import com.belazor.lesson2.award.Award;
import com.belazor.lesson2.nominator.Nominator;
import com.belazor.lesson2.nominee.Nominee;

public class Homework2 {


    public static void main(String[] args) {

        Award myAward1 = new Award(5);
        Award myAward2 = new Award("EUR", 10);
        Award myAward3 = new Award("EUR", 15);
        Nominee myNominee = new Nominee("Boss");
        Nominee myNominee1 = new Nominee("John");

        System.out.println(String.format("Recipient of the award is %s", myNominee.getName()));
        System.out.println(String.format("Recipient of the award is %s", myNominee1.getName()));
        System.out.println(String.format("The amount of the award 1 = %d %s", myAward1.getValue(), myAward1.getCurrency()));
        System.out.println(String.format("The amount of the award 2 = %d %s", myAward2.getValue(), myAward2.getCurrency()));


        Nominator myNominator = new Nominator("Manager");


        myNominator.nominate(myNominee, myNominee1, myAward1);
        myNominator.nominate(myNominee, myNominee1, myAward2);
    }


}

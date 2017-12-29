package com.belazor.lesson2;

import com.belazor.lesson2.award.Award;
import com.belazor.lesson2.nominator.Nominator;
import com.belazor.lesson2.nominee.Nominee;

import java.util.ArrayList;
import java.util.List;

public class Homework2 {


    public static void main(String[] args) {

        Award myAward1 = new Award(25);
        Award myAward2 = new Award("EUR", 10);
        Award myAward3 = new Award("EUR", 15);
        Award awardWithSoli = new Award (20, 1000);
        Nominee myNominee = new Nominee("Boss");
        Nominee myNominee1 = new Nominee("John");

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


    }


}

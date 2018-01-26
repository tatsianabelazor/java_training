package com.belazor.lesson2;

import com.belazor.lesson2.award.Award;
import com.belazor.lesson2.nominator.Nominator;
import com.belazor.lesson2.nominee.Nominee;
import com.belazor.lesson2.utils.NominationHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Homework2Extra {


    public static void main(String[] args) {

        Award myAward1 = new Award(10);
        Award myAward2 = new Award("EUR", 25);
        Award myAward3 = new Award("EUR", 35);
        Award awardWithSoli = new Award(20, 1000);
        Nominee nominee1 = new Nominee("Boss");
        Nominee nominee2 = new Nominee("John");
        Nominator nominator = new Nominator("Adam", 3, 200);


        List<Award> nominee1Awards = new ArrayList<>();
        nominee1Awards.add(myAward1);
        nominee1Awards.add(myAward3);

        List<Award> nominee2Awards = Arrays.asList(myAward2, myAward3, awardWithSoli);

        nominator.nominate(nominee1, nominee1Awards);
        nominator.nominate(nominee2, nominee2Awards);

        int nominee1Population = NominationHelper.calcPopulation(nominee1Awards);
        System.out.println("nominee1Population=" + nominee1Population);
        double nominee1CalcRes1 = NominationHelper.calculation(myAward3, nominee1Population);

        System.out.println(String.format("First quantity is %s", nominee1CalcRes1));

        int nominee2Population = NominationHelper.calcPopulation(nominee2Awards);
        System.out.println("nominee2Population=" + nominee2Population);
        double nominee2CalcRes2 = NominationHelper.calculation(myAward3, nominee2Population);
        System.out.println(String.format("Second quantity is %s", nominee2CalcRes2));


    }


}

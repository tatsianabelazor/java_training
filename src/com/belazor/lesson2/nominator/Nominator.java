package com.belazor.lesson2.nominator;


import com.belazor.lesson2.award.Award;
import com.belazor.lesson2.nominee.Nominee;

import java.util.ArrayList;
import java.util.Random;


public class Nominator {

    private String name;
    double calculation;
    final Random random = new Random ();

    public Nominator(String name) {
        this.name = name;
    }


    public void nominate(Nominee myNominee, Nominee myNominee1, Award testAward) {
        System.out.println(String.format("The recipient %s received %d %s award", myNominee.getName(), testAward.getValue(), testAward.getCurrency()));
        System.out.println(String.format("The recipient %s received %d %s award", myNominee1.getName(), testAward.getValue(), testAward.getCurrency()));
    }

    public void nominate(ArrayList<Nominee> nominees, Award testAward) {

    }
    public double calculation(Award award) {
        double c = random.nextDouble();
        int population = 5;
        int z = random.nextInt();
        double p = award.getValue();

        double a = ((((Math.pow(z,2))*(p)*(1-p)))/(Math.pow(c,2)));
        System.out.println();

        return calculation(award);
    }


}


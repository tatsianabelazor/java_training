package com.belazor.lesson2.nominator;


import com.belazor.lesson2.award.Award;
import com.belazor.lesson2.nominee.Nominee;

public class Nominator {

    private String name;

    public Nominator(String name) {
        this.name = name;
    }


    public void nominate(Nominee myNominee, Nominee myNominee1, Award testAward) {
        System.out.println(String.format("The recipient %s received %d %s award", myNominee.getName(), testAward.getValue(), testAward.getCurrency()));
        System.out.println(String.format("The recipient %s received %d %s award", myNominee1.getName(), testAward.getValue(), testAward.getCurrency()));
    }


}


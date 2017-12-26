package com.belazor.lesson2.nominee;

import com.belazor.lesson2.award.Award;

public class Nominee {

    private String Name;

    public Nominee(String name) {
        this.Name = name;
    }

    public String getName() {
        return Name;
    }

    public Integer receiveAward(Award myAward) {

        if (myAward.getSoli() >= 0){
            double result = myAward.getSoli() * myAward.getValue();
            System.out.println(String.format("Award with soli = %s", result, myAward.getSoli()));
            System.out.println("Award is decreased in " + (result/myAward.getValue()* 100) + "%");
        } else {
            System.out.println(String.format("Award without soli + %d", myAward.getValue()));
        }
        return myAward.getValue();

    }

}




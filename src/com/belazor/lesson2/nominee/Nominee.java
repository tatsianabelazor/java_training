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
        return myAward.getValue();
    }

}




package com.belazor.lesson2.utils;


import com.belazor.lesson2.award.Award;

import java.util.List;
import java.util.Random;

/**
 * Created by Tatsiana_Belazor on 15-Jan-18.
 */
public class NominationHelper {

    /**
     * This method is used to calculate quantity of the awards
     * @param myAward award object
     * @return
     */
    public static double calculation(Award myAward) {
        int population = 5;
        return calculation(myAward, population);
    }

    /**
     * This method is used to calculate quantity of the awards
     * @param award award object
     * @param population
     * @return
     */
    public static double calculation(Award award, int population) {
        //System.out.println("Award before calculation " + award.getValue());
        final Random random = new Random();
        double c = random.nextDouble();
        //System.out.println("c=" + c);
        int z = random.nextInt();
        //System.out.println("z=" + z);
        double p = award.getValue();

        double a = ((((Math.pow(z, 2)) * (p) * (1 - p))) / (Math.pow(c, 2)));
        // System.out.println("Formula");
        double calculation = a / (1 + ((a - 1) / population));
        //System.out.println("Award after calculation " + calculation);
        return calculation;
    }

    /**
     * This method is used to calculate quantity of awards without soli
     * @param awards
     * @return
     */
    public static int calcPopulation(List<Award> awards){
        int countWithoutSoli = 0;
        for (Award a: awards) {
            if (a.getSoli() == 0) {
                countWithoutSoli++;
            }
        }
        return countWithoutSoli;

    }


}

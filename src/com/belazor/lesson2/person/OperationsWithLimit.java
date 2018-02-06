package com.belazor.lesson2.person;

/**
 * Created by Tatsiana_Belazor on 29-Jan-18.
 */
public interface OperationsWithLimit {

    boolean isLimitReached(int interLimitValue, int finalLimitValue);
    boolean isLimitReached(double interLimitValue, double finalLimitValue);
}

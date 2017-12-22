package com.belazor.lesson1;

/**
 * Created by Tatsiana_Belazor on 13-Dec-17.
 */

/**
 * 1. Написать command-line приложение, которое будет:
 * <p>
 * a) выводить в консоль следующий текст:
 * <p>
 * We make work HUMAN. Unlock full potential. Celebrate positive moments. Every day.
 * <p>
 * b) вывести на косоль длину 2ой строки
 * <p>
 * c) переписать всё в нижнем регистре
 * <p>
 * с) заменить символ ‘e’ на ‘E’.
 */

public class Homework1 {

    private static final String MY_CONSTANT_1 = "We make work HUMAN.";
    private static final String MY_CONSTANT_2 = "Unlock full potential. Celebrate positive moments.";
    private static final String MY_CONSTANT_3 = "Every day.";
    private static final String NEW_LINE = "\n";


    public static void main(String args[]) {
        task1();
        System.out.println("-----------");
        task2();
        System.out.println("-----------");
        task3();
    }

    private static void task1() {
        String fullText = MY_CONSTANT_1 + NEW_LINE + MY_CONSTANT_2 + NEW_LINE + MY_CONSTANT_3;
        System.out.println(fullText);
        //fullText = fullText.toLowerCase();
        System.out.println(fullText.toLowerCase());
        System.out.println(fullText.replace('e', 'E'));
        System.out.println(fullText);
    }

    private static void task2() {
        System.out.println(String.format("Length of my string is %d", MY_CONSTANT_2.length()));
    }

    /**
     * 3. a) Создать строку 'Globoforce' как массив символов.
     * <p>
     * b) вывести размер массива.
     * <p>

     * с) заменить символ ‘b’, на символ ‘$’
     */

    private static void task3() {
        char[] logoArray = {'G', 'l', 'o', 'b', 'o', 'f', 'o', 'r', 'c', 'e'};
        String logoString = new String(logoArray);
        System.out.println(logoString);
        System.out.println(logoString.replace('b', '$'));
        System.out.println(String.format("Length of my array is %d", logoArray.length));
        for (int i = 0; i < logoArray.length; i++) {
            if (logoArray[i] == 'b')
                logoArray[i] = '$';
        }
        System.out.println(logoArray);
    }
}

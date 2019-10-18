package com.company.lesson1;

import java.util.Scanner;

public class Homework62 {
    public static void main(String[] args) {
        System.out.println("Enter numbers: ");
        Scanner sc = new Scanner(System.in);
        String commandLine = sc.nextLine();
        String[] numbersLine = commandLine.trim().split(" ");
        int[] numbers = new int[numbersLine.length];
        for (int i = 0; i < numbersLine.length; i++) {
            numbers[i] = Integer.parseInt(numbersLine[i]);
        }
        int maxNumber = numbers[0];
        int minNumber = numbers[0];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > maxNumber) {
                maxNumber = numbers[i];
            } else if (numbers[i] < minNumber) {
                minNumber = numbers[i];
            }
        }
        System.out.println("Max number: " + maxNumber);
        System.out.println("Min number: " + minNumber);


    }

}


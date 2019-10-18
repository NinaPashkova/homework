package com.company.lesson1;

import java.util.Scanner;

public class Homework66 {
    public static void main(String[] args) {
        System.out.println("Enter numbers: ");
        Scanner sc = new Scanner(System.in);
        String commandLine = sc.nextLine();
        String[] numbersLine = commandLine.trim().split(" ");
        int[] numbers = new int[numbersLine.length];
        for (int i = 0; i < numbersLine.length; i++) {
            numbers[i] = Integer.parseInt(numbersLine[i]);
        }
        for (int i = 0; i < numbers.length; i++) {
            String currentNumber = "";
            currentNumber += numbers[i];
            if (currentNumber.length()%2 == 0){
            int midOfLine = currentNumber.length()/2;
            String[] currentNumberArr = currentNumber.trim().split("", 2);
            String ourNumber = "";
        }
    }
}

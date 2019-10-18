package com.company.lesson1;

import java.util.Scanner;

public class Homework66 {
    public static void main(String[] args) {
        System.out.println("Enter numbers: ");
        Scanner sc = new Scanner(System.in);
        String commandLine = sc.nextLine();
        String happyNumbers = "";
        String[] numbersLine = commandLine.trim().split(" ");

        for (int i = 0; i < numbersLine.length; i++) {
            if (numbersLine[i].length() % 2 == 0) {
                int midOfLine = numbersLine[i].length() / 2;
                String firstNumber = numbersLine[i].substring(0, midOfLine);
                String secondNumber = numbersLine[i].substring(midOfLine);
                String[] firstNumbers = firstNumber.split("");
                String[] secondNumbers = secondNumber.split("");
                int firstSum = 0;
                int secondSum = 0;
                for (int j = 0; j < firstNumbers.length; j++) {
                   firstSum += Integer.parseInt(firstNumbers[j]);
                   secondSum += Integer.parseInt(secondNumbers[j]);
                }

                if (firstSum == secondSum) {
                    happyNumbers += numbersLine[i] + " ";
                }

            }
        }
        System.out.println("Happy numbers: " + happyNumbers);
    }
}

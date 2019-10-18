package com.company.lesson1;

import java.util.Scanner;

public class Homework6a {
    public static void main(String[] args) {
        System.out.println("Enter numbers: ");
        Scanner sc = new Scanner(System.in);
        String commandLine = sc.nextLine();
        int[] evenNumbers = new int[0];
        int[] oddNumbers = new int[0];
        for (String i : commandLine.trim().split(" ")) {
            int number = Integer.parseInt(i);
            if (number % 2 == 0) {
                int[] evenNumbersDest = new int[evenNumbers.length+1];
                System.arraycopy(evenNumbers, 0, evenNumbersDest, 0, evenNumbers.length);
                evenNumbersDest[evenNumbers.length] = number;
                evenNumbers = evenNumbersDest;
            } else {
                int[] oddNumbersDest = new int[oddNumbers.length+1];
                System.arraycopy(oddNumbers, 0, oddNumbersDest, 0, oddNumbers.length);
                oddNumbersDest[oddNumbers.length] = number;
                oddNumbers = oddNumbersDest;
            }
        }
        System.out.println("Even numbers:");
        for (int i: evenNumbers) {
            System.out.println(i);
        }
        System.out.println("Odd numbers:");
        for (int j: oddNumbers) {
            System.out.println(j);
        }


    }
}

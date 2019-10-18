package com.company.lesson1;

import java.util.Arrays;
import java.util.Scanner;

public class Homework6 {
    public static void main(String[] args) {
        System.out.println("Enter numbers: ");
        Scanner sc = new Scanner(System.in);
        String commandLine = sc.nextLine();
        String evenNumber = "";
        String oddNumber = "";
        for (String i : commandLine.trim().split(" ")) {
            int number = Integer.parseInt(i);
            if (number % 2 == 0) {
                evenNumber += number + " ";
            } else {
                oddNumber += number + " ";
            }
        }
        System.out.println("Even numbers:" + evenNumber);
        System.out.println("Odd numbers:" + oddNumber);
    }
}







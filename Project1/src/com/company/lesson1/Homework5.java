package com.company.lesson1;

import java.util.Scanner;

public class Homework5 {
    public static void main(String[] args) {
        System.out.println("Enter numbers:");
        Scanner sc = new Scanner(System.in);
        String inputLine = sc.nextLine();
        int mult = 1;
        int sum = 0;
        for (String i : inputLine.trim().split(" ") ) {
            int number = Integer.parseInt(i);
            sum += number;
            mult *= number;
        }
        System.out.println("Sum of numbers: " + sum);
        System.out.println("Multiply of numbers: " + mult);
    }
}

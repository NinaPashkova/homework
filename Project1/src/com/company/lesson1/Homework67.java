package com.company.lesson1;

import java.util.Scanner;

public class Homework67 {
    public static void main(String[] args) {
        System.out.println("Enter numbers: ");
        Scanner sc = new Scanner(System.in);
        String commandLine = sc.nextLine();
        String[] numbersLine = commandLine.trim().split(" ");
        int[] numbers = new int[numbersLine.length];
        for (int i = 0; i < numbersLine.length; i++) {
            numbers[i] = Integer.parseInt(numbersLine[i]);
        }
        for (int i = 0; i < numbers.length - 2; i++) {
          int semiSum = (numbers[i] + numbers[i+2])/2;
          if (numbers[i+1] == semiSum){
              System.out.println(numbers[i+1]);
          }
        }
    }
}

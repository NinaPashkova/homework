package com.company.lesson1;

import java.util.Scanner;

public class Homework64 {
    public static void main(String[] args) {
        System.out.println("Enter numbers: ");
        Scanner sc = new Scanner(System.in);
        String commandLine = sc.nextLine();
        String numbers = "";

        for (String i : commandLine.trim().split(" ")) {
            int number = Integer.parseInt(i);
            if (number % 5 == 0 && number % 7 == 0) {
                numbers += number + " ";
            }
        }
        System.out.println("Numbers which divide to 5 and 7:" + numbers);

    }
}

package com.company.lesson1;

import java.util.Scanner;

public class Homework63 {
    public static void main(String[] args) {
        System.out.println("Enter numbers: ");
        Scanner sc = new Scanner(System.in);
        String commandLine = sc.nextLine();
        String numbers = "";

        for (String i : commandLine.trim().split(" ")) {
            int number = Integer.parseInt(i);
            if (number % 3 == 0 || number % 9 == 0) {
                numbers += number + " ";
            }
        }
        System.out.println("Numbers which divide to 3 or 9:" + numbers);

    }
}

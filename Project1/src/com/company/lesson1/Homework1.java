package com.company.lesson1;

import java.util.Scanner;

public class Homework1 {
    public static void main(String[] args) {
        System.out.println("What's your name?");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        System.out.println("Hello " + name);
    }
}

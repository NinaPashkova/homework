package com.company.lesson1;

import java.util.Scanner;

public class Homework2 {
    public static void main(String[] args) {
        System.out.println("Type smth");
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        System.out.println(new StringBuilder(line).reverse());
    }
}

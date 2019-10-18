package com.company.lesson1;

import java.util.Scanner;

public class Homework4 {
    public static void main(String[] args) {
        String password = "123456qwerty";
        System.out.println("Enter password:");
        Scanner sc = new Scanner(System.in);
        String pass = sc.nextLine();
        if (password.equals(pass)){
            System.out.println("Welcome to system");
        }
        else {
            System.out.println("Invalid password");
        }

    }
}

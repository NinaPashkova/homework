package com.company;

public class Sampleloops {
    public static void main(String[] args) {
        int a = 100;
        if (a < 150) {
            System.out.println("a < 150");
        } else if (a > 150 && a < 200) {
            System.out.println("a > 150");
        } else {
            System.out.println("Hi");
        }
        int age = 7;
        if (age >= 2 && age <= 6) {
            System.out.println("Kindergarden");
        } else if (age >= 7 && age <= 17) {
            System.out.println("School");
        } else if (age > 17 && age <= 22) {
            System.out.println("University");
        } else if (age > 22 && age <= 65) {
            System.out.println("Work");
        } else if (age > 65 && age <= 90) {
            System.out.println("Retirement");
        } else {
            System.out.println("Invaid age");
        } // super code

        int b = 1;
        switch (b) {
            case 1:

            case 2:

            case 3:

            case 4:

            case 5:
                System.out.println("workday");
                break;
            case 6:

            case 7:
                System.out.println("weekend");
                break;
            default:
        }
    }
}

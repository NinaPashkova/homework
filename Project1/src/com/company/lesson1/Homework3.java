package com.company.lesson1;

import java.util.Random;

public class Homework3 {
    public static void main(String[] args) {
        String randNumbers = "";
        int max = 500;
        int min = 50;
        int diff = max - min;
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            randNumbers += random.nextInt(diff + 1) + "\n";
        }
        System.out.println(randNumbers);

        String spacedRandNumbers = "";
        for (int i = 0; i < 20; i++) {
            spacedRandNumbers += random.nextInt() + " ";
        }
        System.out.println(spacedRandNumbers);
    }
}

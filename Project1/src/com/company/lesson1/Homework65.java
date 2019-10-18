package com.company.lesson1;

import java.util.Scanner;

public class Homework65 {
    public static void main(String[] args) {
        System.out.println("Enter numbers: ");
        Scanner sc = new Scanner(System.in);
        String commandLine = sc.nextLine();
        String[] numbersLine = commandLine.trim().split(" ");
        int[] numbers = new int[numbersLine.length];
        for (int i = 0; i < numbersLine.length; i++) {
            numbers[i] = Integer.parseInt(numbersLine[i]);
        }
        for (int i = 0; i < numbers.length ; i++) {
            String currentNumber = "";
            currentNumber += numbers[i];
            String[] currentNumberArr = currentNumber.trim().split("");
            String ourNumber = "";
          /*  for(String j : currentNumberArr){
                if(currentNumberArr[j].equals(currentNumberArr[j+1])){
                        break;
                    } else if (currentNumberArr[j+1].equals(currentNumberArr[j+2])){
                        break;
                    } else if (currentNumberArr[j].equals(currentNumberArr[j+2])) {
                        break;
                    } else {
                        ourNumber += currentNumberArr[j] + currentNumberArr[j+1] + currentNumberArr[j+2];
                        continue;
                    }
            }*/
            if ((!currentNumberArr[0].equals(currentNumberArr[1])) && (!currentNumberArr[2].equals(currentNumberArr[1])) && (!currentNumberArr[0].equals(currentNumberArr[2]))) {
                ourNumber += currentNumberArr[0] + currentNumberArr[1] + currentNumberArr[2];
            }
            System.out.println(ourNumber);
            }

        }
    }


package com.company.homework1;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        greeting();
        reverse();
        password();
        randomNumbers();
        numbersSumandMult();
        String commandLine = enterNumbers();
        evenOddNumbers(commandLine);
        maxAndMinNumber(commandLine);
        numberThatDividedBy3and9(commandLine);
        numberThatDividedBy5and7(commandLine);
        uniqueDigits(commandLine);
        happyNumbers(commandLine);
        elementsHalfSumofNeighbours(commandLine);


    }
    // task 1 Приветствовать любого пользователя при вводе его имени через командную строку

    public static void greeting() {
        System.out.println("What's your name?");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        System.out.println("Hello " + name);
    }

    // task 2 Отобразить в окне консоли аргументы командной строки в обратном порядке

    public static void reverse() {
        System.out.println("Type smth");
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        System.out.println("Your line was reversed: " + new StringBuilder(line).reverse());
    }

    // task 3 Вывести заданное количество случайных чисел с переходом и без перехода на новую строку

    public static void randomNumbers() {
        String randNumbers = "";
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            randNumbers += random.nextInt() + "\n";
        }
        System.out.println("20 random numbers: \n " + randNumbers);
        String spacedRandNumbers = "";
        for (int i = 0; i < 20; i++) {
            spacedRandNumbers += random.nextInt() + " ";
        }
        System.out.println("20 random numbers in one line: " + spacedRandNumbers);
    }

    // task 4 Ввести пароль из командной строки и сравнить его со строкой-образцом

    public static void password() {
        String password = "123456qwerty";
        System.out.println("Enter password:");
        Scanner sc = new Scanner(System.in);
        String pass = sc.nextLine();
        if (password.equals(pass)) {
            System.out.println("Welcome to system");
        } else {
            System.out.println("Invalid password");
        }
    }

    // task 5 Ввести целые числа как аргументы командной строки, подсчитать их суммы (произведения) и вывести результат на консоль

    public static void numbersSumandMult() {
        System.out.println("Enter numbers:");
        Scanner sc = new Scanner(System.in);
        String inputLine = sc.nextLine();
        int mult = 1;
        int sum = 0;
        for (String i : inputLine.trim().split(" ")) {
            int number = Integer.parseInt(i);
            sum += number;
            mult *= number;
        }
        System.out.println("Sum of numbers: " + sum);
        System.out.println("Multiply of numbers: " + mult);
    }

    // task 6 Ввести с консоли n целых чисел. На консоль вывести:

    public static String enterNumbers() {
        System.out.println("Enter numbers: ");
        Scanner sc = new Scanner(System.in);
        String commandLine = sc.nextLine();
        return commandLine;
    }
    // task 6.1 Четные и нечетные числа

    public static void evenOddNumbers(String commandLine) {
        String evenNumber = "";
        String oddNumber = "";
        for (String i : commandLine.trim().split(" ")) {
            int number = Integer.parseInt(i);
            if (number % 2 == 0) {
                evenNumber += number + " ";
            } else {
                oddNumber += number + " ";
            }
        }
        System.out.println("Even numbers:" + evenNumber);
        System.out.println("Odd numbers:" + oddNumber);
    }

    // task 6.2 Наибольшее и наименьшее число

    public static void maxAndMinNumber(String commandLine) {
        String[] numbersLine = commandLine.trim().split(" ");
        int[] numbers = new int[numbersLine.length];
        for (int i = 0; i < numbersLine.length; i++) {
            numbers[i] = Integer.parseInt(numbersLine[i]);
        }
        int maxNumber = numbers[0];
        int minNumber = numbers[0];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > maxNumber) {
                maxNumber = numbers[i];
            } else if (numbers[i] < minNumber) {
                minNumber = numbers[i];
            }
        }
        System.out.println("Max number: " + maxNumber);
        System.out.println("Min number: " + minNumber);
    }

    // task 6.3 Числа, которые делятся на 3 или на 9

    public static void numberThatDividedBy3and9(String commandLine) {
        String numbers = "";
        for (String i : commandLine.trim().split(" ")) {
            int number = Integer.parseInt(i);
            if (number % 3 == 0 || number % 9 == 0) {
                numbers += number + " ";
            }
        }
        System.out.println("Numbers which divide to 3 or 9:" + numbers);
    }

    //task 6.4 Числа, которые делятся на 5 и на 7

    public static void numberThatDividedBy5and7(String commandLine) {
        String numbers = "";
        for (String i : commandLine.trim().split(" ")) {
            int number = Integer.parseInt(i);
            if (number % 5 == 0 && number % 7 == 0) {
                numbers += number + " ";
            }
        }
        System.out.println("Numbers which divide to 5 and 7:" + numbers);
    }

    //task 6.5 Все трехзначные числа, в десятичной записи которых нет одинаковых цифр

    public static void uniqueDigits(String commandLine) {
        String[] numbersLine = commandLine.trim().split(" ");
        for (int i = 0; i < numbersLine.length; i++) {
            if (numbersLine[i].length() == 3) {
                String currentNumber = numbersLine[i];
                String ourNumber = null;
                String[] currentNumberArr = currentNumber.trim().split("");
                for (int j = 0; j < currentNumberArr.length; j++) {
                    if (j == 0 && (currentNumberArr[j].equals(currentNumberArr[j + 1])
                            || currentNumberArr[j].equals(currentNumberArr[j + 2]))) {
                        break;
                    } else if (j == 1 && (currentNumberArr[j].equals(currentNumberArr[j - 1])
                            || currentNumberArr[j].equals(currentNumberArr[j + 1]))) {
                        break;
                    } else if (j == 2) {
                        ourNumber = currentNumber;
                    }
                }
                if (ourNumber != null) {
                    System.out.println("This number contains only unique digits: " + ourNumber);
                }
            }
        }
    }

    //task 6.6 «Счастливые» числа

    public static void happyNumbers(String commandLine) {
        String happyNumbers = "";
        String[] numbersLine = commandLine.trim().split(" ");
        for (int i = 0; i < numbersLine.length; i++) {
            if (numbersLine[i].length() % 2 == 0) {
                int midOfLine = numbersLine[i].length() / 2;
                String firstNumber = numbersLine[i].substring(0, midOfLine);
                String secondNumber = numbersLine[i].substring(midOfLine);
                String[] firstNumbers = firstNumber.split("");
                String[] secondNumbers = secondNumber.split("");
                int firstSum = 0;
                int secondSum = 0;
                for (int j = 0; j < firstNumbers.length; j++) {
                    firstSum += Integer.parseInt(firstNumbers[j]);
                    secondSum += Integer.parseInt(secondNumbers[j]);
                }
                if (firstSum == secondSum) {
                    happyNumbers += numbersLine[i] + " ";
                }
            }
        }
        System.out.println("Happy numbers: " + happyNumbers);
    }

    // task 6.7 Элементы, которые равны полусумме соседних элементов

    public static void elementsHalfSumofNeighbours(String commandLine) {
        String[] numbersLine = commandLine.trim().split(" ");
        int[] numbers = new int[numbersLine.length];
        for (int i = 0; i < numbersLine.length; i++) {
            numbers[i] = Integer.parseInt(numbersLine[i]);
        }
        for (int i = 0; i < numbers.length - 2; i++) {
            int semiSum = (numbers[i] + numbers[i + 2]) / 2;
            if (numbers[i + 1] == semiSum) {
                System.out.println(numbers[i + 1]);
            }
        }
    }
}


package com.company.homework3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter properties for first person splited up by space: Gender m or f, Name, Surname, Height sm, Weight kg");
        String personLine = sc.nextLine();
        Human human1 = createHuman(personLine);
        System.out.println("Enter properties for second person splited up by space: Gender m or f, Name, Surname, Height sm, Weight kg");
        personLine = sc.nextLine();
        Human human2 = createHuman(personLine);
        Human baby = compatibilityTest(human1,human2);

        if (baby != null) {
            System.out.println("We successfully created a baby!");
            System.out.println(baby);
        }
    }

    public static Human createHuman(String personLine) {
        String[] person = personLine.trim().split(" ");
        Boolean gender = null;
        String name;
        String surname;
        float height;
        float weight;

        if ("m".equals(person[0])) {
            gender = true;
            System.out.println("It's man. Creating new man...");
        } else if (person[0].equals("f")) {
            System.out.println("It's woman. Creating new woman...");
            gender = false;
        } else {
            System.out.println("Invalid gender, male is chosen. Creating new man... ");
            gender = true;
        }

        name = person[1];
        surname = person[2];
        height = Float.parseFloat(person[3]);
        weight = Float.parseFloat(person[4]);
        Human newHuman = null;
        if (gender) {
            newHuman = new Man(name, surname, height, weight);
        } else {
            newHuman = new Woman(name, surname, height, weight);
        }
        return newHuman;
    }

    public static Human compatibilityTest(Human human1, Human human2){
        return human1.haveARelationship(human2);

    }
}
package com.company.homework3;

import java.util.Scanner;

public class Woman extends Human implements Pregnantable{

    public Woman(String name, String surname, float height, float weight) {
        super(false, name, surname, height, weight);
    }

    @Override
    public Human haveARelationship(Human human) {
        Boolean speak = speak(human);
        if (!speak) {
            System.out.println("This boys even can't speak to each other. It's a little bit sad");
        } else {
            System.out.println("They can speak to each other! Keep checking...");
        }
        Boolean tolerate = tolerate(human);
        if (!tolerate) {
            System.out.println("Unfortunately, they can't stand each other");
        } else {
            System.out.println("They can stand each other. Keep checking...");
        }
        Boolean spendTimeTogether = spendTimeTogether(human);
        if (!spendTimeTogether) {
            System.out.println("Unfortunately, they can't spend time together");
        } else {
            System.out.println("They can spend time together. Keep checking...");
        }
        if (speak && tolerate && spendTimeTogether) {
            System.out.println("They get on well with each other!");
            if (this.isGender() == human.isGender()) {
                System.out.println("But they stay only friends, because they're girls");
                return null;
            } else {
                System.out.println("Oh yeah! They can have a baby!");
                return haveABaby(human);
            }
        } else if (!speak || !tolerate || !spendTimeTogether) {
            if (this.isGender() == human.isGender()) {
                System.out.println("Unfortunately, they can't become friends");
            } else {
                System.out.println("hm...smth went wrong, they have splited up");
                return null;
            }
            return null;
        }
        return null;
    }

    public Human haveABaby(Human man) {
        System.out.println("Start creating baby...wait");
        Scanner sc = new Scanner(System.in);
        String babyName;
        Human baby = null;
        if (Math.random() < 0.5) {
            System.out.println("Enter baby name for boy: ");
            babyName = sc.nextLine();
            baby = new Man(babyName, man.getSurname(), (float) (man.getHeight() + (0.1 * (this.getHeight() - man.getHeight()))), (float) (man.getWeight() + (0.1 * (this.getWeight() - man.getWeight()))));

        } else {
            System.out.println("Enter baby name for girl: ");
            babyName = sc.nextLine();
            baby = new Woman(babyName, man.getSurname(), (float) (this.getHeight() + (0.1 * (man.getHeight() - this.getHeight()))), (float) (this.getWeight() + (0.1 * (man.getWeight() - this.getWeight()))));
        }
        return baby;
    }
}
package com.company.homework3;

public class Man extends Human {

    public Man(String name, String surname, float height, float weight) {
        super(true, name, surname, height, weight);
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
                System.out.println("But they stay only friends, because they're boys");
                return null;
            } else {
                System.out.println("Oh yeah! They can have a baby!");
                return ((Woman) human).haveABaby(this);
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
}

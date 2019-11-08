package com.company.homework3;

import java.util.Objects;
import java.util.Random;

public abstract class Human {
    protected boolean gender;
    protected String name;
    protected String surname;
    protected float height;
    protected float weight;

    public Human(boolean gender, String name, String surname, float height, float weight) {
        setGender(gender);
        setName(name);
        setSurname(surname);
        setHeight(height);
        setWeight(weight);
    }

    public abstract Human haveARelationship(Human human);

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        if (height > 140 && height < 230) {
            this.height = height;
        } else {
            System.out.println("Invalid height");
        }
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        if (weight > 40 && weight < 250) {
            this.weight = weight;
        } else {
            System.out.println("Invalid height");
        }
    }

    @Override
    public String toString() {
        String gen;
        if (gender == false) {
            gen = "female";
        } else {
            gen = "male";
        }
        return "Human{" +
                "gender=" + gen +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }

    public Boolean speak(Human human) {
        System.out.println("Cheking if they can speak or not");
        if ((this.isGender() != human.isGender() || (!this.isGender() && !human.isGender()))) {
            return true;
        } else if (this.isGender() && human.isGender()) {
            return Math.random() < 0.5;
        }
        return false;
    }

    public Boolean tolerate(Human human) {
        System.out.println("Cheking if they can stand each other or not");
        if (this.isGender() != human.isGender()) {
            return Math.random() < 0.7;
        } else if (this.isGender() && human.isGender()) {
            return Math.random() < 0.056;
        } else if (!this.isGender() && !human.isGender()) {
            return Math.random() < 0.05;
        }
        return false;
    }

    public Boolean spendTimeTogether(Human human) {
        System.out.println("Checking if they can spend time together or not");
        Random r = new Random();
        float diff = Math.abs(this.getHeight() - human.getHeight());
        if (this.getHeight() > human.getHeight()) {
            if (this.isGender() && !human.isGender()) {
                System.out.println("This man taller than woman");
            } else if (this.isGender() && human.isGender()) {
                System.out.println("First guy taller than second");
            } else if (!this.isGender() && human.isGender()) {
                System.out.println("This woman taller than man");
            } else if (!this.isGender() && !human.isGender()) {
                System.out.println("First woman taller than second");
            }
            if ((this.getHeight() * 0.1) > diff) {
                System.out.println("They height differ less than 10%");
                return Math.random() < 0.95;
            } else {
                System.out.println("They height differ more than 10%");
                return Math.random() < 0.85;
            }
        } else if (this.getHeight() < human.getHeight()) {
            if (this.isGender() && !human.isGender()) {
                System.out.println("This man shorter than woman");
            } else if (this.isGender() && human.isGender()) {
                System.out.println("First guy shorter than second");
            } else if (!this.isGender() && human.isGender()) {
                System.out.println("This woman shorter than man");
            } else if (!this.isGender() && !human.isGender()) {
                System.out.println("First woman shorter than second");
            }
            if ((human.getHeight() * 0.1) > diff) {
                System.out.println("They height differ less than 10%");
                return Math.random() < 0.95;

            } else {
                System.out.println("They height differ more than 10%");
                return Math.random() < 0.85;
            }
        }
        return false;
    }
}

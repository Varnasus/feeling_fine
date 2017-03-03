package com.example.android.feelinggood;

/**
 * Created by zachvarney on 2/28/17.
 *
 * practicing inheritance
 *
 */

public abstract class Animal {

    public int age;

    public Animal(int age) {
        this.age = age;
        System.out.println("An animal has been created!");
    }

    public abstract void eat();

    public void sleep() {
        System.out.println("A animal is sleeping");
    }

    public int getAge() {
        return age;
    }

    public static void main(String[] args) {
        Raptor r = new Raptor();
        TRex t = new TRex();
        r.eat();
        t.eat();
        r.sleep();
        t.sleep();
        r.run();
        CalendarPractice();
    }
}

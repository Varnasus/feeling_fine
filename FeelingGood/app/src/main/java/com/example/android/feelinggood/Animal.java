package com.example.android.feelinggood;

/**
 * Created by zachvarney on 2/28/17.
 *
 * practicing inheritance
 *
 */

public class Animal {

    public int age;

    public Animal(int age) {
        this.age = age;
        System.out.println("An animal has been created!");
    }

    public void eat() {
        System.out.println("An animal is eating.");
    }

    public int getAge() {
        return age;
    }

    public static void main(String[] args) {
        Animal a = new Animal(5);
        Raptor r = new Raptor();
        TRex t = new TRex();
        r.rawr();
        r.run();
        a.eat();
        t.groundShake();
        t.roar();
        System.out.println("TRex age is: " + t.age);
        System.out.println("Raptor age is: " + r.age);

    }
}

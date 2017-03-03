package com.example.android.feelinggood;

/**
 * Created by zachvarney on 2/28/17.
 */

public class Raptor extends Animal {

    public Raptor() {
        super(1);
        System.out.println("A Raptor has been created.");
    }

    public void eat() {
        System.out.println("Raptor is eating.");
    }

    public void sleep() {
        System.out.println("The Raptor is sleeping.");
    }

    public void rawr() {
        System.out.println("The Raptor growled!");
    }

    public void run() {
        System.out.println("The Raptor is running!");
    }
}

package com.example.android.feelinggood;

/**
 * Created by zachvarney on 2/28/17.
 */

public class TRex extends Animal {

    public TRex() {
        super(5);
        System.out.println("A TRex has been created!");
    }

    public void roar() {
        System.out.println("TRex roars!");
    }

    public void groundShake() {
        System.out.println("The ground is shaking from the TRex!!");
    }
}

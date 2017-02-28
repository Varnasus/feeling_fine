package com.example.android.feelinggood;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public static int summation (int n) {
        if (n<=0) {
            return 0;
        }
        else {
            return n + summation(n -1);
        }
    }

    public static int factorial(int n) {
        if (n<=1) {
            return 1;
        }
        else {
            return n * factorial(n-1);
        }

    }

    public static int exponentation(int n, int p) {
        if (p<=0) {
            return 1;
        }
        else {
            return n * exponentation(n, p-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(summation(3));
        System.out.println(factorial(3));
        System.out.println(exponentation(5, 3));
    }
}

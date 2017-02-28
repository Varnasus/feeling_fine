package com.example.android.feelinggood;

/**
 * Created by zachvarney on 2/28/17.
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();


        String s= Integer.toBinaryString(n);
        int[] a = new int[s.length()];

        int count=0;
        int max=0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='1') {
                count++;
            }
            else{
                count=0;
            }
            if(max<count)
                max = count;

        }

        System.out.println("Varney: " + max);
    }
}


package com.example.android.feelinggood;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zachvarney on 3/6/17.
 */

public class DictionaryPractice {

    public static void main(String[] args) {
        //English to Spanish dictionary
        Map<String,String> engSpanDict = new HashMap<String, String>();
        engSpanDict.put("Monday", "Lunes");
        engSpanDict.put("Tuesday", "Martes");
        engSpanDict.put("Wednesday", "Miercoles");
        engSpanDict.put("Thursday", "Jueves");
        engSpanDict.put("Friday", "Viernes");
        engSpanDict.put("Saturday", "Sabado");
        engSpanDict.put("Sunday", "Domingo");

        //print out individual keys
//        System.out.println(engSpanDict.get("Monday"));
//        System.out.println(engSpanDict.get("Tuesday"));
//        System.out.println(engSpanDict.get("Wednesday"));
//        System.out.println(engSpanDict.get("Thursday"));
//        System.out.println(engSpanDict.get("Friday"));

        //print out all keys
        System.out.println(engSpanDict.keySet());

        System.out.println(engSpanDict.values());

        System.out.println(engSpanDict.size());

        System.out.println();
        System.out.println();

        //shopping list
        Map<String,Boolean> shoppingList = new HashMap<String, Boolean>();
        //fill dictionary
        shoppingList.put("Coffee", true);
        shoppingList.put("Chicken", Boolean.TRUE);
        shoppingList.put("Salad", Boolean.TRUE);
        shoppingList.put("Eggs", Boolean.FALSE);
        shoppingList.put("Cereal", false);

        System.out.println(shoppingList.get("Coffee"));
        System.out.println(shoppingList.get("Cereal"));

        shoppingList.remove("Eggs");

        System.out.println(shoppingList.toString());

        shoppingList.clear();

        System.out.println(shoppingList.toString());

    }
}

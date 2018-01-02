package com.varnasus.bakersdozen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "started");

        RecyclerView recyclerView = findViewById(R.id.recylcer_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

//        ArrayList<Recipes> recipeArray = new ArrayList<>();
        ArrayList<Contents> contentsArray = new ArrayList<>();

        Contents littleItaly = new Contents("Little Italy", "10");
        contentsArray.add(littleItaly);

//        Contents italianWeddingCookies = new Contents("Italian Wedding Cookies", "13");
//        contentsArray.add(italianWeddingCookies);
//
//        Contents newYears = new Contents("New Year's", "9");
//        contentsArray.add(newYears);
//
//        Contents stPaddyDay = new Contents("St. Patrick's Day", "6");
//        contentsArray.add(stPaddyDay);
//
//        Contents lent = new Contents("Lent", "11");
//        contentsArray.add(lent);
//
//        Contents easter = new Contents("Easter", "9");
//        contentsArray.add(easter);
//
//        Contents halloween = new Contents("Halloween", "5");
//        contentsArray.add(halloween);
//
//        Contents thanksgiving = new Contents("Thanksgiving", "16");
//        contentsArray.add(thanksgiving);
//
//        Contents santaClaus = new Contents("Here Comes Santa Claus", "3");
//        contentsArray.add(santaClaus);
//
//        Contents advent = new Contents("Advent", "3");
//        contentsArray.add(advent);
//
//        Contents nightBeforeXmas = new Contents("Twas' the Night Before Christmas", "4");
//        contentsArray.add(nightBeforeXmas);
//
//        Contents xmasDay = new Contents("Christmas Day", "5");
//        contentsArray.add(xmasDay);
//
//        Contents mainDishes = new Contents("Main Dishes", "10");
//        contentsArray.add(mainDishes);
//
//        Contents comfortFoods = new Contents("Comfort Foods", "8");
//        contentsArray.add(comfortFoods);
//
//        Contents lakeFood = new Contents("Lake Food", "10");
//        contentsArray.add(lakeFood);
//
//        Contents dessert = new Contents("Desert", "10");
//        contentsArray.add(dessert);
//
//        Contents favorites = new Contents("Favorites", "11");
//        contentsArray.add(favorites);

        ContentsAdapter contentsAdapter = new ContentsAdapter(getApplicationContext(), contentsArray);
        recyclerView.setAdapter(contentsAdapter);

    }
}

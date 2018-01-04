package com.varnasus.bakersdozen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;
import android.view.WindowManager;

import java.util.ArrayList;

public class WeddingCookies extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_wedding_cookies);

        RecyclerView recyclerView = findViewById(R.id.recylcer_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setNestedScrollingEnabled(false);

        ArrayList<Recipes> recipeArray = new ArrayList<>();

        Recipes almondSlices = new Recipes("Almond Slices", R.drawable.img_saugu);
        recipeArray.add(almondSlices);

        Recipes sesameCookie = new Recipes("Sesame Cookies", R.drawable.img_saugu);
        recipeArray.add(sesameCookie);

        Recipes dueDues = new Recipes("Due Dues", R.drawable.img_saugu);
        recipeArray.add(dueDues);

        Recipes thumbprintCookies = new Recipes("Thumbprint Cookies", R.drawable.img_saugu);
        recipeArray.add(thumbprintCookies);

        Recipes figCookies = new Recipes("Fig Cookies", R.drawable.img_saugu);
        recipeArray.add(figCookies);

        Recipes pizzelles = new Recipes("Pizzelles", R.drawable.img_saugu);
        recipeArray.add(pizzelles);

        Recipes patelCookies = new Recipes("Patel Cookies", R.drawable.img_saugu);
        recipeArray.add(patelCookies);

        Recipes creamWafers = new Recipes("Cream Wafers", R.drawable.img_saugu);
        recipeArray.add(creamWafers);

        Recipes russianBalls = new Recipes("Russian Balls", R.drawable.img_saugu);
        recipeArray.add(russianBalls);

        Recipes pignolate = new Recipes("Pignolate", R.drawable.img_saugu);
        recipeArray.add(pignolate);

        Recipes biscotti = new Recipes("Biscotti", R.drawable.img_saugu);
        recipeArray.add(biscotti);

        Recipes teaTimeTassies = new Recipes("TeaTime Tassies", R.drawable.img_saugu);
        recipeArray.add(teaTimeTassies);

        Recipes spritzCookies = new Recipes("Spritz Cookies", R.drawable.img_saugu);
        recipeArray.add(spritzCookies);

        RecipesAdapter recipesAdapter = new RecipesAdapter(getApplicationContext(), recipeArray);
        recyclerView.setAdapter(recipesAdapter);

    }
}

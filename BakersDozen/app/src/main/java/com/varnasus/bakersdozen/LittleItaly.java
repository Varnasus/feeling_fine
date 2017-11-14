package com.varnasus.bakersdozen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class LittleItaly extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_little_italy);

        RecyclerView recyclerView = findViewById(R.id.recylcer_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<Recipes> recipeArray = new ArrayList<>();

        Recipes saugu = new Recipes("Saugu", R.drawable.img_saugu);
        recipeArray.add(saugu);

        Recipes marinara = new Recipes("Marinara Sauce", R.drawable.img_saugu);
        recipeArray.add(marinara);

        Recipes italSausage = new Recipes("Italian Sausage", R.drawable.img_saugu);
        recipeArray.add(italSausage);

        Recipes meatballs = new Recipes("Meatballs", R.drawable.img_saugu);
        recipeArray.add(meatballs);

        Recipes oliveSalad = new Recipes("Olive Salad", R.drawable.img_saugu);
        recipeArray.add(oliveSalad);

        Recipes eggParm = new Recipes("Eggplant Parmesan", R.drawable.img_saugu);
        recipeArray.add(eggParm);

        Recipes bastaAglio = new Recipes("Basta Aglio e olio", R.drawable.img_saugu);
        recipeArray.add(bastaAglio);

        Recipes stuffArtichoke = new Recipes("Italian Stuffed Artichokes", R.drawable.img_saugu);
        recipeArray.add(stuffArtichoke);

        Recipes cannoli = new Recipes("Cannoli", R.drawable.img_saugu);
        recipeArray.add(cannoli);

        Recipes pastaSalad = new Recipes("Italian Pasta Salad", R.drawable.img_saugu);
        recipeArray.add(pastaSalad);

        RecipesAdapter recipesAdapter = new RecipesAdapter(getApplicationContext(), recipeArray);
        recyclerView.setAdapter(recipesAdapter);
    }
}

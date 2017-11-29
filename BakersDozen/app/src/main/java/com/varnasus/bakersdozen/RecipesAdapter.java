package com.varnasus.bakersdozen;

import android.content.Context;
import android.icu.text.AlphabeticIndex;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

import java.util.ArrayList;

/**
 * Created by Zachary on 11/13/2017.
 */

public class RecipesAdapter extends RecyclerView.Adapter<RecipesAdapter.CustomViewHolder> {

    Context context;
    ArrayList<Recipes> recipes;

    public RecipesAdapter(Context context, ArrayList<Recipes> recipes) {
        this.context = context;
        this.recipes = recipes;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_view, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        Recipes recipeView = recipes.get(position);
        holder.imageView.setImageResource(recipeView.imageID);
        holder.textView.setText(recipeView.recipeName);
        
    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView;
        LinearLayout recipesLayout;
//        private RatingBar ratingBar;

        public CustomViewHolder(View view) {
            super(view);
            imageView = view.findViewById(R.id.imageView);
            textView = view.findViewById(R.id.textView);
            recipesLayout = view.findViewById(R.id.recipeLayout);
//            ratingBar = view.findViewById(R.id.ratingBar);
        }
    }

}

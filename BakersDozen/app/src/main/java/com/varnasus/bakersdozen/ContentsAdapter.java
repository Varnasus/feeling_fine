package com.varnasus.bakersdozen;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Zachary on 11/13/2017.
 */

public class ContentsAdapter extends RecyclerView.Adapter<ContentsAdapter.CustomViewHolder> {

    Context context;
    ArrayList<Contents> contents;


    public ContentsAdapter(Context context, ArrayList<Contents> contents) {
        this.context = context;
        this.contents = contents;
    }

    @Override
    public ContentsAdapter.CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contents_view, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ContentsAdapter.CustomViewHolder holder, final int position) {
        final Contents contentsView = contents.get(position);
        holder.contentName.setText(contentsView.contentName);
        holder.recipeCount.setText(contentsView.recipeCount);
        holder.contentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), LittleItaly.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return contents.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder{

        TextView contentName;
        TextView recipeCount;
        RelativeLayout contentLayout;

        public CustomViewHolder(View view) {
            super(view);
            contentName = view.findViewById(R.id.contentName);
            recipeCount = view.findViewById(R.id.recipe_count);
            contentLayout = view.findViewById(R.id.content_layout);
        }
    }
}

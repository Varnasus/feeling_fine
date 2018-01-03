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

        ArrayList<Contents> contentsArray = new ArrayList<>();

        Contents littleItaly = new Contents("Little Italy", "10");
        contentsArray.add(littleItaly);

        ContentsAdapter contentsAdapter = new ContentsAdapter(getApplicationContext(), contentsArray);
        recyclerView.setAdapter(contentsAdapter);

    }
}

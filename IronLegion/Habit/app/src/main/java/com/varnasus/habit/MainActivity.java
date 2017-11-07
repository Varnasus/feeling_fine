package com.varnasus.habit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    View energyBtn;
    View focusBtn;
    View weightBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        energyBtn = findViewById(R.id.energy);
        focusBtn = findViewById(R.id.focus);
        weightBtn = findViewById(R.id.weight);

        energyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, getUserName.class);
                startActivity(intent);
            }
        });

    }
}

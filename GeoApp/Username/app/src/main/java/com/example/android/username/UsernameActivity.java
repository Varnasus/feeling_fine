package com.example.android.username;

/**
 * Created by zachvarney on 4/10/17.
 */

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by zachvarney on 4/9/17.
 * UsernameActivity.java
 */

public class UsernameActivity extends AppCompatActivity {

    public Button loginBtn;
    public Button eyeprintBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_username);

        loginBtn = (Button) findViewById(R.id.login_btn);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alertDialog = new AlertDialog.Builder(UsernameActivity.this).create();
                alertDialog.setTitle("Wanna make logging in easier?");
                alertDialog.setMessage("Setup your EyePrint for faster login");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();
            }
        });

        eyeprintBtn = (Button) findViewById(R.id.eyeprint_btn);

        eyeprintBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //send to instruction screen
            }
        });
    }
}
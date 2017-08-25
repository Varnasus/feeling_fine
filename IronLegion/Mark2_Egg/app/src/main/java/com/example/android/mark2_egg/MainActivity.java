package com.example.android.mark2_egg;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    public int timer = 10000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.timer_selections, R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        String text = spinner.getSelectedItem().toString();
    }

    public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
        switch (position) {
            case 1:
                timer = 10000;

                break;
            case 2:
                timer = 20000;

                break;
        }
    }

    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // TODO Auto-generated method stub

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        int pos = spinner.getSelectedItemPosition();
        String[] information = getResources().getStringArray(R.array.timer_selections);

    }

    private void Toast() {
        Toast.makeText(getApplicationContext(), "Timer is done!", Toast.LENGTH_LONG).show();
    }


    //Start Timer button
    public void buStartTimer(View view) {
//        Toast();

        final TextView _tv = (TextView) findViewById( R.id.textview );
        new CountDownTimer(timer, 1000) { // adjust the milli seconds here

            Spinner spinner = (Spinner) findViewById(R.id.spinner);
            spinner.setOnItemClickListener((AdapterView.OnItemClickListener) this);

            public void onTick(long millisUntilFinished) {
                _tv.setText(""+String.format("%d min, %d sec",
                        TimeUnit.MILLISECONDS.toMinutes( millisUntilFinished),
                        TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) -
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));
            }

            public void onFinish() {
                _tv.setText("done!");
            }
        }.start();
    }
}

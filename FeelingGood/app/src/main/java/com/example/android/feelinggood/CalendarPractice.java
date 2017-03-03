package com.example.android.feelinggood;

import android.support.v7.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import android.os.Bundle;
import java.util.Date;

/**
 * Created by zachvarney on 3/3/17.
 */

public class CalendarPractice extends Animal {

    public void eat() {

    }

    public class MainActivity extends AppCompatActivity {


        public static void main(String[] args) {
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DATE, 85);
            System.out.println(cal.getTime());
            SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
            String formatted = format1.format(cal.getTime());
            System.out.println(formatted);
            System.out.println(cal.getWeeksInWeekYear());
        }
    }
}

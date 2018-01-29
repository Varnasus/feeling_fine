package com.varnasus.sensor_mark1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;
import android.widget.TextView;

public class BatteryActivity extends AppCompatActivity {

    private TextView batteryHealth;
    private TextView batteryStatus;
    private TextView batteryTemp;
    private TextView batteryPercentage;
    private TextView mTextViewPercentage;

    IntentFilter intentfilter;

    private ProgressBar mProgressBar;

    private int mProgressStatus = 0;
    int status;
    int deviceStatus;

    float fBatteryTemp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battery);

        batteryHealth = findViewById(R.id.battery_health);
        batteryStatus = findViewById(R.id.battery_status);
        batteryTemp = findViewById(R.id.battery_temp);
        batteryPercentage = findViewById(R.id.battery_percent);
        mTextViewPercentage = findViewById(R.id.tv_percentage);
        mProgressBar = findViewById(R.id.pb);

        intentfilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        BatteryActivity.this.registerReceiver(broadcastreceiver, intentfilter);
        BatteryActivity.this.registerReceiver(statusReceiver, intentfilter);
        BatteryActivity.this.registerReceiver(tempReceiver, intentfilter);
        BatteryActivity.this.registerReceiver(percentageReceiver, intentfilter);
    }

    private BroadcastReceiver statusReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            deviceStatus = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1);

            if (deviceStatus == BatteryManager.BATTERY_STATUS_CHARGING) {
                batteryStatus.setText("Battery Status = Charging ");

            } else if (deviceStatus == BatteryManager.BATTERY_STATUS_DISCHARGING) {
                batteryStatus.setText("Battery Status = Not Charging ");

            } else if (deviceStatus == BatteryManager.BATTERY_STATUS_FULL) {
                batteryStatus.setText("Battery Status = Battery Full ");

            } else if (deviceStatus == BatteryManager.BATTERY_STATUS_UNKNOWN) {
                batteryStatus.setText("Battery Status = Unknown ");

            }
        }
    };

    BroadcastReceiver broadcastreceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            status = intent.getIntExtra(BatteryManager.EXTRA_HEALTH, 0);

            if (status == BatteryManager.BATTERY_HEALTH_COLD) {

                batteryHealth.setText("Battery Health = Cold");

            } else if (status == BatteryManager.BATTERY_HEALTH_DEAD) {

                batteryHealth.setText("Battery Health = Dead");

            } else if (status == BatteryManager.BATTERY_HEALTH_GOOD) {

                batteryHealth.setText("Battery Health = Good");

            } else if (status == BatteryManager.BATTERY_HEALTH_OVERHEAT) {

                batteryHealth.setText("Battery Health = Over Heat");

            } else if (status == BatteryManager.BATTERY_HEALTH_OVER_VOLTAGE) {

                batteryHealth.setText("Battery Health = Over Voltage");

            } else if (status == BatteryManager.BATTERY_HEALTH_UNKNOWN) {

                batteryHealth.setText("Battery Health = Unknown");

            } else if (status == BatteryManager.BATTERY_HEALTH_UNSPECIFIED_FAILURE) {

                batteryHealth.setText("Battery Health = Unspecified failure");

            }
        }
    };

    private BroadcastReceiver tempReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            fBatteryTemp = (float) (intent.getIntExtra(BatteryManager.EXTRA_TEMPERATURE, 0)) / 10;

            batteryTemp.setText("Battery Temperature = " + fBatteryTemp + " " + (char) 0x00B0 + "C");
        }
    };

    private BroadcastReceiver percentageReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
            int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);

            float percentage = level / (float) scale;

            mProgressStatus = (int) ((percentage) * 100);

            mTextViewPercentage.setText("" + mProgressStatus + "%");
            batteryPercentage.setText("Percentage : " + mProgressStatus + "%");

            mProgressBar.setProgress(mProgressStatus);
        }
    };
}


package com.varnasus.sensor_mark1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BatteryActivity extends AppCompatActivity {

    TextView batteryHealth;
    TextView batteryStatus;
    TextView batteryTemp;

    IntentFilter intentfilter;
    IntentFilter tempFilter;
    IntentFilter statusFilter;

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

        intentfilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        BatteryActivity.this.registerReceiver(broadcastreceiver, intentfilter);
        BatteryActivity.this.registerReceiver(statusReceiver, intentfilter);
        BatteryActivity.this.registerReceiver(tempReceiver, intentfilter);
    }

    private BroadcastReceiver statusReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            deviceStatus = intent.getIntExtra(BatteryManager.EXTRA_STATUS,-1);

            if(deviceStatus == BatteryManager.BATTERY_STATUS_CHARGING){
                batteryStatus.setText("Battery Status = Charging ");

            } else if(deviceStatus == BatteryManager.BATTERY_STATUS_DISCHARGING){
                batteryStatus.setText("Battery Status = Not Charging ");

            } else if (deviceStatus == BatteryManager.BATTERY_STATUS_FULL){
                batteryStatus.setText("Battery Status = Battery Full ");

            } else if(deviceStatus == BatteryManager.BATTERY_STATUS_UNKNOWN){
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

            batteryTemp.setText("Battery Temperature: " + fBatteryTemp + " " + (char) 0x00B0 + "C");
        }
    };
}


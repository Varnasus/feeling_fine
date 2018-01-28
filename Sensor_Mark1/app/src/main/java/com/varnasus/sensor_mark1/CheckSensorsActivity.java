package com.varnasus.sensor_mark1;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class CheckSensorsActivity extends Activity {

    TextView tv1 = null;
    SensorManager mSensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_sensors);

        tv1 = findViewById(R.id.sensor_info);
        tv1.setVisibility(View.GONE);

        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        List<Sensor> mList = mSensorManager.getSensorList(Sensor.TYPE_ALL);

        for (int i = 1; i < mList.size(); i++) {
            tv1.setVisibility(View.VISIBLE);
            tv1.append("\n" + "Sensor name: " + mList.get(i).getName() + "\n" + "Version #: " + mList.get(i).getVersion() + "\n" + "Type: " + mList.get(i).getType());
        }
    }
}

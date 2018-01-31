package com.varnasus.sensor_mark1;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

/**
 * Created by Zachary on 1/23/2018.
 */

public class AccelerometerActivity extends Activity implements SensorEventListener {

    private SensorManager sensorManager;
    private boolean color = false;
//    private long lastUpdate;

    TextView tvX;
    TextView tvY;
    TextView tvZ;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_accelerometer);

        tvX = findViewById(R.id.textViewX);
        tvY = findViewById(R.id.textViewY);
        tvZ = findViewById(R.id.textViewZ);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorManager.registerListener(this,
                sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);
//        lastUpdate = System.currentTimeMillis();
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            getAccelerometer(event);
        }

    }

    public void getAccelerometer(SensorEvent event) {
        float[] values = event.values;
        // Movement
        float x = values[0];
        float y = values[1];
        float z = values[2];

        long actualTime = System.currentTimeMillis();

//            lastUpdate = actualTime;

        x = roundAvoid(x, 3);
        y = roundAvoid(y, 3);
        z = roundAvoid(z, 3);

        String xTV = String.valueOf(x);
        String yTV = String.valueOf(y);
        String zTV = String.valueOf(z);


        tvX.setText(xTV);
        tvY.setText(yTV);
        tvZ.setText(zTV);

        color = !color;
    }

    public static float roundAvoid(float value, int places) {
        float scale = (float) Math.pow(10, places);
        return (Math.round(value * scale) / scale);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this,
                sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }
}

package com.example.customview;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    private static final String TAG = "MainActivity";
    private SensorManager sensorManager;
    private DeleteView mDeleteView;
    private SpinnerView mSpinnerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
//        List<Sensor> sensorList = sensorManager.getSensorList(Sensor.TYPE_ALL);
//        for (Sensor sensor : sensorList) {
//            Log.e(TAG, "onCreate: 传感器：" + sensor.getName() + "/n");
//        }


    }

    private void initView() {

        mDeleteView = (DeleteView) findViewById(R.id.deleteView);
        mSpinnerView = (SpinnerView) findViewById(R.id.spinnerView);
        mDeleteView.setDeleteLine();


    }

    @Override
    protected void onStart() {
        super.onStart();
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float[] values = event.values;
        float x = values[0];
        float y = values[1];
        float z = values[2];

        if (Math.abs(x) > 17 || Math.abs(y) > 17 || Math.abs(z) > 17) {
            Log.e(TAG, "onSensorChanged: 摇一摇");
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    protected void onStop() {
        super.onStop();
        sensorManager.unregisterListener(this);
    }

}

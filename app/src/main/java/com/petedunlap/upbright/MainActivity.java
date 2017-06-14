package com.petedunlap.upbright;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager mSensorManager;
    private Sensor mRotation;
    private float initialBrightness;

    @BindView(R.id.background) RelativeLayout mBackground;
    @BindView(R.id.xValue) TextView mXValue;
    @BindView(R.id.yValue) TextView mYValue;
    @BindView(R.id.zValue) TextView mZValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initialBrightness = getWindow().getAttributes().screenBrightness;
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mRotation = mSensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY);
    }

    @Override
    public final void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Do something here if sensor accuracy changes.
    }

    @Override
    public final void onSensorChanged(SensorEvent event) {
        // The light sensor returns a single value.
        // Many sensors return 3 values, one for each axis.
        float x = event.values[0];
        float y = event.values[1];
        float z = event.values[2];
        updateDisplay(x, y, z);
//        Toast.makeText(this, (lux + ""), Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mRotation, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }

    private void updateDisplay(float x, float y, float z) {

        mXValue.setText(x + "");
        mYValue.setText(y + "");
        mZValue.setText(z + "");

        WindowManager.LayoutParams layout = getWindow().getAttributes();
//        if (Math.abs(x) > 8 || Math.abs(y) > 8) {
        if (Math.abs(z) < 5) {
            layout.screenBrightness = initialBrightness;
        } else {
            layout.screenBrightness = 0;
        }

        getWindow().setAttributes(layout);



    }
}

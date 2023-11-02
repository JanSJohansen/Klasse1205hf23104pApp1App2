package dk.tec.sensorproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener, View.OnClickListener {
    TextView txtX, txtY, txtZ;
    Button btnShowBall;
    LinearLayout theLayout;
    SensorManager sensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtX = findViewById(R.id.txtX);
        txtY = findViewById(R.id.txtY);
        txtZ = findViewById(R.id.txtZ);
        theLayout = findViewById(R.id.theLayout);
        btnShowBall = findViewById(R.id.btnShowBall);
        btnShowBall.setOnClickListener(this);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensorManager.registerListener(this,
                sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),100000);
    }

    @Override
    public void onSensorChanged(SensorEvent event)
    {
        if(event.sensor.getType() == Sensor.TYPE_ACCELEROMETER)
        {
            updateValues(event.values);
        }
    }

    public void updateValues(float[] values)
    {
        txtX.setText(String.format("%5.1f", values[0]));
        txtY.setText(String.format("%5.1f", values[1]));
        txtZ.setText(String.format("%5.2f", values[2]));
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {}

    @Override
    public void onClick(View v)
    {
        sensorManager.unregisterListener(this,
                sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER));
        MyGraphics mg = new MyGraphics(this);
        theLayout.addView(mg);
        sensorManager.registerListener(mg,
                sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                10000);
    }
}
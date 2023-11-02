package dk.tec.sensorproject;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.view.View;

public class MyGraphics extends View implements SensorEventListener
{
    float x = 200, y = 300;
    float xMove = 0, yMove = 0;
    int ballW, ballH;
    Drawable drwBall;
    int screenW, screenH;
    MainActivity main;
    public MyGraphics(MainActivity mainActivity)
    {
        super(mainActivity);
        this.main = mainActivity;
        drwBall = getResources().getDrawable(R.drawable.kugle_rwb, null);
        ballW = drwBall.getIntrinsicWidth() / 2;
        ballH = drwBall.getIntrinsicHeight() / 2;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        screenW = w;
        screenH = h;
    }

    @Override
    public void draw(Canvas canvas)
    {
        super.draw(canvas);
        drwBall.setBounds((int)x, (int)y,(int)x + ballW, (int)y + ballH);
        drwBall.draw(canvas);

    }

    @Override
    public void onSensorChanged(SensorEvent event)
    {
        main.updateValues(event.values);
        float xSlope = -event.values[0] / 50;
        float ySlope = event.values[1] / 50;
        xMove += xSlope;
        yMove += ySlope;
        x += xMove;
        y += yMove;

        if(x < 0 - 30)
        {
            xMove = Math.abs(xMove)  * 0.9f;
            x += 1;
        }
        if(x > screenW - ballW + 32)
        {
            xMove = -Math.abs(xMove)  * 0.9f;
            x -= 1;
        }

        if(y < 0 - 30)
        {
            yMove = Math.abs(yMove) * 0.9f;
            x += 1;
        }
        if(y > screenH - ballH + 32)
        {
            yMove = -Math.abs(yMove) * 0.9f ;
            x -= 1;
        }

        invalidate();

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}

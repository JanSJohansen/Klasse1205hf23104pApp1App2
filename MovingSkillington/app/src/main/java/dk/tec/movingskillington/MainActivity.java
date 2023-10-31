package dk.tec.movingskillington;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity
{
    FrameLayout theLinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        theLinearLayout = findViewById(R.id.theLinearLayout);
        MyGraphics mg = new MyGraphics(this);
        theLinearLayout.addView(mg, 0);
        Thread t = new Thread(mg);
        t.start();


    }
}
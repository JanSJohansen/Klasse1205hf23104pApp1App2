package dk.tec.ourfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


//Projektet opretter en brugerfladen i Java-koden
// eller i XML alt efter hvordan setContView() kaldes.
public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);  // XML

        LinearLayout l = new LinearLayout(this);
        TextView txt = new TextView(this);
        Button btn = new Button(this);

        l.setOrientation(LinearLayout.VERTICAL);
        txt.setText("Dette er oprettet i Java-koden");
        btn.setText("Tryk Her");
        l.addView(txt);
        l.addView(btn);
        setContentView(l); // Brugerflade  Java-kode

    }
}
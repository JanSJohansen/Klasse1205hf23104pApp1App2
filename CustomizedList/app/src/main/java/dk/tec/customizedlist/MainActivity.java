package dk.tec.customizedlist;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    ArrayList<Elev> elever;
    ListView lstElever;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        elever = new ArrayList<Elev>();
        elever.add(new Elev("Ahmad", "Flink fyr", R.drawable.ahmad));
        elever.add(new Elev("Anders", "Dygtig fyr", R.drawable.anders));
        elever.add(new Elev("Anna", "Elsker Big Band ", R.drawable.anna));
        elever.add(new Elev("Haittham", "Sig Hej til ham Haittham", R.drawable.haittham));
        elever.add(new Elev("Jan", "Boomer pensionist", R.drawable.jan));
        elever.add(new Elev("Jeppe", "Jeppe på bjerget", R.drawable.jeppe));
        elever.add(new Elev("Jimmy", "Selskabstømmer", R.drawable.jimmy));
        elever.add(new Elev("Mads", "Vi må kalde ham Mads", R.drawable.haittham));
        elever.add(new Elev("Marco", "Mafia Narko Marco", R.drawable.marco));
        elever.add(new Elev("Niyazi", "Hjælper damer i trafikken", R.drawable.niyazi));
        elever.add(new Elev("Philip", "Philip Hue", R.drawable.philip));
        elever.add(new Elev("Sebastian", "Er du sikker", R.drawable.sebastian));
        elever.add(new Elev("Valbon", "Han er gået", R.drawable.valbon));
        elever.add(new Elev("Wobin", "Han er ordentlig syg", R.drawable.wobin));

        ElevAdapter elevAdapter = new ElevAdapter(this, elever);
        lstElever = findViewById(R.id.lstElever);
        lstElever.setAdapter(elevAdapter);
    }
}
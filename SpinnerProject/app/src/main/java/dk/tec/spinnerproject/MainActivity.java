package dk.tec.spinnerproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity
        implements AdapterView.OnItemSelectedListener {
    TextView txtChosen;
    Spinner spnElever;
    String[] elever = {"Mads", "Haittham", "Jeppe", "Jimmy", "Anders",
            "Sebastian", "Anna", "Philip", "Valbon", "Jan"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtChosen = findViewById(R.id.txtChosen);
        spnElever = findViewById(R.id.spnElever);

        ArrayAdapter adapter = new ArrayAdapter(this,
                        android.R.layout.simple_spinner_item,
                        elever);
        spnElever.setAdapter(adapter);
        spnElever.setOnItemSelectedListener(this);
    }



    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {
        // Parameteren view indeholder det valgte item, som er en TextView
        TextView txt = (TextView)view;
        String text = txt.getText().toString();
        //txtChosen.setText(text);

        // Alle andre steder kan det valgte hentes ud af spinneren
        String txt2 = (String)spnElever.getSelectedItem();
        txtChosen.setText(txt2);

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {}
}
package dk.tec.radiobuttonsproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    RadioGroup rdgElever;
    TextView txtChosen;
    Button btnChose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rdgElever = findViewById(R.id.rdgElever);
        rdgElever.setOnCheckedChangeListener(this);
        txtChosen = findViewById(R.id.txtChosen);
        btnChose = findViewById(R.id.btnChose);
        btnChose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (rdgElever.getCheckedRadioButtonId()) {
                    case R.id.rdbAnna:
                        Toast.makeText(MainActivity.this, "Anna er valgt", Toast.LENGTH_LONG).show();
                        Log.d("JansTekst", "Anna er valgt");
                        break;
                    case R.id.rdbFrederik:
                        Toast.makeText(MainActivity.this, "Frederik er valgt", Toast.LENGTH_LONG).show();

                        Log.d("JansTekst", "Frederik er valgt");
                        break;
                    case R.id.rdbJeppe:
                        Log.d("JansTekst", "Jeppe er valgt");
                        break;
                    case R.id.rdbPhilip:
                        Log.d("JansTekst", "Philip er valgt");
                        break;
                }
            }
        });
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rdbAnna:
                txtChosen.setText("Anna");
                break;
            case R.id.rdbFrederik:
                txtChosen.setText("Frederik");
                break;
            case R.id.rdbJeppe:
                txtChosen.setText("Jeppe");
                break;
            case R.id.rdbPhilip:
                txtChosen.setText("Philip");
                break;
        }


    }
}
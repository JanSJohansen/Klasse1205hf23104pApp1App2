package dk.tec.twoactivities;

import static dk.tec.twoactivities.MainActivity.TEXT_TO_CALLER;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {
    TextView txtFromCaller;
    Button btnGoBack;
    EditText txtToCaller;
    Intent theIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        txtFromCaller = findViewById(R.id.txtFromCaller);
        btnGoBack = findViewById(R.id.btnGoBack);
        txtToCaller = findViewById(R.id.txtToCaller);
        btnGoBack.setOnClickListener(this);

        theIntent = getIntent();
        String str = theIntent.getStringExtra(MainActivity.TEXT_FROM_CALLER);
        txtFromCaller.setText(str);
        int i = theIntent.getIntExtra("Tal", 0);
    }

    @Override
    public void onClick(View v)
    {
        String str = txtToCaller.getText().toString();
        theIntent.putExtra(TEXT_TO_CALLER, str);
        setResult(SecondActivity.RESULT_OK, theIntent);
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
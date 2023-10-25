package dk.tec.twoactivities;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView txtFromSecond;
    Button btnGoToSecond;
    EditText txtToSecond;
    public static final String TEXT_FROM_CALLER = "TextFromCaller";
    public static final String TEXT_TO_CALLER = "TextToCaller";

    ActivityResultLauncher<Intent> secondActivityLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtToSecond = findViewById(R.id.txtToSecond);
        btnGoToSecond = findViewById(R.id.btnGoToSecond);
        txtFromSecond = findViewById(R.id.txtFromSecond);
        btnGoToSecond.setOnClickListener(this);

        secondActivityLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result)
                    {
                        if(result.getResultCode() == Activity.RESULT_OK)
                        {
                            Intent intent = result.getData();
                            String str = intent.getStringExtra(TEXT_TO_CALLER);
                            txtFromSecond.setText(str);
                        }
                        else
                        {
                            txtFromSecond.setText("Cancelled");
                        }
                    }
                });
    }

    @Override
    public void onClick(View v)
    {
        Intent intent = new Intent(this, SecondActivity.class);
        String str = txtToSecond.getText().toString();
        intent.putExtra(MainActivity.TEXT_FROM_CALLER, str);
        intent.putExtra("Tal", 5);
        //startActivity(intent);
        secondActivityLauncher.launch(intent);
    }
}
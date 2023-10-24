package dk.tec.buttoneventhandlers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnTryk;
    EditText txtWrite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTryk = findViewById(R.id.btnTryk);
        txtWrite = findViewById(R.id.txtWrite);

        //btnTryk.setOnClickListener(this);

        //btnTryk.setOnClickListener(new MyHandler(this));

//        btnTryk.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v)
//            {
//                txtWrite.setText("Handler i anonymous inner class");
//            }
//        });


    }

    @Override
    public void onClick(View v)
    {
        txtWrite.setText("Der blev trykket på Tryk");
    }

    public void myOnClick(View v)
    {
        txtWrite.setText("Handler angivet i layout");
    }
}
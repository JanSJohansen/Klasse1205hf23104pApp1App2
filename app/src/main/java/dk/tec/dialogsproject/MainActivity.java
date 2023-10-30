package dk.tec.dialogsproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnShowDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShowDialog = findViewById(R.id.btnShowDialog);
        btnShowDialog.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Pause");
        dialog.setMessage("Er det snart pause?");
        dialog.setPositiveButton("Ja", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                Snackbar snack =  Snackbar.make(
                        btnShowDialog,
                        "OK det er pause nu",
                        Snackbar.LENGTH_LONG);
                snack.show();
            }
        });
        dialog.setNegativeButton("Nej", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                Snackbar snack =  Snackbar.make(
                        btnShowDialog,
                        "OK boomer, der er ikke pause nu",
                        Snackbar.LENGTH_LONG);
                snack.show();
            }
        });
        dialog.setNeutralButton("Ved ikke", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                Snackbar snack =  Snackbar
                        .make(
                        btnShowDialog,
                        "Tja Bom Bom",
                        Snackbar.LENGTH_LONG)
                        .setAction("OK", new View.OnClickListener() {
                            @Override
                            public void onClick(View v)
                            {
                                Snackbar sn =  Snackbar
                                        .make(
                                                btnShowDialog,
                                                "Du nåede det lige",
                                                Snackbar.LENGTH_LONG);
                                sn.show();
                            }
                        });
                snack.show();
            }
        });
        dialog.show();
    }
}
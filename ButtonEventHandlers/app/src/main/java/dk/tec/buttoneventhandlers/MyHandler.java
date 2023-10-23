package dk.tec.buttoneventhandlers;

import android.view.View;

public class MyHandler implements View.OnClickListener
{
    MainActivity main;

    public MyHandler(MainActivity mainActivity)
    {
        main = mainActivity;
    }

    @Override
    public void onClick(View v)
    {
        main.txtWrite.setText("Handler i extern klasse");
    }
}

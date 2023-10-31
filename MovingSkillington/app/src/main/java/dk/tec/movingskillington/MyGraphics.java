package dk.tec.movingskillington;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;

public class MyGraphics extends View implements Runnable
{
    Drawable skillington;
    int skillingWidth, getSkillingHeight;
    int x = 200, y =100;
    int xMove = 2, yMove = 2;
    int screenWidth, screenHeight;
    MainActivity main;
    public MyGraphics(MainActivity main)
    {
        super(main);
        this.main = main;
        skillington = main.getResources().getDrawable(R.drawable.skillington, null);
        skillingWidth = skillington.getIntrinsicWidth() / 2;
        getSkillingHeight = skillington.getIntrinsicHeight() / 2;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        screenWidth = w;
        screenHeight = h;
    }

    @Override
    public void draw(Canvas canvas)
    {
        super.draw(canvas);
        skillington.setBounds(x, y, x + skillingWidth, y + getSkillingHeight);
        skillington.draw(canvas);

    }

    @Override
    public void run()
    {
        while(true)
        {
            if(x + skillingWidth >= screenWidth)
            {
                xMove = xMove * -1;
            }
            else if(x <=0)
            {
                xMove = xMove * -1;
            }
            if(y + getSkillingHeight >= screenHeight)
            {
                yMove = yMove * -1;
            }
            else if(y <=0)
            {
                yMove = yMove * -1;
            }

            x += xMove;
            y += yMove;

            postInvalidate();
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
            }
        }
    }
}

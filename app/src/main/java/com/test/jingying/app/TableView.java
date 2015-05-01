package com.test.jingying.app;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by guoyumei on 5/1/15.
 */
public class TableView extends ViewGroup{

    private static final int STARTX = 0;
    private static final int STARTY = 0;
    private static final int BORDER = 20;
    private static final String[] fields = {"Time", "Actor", "Region", "Category", "Version", "BitRate"};
    private int mRow;
    private int mClo;


    public TableView(Context context, int row, int clo) {
        super(context);
        this.mRow = row;
        this.mClo = clo;
        // 添加子控件
        this.addOtherView(context);
    }

    public void addOtherView(Context context) {

        for (int i = 0; i < mRow; i++) {
            TextView view = new TextView(context);
            view.setText(fields[i]);
            view.setGravity(Gravity.CENTER);
            view.setTextColor(Color.rgb(79, 129, 189));

            ImageView img = new ImageView(context);
            img.setImageResource(R.drawable.ic_launcher);

            if(i%2==0){
                view.setBackgroundColor(Color.rgb(219, 238, 243));
                img.setBackgroundColor(Color.rgb(219, 238, 243));
            }else{
                view.setBackgroundColor(Color.rgb(235, 241, 221));
                img.setBackgroundColor(Color.rgb(235, 241, 221));
            }
            this.addView(img);
            this.addView(view);
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int x = STARTX+BORDER;
        int y = STARTY+BORDER;

        int count = getChildCount();

        for (int i = 0; i < count; i++) {

            View view = getChildAt(i);
            view.layout(x, y, x + getWidth()/mClo - BORDER * 2, y + getHeight() / mRow - BORDER * 2);
            if (i % 2 == 1) {
                y += getHeight() / mRow;
                x = STARTX+BORDER;
            } else {
                x += getWidth()/mClo - BORDER*2;
            }
        }
    }
}

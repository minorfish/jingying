package com.test.jingying.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

/**
 * Created by guoyumei on 4/30/15.
 */
public class MovieActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        GridView gridView = (GridView) findViewById(R.id.gv_movie);
        gridView.setAdapter(new ImageAdapter(this));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MovieActivity.this,CategoryActivity.class);
                startActivity(intent);
            }
        });

    }
}

class ImageAdapter extends BaseAdapter {
    private Context mContext;
    private Integer[] imgs = {R.drawable.ic_launcher, R.drawable.ic_launcher,R.drawable.ic_launcher,
            R.drawable.ic_launcher, R.drawable.ic_launcher,R.drawable.ic_launcher};
    private String[] description = {"zuoer", "xxxx","uuuuuu", "hhhhhh", "jjjjjjjjjj", "dfg"};

    public ImageAdapter(Context context) {
        this.mContext=context;
    }

    @Override
    public int getCount() {
        return imgs.length;
    }

    @Override
    public Object getItem(int position) {
        return imgs[position];
    }

    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //定义一个TextView,显示在GridView里
        TextView textView = new TextView(mContext);
        textView.setGravity(Gravity.CENTER_HORIZONTAL);
        //TextView below to image
        textView.setCompoundDrawablesWithIntrinsicBounds(null, mContext.getResources().getDrawable(imgs[position]), null, null);

        textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 16f);
        textView.setText(description[position]);
        return textView;
    }

}



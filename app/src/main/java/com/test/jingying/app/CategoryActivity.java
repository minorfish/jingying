package com.test.jingying.app;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;

/**
 * Created by guoyumei on 5/1/15.
 */
public class CategoryActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_category);
        TableView table = new TableView(CategoryActivity.this, 6, 2);
       // GridView table = (GridView) findViewById(R.id.gv_category);
        setContentView(table);
    }

}

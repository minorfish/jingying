package com.test.jingying.app;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Movie;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by guoyumei on 4/30/15.
 */
public class SearchActivity extends Activity {
    private ImageButton ibtHome;
    private ImageButton ibtSearch;
    private ImageButton ibtMovie;
    private ImageButton ibtUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        ibtHome = (ImageButton) findViewById(R.id.imageButtonHome);
        ibtSearch = (ImageButton) findViewById(R.id.imageButtonSearch);
        ibtMovie = (ImageButton) findViewById(R.id.imageButtonMovie);
        ibtUser = (ImageButton) findViewById(R.id.imageButtonUser);

        //register click activity
        ibtHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SearchActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
        ibtSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SearchActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });
        ibtMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SearchActivity.this, MovieActivity.class);
                startActivity(intent);
            }
        });
        ibtUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SearchActivity.this, UserActivity.class);
                startActivity(intent);
            }
        });
    }
}

package com.test.jingying.app;


import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guoyumei on 5/3/15.
 */
public class MovieActivity extends FragmentActivity implements View.OnClickListener {

    private LinearLayout tab_descriptiption;
    private LinearLayout tab_photo;
    private LinearLayout tab_short;
    private LinearLayout tab_long;

    private TextView text_description;
    private TextView text_photo;
    private TextView text_short;
    private TextView text_long;

    private ViewPager mViewPager;
    private FragmentPagerAdapter mAdapter;
    private List<Fragment> mFragments;

    private  Resources resource;
    private  ColorStateList csl_select;
    private  ColorStateList csl_normal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_movie);
        initView();
        initEvent();
        setTab(0);
    }

    private void initEvent() {
        tab_descriptiption.setOnClickListener(this);
        tab_photo.setOnClickListener(this);
        tab_short.setOnClickListener(this);
        tab_long.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
            switch(v.getId()) {
                case R.id.id_tab_description:
                    setSelect(0);
                    break;
                case R.id.id_tab_photo:
                    setSelect(1);
                    break;
                case R.id.id_tab_short_commentt:
                    setSelect(2);
                    break;
                case R.id.id_tab_long_comment:
                    setSelect(3);
                    break;
                default:
                    break;
            }
    }

    void resetImgs() {
        text_description.getPaint().setFlags(0);
        text_photo.getPaint().setFlags(0);
        text_short.getPaint().setFlags(0);
        text_long.getPaint().setFlags(0);
    }

    private void setTab(int i) {

        resetImgs();
        switch(i) {
            case '0':
                text_description.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);//下划线
                break;
            case '1':
                text_photo.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);//下划线
                break;
            case '2':
                text_short.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);//下划线
                break;
            case '3':
                text_long.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);//下划线
                break;
            default:
                break;
        }
    }

    private void setSelect(int i) {
        setTab(i);
        mViewPager.setCurrentItem(i);
    }


    void initView () {

        resource = (Resources) getBaseContext().getResources();
        csl_select = (ColorStateList) resource.getColorStateList(R.color.lightblue);;
        csl_normal  = (ColorStateList) resource.getColorStateList(R.color.white);

        tab_descriptiption = (LinearLayout)findViewById(R.id.id_tab_description);
        tab_photo = (LinearLayout)findViewById(R.id.id_tab_photo);
        tab_short = (LinearLayout)findViewById(R.id.id_tab_short_commentt);
        tab_long = (LinearLayout)findViewById(R.id.id_tab_long_comment);

        text_description = (TextView)findViewById(R.id.text_desc);
        text_photo = (TextView)findViewById(R.id.text_photo);
        text_short = (TextView)findViewById(R.id.text_short);
        text_long = (TextView)findViewById(R.id.text_long);


        mViewPager = (ViewPager)findViewById(R.id.viewPager_movie);

        mFragments = new ArrayList<Fragment>();
        Fragment fragment1 = new DescriptionFragment();
        Fragment fragment2 = new PhotoFragment();
        Fragment fragment3 = new ShortFragment();
        Fragment fragment4 = new LongFragment();
        mFragments.add(fragment1);
        mFragments.add(fragment2);
        mFragments.add(fragment3);
        mFragments.add(fragment4);

        mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return mFragments.get(i);
            }

            @Override
            public int getCount() {
                return mFragments.size();
            }
        };

        mViewPager.setAdapter(mAdapter);

        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                //当viewPager发生改变时，同时改变上面的currentTab
                setTab(i);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

    }


}

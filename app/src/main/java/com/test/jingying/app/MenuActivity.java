package com.test.jingying.app;


import android.os.Bundle;
import android.support.v4.app.*;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;
import android.view.View.OnClickListener;

/**
 * Created by guoyumei on 4/30/15.
 */
public class MenuActivity extends FragmentActivity implements OnClickListener {

    //declare a ViewPager Object
    private ViewPager mViewPager;
    private FragmentPagerAdapter mAdapter;
    private List<Fragment>  mFragments;

    private LinearLayout mTabHome;
    private LinearLayout mTabMovie;
    private LinearLayout mTabSearch;
    private LinearLayout mTabUser;

    private ImageView mImgHome;
    private ImageView mImgMovie;
    private ImageView mImgSearch;
    private ImageView mImgUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_menu);
        initView();
        initEvent();
        setTab(0);
    }

    private void initEvent()
    {
        mTabHome.setOnClickListener(this);
        mTabMovie.setOnClickListener(this);
        mTabSearch.setOnClickListener(this);
        mTabUser.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.id_tab_home:
                setSelect(0);
                break;
            case R.id.id_tab_movie:
                setSelect(1);
                break;
            case R.id.id_tab_search:
                setSelect(2);
                break;
            case R.id.id_tab_user:
                setSelect(3);
                break;
            default:
                break;
        }
    }

    private void setSelect(int i)
    {
        setTab(i);
        mViewPager.setCurrentItem(i);
    }

    private void resetImgs()
    {
        mImgHome.setSelected(false);
        mImgMovie.setSelected(false);
        mImgSearch.setSelected(false);
        mImgUser.setSelected(false);
    }

    private void setTab(int i) {
        resetImgs();
        switch(i) {
            case '0':
                mImgHome.setSelected(true);
                break;
            case '1':
                mImgMovie.setSelected(true);
                break;
            case '2':
                mImgSearch.setSelected(true);
                break;
            case '3':
                mImgUser.setSelected(true);
                break;
            default:
                break;
        }
    }

    private void initView() {

        mViewPager = (ViewPager) findViewById(R.id.viewPager);

        mTabHome = (LinearLayout)findViewById(R.id.id_tab_home);
        mTabMovie = (LinearLayout)findViewById(R.id.id_tab_movie);
        mTabSearch = (LinearLayout)findViewById(R.id.id_tab_search);
        mTabUser = (LinearLayout)findViewById(R.id.id_tab_user);

        mImgHome = (ImageView) findViewById(R.id.id_tab_home_img);
        mImgMovie = (ImageView)findViewById(R.id.id_tab_movie_img);
        mImgSearch = (ImageView)findViewById(R.id.id_tab_search_img);
        mImgUser = (ImageView)findViewById(R.id.id_tab_user_img);

        mFragments = new ArrayList<Fragment>();
        Fragment fragment1 = new HomeFragment();
        Fragment fragment2 = new MovieFragment();
        Fragment fragment3 = new SearchFragment();
        Fragment fragment4 = new UserFragment();
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

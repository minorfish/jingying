package com.test.jingying.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.test.jingying.datas.MovieItem;
import com.test.jingying.common.CommonAdapter;
import com.test.jingying.common.CommonViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guoyumei on 5/1/15.
 */
public class HomeFragment extends android.support.v4.app.Fragment{

    private static final Integer movieImgSrc[] = {R.drawable.ic_launcher,R.drawable.ic_launcher, R.drawable.ic_launcher,
                                                  R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher};
    private static final String title[] = {"左耳", "何以笙萧默", "速度与激情7", "赤道", "疯狂外星人"
            ,"万物生长"};

    private static final Integer rankSrc[] = {R.drawable.home,R.drawable.home,R.drawable.home,
                                              R.drawable.home,R.drawable.home, R.drawable.home};

    private static final String score[] = {"5.6", "7.9", "3.5", "2.0", "5.6", "8.8"};

    private View view = null;
    private List<MovieItem> items = null;
    private GridView mGridView = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home,
                container, false);
        initDatas();
        initView();
        return view;
    }
    private void initDatas() {
        items = new ArrayList<MovieItem>();
        int count = movieImgSrc.length;
        for (int i = 0; i < count; i++) {
            items.add(new MovieItem(movieImgSrc[i],  rankSrc[i], title[i],score[i]));
        }
    }

    private void initView() {

        mGridView = (GridView) view.findViewById(R.id.gv_movie);
        mGridView.setAdapter(new CommonAdapter<MovieItem>(HomeFragment.this.getActivity(),items,R.layout.movie_grid_item) {

            @Override
            public void convert(CommonViewHolder viewHolder, MovieItem bean) {
                viewHolder.setImageResource(R.id.movie_item_img,bean.getMovieSrcId())
                        .setImageResource(R.id.movie_item_rank, bean.getRanSrcId())
                        .setText(R.id.movie_item_title, bean.getMovieTitle())
                        .setText(R.id.movie_item_score, bean.getScore());
            }
        });

        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(HomeFragment.this.getActivity(),MovieActivity.class);
                startActivity(intent);
            }
        });
    }
}


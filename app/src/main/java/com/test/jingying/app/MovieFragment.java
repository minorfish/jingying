package com.test.jingying.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.test.jingying.datas.Bean;
import com.test.jingying.common.CommonAdapter;
import com.test.jingying.common.CommonViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guoyumei on 5/2/15.
 */
public class MovieFragment extends Fragment{

    private static final String[] fields = {"时间","演员","地区","类别","版本","码率"};
    private static final Integer[] imgs = {R.drawable.ic_launcher, R.drawable.ic_launcher,R.drawable.ic_launcher,
            R.drawable.ic_launcher, R.drawable.ic_launcher,R.drawable.ic_launcher};
    private static final Integer[] colors = {R.color.aliceblue, R.color.aquamarine, R.color.brown};
    private View view = null;
    private List<Bean> items = null;
    private ListView mListView = null;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

       view = inflater.inflate(R.layout.fragment_movie,
                container, false);
        initDatas();
        initView();
        return view;
    }

    private void initDatas() {
        items = new ArrayList<Bean>();
        int count = fields.length;
        for (int i = 0; i < count; i++) {
            items.add(new Bean(imgs[i], fields[i]));
        }
    }

    private void initView() {

         mListView = (ListView) view.findViewById(R.id.listView_category);
         mListView.setAdapter(new CommonAdapter<Bean>(MovieFragment.this.getActivity(),items,R.layout.category_list_item) {

            @Override
            public void convert(CommonViewHolder viewHolder, Bean bean) {
               viewHolder.setImageResource(R.id.img_category,bean.getSrcId())
                       .setText(R.id.text_category, bean.getCategory());
                      // .setImageResource(R.id.category,R.drawable.main_tab_item_bg_focus);
            }
        });
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MovieFragment.this.getActivity(),MovieActivity.class);
                startActivity(intent);
            }
        });
    }

}



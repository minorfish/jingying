package com.test.jingying.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import com.test.jingying.common.CommonAdapter;
import com.test.jingying.common.CommonViewHolder;
import com.test.jingying.datas.MovieItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guoyumei on 5/2/15.
 */

public class UserFragment extends Fragment{

    private String[] userTitle1 = {"我的电影","已看电影","个人信息","猜你喜欢"};
    private String[] userTitle2 = {"想看", "登出"};

    private View view = null;
    private List<String> items1 = null;
    private List<String> items2 = null;

    private ListView listView1;
    private ListView listView2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_user,
                container, false);
        initData();
        initView();
        return view;
    }

    private void initData() {

        items1 = new ArrayList<String>();
        items2 = new ArrayList<String>();
        int count1 = userTitle1.length;
        int count2 = userTitle2.length;

        for (int i = 0; i <count1; i++)
            items1.add(userTitle1[i]);
        for (int i = 0; i <count2; i++)
            items2.add(userTitle2[i]);
    }

    private void initView() {

        listView1 = (ListView)view.findViewById(R.id.listView_user1);
        listView2 = (ListView)view.findViewById(R.id.listView_user2);

        listView1.setAdapter(new CommonAdapter<String>(UserFragment.this.getActivity(),items1,R.layout.user_list_item) {
            @Override
            public void convert(CommonViewHolder viewHolder, String s) {

                viewHolder.setText(R.id.user_item_title,s);
            }
        });
        listView2.setAdapter(new CommonAdapter<String>(UserFragment.this.getActivity(), items2, R.layout.user_list_item) {
            @Override
            public void convert(CommonViewHolder viewHolder, String s) {
                viewHolder.setText(R.id.user_item_title, s);
            }
        });
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(UserFragment.this.getActivity(),LoginActivity.class);
                startActivity(intent);
            }
        });
        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(UserFragment.this.getActivity(), MovieActivity.class);
                startActivity(intent);
            }
        });
    }
}

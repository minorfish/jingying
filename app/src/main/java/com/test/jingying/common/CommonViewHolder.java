package com.test.jingying.common;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by guoyumei on 5/3/15.
 */
public class CommonViewHolder {

        private SparseArray<View> mViews;
        private View mConvertView;
        private int position;

        public CommonViewHolder(Context context, ViewGroup parent, int layoutId, int position) {

            mViews = new SparseArray<View>();
            this.position = position;
            this.mConvertView = LayoutInflater.from(context).inflate(layoutId, parent, false);
            mConvertView.setTag(this);
        }

        public static CommonViewHolder get(Context context, View convertView, ViewGroup parent, int layoutId, int position) {
            if (convertView == null) {
                return new CommonViewHolder(context, parent, layoutId, position);
            }else {
                CommonViewHolder viewHolder = (CommonViewHolder)convertView.getTag();
                viewHolder.position = position; //position is different
                return viewHolder;
            }
        }

        //Through viewId to get a viewObject
        public <T extends View> T getView(int viewId) {

            View view = mViews.get(viewId);
            if (view == null) {
                view = mConvertView.findViewById(viewId);
                mViews.put(viewId, view);
            }
            return (T)view;
        }

        public View getConvertView() {
            return mConvertView;
        }

        //TextView
        public CommonViewHolder setText (int viewId, String text) {
            TextView tv = getView(viewId);
            tv.setText(text);
            return this;
        }
       //ImageView
        public CommonViewHolder setImageResource(int viewId, int resId) {
            ImageView iv = getView(viewId);
            iv.setImageResource(resId);
            return this;
        }
    
}

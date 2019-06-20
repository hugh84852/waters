package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;




public class ListViewAdapter {
    public static class MyListAdapter extends BaseAdapter {
        private Context mContext;
        private LayoutInflater mLayoutInflater;

        MyListAdapter(Context context) {
            this.mContext = context;
            this.mLayoutInflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return 10;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        static class ViewHolder {

            public TextView tvTitle, tvTime, tvContent;
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            if (convertView == null) {
                convertView = mLayoutInflater.inflate(R.layout.activity_layout_list_item, null);
                holder = new ViewHolder();

                holder.tvTitle = (TextView) convertView.findViewById(R.id.tv_title);
                holder.tvTime = (TextView) convertView.findViewById(R.id.tv_time);
                holder.tvContent = (TextView) convertView.findViewById(R.id.tv_content);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.tvTitle.setText("標題");
            holder.tvTime.setText("2019-03-30");
            holder.tvContent.setText("內容");

            return convertView;
        }
    }

}

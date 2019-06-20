package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


import org.w3c.dom.Text;

public class ListViewAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mLayoutInflater;

    ListViewAdapter(Context context) {
        this.mContext = context;
        this.mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 1;
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
        public ImageView imageView;
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
        Glide.with(mContext).load("https://pic.pimg.tw/heartisdie/1485176139-3346578719_b.jpg").into(holder.imageView);
        return convertView;
    }
}

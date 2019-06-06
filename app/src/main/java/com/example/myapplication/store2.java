package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.List;

public class store2 extends AppCompatActivity {

        //定義圖片陣列
        private int images[]={R.drawable.one,R.drawable.two,R.drawable.three};
        //定義一個View的陣列
        private List<View> views=new ArrayList<>();
        private ViewPager vp_main_viewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store2);
        vp_main_viewpager = (ViewPager) findViewById(R.id.vp_main_viewpager);

        //將images陣列中的圖片放入ImageView
        for (int i = 0; i < images.length; i++) {
            ImageView imageView=new ImageView(this);
            imageView.setImageResource(images[i]);
            views.add(imageView);
    }
        //為ViewPager設定介面卡
        vp_main_viewpager.setAdapter(new MyAdapter());
    }

        class MyAdapter extends PagerAdapter {

            @Override
            public int getCount() {
                return views.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view==object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                View v=views.get(position);
                container.addView(v);

                return v;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                View v=views.get(position);
                //前一張圖片劃過後刪除該View
                container.removeView(v);
            }


        }
}


package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.support.v4.view.ViewPager;
import java.util.*;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bumptech.glide.*;
import com.bumptech.glide.load.engine.DiskCacheStrategy;






public class store extends AppCompatActivity {

    private Context mContext;

    //參數
    private ViewPager mViewPager;

    //假資料

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        mViewPager = (ViewPager) findViewById(R.id.view_pager);

        //假資料
        List<String> mUrlList = new ArrayList<>();
        mUrlList.add("http://android.suvenconsultants.com/newimage/android-developer2.png");
        mUrlList.add("http://cdn.makeuseof.com/wp-content/uploads/2017/05/android-apps-eat-battery-670x335.jpg");
        mUrlList.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSpSWJ32XK7TcLUT2XpXTrzwHMOiKHJkzD7QodGrhRzfvRn35Z4mg");
        mUrlList.add("http://android.suvenconsultants.com/newimage/android-developer2.png");

        //呼叫Adapter
        BannerAdapter bannerAdapter = new BannerAdapter(this, mUrlList);
        mViewPager.setAdapter(bannerAdapter);

    }


    //製作Adapter
    class BannerAdapter extends PagerAdapter {

        private LayoutInflater mInflater;
        private List<String> mUrlList;

        //建構子
        public BannerAdapter(Context context, List<String> mUrlList) {
            //如果把這個寫在instantiateItem的話，每一個Item都會呼叫一次，很吃資源
            mInflater = LayoutInflater.from(context);
            this.mUrlList = mUrlList;
        }

        //看你這ViewPager要有幾頁，靠著List的大小擴充
        @Override
        public int getCount() {
            //如果陣列為空，返回0 防呆機制
            return mUrlList == null ? 0 : mUrlList.size();
        }

        //用來判斷目前的畫面是否和instantiateItem創建的為同一個
        @Override
        public boolean isViewFromObject(View view, Object o) {
            return o == view;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            //每一個Item都創建View
            View view = mInflater.inflate(R.layout.main_viewpager, container, false);
            ImageView imageView = (ImageView) view.findViewById(R.id.image);

            //用Glide下載圖片
            Glide.with(mContext)
                    .load(mUrlList.get(position))
                    .error(R.drawable.image_loading)
                    .placeholder(R.drawable.image_loading)
                    .centerCrop()
                    .fitCenter()
                    .diskCacheStrategy(DiskCacheStrategy.RESULT)
                    .into(imageView);
            container.addView(view);
            return view;
        }

        //移除ViewPager內所對應的視圖
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }

}

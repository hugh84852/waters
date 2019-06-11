package com.example.myapplication;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.MenuItem;
import android.widget.TextView;


public class home_1 extends AppCompatActivity {
    private TextView mTextMessage;
    private FragmentOne fragmentOne;
    private FragmentTwo fragmentTwo;
    private FragmentThree fragmentThree;
    private FragmentFour fragmentFour;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    showNav(R.id.navigation_home);
                    return true;
                case R.id.navigation_res:
                    mTextMessage.setText(R.string.title_res);
                    showNav(R.id.navigation_res);
                    return true;
                case R.id.navigation_card:
                    mTextMessage.setText(R.string.title_card);
                    showNav(R.id.navigation_card);
                    return true;
                case R.id.navigation_story:
                    mTextMessage.setText(R.string.title_story);
                    showNav(R.id.navigation_story);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home_1);
        init();
        BottomNavigationView navView = findViewById(R.id.navigation);
        mTextMessage = (TextView)findViewById(R.id.message);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


    }

    private void init() {
        fragmentOne = new FragmentOne();
        fragmentTwo = new FragmentTwo();
        fragmentThree = new FragmentThree();
        fragmentFour = new FragmentFour();
        FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
        beginTransaction.add(R.id.content,fragmentOne).add(R.id.content, fragmentTwo).add(R.id.content, fragmentThree).add(R.id.content, fragmentFour);//开启一个事务将fragment动态加载到组件
        beginTransaction.hide(fragmentOne).hide(fragmentTwo).hide(fragmentThree).hide(fragmentFour);//隐藏fragment
        beginTransaction.addToBackStack(null);//返回到上一个显示的fragment
        beginTransaction.commit();//每一个事务最后操作必须是commit（），否则看不见效果
        showNav(R.id.navigation_home);

    }

    private void showNav(int navid){
        FragmentTransaction beginTransaction=getFragmentManager().beginTransaction();
        switch (navid){
            case R.id.navigation_home:
                beginTransaction.hide(fragmentTwo).hide(fragmentThree).hide(fragmentFour);
                beginTransaction.show(fragmentOne);
                beginTransaction.addToBackStack(null);
                beginTransaction.commit();
                break;
            case R.id.navigation_res:
                beginTransaction.hide(fragmentOne).hide(fragmentThree).hide(fragmentFour);
                beginTransaction.show(fragmentTwo);
                beginTransaction.addToBackStack(null);
                beginTransaction.commit();
                break;
            case R.id.navigation_card:
                beginTransaction.hide(fragmentTwo).hide(fragmentOne).hide(fragmentFour);
                beginTransaction.show(fragmentThree);
                beginTransaction.addToBackStack(null);
                beginTransaction.commit();
                break;
            case R.id.navigation_story:
                beginTransaction.hide(fragmentTwo).hide(fragmentOne).hide(fragmentThree);
                beginTransaction.show(fragmentFour);
                beginTransaction.addToBackStack(null);
                beginTransaction.commit();
                break;
        }
    }

}




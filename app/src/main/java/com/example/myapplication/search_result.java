package com.example.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.app.Activity;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class search_result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);
//        Bundle bundle = this.getIntent().getExtras();
//        final String sv = bundle.getString("search");
//        sv = (TextView) findViewById(R.id.textView34);
    }


    private MyAPIService MyAPIService;
    Restaurant restaurant;
    private TextView res_name;

    private int boo = 0;
    SearchView SV;
    ListView LV;
   // 以上四個  為了接值&檢查搜尋是否符合資料庫內資料

    private String choose = "sukiya";

//    public void getResturant(final String choose) {
//        MyAPIService = RetrofitManager.getInstance().getAPI();
//        // 3. 建立連線的Call，此處設置call為myAPIService中的getAlbums()連線
//        Call<Restaurant> call = MyAPIService.getRes();
//
//        // 4. 執行call
//        call.enqueue(new Callback<Restaurant>() {
//            @Override
//            //如果請求連接資料庫並成功抓到值
//            public void onResponse(Call<Restaurant> call, Response<Restaurant> response) {
//
//                int len = response.body().getRecords().length; //Restaurant資料表有幾筆資料
//                int i = 0; //第0筆資料開始抓
//
//                for (i = 0; i < len; i++) {
//                    if (response.body().getfields(i).getRes_name().equals(choose)) {
//                        boo = 1;
//                        sv.setText(response.body().getfields(i).getRes_name());
//
//                        break;
//                    }
//                    else
//                    {
//                          Toast.makeText(search_result.this,"沒有!",Toast.LENGTH_SHORT).show();
//                            continue;
//                    }
//
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<Restaurant> call, Throwable t) {
//                res_name.setText(t.getMessage());
//
//            }
//        });
//    }
}

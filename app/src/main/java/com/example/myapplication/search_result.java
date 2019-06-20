package com.example.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
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
    private TextView res_address;
    private TextView res_phone;
    private TextView res_opening_time;
    private TextView ser_name;
    private TextView cat_name;
    private TextView res_info;
    ArrayAdapter<String> adapter3;
    private Spinner sp3;
    private Context context;
    private MyAPIService MyAPIService;
    Restaurant restaurant;
    private TextView res_name;
    private int boo = 0;
    private ImageButton b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);

        res_name = (TextView) findViewById(R.id.textView20);
        res_address = (TextView) findViewById(R.id.textView21);
        res_phone = (TextView) findViewById(R.id.textView22);
        res_opening_time = (TextView) findViewById(R.id.textView23);
        cat_name = (TextView) findViewById(R.id.textView24);
        ser_name = (TextView) findViewById(R.id.textView25);
        res_info = (TextView) findViewById(R.id.textView26);

        b1 = (ImageButton) findViewById(R.id.imageButton4);
        b1.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent();
                intent.setClass(search_result.this,store2.class);
                startActivity(intent);

            }
        });

        Bundle bundle = this.getIntent().getExtras();
        String get = bundle.getString("get");
        getResturant(get);


    }

    public void getResturant(final String get) {
        MyAPIService = RetrofitManager.getInstance().getAPI();
        // 3. 建立連線的Call，此處設置call為myAPIService中的getAlbums()連線
        Call<Restaurant> call = MyAPIService.getRes();
        call.enqueue(new Callback<Restaurant>() {
            @Override
            public void onResponse(Call<Restaurant> call, Response<Restaurant> response) {

                int len = response.body().getRecords().length; //Restaurant資料表有幾筆資料
                int i = 0; //第0筆資料開始抓
                for (i = 0; i < len; i++) {
                    if (response.body().getfields(i).getRes_name().equalsIgnoreCase(get)) {
                        res_name.setText(response.body().getfields(i).getRes_name());
                        res_address.setText(response.body().getfields(i).getRes_address());
                        res_phone.setText(response.body().getfields(i).getRes_phone());
                        res_opening_time.setText(response.body().getfields(i).getRes_opening_time());
                        res_info.setText(response.body().getfields(i).getRes_info());
                        ser_name.setText(response.body().getfields(i).getSer_name().get(0));
                        cat_name.setText(response.body().getfields(i).getCat_name().get(0));
                        break;
                    }


                }
            }

            @Override
            public void onFailure(Call<Restaurant> call, Throwable t) {
                res_name.setText(t.getMessage());
                res_address.setText(t.getMessage());
                res_phone.setText(t.getMessage());
                res_opening_time.setText(t.getMessage());
                cat_name.setText(t.getMessage());
                ser_name.setText(t.getMessage());
                res_info.setText(t.getMessage());
            }
        });
    }




}

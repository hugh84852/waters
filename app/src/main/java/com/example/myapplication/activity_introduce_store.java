package com.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class activity_introduce_store extends  AppCompatActivity {
    private ImageButton b1;
    Restaurant restaurant;
    private com.example.myapplication.MyAPIService MyAPIService;
    private TextView res_name;
    private TextView res_address;
    private TextView res_phone;
    private TextView res_opening_time;
    private TextView ser_name;
    private TextView cat_name;
    private TextView res_info;
    private Button home;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduce_store);

        Bundle bundle1 = this.getIntent().getExtras();
        final String choose = bundle1.getString("Rest");



        res_name = (TextView) findViewById(R.id.textView20);
        res_address = (TextView) findViewById(R.id.textView21);
        res_phone = (TextView) findViewById(R.id.textView22);
        res_opening_time = (TextView) findViewById(R.id.textView23);
        cat_name = (TextView) findViewById(R.id.textView24);
        ser_name = (TextView) findViewById(R.id.textView25);
        res_info = (TextView) findViewById(R.id.textView26);
        getResturant(choose);
        b1 = (ImageButton) findViewById(R.id.imageButton4);
        b1.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent();
                intent.setClass(activity_introduce_store.this,store2.class);
                startActivity(intent);

            }
        });
        Button home = (Button) findViewById(R.id.tothehome);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_introduce_store.this, home_page.class);
                startActivity(intent);
                ProgressDialogUtil.dismiss();
            }
        });

    }

    public void getResturant(final String choose){
        MyAPIService = RetrofitManager.getInstance().getAPI();

        // 3. 建立連線的Call，此處設置call為myAPIService中的getAlbums()連線
        Call<Restaurant> call = MyAPIService.getRes();

        // 4. 執行call
        call.enqueue(new Callback<Restaurant>() {
            @Override
            //如果請求連接資料 庫並成功抓到值
            public void onResponse(Call<Restaurant> call, Response<Restaurant> response) {
                int len = response.body().getRecords().length; //Restaurant資料表有幾筆資料
                int i;
                String Ser = "";
                for(i = 0 ; i < len ; i++){
//                {//第0筆資料開始抓
                    if(response.body().getfields(i).getRes_name().equals(choose)){
                        res_name.setText(response.body().getfields(i).getRes_name());
                        res_address.setText(response.body().getfields(i).getRes_address());
                        res_phone.setText(response.body().getfields(i).getRes_phone());
                        res_opening_time.setText(response.body().getfields(i).getRes_opening_time());
                        res_info.setText(response.body().getfields(i).getRes_info());
                        cat_name.setText(response.body().getfields(i).getCat_name().get(0));
                        for(int j = 0; j < response.body().getfields(i).getSer_name().size();j++){
                            Ser+=response.body().getfields(i).getSer_name().get(j)+" ";
                        }
                        ser_name.setText(Ser);
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


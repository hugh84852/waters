package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class search_result2 extends AppCompatActivity {
    private ListView mlv1;

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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result2);


       // mlv1 = (ListView) findViewById(R.id.lv_1);
        mlv1.setAdapter(new ListViewAdapter(search_result2.this));
        mlv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(search_result2.this,"pos:"+position,Toast.LENGTH_SHORT).show();
            }
        });
        mlv1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){
            @Override
            public boolean onItemLongClick(AdapterView<?> parent,View view,int position,long id){
                Toast.makeText(search_result2.this,"長按"+position,Toast.LENGTH_SHORT).show();
                return true;
            }
        });


        Bundle bundle = this.getIntent().getExtras();
        String get = bundle.getString("get");
    }

    public void getCAT(final String SP) {
        MyAPIService = RetrofitManager.getInstance().getAPI();
        // 3. 建立連線的Call，此處設置call為myAPIService中的getAlbums()連線
        Call<Category> call = MyAPIService.getCat();

        // 4. 執行call
        call.enqueue(new Callback<Category>() {
            @Override
            //如果請求連接資料庫並成功抓到值
            public void onResponse(Call<Category> call, Response<Category> response) {

                int len = response.body().getRecords().length; //category資料表有幾筆資料
                int i = 0; //第0筆資料開始抓

                for (i = 0; i < len; i++)
                {
                    if (response.body().getfields(i).getCat_name2().equalsIgnoreCase(SP))
                    {
                        //boo = 1;
                        //res_name.setText(response.body().getfields(i).getRes_name());
                        //Toast.makeText(search.this,"有!",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(search_result2.this, search_result3.class);
//                        Bundle bundle = new Bundle();
//                        bundle.putString("get",SP);
//                        intent.putExtras(bundle);
                        startActivity(intent);
                        break;
                    }
                }
                if(boo==0)
                {
                    Toast.makeText(search_result2.this, "查無此類型店家!", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<Category> call, Throwable t) {
                Toast.makeText(search_result2.this,"fail",Toast.LENGTH_SHORT).show();

            }
        });
    }
}

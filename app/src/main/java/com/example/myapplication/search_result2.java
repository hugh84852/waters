package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.dto.CategoryDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


        Bundle bundle = this.getIntent().getExtras();
        String get2 = bundle.getString("get2");



        mlv1 = (ListView) findViewById(R.id.lv_1);
//        mlv1.setAdapter(new ListViewAdapter(search_result2.this));



        getCat(get2);
    }

    public void getCat(final String SP) {
        MyAPIService = RetrofitManager.getInstance().getAPI();
        // 3. 建立連線的Call，此處設置call為myAPIService中的getAlbums()連線
        Map<String, String> query = new HashMap<>();
        //用formula判斷餐廳名稱
        query.put("filterByFormula", "{cat_name} = '" + SP + "'");
        Call<ListRes<CategoryDto>> call = MyAPIService.getCat(query);
        // 4. 執行call
        call.enqueue(new Callback<ListRes<CategoryDto>>() {
            @Override
            //如果請求連接資料庫並成功抓到值
            public void onResponse(Call<ListRes<CategoryDto>> call, Response<ListRes<CategoryDto>> response) {


                List<Res<CategoryDto>> categoryResList = response.body().getRecords();
                for(int i=1;i<categoryResList.size();i++) {
                    if (categoryResList.get(i).getFields().getCat_name().equals(SP)) {
                        mlv1.setAdapter(new ListViewAdapter(categoryResList.get(i).getFields().getCat_name(), search_result2.this, categoryResList.get(i).getFields().getCat_name().length()));


                        //boo = 1;
                        //res_name.setText(response.body().getfields(i).getRes_name());
                        //Toast.makeText(search.this,"有!",Toast.LENGTH_SHORT).show();

//                    Bundle bundle = new Bundle();
//                    bundle.putString("get", SP);
//                    intent.putExtras(bundle);


                    } else {
                        Toast.makeText(search_result2.this, "查無此類型店家!", Toast.LENGTH_SHORT).show();
                    }
                }
            }


            @Override
            public void onFailure(Call<ListRes<CategoryDto>> call, Throwable t) {
                Toast.makeText(search_result2.this, "fail", Toast.LENGTH_SHORT).show();
                Log.e("search", "[getCAT]" + t.getMessage());
            }
        });
    }
}

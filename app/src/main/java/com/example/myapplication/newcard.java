package com.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class newcard extends AppCompatActivity {
    private MyAPIService MyAPI ;
    private String cat = "中式";
    private List<String> pool;
    private Button back;
    private Button check;
    private  TextView Restext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newcard);
        getResturant();

        back = (Button) findViewById(R.id.back);
        back.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent();
                intent.setClass(newcard.this,activity_card.class);
                startActivity(intent);
            }
        });



        check = (Button) findViewById(R.id.checkout);
        check.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent();
                intent.setClass(newcard.this,activity_introduce_store.class);
                startActivity(intent);
                SharedPreferences abcd=getSharedPreferences("save",activity_card.MODE_PRIVATE);
                String b=abcd.getString("card","fail");


                Bundle bundle1 = new Bundle();
                bundle1.putString("Rest",b);
                intent.putExtras(bundle1);
                startActivity(intent);
            }
        });



    }

    public void getResturant() {
        MyAPI = RetrofitManager.getInstance().getAPI();
        // 3. 建立連線的Call，此處設置call為myAPIService中的getAlbums()連線
        Call<Restaurant> call = MyAPI.getRes();

        // 4. 執行call
        call.enqueue(new Callback<Restaurant>() {
            @Override
            //如果請求連接資料庫並成功抓到值
            public void onResponse(Call<Restaurant> call, Response<Restaurant> response) {

//                int len = response.body().getRecords().length; //Restaurant資料表有幾筆資料
                TextView Restxt =(TextView)findViewById(R.id.Restxt);
                SharedPreferences abcd=getSharedPreferences("save",activity_card.MODE_PRIVATE);
                SharedPreferences.Editor editor=abcd.edit();
                String b=abcd.getString("card","fail");
                int a =abcd.getInt("restnum",0);

                editor.commit();

                Restxt.setText(b);

//                int i = 0; //第0筆資料開始抓
//                int j = 0 ;
//                for (i = 0; i < len; i++) {
//                    if (response.body().getfields(i).getCat_name().get(0).equals(cat)) {
//                        for ( j = 0 ; j < i ; j ++) {
//                            //res_name.setText(response.body().getfields(i).getRes_name());
//                            //Toast.makeText(activity_card.this,"有!",Toast.LENGTH_SHORT).show();
//                            pool.add(response.body().getfields(i).getRes_name());
//
//                            int r = (int) (Math.random()*j);
//                            Restxt.setText(pool.get(r));
//                        }
//                    }
//                }
            }

            @Override
            public void onFailure(Call<Restaurant> call, Throwable t) {
                //res_name.setText(t.getMessage());

            }
        });
    }

    public void setPool(List<String> pool) {
        this.pool = pool;
    }


//    public void getRes(){
//        test1 = RetrofitManager.getInstance().getAPI();
//        Call<Restaurant> call =((MyAPIService) test1).getRes();
//        call.enqueue(new Callback<Restaurant>() {
//            @Override
//            public void onResponse(Call<Restaurant> call, Response<Restaurant> response) {
//                Restxt.setText(response.body().getfields(i).getRes_name());
//            }
//
//            @Override
//            public void onFailure(Call<Restaurant> call, Throwable t) {
//                Restxt.setText(t.getMessage());
//            }
//        });
//
//
//
//    }
}

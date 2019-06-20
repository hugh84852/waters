package com.example.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class activity_card extends AppCompatActivity {
    private ImageButton d1;
    private ImageButton a1;
    private ImageButton b1;
    private ImageButton c1;
    private ImageButton b4;
    private Button p1;
    private MyAPIService MyAPI ;

    private int count;
    private int boo = 0;
    private String cat = "中式";
    private String cat1 = "日式";
    private String cat2 = "西式";

    private List<String> pool;
    private TextView testarray;










    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);
        TextView counter = (TextView) findViewById(R.id.counter);

        int restnum = getSharedPreferences("save", MODE_PRIVATE)
                .getInt("restnum", Integer.parseInt("0"));
        String countshow = Integer.toString(restnum);
        counter.setText(countshow);

        pool = new ArrayList<>();

        d1 = (ImageButton) findViewById(R.id.imageButton06);
        d1.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                /* TODO Auto-generated method stub */
                Intent intent = new Intent();
                intent.setClass(activity_card.this, home_page.class);
                startActivity(intent);

            }
        });
        a1 = (ImageButton) findViewById(R.id.imageButton03);
        a1.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                /* TODO Auto-generated method stub */
                Intent intent = new Intent();
                intent.setClass(activity_card.this, near_res.class);
                startActivity(intent);

            }
        });
        b1 = (ImageButton) findViewById(R.id.imageButton07);
        b1.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                /* TODO Auto-generated method stub */
                Intent intent = new Intent();
                intent.setClass(activity_card.this, story.class);
                startActivity(intent);

            }
        });
        c1 = (ImageButton) findViewById(R.id.imageButton08);
        c1.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                /* TODO Auto-generated method stub */
                Intent intent = new Intent();
                intent.setClass(activity_card.this, memberinfo.class);
                startActivity(intent);

            }
        });
            p1 = (Button) findViewById(R.id.p1);
            p1.setOnClickListener(new Button.OnClickListener() {
                public void onClick(View v) {
                    SharedPreferences bcde = getSharedPreferences("save",activity_register.MODE_PRIVATE);
                    SharedPreferences abcd = getSharedPreferences("save",MODE_PRIVATE);
                    int x =bcde.getInt("restnum",1);
                    if(x > 0) {

                        /* TODO Auto-generated method stub */
                        getResturant();
                        Intent intent = new Intent();
                        intent.setClass(activity_card.this, newcard.class);
                        startActivity(intent);
                        TextView counter = (TextView) findViewById(R.id.counter);

                        int restnum = getSharedPreferences("save", MODE_PRIVATE)
                                .getInt("restnum", Integer.parseInt("0"));
                        String countshow = Integer.toString(restnum);

                        counter.setText(countshow);


                    }
                    else {
                        Toast.makeText(activity_card.this,"今日抽卡次數已用盡!",Toast.LENGTH_SHORT).show();


                    }
                }
            });

    }




    public void dialog1(View v) {

        AlertDialog.Builder alertadd = new AlertDialog.Builder(this);
        LayoutInflater factory = LayoutInflater.from(activity_card.this);
        final View view = factory.inflate(R.layout.activity_cardrecord, null);
        alertadd.setView(view);
        alertadd.setNeutralButton("確認!", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dlg, int sumthin) {

            }
        });
        alertadd.setPositiveButton("查看店家資訊!", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dlg, int sumthin) {

            }
        });

        alertadd.show();
        b4 = (ImageButton) findViewById(R.id.imageButton06);
        b4.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent();
                intent.setClass(activity_card.this, home_page.class);
                startActivity(intent);

            }
        });


    }




    public void setCount(final int count){
        MyAPI = RetrofitManager.getInstance().getAPI();
        Call<Reqregist> call = MyAPI.changeInfor(new Reqregist(new cardcount_fields(count)));
        call.enqueue(new Callback<Reqregist>(){

            @Override
            public void onResponse(Call<Reqregist> call, Response<Reqregist> response) {
                Toast.makeText(activity_card.this,"ok",Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<Reqregist> call, Throwable t) {
                Toast.makeText(activity_card.this,"no",Toast.LENGTH_SHORT).show();
            }
        });
    }


    public void getCou(){
        MyAPI = RetrofitManager.getInstance().getAPI();
        Call<Card_count> call = MyAPI.getCou();
        call.enqueue(new Callback<Card_count>() {
            @Override
            public void onResponse(Call<Card_count> call, Response<Card_count> response) {
                int count1 = response.body().getCount();
                TextView counter = (TextView) findViewById(R.id.counter);
                String countshow = Integer.toString(count1);
                counter.setText(countshow);

            }

            @Override
            public void onFailure(Call<Card_count> call, Throwable t) {

            }

        });


    }

    public void getCou1(){
        MyAPI = RetrofitManager.getInstance().getAPI();
        Call<Card_count> call = MyAPI.getCou();
        call.enqueue(new Callback<Card_count>() {
            @Override
            public void onResponse(Call<Card_count> call, Response<Card_count> response) {
                int count1 = response.body().getCount();
                count1++;
                setCount(count1);
                TextView counter = (TextView) findViewById(R.id.counter);
                String countshow = Integer.toString(count1);
                counter.setText(countshow);
            }

            @Override
            public void onFailure(Call<Card_count> call, Throwable t) {
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

                int len = response.body().getRecords().length; //Restaurant資料表有幾筆資料
                int i;
                int j;
                for (i = 0; i < len; i++) {
                    if (response.body().getfields(i).getCat_name().get(0).equals(cat)||response.body().getfields(i).getCat_name().get(0).equals(cat1)||response.body().getfields(i).getCat_name().get(0).equals(cat2)) {
                        pool.add(response.body().getfields(i).getRes_name());
                    }
                }
                    int r = (int) (Math.random()*pool.size());
                    SharedPreferences abcd =getSharedPreferences("save",MODE_PRIVATE);
                    abcd.edit()
                        .putString("card",pool.get(r))
                        .commit();

                    SharedPreferences bcde = getSharedPreferences("save",activity_register.MODE_PRIVATE);
                    SharedPreferences.Editor editor = abcd.edit();
                    int x = bcde.getInt("restnum",1);
                    editor.putInt("restnum",x-1);
                    editor.commit();
                            //================================================================
                    //pool.add(response.body().getfields(i).getRes_name());
                    //String a =pool.get(r);
                            //res_name.setText(response.body().getfields(i).getRes_name());
                            // Toast.makeText(activity_card.this,"有!",Toast.LENGTH_SHORT).show();
                            //SharedPreferences abcd =getSharedPreferences("save",MODE_PRIVATE);
                            //SharedPreferences bcde=getSharedPreferences("save",activity_register.MODE_PRIVATE);
                            //SharedPreferences.Editor editor = abcd.edit();
                            //editor.putString("rest",a);
                            //int x =bcde.getInt("restnum",1);
                            //editor.putInt("restnum",x+1);
                            //editor.commit();
                            //================================================================


                    }




            @Override
            public void onFailure(Call<Restaurant> call, Throwable t) {
                //res_name.setText(t.getMessage());

            }
        });
    }


}






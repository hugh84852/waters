package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class newcard extends AppCompatActivity {
    private Object test1 ;
    private Button back;
    private Button check;
    private TextView Restxt;
    int i = (int) (Math.random()*6);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newcard);
        Restxt = (TextView)findViewById(R.id.Restxt);
        getRes();

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
            }
        });



    }


    public void getRes(){
        test1 = RetrofitManager.getInstance().getAPI();
        Call<Restaurant> call =((MyAPIService) test1).getRes();
        call.enqueue(new Callback<Restaurant>() {
            @Override
            public void onResponse(Call<Restaurant> call, Response<Restaurant> response) {
                Restxt.setText(response.body().getfields(i).getRes_name());
            }

            @Override
            public void onFailure(Call<Restaurant> call, Throwable t) {
                Restxt.setText(t.getMessage());
            }
        });



    }
}

package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class  cardresult extends AppCompatActivity {
    private Object MyAPIService ;
    private TextView textView16;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardresult);

        textView16 = (TextView)findViewById(R.id.textView16);
         getRes();

    }


    //    <------------------------------->
    @SuppressWarnings("unchecked")
    public void getRes(){
        MyAPIService = RetrofitManager.getInstance().getAPI();
        Call<Restaurant> call =((MyAPIService) MyAPIService).getRes();
        call.enqueue(new Callback<Restaurant>() {
            @Override
            public void onResponse(Call<Restaurant> call, Response<Restaurant> response) {
                textView16.setText(response.body().getfields(0).getRes_name());
            }

            @Override
            public void onFailure(Call<Restaurant> call, Throwable t) {
                textView16.setText(t.getMessage());
            }
        });

    }

}

//    <------------------------------->


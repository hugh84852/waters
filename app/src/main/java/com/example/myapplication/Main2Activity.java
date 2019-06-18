package com.example.myapplication;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Main2Activity extends AppCompatActivity {
    //    implements CompoundButton.OnCheckedChangeListener
    private MyAPIService MyAPI;
    private boolean bt;
    private CheckBox CB1;
    private CheckBox CB2;
    private CheckBox CB3;
    private CheckBox CB4;
    private CheckBox CB5;
    private CheckBox CB6;
    private CheckBox CB7;
    private CheckBox CB8;
    private CheckBox CB9;
    private CheckBox CB10;
    private CheckBox CB11;
    private CheckBox CB12;
    private Button BTN;
    private List<CheckBox> checkBoxList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        SharedPreferences sharedPreferences = getSharedPreferences("User" , MODE_PRIVATE);
        final String mem_id = sharedPreferences.getString("mem_id" , null);

        CB1 = (CheckBox) findViewById(R.id.checkBox1);
        CB2 = (CheckBox) findViewById(R.id.checkBox2);
        CB3 = (CheckBox) findViewById(R.id.checkBox3);
        CB4 = (CheckBox) findViewById(R.id.checkBox4);
        CB5 = (CheckBox) findViewById(R.id.checkBox5);
        CB6 = (CheckBox) findViewById(R.id.checkBox6);
        CB7 = (CheckBox) findViewById(R.id.checkBox7);
        CB8 = (CheckBox) findViewById(R.id.checkBox8);
        CB9 = (CheckBox) findViewById(R.id.checkBox9);
        CB10 = (CheckBox) findViewById(R.id.checkBox10);
        CB11 = (CheckBox) findViewById(R.id.checkBox11);
        CB12 = (CheckBox) findViewById(R.id.checkBox12);

        checkBoxList.add(CB1);
        checkBoxList.add(CB2);
        checkBoxList.add(CB3);
        checkBoxList.add(CB4);
        checkBoxList.add(CB5);
        checkBoxList.add(CB6);
        checkBoxList.add(CB7);
        checkBoxList.add(CB8);
        checkBoxList.add(CB9);
        checkBoxList.add(CB10);
        checkBoxList.add(CB11);
        checkBoxList.add(CB12);

        BTN = (Button) findViewById(R.id.button4);
        BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuffer sb = new StringBuffer();
                for (CheckBox checkbox : checkBoxList) {
                    if (checkbox.isChecked()) {
                        sb.append(checkbox.getText().toString() + "、");
                    }
                }
                if (sb != null && "".equals(sb.toString())) {
                    Toast.makeText(getApplicationContext(), "至少選擇一個", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "你選擇的是:" + sb.toString(), Toast.LENGTH_LONG).show();
                }
//                getmemid(mem_id);
            }

//            public void Updateinfor(String[] cat_name){
//                MyAPI = RetrofitManager.getInstance().getAPI();
//                Call<Req> call = MyAPI.UpdateMemInfor(new Req(new fields(cat_name)));
//                call.enqueue(new Callback<Req>() {
//                    @Override
//                    public void onResponse(Call<Req> call, Response<Req> response) {
//
//                        Intent intent = new Intent(Main2Activity.this, home_page.class);
//                        startActivity(intent);
//                    }
//
//                    @Override
//                    public void onFailure(Call<Req> call, Throwable t) {
//
//                    }
//
//                });
//
//            };
        });

    }
}
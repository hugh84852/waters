package com.example.myapplication;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//import static com.example.myapplication.activity_register.mem_birthday;


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
    String msg = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        int[] cb_id = {R.id.checkBox1, R.id.checkBox2, R.id.checkBox3, R.id.checkBox4, R.id.checkBox5,
                R.id.checkBox6, R.id.checkBox7, R.id.checkBox8, R.id.checkBox9, R.id.checkBox10,
                R.id.checkBox11, R.id.checkBox12,};

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




    /*CompoundButton.OnCheckedChangeListener mOnCheckedChangeListener = new CompoundButton.OnCheckedChangeListener(){

        @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                switch (buttonView.getId()){
                    case R.id.checkBox1:
                        if(isChecked) {
                            Toast.makeText(Main2Activity.this, "你是程式設計師", Toast.LENGTH_SHORT).show();
                        } else{
                            Toast.makeText(Main2Activity.this, "你不是程式設計師", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case R.id.checkBox2:
                        if(isChecked) {
                            Toast.makeText(Main2Activity.this, "你是男性", Toast.LENGTH_SHORT).show();
                        } else{
                            Toast.makeText(Main2Activity.this, "你是女性", Toast.LENGTH_SHORT).show();
                        }
                        break;
                }
            }
        };

        }*/

//        for(int i:cb_id) {    // 以迴圈逐一檢視各 CheckBox 是否被選取
//            CheckBox chk = (CheckBox) findViewById(i);
//            if (chk.isChecked()) {// 若有被選取
//
//
//            }
//        }




        BTN = (Button) findViewById(R.id.button4);
        BTN.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this, home_page.class);
                startActivity(intent);
            }
        });




        }



}

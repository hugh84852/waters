package com.example.myapplication;


import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;




public class MainActivity extends AppCompatActivity {
    private Button b2;
    private Button b;
    private EditText EditText6;
    private EditText EditText7;
    final  private  ArrayList<String> acc = new ArrayList<>();
    final  private  ArrayList<String> passs = new ArrayList<>();

    private Button botton;
    private Button botton2;
    private Object test1;
    private  TextView test2;
    private Button btn1;
   final private ArrayList<String> corpas = new ArrayList<>();

    //memberlst memberlst;
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


            test1 =RetrofitManager.getInstance().getAPI();
            final Call<ListRes<Member>> call= ((test1) test1).getMem();
            test2=(TextView)findViewById(R.id.test2);

            EditText6 =(EditText)findViewById(R.id.editText6);
            EditText7 =(EditText)findViewById(R.id.editText7);

            SharedPreferences session = getSharedPreferences("save_EditText6",MODE_PRIVATE);
            final SharedPreferences.Editor editor=session.edit();

            call.enqueue(new Callback<ListRes<Member>>() {
                @Override
                public void onResponse(Call<ListRes<Member>> call,Response<ListRes<Member>> response)
                {

                    for(Res<Member> xxx : response.body().getRecords()){
                        acc.add(xxx.getFields().getMem_account());
                    }
                    for (Res<Member> aaa : response.body().getRecords()){
                        passs.add((aaa.getFields().getMem_password()));
                    }
                //test2.setText(response.body().getRecords().get(1).getFields().getMem_account()+passs);

                }

                @Override
                public void onFailure(Call<ListRes<Member>> call, Throwable t) {
                    t.printStackTrace();
                }
            });

            btn1 = (Button)  findViewById(R.id.botton);
            btn1.setOnClickListener(new OnClickListener(){



                public void onClick(View v)
                {

                    int log =0;
                    int passd=0;

                    String user =EditText6.getText().toString();
                    String pass = EditText7.getText().toString();
                    for (int i=0 ; i<acc.size();i=i+1){
                        if (acc.get(i).equals(user)){
                            corpas.clear();
                            corpas.add(passs.get(i));
                            log=1;
                            break;
                        }
                    }
                    if(log==1){
                        if (corpas.get(0).equals(pass)){
                            editor.putString("user_id",user);
                            editor.commit();
                            Intent intent= new Intent(MainActivity.this, Main2Activity.class);
                            startActivity(intent);
                        }
                        else {
                           test2.setText("Warning : 密碼錯誤!");
                        }
                    }
                    else{
                        test2.setText("Warning : 查無此帳號! ");
                    }
                }
            });


        b2 = (Button) findViewById(R.id.button2);
        b2.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, register.class);
                startActivity(intent);
            }
        });

    }

        }




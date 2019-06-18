package com.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import java.util.*;
import android.widget.*;
import android.support.v7.app.*;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class test_main2 extends AppCompatActivity implements OnClickListener{

    private MyAPIService MyAPI;
    private List<CheckBox> checkBoxs = new ArrayList<CheckBox>();
    private String test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_test_main2);

        String[] checkBoxTest = new String[] {
                "你是学生吗？", "是否喜欢Android？", "你喜欢旅游吗？", "打算出国吗？"
        };

        LinearLayout linearLayout = (LinearLayout) getLayoutInflater().inflate(R.layout.activity_test_main2, null);
        //给指定的checkbox赋值
        for(int i = 0; i < checkBoxTest.length; i++) {
            //先获得checkBox.xml的对象
            CheckBox checkBoxLayout = (CheckBox)getLayoutInflater().inflate(R.layout.activity_checkbox, null);
            checkBoxs.add(checkBoxLayout);
            checkBoxs.get(i).setText(checkBoxTest[i]);

            //实现了在main主布局中，通过LinearLayout在for循环中添加checkbox。
            linearLayout.addView(checkBoxLayout, i);
            setContentView(linearLayout);

            Button button = (Button)findViewById(R.id.button);
            button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent= new Intent(test_main2.this, test_main2.class);
                postcheck();
                startActivity(intent);
            }
        });
        }
    }
    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        //当用户点击按钮的时候，要取出这个布局
        String str = "";
        MyAPI = RetrofitManager.getInstance().getAPI();
        Call<Member> call = MyAPI.getMem();


        for(CheckBox a : checkBoxs){
            if(a.isChecked()){
                str += a.getText() + "\n";
                postcheck();
            }
        }
        if("".equals(str)){
            str = "你还没有选中选项!!";
        }
        //使用一个提示框来显示用户信息
        new AlertDialog.Builder(this).setMessage(str).setPositiveButton("OK",  null).show();
    }

    public void postcheck() {
        MyAPI = RetrofitManager.getInstance().getAPI();
        List<String> checkbox = new ArrayList<>();
        //checkbox.add("1");
        SharedPreferences session = getSharedPreferences("save_useraccount",MODE_PRIVATE);
        SharedPreferences.Editor editor=session.edit();


        Call<Res<Member>> call = MyAPI.PostMember(new Req<>(new Member(checkbox)));
        call.enqueue(new Callback<Res<Member>>() {
            @Override
            public void onResponse(Call<Res<Member>> call, Response<Res<Member>> response) {
            }
            @Override
            public void onFailure(Call<Res<Member>> call, Throwable t) {
            }
        });
    }
}
package com.example.myapplication;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class activity_register extends AppCompatActivity {
    private Button submit;
    private EditText email;
    private EditText password;
    private EditText name;
    private EditText phone;
    private EditText birthday;
    private RadioGroup gender;
    private MyAPIService MyAPI;
    static String mem_birthday;
    private static String gender_tostring = "";
    int getnum = 0;
    private static String str1;
    private static String str2;
    private static String str3;
    private List<String> checkbox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        checkbox = new ArrayList<>();

        email = (EditText) findViewById(R.id.editText);
        password = (EditText) findViewById(R.id.editText4);
        name = (EditText) findViewById(R.id.editText3);
        phone = (EditText) findViewById(R.id.editText2);
        birthday = (EditText) findViewById(R.id.editText5);
        gender = (RadioGroup) findViewById(R.id.radioGroup);

        //----------------------------------------------------------------------------------
        final Spinner spinnercat_1 = (Spinner) findViewById(R.id.spinnercat_1);
        str1 = (String) spinnercat_1.getSelectedItem();

        spinnercat_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                //拿到被選擇項的值
                str1 = (String) spinnercat_1.getSelectedItem();
                if (str1.equals("請選擇你的喜好！")){
                }
                else if (str1.equals("中式")){
                    checkbox.add("rec2xSGBD05rAgaNP");
                }
                else if (str1.equals("日式")){
                    checkbox.add("rec0DdBrLDS2mJr04");
                }
                else if (str1.equals("港式")){
                    checkbox.add("recHVXS6MGesIQKXD");
                }
                else if (str1.equals("韓式")){
                    checkbox.add("recWbj5NtvBM03iZl");
                }
                else if (str1.equals("台式")){
                    checkbox.add("recNciYuCniEh9nap");
                }
                else if (str1.equals("美式")){
                    checkbox.add("rechhKasnfYTL17tj");
                }
                else if (str1.equals("墨式")){
                    checkbox.add("recxDrVjfq60t8gnW");
                }
                else if (str1.equals("泰式")){
                    checkbox.add("recRcXsiI2FI7XS2Q");
                }
                else if (str1.equals("印式")){
                    checkbox.add("recmKKWUezdg84Yve");
                }
                else if (str1.equals("法式")){
                    checkbox.add("recp16LKymmgeqw9V");
                }
                else if (str1.equals("西式")){
                    checkbox.add("rec5tMXxS0A6KpCNs");
                }
                else if (str1.equals("甜點")){
                    checkbox.add("recbsOylkDNI1hsuk");
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });

        final Spinner spinnercat_2 = (Spinner) findViewById(R.id.spinnercat_2);
        str2 = (String) spinnercat_2.getSelectedItem();

        spinnercat_2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                //拿到被選擇項的值
                str2 = (String) spinnercat_2.getSelectedItem();
                if (str2.equals("請選擇你的喜好！")){
                }
                else if (str2.equals("中式")){
                    checkbox.add("rec2xSGBD05rAgaNP");
                }
                else if (str2.equals("日式")){
                    checkbox.add("rec0DdBrLDS2mJr04");
                }
                else if (str2.equals("港式")){
                    checkbox.add("recHVXS6MGesIQKXD");
                }
                else if (str2.equals("韓式")){
                    checkbox.add("recWbj5NtvBM03iZl");
                }
                else if (str2.equals("台式")){
                    checkbox.add("recNciYuCniEh9nap");
                }
                else if (str2.equals("美式")){
                    checkbox.add("rechhKasnfYTL17tj");
                }
                else if (str2.equals("墨式")){
                    checkbox.add("recxDrVjfq60t8gnW");
                }
                else if (str2.equals("泰式")){
                    checkbox.add("recRcXsiI2FI7XS2Q");
                }
                else if (str2.equals("印式")){
                    checkbox.add("recmKKWUezdg84Yve");
                }
                else if (str2.equals("法式")){
                    checkbox.add("recp16LKymmgeqw9V");
                }
                else if (str2.equals("西式")){
                    checkbox.add("rec5tMXxS0A6KpCNs");
                }
                else if (str2.equals("甜點")){
                    checkbox.add("recbsOylkDNI1hsuk");
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });

        final Spinner spinnercat_3 = (Spinner) findViewById(R.id.spinnercat_3);
        str3 = (String) spinnercat_3.getSelectedItem();

        spinnercat_3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                //拿到被選擇項的值
                str3 = (String) spinnercat_3.getSelectedItem();
                if (str3.equals("請選擇你的喜好！")){
                }
                else if (str3.equals("中式")){
                    checkbox.add("rec2xSGBD05rAgaNP");
                }
                else if (str3.equals("日式")){
                    checkbox.add("rec0DdBrLDS2mJr04");
                }
                else if (str3.equals("港式")){
                    checkbox.add("recHVXS6MGesIQKXD");
                }
                else if (str3.equals("韓式")){
                    checkbox.add("recWbj5NtvBM03iZl");
                }
                else if (str3.equals("台式")){
                    checkbox.add("recNciYuCniEh9nap");
                }
                else if (str3.equals("美式")){
                    checkbox.add("rechhKasnfYTL17tj");
                }
                else if (str3.equals("墨式")){
                    checkbox.add("recxDrVjfq60t8gnW");
                }
                else if (str3.equals("泰式")){
                    checkbox.add("recRcXsiI2FI7XS2Q");
                }
                else if (str3.equals("印式")){
                    checkbox.add("recmKKWUezdg84Yve");
                }
                else if (str3.equals("法式")){
                    checkbox.add("recp16LKymmgeqw9V");
                }
                else if (str3.equals("西式")){
                    checkbox.add("rec5tMXxS0A6KpCNs");
                }
                else if (str3.equals("甜點")){
                    checkbox.add("recbsOylkDNI1hsuk");
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });
//        //----------------------------------------------------------------------------------

        gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = (RadioButton) group.findViewById(checkedId);
                gender_tostring = radioButton.getText().toString();
                getnum++;
            }
        });
        birthday.setInputType(InputType.TYPE_NULL); //不顯示系统輸入鍵盤</span>
        birthday.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                // TODO Auto-generated method stub
                if (hasFocus) {
                    showDatePickerDialog();
                }
            }
        });

        birthday.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                showDatePickerDialog();
            }
        });

        submit = findViewById(R.id.button30);
        submit.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v) {
                // TODO Auto-generated method stub
                String mem_email = email.getText().toString().trim();
                String mem_password = password.getText().toString().trim();
                String mem_name = name.getText().toString().trim();
                String mem_phone = phone.getText().toString().trim();
                String mem_birthday = birthday.getText().toString().trim();
                String gender_choose = gender_tostring;

                if(mem_email.equals("") || mem_password.equals("") || mem_birthday == null || mem_name.equals("") ||mem_phone.equals("") || getnum == 0)
                {
                    Toast.makeText(activity_register.this,"有必填欄位未填!",Toast.LENGTH_SHORT).show();
                }
                else{
                    if(gender_tostring.equals("男")){
                        gender_choose = "男";
                    }
                    else{
                        gender_choose = "女";
                    }
                    getMember(mem_email,mem_password,mem_name,gender_choose,mem_phone,mem_birthday);
                }
            }
        });
    }

    public void getMember(final String mem_email, final String mem_password, final String mem_name, final String gender_tostring, final String mem_phone, final String mem_birthday) {
        MyAPI = RetrofitManager.getInstance().getAPI();
        Call<Member> call = MyAPI.getMem();
        call.enqueue(new Callback<Member>() {
            @Override
            public void onResponse(Call<Member> call, Response<Member> response) {//如果請求連接資料庫並成功抓到值
                int len = response.body().getRecords().length;
                int j = 0;
                boolean ifExisted = false;
                while (j < len) {
                    if (response.body().getfields(j).getMem_account().equals(mem_email)) {
                        ifExisted = true;
                        Toast.makeText(activity_register.this, "此帳號已存在!", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    j++;
                }
                if (ifExisted == false) {
                    PostRegister(mem_email,mem_password,mem_name,gender_tostring,mem_phone,mem_birthday,checkbox);
                }
            }

            @Override
            public void onFailure(Call<Member> call, Throwable t) {
                Toast.makeText(activity_register.this, "註冊失敗!!", Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void showDatePickerDialog() {
        Calendar c = Calendar.getInstance();
        new DatePickerDialog(activity_register.this, new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                // TODO Auto-generated method stub
                birthday.setText(year + "/" + (monthOfYear + 1) + "/" + dayOfMonth);
                mem_birthday = year + "-" + (monthOfYear + 1) + "-" + dayOfMonth;
            }
        }, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH)).show();
    }
////////////////
    public void PostRegister(final String mem_email,final String mem_password , final String mem_name,
                             final String gender_tostring , final String mem_phone, final String mem_birthday, final List<String> checkbox) {
        MyAPI = RetrofitManager.getInstance().getAPI();
        Call<Reqregist> call = MyAPI.PostMember(new Reqregist(new fields(mem_email,mem_password,mem_name,gender_tostring,mem_birthday,mem_phone,checkbox)));
        call.enqueue(new Callback<Reqregist>() {
            @Override
            public void onResponse(Call<Reqregist> call, Response<Reqregist> response) {
                ProgressDialogUtil.showProgressDialog(activity_register.this);
                Toast.makeText(activity_register.this,"註冊成功!",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(activity_register.this, MainActivity.class);
                startActivity(intent);
            }
            @Override
            public void onFailure(Call<Reqregist> call, Throwable t) {
                Toast.makeText(activity_register.this,"註冊失敗!",Toast.LENGTH_SHORT).show();
            }
        });
    }
}

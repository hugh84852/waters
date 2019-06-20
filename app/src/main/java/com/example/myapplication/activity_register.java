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
import android.widget.Toast;

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
    private String mem_birthday;
    private static String gender_tostring = "";
    int getnum = 0;
    private String str;
    private String str1;
    private String str2;
    private List<String> checkbox;
    private String mem_email;
    private String mem_password;
    private String mem_name;
    private String mem_phone ;
    private String gender_choose;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        SharedPreferences abcd =getSharedPreferences("save",MODE_PRIVATE);
        SharedPreferences.Editor editor = abcd.edit();
        editor.putInt("restnum",0);
        editor.commit();
        checkbox = new ArrayList<>();

        getnum = 0 ;
        email = (EditText) findViewById(R.id.editText);
        password = (EditText) findViewById(R.id.editText4);
        name = (EditText) findViewById(R.id.editText3);
        phone = (EditText) findViewById(R.id.editText2);
        birthday = (EditText) findViewById(R.id.editText5);
        gender = (RadioGroup) findViewById(R.id.radioGroup);



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
                 mem_email = email.getText().toString().trim();
                 mem_password = password.getText().toString().trim();
                 mem_name = name.getText().toString().trim();
                 mem_phone = phone.getText().toString().trim();
                 mem_birthday = birthday.getText().toString().trim();
                 gender_choose = gender_tostring;


                //----------------------------------------------------------------------------------
                final Spinner spinnercat_1 = (Spinner) findViewById(R.id.spinnercat_1);
                str = (String) spinnercat_1.getSelectedItem();

                spinnercat_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view,
                                               int position, long id) {
                        //拿到被选择项的值
                        str = (String) spinnercat_1.getSelectedItem();
                        if (str.equals("請選擇你的喜好！")){
                            checkbox.add("1");
                        }
                        else if (str.equals("中式")){
                            checkbox.add("1 ");
                        }
                        else if (str.equals("日式")){
                            checkbox.add("2");
                        }
                        else if (str.equals("港式")){
                            checkbox.add("3");
                        }
                        else if (str.equals("韓式")){
                            checkbox.add("4");
                        }
                        else if (str.equals("台式")){
                            checkbox.add("5");
                        }
                        else if (str.equals("美式")){
                            checkbox.add("6");
                        }
                        else if (str.equals("墨式")){
                            checkbox.add("7");
                        }
                        else if (str.equals("泰式")){
                            checkbox.add("8");
                        }
                        else if (str.equals("印式")){
                            checkbox.add("9");
                        }
                        else if (str.equals("法式")){
                            checkbox.add("10");
                        }
                        else if (str.equals("西式")){
                            checkbox.add("11");
                        }
                        else if (str.equals("其他")){
                            checkbox.add("12");
                        }
                    }
                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        // TODO Auto-generated method stub
                    }
                });

                final Spinner spinnercat_2 = (Spinner) findViewById(R.id.spinnercat_2);
                str1 = (String) spinnercat_2.getSelectedItem();

                spinnercat_2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view,
                                               int position, long id) {
                        //拿到被选择项的值
                        str1 = (String) spinnercat_2.getSelectedItem();
                        if (str1.equals("請選擇你的喜好！")){
                            checkbox.add("1");
                        }
                        else if (str1.equals("中式")){
                            checkbox.add("1");
                        }
                        else if (str1.equals("日式")){
                            checkbox.add("2 ");
                        }
                        else if (str1.equals("港式")){
                            checkbox.add("3");
                        }
                        else if (str1.equals("韓式")){
                            checkbox.add("4");
                        }
                        else if (str1.equals("台式")){
                            checkbox.add("5");
                        }
                        else if (str1.equals("美式")){
                            checkbox.add("6");
                        }
                        else if (str1.equals("墨式")){
                            checkbox.add("7");
                        }
                        else if (str1.equals("泰式")){
                            checkbox.add("8");
                        }
                        else if (str1.equals("印式")){
                            checkbox.add("9");
                        }
                        else if (str1.equals("法式")){
                            checkbox.add("10");
                        }
                        else if (str1.equals("西式")){
                            checkbox.add("11");
                        }
                        else if (str1.equals("其他")){
                            checkbox.add("12");
                        }
                    }
                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        // TODO Auto-generated method stub
                    }
                });

                final Spinner spinnercat_3 = (Spinner) findViewById(R.id.spinnercat_3);
                str2 = (String) spinnercat_3.getSelectedItem();

                spinnercat_3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        //拿到被选择项的值
                        str2 = (String) spinnercat_3.getSelectedItem();
                        if (str2.equals("請選擇你的喜好！")){
                            checkbox.add("1");
                        }
                        else if (str2.equals("中式")){
                            checkbox.add("1");
                        }
                        else if (str2.equals("日式")){
                            checkbox.add("2");
                        }
                        else if (str2.equals("港式")){
                            checkbox.add("3 ");
                        }
                        else if (str2.equals("韓式")){
                            checkbox.add("4");
                        }
                        else if (str2.equals("台式")){
                            checkbox.add("5");
                        }
                        else if (str2.equals("美式")){
                            checkbox.add("6");
                        }
                        else if (str2.equals("墨式")){
                            checkbox.add("7");
                        }
                        else if (str2.equals("泰式")){
                            checkbox.add("8");
                        }
                        else if (str2.equals("印式")){
                            checkbox.add("9");
                        }
                        else if (str2.equals("法式")){
                            checkbox.add("10");
                        }
                        else if (str2.equals("西式")){
                            checkbox.add("11");
                        }
                        else if (str2.equals("其他")){
                            checkbox.add("12");
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        // TODO Auto-generated method stub
                    }
                });
                //----------------------------------------------------------------------------------


                if(mem_email.equals("") || mem_password.equals("") || mem_birthday == null || mem_name.equals("") ||mem_phone.equals("") || getnum == 0)
                {
                    Toast.makeText(activity_register.this,"有必填欄位未填!",Toast.LENGTH_SHORT).show();
                }
                else{
                    if(gender_tostring.equals("男")){
                        gender_tostring = "M";
                    }
                    else{
                        gender_tostring = "F";
                    }
                    getMember(mem_email,mem_password,mem_name,gender_choose,mem_phone,mem_birthday);
                }
            }
        });
    }
    public void getMember(final String mem_email,final String mem_password , final String mem_name ,
                          final String gender_tostring , final String mem_phone, final String mem_birthday) {
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
                    //postinfor();
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

    public void PostRegister(final String mem_email,final String mem_password , final String mem_name ,
                             final String gender_tostring , final String mem_phone, final String mem_birthday, final List<String>checkbox)
    {
        MyAPI = RetrofitManager.getInstance().getAPI();
        Call<Reqregist> call = MyAPI.PostMember(new Reqregist(new fields(mem_email,mem_password,mem_name,gender_tostring,mem_birthday,mem_phone,checkbox)));
        call.enqueue(new Callback<Reqregist>() {
            @Override
            public void onResponse(Call<Reqregist> call, Response<Reqregist> response) {
                String ID = response.body().getId();
                ProgressDialogUtil.showProgressDialog(activity_register.this);
                Toast.makeText(activity_register.this,"註冊成功!",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(activity_register.this, MainActivity.class);
                startActivity(intent);

//                public void UpdateCheckbox(final List<String>checkbox,final String ID){
//                    MyAPI = RetrofitManager.getInstance().getAPI();
//                    Call<Reqregist> call = MyAPI.UpdateMemInfor(new Reqregist(new fields(checkbox)),ID);
//                }

            }
            @Override
            public void onFailure(Call<Reqregist> call, Throwable t) {
                Toast.makeText(activity_register.this,"註冊失敗!",Toast.LENGTH_SHORT).show();
            }
        });
    }


//    public void postinfor() {
//        MyAPI = RetrofitManager.getInstance().getAPI();
//
//                Call<Res<fields>> call = MyAPI.PostMember(new Req<>(new fields
//                        (mem_email, mem_password, mem_name, gender_tostring, mem_birthday, mem_phone,checkbox)
//        ));
//        call.enqueue(new Callback<Res<fields>>() {
//            @Override
//            public void onResponse(Call<Res<fields>> call, Response<Res<fields>> response) {
//            }
//            @Override
//            public void onFailure(Call<Res<fields>> call, Throwable t) {
//            }
//        });
//    }

}

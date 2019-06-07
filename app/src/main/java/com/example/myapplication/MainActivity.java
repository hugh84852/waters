package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.app.Activity;
import android.widget.Button;




public class MainActivity extends AppCompatActivity {
    private Button b2;
    private Button b3;
    private Button BTN1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b2 = (Button) findViewById(R.id.button2);
        b2.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }
        });
        /*BTN1 = (Button) findViewById(R.id.button3);
        BTN1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,activity_addstore.class);
                startActivity(intent);
            }
        });*/

        /*b3 = (Button) findViewById(R.id.button3);
        b3.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,activity_addstore.class);
                startActivity(intent);
            }
        });*/

    }


}
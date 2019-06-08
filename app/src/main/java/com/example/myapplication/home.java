package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class home extends AppCompatActivity {
    private ImageButton b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


    b2 = (ImageButton) findViewById(R.id.imageButton9);
        b2.setOnClickListener(new Button.OnClickListener(){
        public void onClick(View v) {
            // TODO Auto-generated method stub
            Intent intent = new Intent();
            intent.setClass(home.this,activity_addstore.class);
            startActivity(intent);
        }
    });


}
}

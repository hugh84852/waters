package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class awholenewworld extends AppCompatActivity {

    private ImageButton C1;
    private ImageButton b1;
    private ImageButton b2;
    private ImageButton b3;
    private ImageButton b4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_awholenewworld);

        C1 = (ImageButton) findViewById(R.id.imageButton29);
        C1.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                /* TODO Auto-generated method stub */
                Intent intent = new Intent();
                intent.setClass(awholenewworld.this, activity_introduce_store.class);
                startActivity(intent);

            }
        });
        b1 = (ImageButton) findViewById(R.id.imageButton5);
        b1.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent();
                intent.setClass(awholenewworld.this, activity_card.class);
                startActivity(intent);
            }
        });
        b2 = (ImageButton) findViewById(R.id.imageButton3);
        b2.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent();
                intent.setClass(awholenewworld.this, near_res.class);
                startActivity(intent);
            }
        });

        b3 = (ImageButton) findViewById(R.id.imageButton6);
        b3.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent();
                intent.setClass(awholenewworld.this, awholenewworld.class);
                startActivity(intent);
            }
        });

        b4 = (ImageButton) findViewById(R.id.imageButton8);
        b4.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent();
                intent.setClass(awholenewworld.this, Member.class);
                startActivity(intent);
            }
        });

    }
}

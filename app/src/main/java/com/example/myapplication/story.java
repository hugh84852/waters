package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class story extends AppCompatActivity {
    private ImageButton IB6;
    private ImageButton IB7;
    private ImageButton IB8;
    private ImageButton IB9;
    private ImageButton IB10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        IB6 = (ImageButton) findViewById(R.id.iB700);
        IB6.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent();
                intent.setClass(story.this, awholenewworld.class);
                startActivity(intent);
            }
        });

        IB7 = (ImageButton) findViewById(R.id.iB7);
        IB7.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent();
                intent.setClass(story.this, near_res.class);
                startActivity(intent);
            }

        });

        IB8 = (ImageButton) findViewById(R.id.iB800);
        IB8.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent();
                intent.setClass(story.this, activity_card.class);
                startActivity(intent);
            }

        });

        IB10 = (ImageButton) findViewById(R.id.iB1000);
        IB10.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent();
                intent.setClass(story.this, memberinfo.class);
                startActivity(intent);
            }

        });
    }
}

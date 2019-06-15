package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class near_res extends AppCompatActivity {
    private ImageButton IB110;
    private ImageButton IB120;
    private ImageButton IB130;
    private ImageButton IB140;
    private ImageButton IB150;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_near_res);

        IB110 = (ImageButton) findViewById(R.id.imageButton110);
        IB110.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent();
                intent.setClass(near_res.this, home_page.class);
                startActivity(intent);
            }
        });

        IB130 = (ImageButton) findViewById(R.id.imageButton130);
        IB130.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent();
                intent.setClass(near_res.this, activity_card.class);
                startActivity(intent);
            }

        });

        IB140 = (ImageButton) findViewById(R.id.imageButton140);
        IB140.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent();
                intent.setClass(near_res.this, story.class);
                startActivity(intent);
            }

        });

        IB150 = (ImageButton) findViewById(R.id.imageButton150);
        IB150.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent();
                intent.setClass(near_res.this, memberinfo.class);
                startActivity(intent);
            }

        });
    }
}

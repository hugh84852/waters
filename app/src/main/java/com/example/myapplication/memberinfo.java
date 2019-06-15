package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class memberinfo extends AppCompatActivity {

    private ImageButton d1;
    private ImageButton a1;
    private ImageButton b1;
    private ImageButton c1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memberinfo);

        d1 = (ImageButton) findViewById(R.id.iB7);
        d1.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v) {
                /* TODO Auto-generated method stub */
                Intent intent = new Intent();
                intent.setClass(memberinfo.this, home_page.class);
                startActivity(intent);

            }
        });
        a1 = (ImageButton) findViewById(R.id.iB6);
        a1.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v) {
                /* TODO Auto-generated method stub */
                Intent intent = new Intent();
                intent.setClass(memberinfo.this,near_res.class);
                startActivity(intent);

            }
        });
        b1 = (ImageButton) findViewById(R.id.iB9);
        b1.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v) {
                /* TODO Auto-generated method stub */
                Intent intent = new Intent();
                intent.setClass(memberinfo.this,story.class);
                startActivity(intent);

            }
        });
        c1 = (ImageButton) findViewById(R.id.iB8);
        c1.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v) {
                /* TODO Auto-generated method stub */
                Intent intent = new Intent();
                intent.setClass(memberinfo.this,activity_card.class);
                startActivity(intent);

            }
        });
    }
}

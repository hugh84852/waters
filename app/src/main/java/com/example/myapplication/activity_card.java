package com.example.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class activity_card extends AppCompatActivity {
    private ImageButton d1;
    private ImageButton a1;
    private ImageButton b1;
    private ImageButton c1;

    private ImageButton b4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);

        d1 = (ImageButton) findViewById(R.id.imageButton06);
        d1.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v) {
                /* TODO Auto-generated method stub */
                Intent intent = new Intent();
                intent.setClass(activity_card.this, home_page.class);
                startActivity(intent);

            }
        });

        a1 = (ImageButton) findViewById(R.id.imageButton03);
        a1.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v) {
                /* TODO Auto-generated method stub */
                Intent intent = new Intent();
                intent.setClass(activity_card.this,near_res.class);
                startActivity(intent);

            }
        });
        b1 = (ImageButton) findViewById(R.id.imageButton07);
        b1.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v) {
                /* TODO Auto-generated method stub */
                Intent intent = new Intent();
                intent.setClass(activity_card.this,story.class);
                startActivity(intent);

            }
        });
        c1 = (ImageButton) findViewById(R.id.imageButton08);
        c1.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v) {
                /* TODO Auto-generated method stub */
                Intent intent = new Intent();
                intent.setClass(activity_card.this,memberinfo.class);
                startActivity(intent);

            }
        });
       }


        public void dialog(View v)
        {
            AlertDialog.Builder alertadd = new AlertDialog.Builder(this);
            LayoutInflater factory = LayoutInflater.from(activity_card.this);
            final View view = factory.inflate(R.layout.activity_cardresult, null);
            alertadd.setView(view);
            alertadd.setNeutralButton("確認!", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dlg, int sumthin) {

                }
            });
            alertadd.setPositiveButton("查看店家資訊!", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dlg, int sumthin) {

                }
            });

            alertadd.show();


        }

    public void dialog1(View v)
    {

        AlertDialog.Builder alertadd = new AlertDialog.Builder(this);
        LayoutInflater factory = LayoutInflater.from(activity_card.this);
        final View view = factory.inflate(R.layout.activity_cardrecord, null);
        alertadd.setView(view);
        alertadd.setNeutralButton("確認!", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dlg, int sumthin) {

            }
        });
        alertadd.setPositiveButton("查看店家資訊!", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dlg, int sumthin) {

            }
        });

        alertadd.show();
        b4 = (ImageButton) findViewById(R.id.imageButton06);
        b4.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent();
                intent.setClass(activity_card.this, home_page.class);
                startActivity(intent);

            }
        });


    }


}

package com.example.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.app.Activity;
import android.view.Menu;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


public class activity_card extends AppCompatActivity {

    private ImageButton b4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);
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
                intent.setClass(activity_card.this,awholenewworld.class);
                startActivity(intent);

            }
        });


    }


}

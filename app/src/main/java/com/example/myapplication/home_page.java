package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SearchView;

public class home_page extends AppCompatActivity {

    private ImageButton C1;
    private ImageButton b1;
    private ImageButton D1;
    private ImageButton a1;
    private ImageButton E1;
    private SearchView Search;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        C1 = (ImageButton) findViewById(R.id.imageButton29);
        C1.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v) {
                /* TODO Auto-generated method stub */
                Intent intent = new Intent();
                intent.setClass(home_page.this,activity_introduce_store.class);
                startActivity(intent);

            }
        });
        D1 = (ImageButton) findViewById(R.id.iB900);
        D1.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v) {
                /* TODO Auto-generated method stub */
                Intent intent = new Intent();
                intent.setClass(home_page.this,story.class);
                startActivity(intent);

            }
        });
        b1 = (ImageButton) findViewById(R.id.iB800);
        b1.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent();
                intent.setClass(home_page.this,activity_card.class);
                startActivity(intent);

            }
        });
        a1 = (ImageButton) findViewById(R.id.iB700);
        a1.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent();
                intent.setClass(home_page.this,near_res.class);
                startActivity(intent);

            }
        });
        E1 = (ImageButton) findViewById(R.id.iB1000);
        E1.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent();
                intent.setClass(home_page.this,memberinfo.class);
                startActivity(intent);

            }
        });

        Search = (SearchView) findViewById(R.id.SearchRestaurant);
        Search.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v) {
                /* TODO Auto-generated method stub */
                Intent intent = new Intent();
                intent.setClass(home_page.this,search.class);
                startActivity(intent);

            }
        });
    }
}
package com.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SearchEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SearchView;

public class home_page extends AppCompatActivity {

    private ImageButton C1;
    private ImageButton F1;
    private ImageButton b1;
    private ImageButton D1;
    private ImageButton a1;
    private ImageButton E1;
    private SearchView Search;

    private SearchView S1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        SharedPreferences session = getSharedPreferences("User",MODE_PRIVATE);
        String x = session.getString("mem_account","1080");
        System.out.println(x);




        S1 = (SearchView) findViewById(R.id.SearchRestaurant);
        S1.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v) {
                /* TODO Auto-generated method stub */
                Intent intent = new Intent();
                intent.setClass(home_page.this,search.class);
                startActivity(intent);

            }
        });

        C1 = (ImageButton) findViewById(R.id.imageButton29);
        C1.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v) {
                /* TODO Auto-generated method stub */
                Intent intent = new Intent();
                intent.setClass(home_page.this,activity_introduce_store.class);

                Bundle bundle = new Bundle();
                bundle.putString("Rest","重慶酸辣粉");
                intent.putExtras(bundle);
                startActivity(intent);



            }
        });
        F1 = (ImageButton) findViewById(R.id.imageButton11);
        F1.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v) {
                /* TODO Auto-generated method stub */
                Intent intent = new Intent();
                intent.setClass(home_page.this,activity_introduce_store.class);

                Bundle bundle = new Bundle();
                bundle.putString("Rest","名廚鐵板燒");
                intent.putExtras(bundle);
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

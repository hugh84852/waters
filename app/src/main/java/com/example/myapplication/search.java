package com.example.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.app.Activity;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class search extends AppCompatActivity {
    private String[] County = new String [] {
            "縣/市","臺北市","新北市","桃園市","臺中市","臺南市","高雄市","基隆市","新竹縣",
            "新竹市", "苗栗縣","彰化縣","南投縣","雲林縣","嘉義縣","嘉義市","屏東縣","宜蘭縣",
            "花蓮縣","臺東縣","澎湖縣","金門縣","連江縣"
    };
    private String[] start = new String[]{"ssss"};
    private String[][] district = new String [][] {
            {"鄉/鎮/市/區"},
            {"中正區","大同區","中山區","松山區","大安區","萬華區","信義區", "士林區",
                    "北投區", "內湖區","南港區","文山區"},
            {"板橋區","新莊區","中和區","永和區","土城區","樹林區","三峽區","鶯歌區","三重區",
                    "蘆洲區","五股區","泰山區","林口區","八里區","淡水區","三芝區","石門區",
                    "金山區", "萬里區","汐止區","瑞芳區","貢寮區","平溪區","雙溪區","新店區",
                    "深坑區","石碇區", "坪林區","烏來區"},
            {"桃園區","八德區","龜山區","蘆竹區","大園區","大溪區","中壢區","平鎮區","楊梅區",
                    "龍潭區","新屋區","觀音區","復興區"},
            {"中區","東區","南區","西區","北區","北屯區","西屯區","南屯區","太平區","大里區",
                    "霧峰區","烏日區","豐原區","后里區","石岡區","東勢區","和平區","新社區",
                    "潭子區", "大雅區","神岡區","大肚區","龍井區","沙鹿區","梧棲區","清水區",
                    "大甲區","外埔區", "大安區"},
            {"東區","南區","北區","安南區","安平區","中西區","新營區","鹽水區","白河區",
                    "柳營區", "後壁區","東山區","麻豆區","下營區","六甲區","官田區","大內區",
                    "佳里區","學甲區", "西港區","七股區","將軍區","北門區","新化區","善化區",
                    "新市區","安定區","山上區", "玉井區","楠西區","南化區","左鎮區","仁德區",
                    "歸仁區","關廟區","龍崎區","永康區"},
            {"鹽埕區","鼓山區","左營區","楠梓區","三民區","新興區","前金區","苓雅區","前鎮區",
                    "旗津區","小港區","鳳山區","林園區","大寮區","大樹區","大社區","仁武區",
                    "鳥松區", "岡山區","橋頭區","燕巢區","田寮區","阿蓮區","路竹區","湖內區",
                    "茄萣區","永安區", "彌陀區","梓官區","旗山區","美濃區","六龜區","甲仙區",
                    "杉林區","內門區","茂林區", "桃源區","那瑪夏區"}
    };
    private Spinner sp1;
    private Spinner sp2;
    private Context context;
    ArrayAdapter<String> adapter1;
    ArrayAdapter<String> adapter2;

    public void setSeachView(SearchView search)
    {
        // 設置SearchView默認是否自動缩小為圖標
        search.setIconifiedByDefault(true);
        // 顯示搜尋按鈕
        search.setSubmitButtonEnabled(true);
        int id = search.getContext().getResources().getIdentifier("android:id/search", null, null);
        TextView textView = (TextView) findViewById(id);


        SpannableString spanText = new SpannableString("請輸 入需要查詢内容");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        context = this;

        Button BTN = (Button) findViewById(R.id.button7);
        BTN.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(search.this, activity_introduce_store.class);
                startActivity(intent);
            }
        });

        //程式剛啟動始時載入第一個下拉選單
        adapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,County);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp1 = (Spinner) findViewById(R.id.spinner);
        sp1.setAdapter(adapter1);
        sp1.setOnItemSelectedListener(selectListener);

        //因為下拉選單第一個為縣市，所以先載入縣市群組進第二個下拉選單
        adapter2 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,start);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp2 = (Spinner) findViewById(R.id.spinner2);
        sp2.setAdapter(adapter2);
    }

        //第一個下拉類別的監看式
        private OnItemSelectedListener selectListener = new OnItemSelectedListener(){
        public void onItemSelected(AdapterView<?> parent , View v , int position , long id){
            //讀取第一個下拉選單是選擇第幾個
            int pos = sp1.getSelectedItemPosition();
            //重新產生新的Adapter，用的是二維陣列district[pos]
            adapter2 = new ArrayAdapter<String>(context,android.R.layout.simple_spinner_item, district[pos]);
            //載入第二個下拉選單Spinner
            sp2.setAdapter(adapter2);
        }

        @Override
        public void onNothingSelected(AdapterView<?> arg0){

        }
    };
}

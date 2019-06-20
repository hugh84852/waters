package com.example.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.StringBuilderPrinter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class search_result2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result2);
    }
}

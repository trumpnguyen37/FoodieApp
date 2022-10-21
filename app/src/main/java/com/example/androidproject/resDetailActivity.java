package com.example.androidproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import java.util.ArrayList;

public class resDetailActivity extends AppCompatActivity {

    private RecyclerView recyclerView1,recyclerView2;

    Activity context;
    int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_res_detail);

        Intent intent = getIntent();
        pos = intent.getIntExtra("pos", 0);


    }
}
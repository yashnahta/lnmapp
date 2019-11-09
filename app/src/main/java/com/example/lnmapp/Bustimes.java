package com.example.lnmapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class Bustimes extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bustimes);

        ArrayList<ExampleItem> exampleList = new ArrayList<>();
        exampleList.add(new ExampleItem("MON - FRI"+"\n\n7:00 AM: Ajmeri Gate -> LNMIIT"));
        exampleList.add(new ExampleItem("MON - FRI"+"\n\n8:00 AM: Ajmeri Gate -> LNMIIT"));
        exampleList.add(new ExampleItem("SAT - SUN & HOLIDAYS"+"\n\n8:00 AM: Ajmeri Gate -> LNMIIT"));
        exampleList.add(new ExampleItem("SAT - SUN & HOLIDAYS"+"\n\n10:00 AM: LNMIIT -> Ajmeri Gate"));
        exampleList.add(new ExampleItem("MON - FRI"+"\n\n11:00 AM: LNMIIT -> Ajmeri Gate"));

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ExampleAdapter(exampleList);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

}
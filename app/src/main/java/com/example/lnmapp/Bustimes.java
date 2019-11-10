package com.example.lnmapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Bustimes extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference mDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bustimes);



        mDatabase = database.getReference().child("BUS TIMETABLE").child("MONDAY TO FRIDAY").child("11:001AM");
        mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String s=dataSnapshot.getValue(String.class);
                ArrayList<ExampleItem> exampleList = new ArrayList<>();
                String[] arrSplit;
                 arrSplit = s.split("-");

             //   exampleList.add(new ExampleItem("MON - FRI"+"\n\n7:00 AM: Ajmeri Gate -> LNMIIT"));
                for (int i=0; i < arrSplit.length; i++)
                {

                    exampleList.add(new ExampleItem(" MON - FRI"+"\n\n"+arrSplit[i]));
                  //  Toast.makeText(getApplicationContext(),arrSplit.length+"  1  "+arrSplit[i],Toast.LENGTH_SHORT).show();
                }
                mRecyclerView = findViewById(R.id.recyclerView);
                mRecyclerView.setHasFixedSize(true);
                mLayoutManager = new LinearLayoutManager(getApplicationContext());
                mAdapter = new ExampleAdapter(exampleList);
                mRecyclerView.setLayoutManager(mLayoutManager);
                mRecyclerView.setAdapter(mAdapter);
                // Toast.makeText(getActivity(), "yoo    " + dataSnapshot.getValue(String.class), Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        mDatabase = database.getReference().child("BUS TIMETABLE").child("SATURDAY,SUNDAY and HOLIDAYS").child("ssh");
        mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String s=dataSnapshot.getValue(String.class);
//                String[] arrSplit = s.split("-");
//                for (int i=0; i < arrSplit.length; i++)
//                {
//                    Toast.makeText(getApplicationContext(),arrSplit.length+"  1  "+arrSplit[i],Toast.LENGTH_SHORT).show();
//                }
//                //Toast.makeText(getActivity(), "yoo    " + dataSnapshot.getValue(String.class), Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

//
//        exampleList.add(new ExampleItem("MON - FRI"+"\n\n7:00 AM: Ajmeri Gate -> LNMIIT"));
//        exampleList.add(new ExampleItem("MON - FRI"+"\n\n8:00 AM: Ajmeri Gate -> LNMIIT"));
//        exampleList.add(new ExampleItem("SAT - SUN & HOLIDAYS"+"\n\n8:00 AM: Ajmeri Gate -> LNMIIT"));
//        exampleList.add(new ExampleItem("SAT - SUN & HOLIDAYS"+"\n\n10:00 AM: LNMIIT -> Ajmeri Gate"));
//        exampleList.add(new ExampleItem("MON - FRI"+"\n\n11:00 AM: LNMIIT -> Ajmeri Gate"));

//        mRecyclerView = findViewById(R.id.recyclerView);
//        mRecyclerView.setHasFixedSize(true);
//        mLayoutManager = new LinearLayoutManager(this);
//        mAdapter = new ExampleAdapter(exampleList);
//        mRecyclerView.setLayoutManager(mLayoutManager);
//        mRecyclerView.setAdapter(mAdapter);
    }

}
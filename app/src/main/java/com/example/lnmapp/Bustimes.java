package com.example.lnmapp;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.app.ActionBar;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Calendar;

public class Bustimes extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public ArrayList<ExampleItem> exampleList = new ArrayList<>();
    public String[] arrSplit;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference mDatabase;


    public boolean onOptionsItemSelected(MenuItem item){
//        Intent intent = new Intent(getApplicationContext(),HomeActivity.class );
//        startActivityForResult(intent,0);
        finish();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bustimes);
        this.setTitle("Bus Schedule");
//
        ActionBar actionBar = getActionBar();
       // actionBar.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final ProgressDialog dialog = ProgressDialog.show(this, "",
                "Loading. Please wait...", true);
        dialog.show();

        Runnable progressRunnable = new Runnable() {

            @Override
            public void run() {
                dialog.cancel();
            }
        };

        Handler pdCanceller = new Handler();
        pdCanceller.postDelayed(progressRunnable, 1000);


        mDatabase = database.getReference().child("BUS TIMETABLE").child("MONDAY TO FRIDAY").child("11:001AM");
        mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String s=dataSnapshot.getValue(String.class);

                arrSplit = s.split("-");

                //   exampleList.add(new ExampleItem("MON - FRI"+"\n\n7:00 AM: Ajmeri Gate -> LNMIIT"));
                for (int i=0; i < arrSplit.length; i++)
                {

                    exampleList.add(new ExampleItem(" MON - FRI"+"\n\n"+arrSplit[i]));
                    //  Toast.makeText(getApplicationContext(),arrSplit.length+"  1  "+arrSplit[i],Toast.LENGTH_SHORT).show();
                }

                // Toast.makeText(getActivity(), "yoo      " + dataSnapshot.getValue(String.class), Toast.LENGTH_SHORT).show();
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
                String[] arrSplit = s.split("-");


                for (int i=0; i < arrSplit.length; i++)
                {
                    exampleList.add(new ExampleItem("SAT - SUN"+"\n\n"+arrSplit[i]));
                }
                mRecyclerView = findViewById(R.id.recyclerView);
                mRecyclerView.setHasFixedSize(true);
                mLayoutManager = new LinearLayoutManager(getApplicationContext());
                mAdapter = new ExampleAdapter(exampleList);
                mRecyclerView.setLayoutManager(mLayoutManager);
                mRecyclerView.setAdapter(mAdapter);
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
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void swii(View view){

        Switch sw3 =  view.findViewById(R.id.switch11);
        if(sw3.isChecked()==true){
            //    Toast.makeText(getActivity(),"hello",Toast.LENGTH_SHORT).show();;
            AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

            Intent notificationIntent = new Intent(this, AlarmReceiver2.class);
            PendingIntent broadcast = PendingIntent.getBroadcast(this, 100, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.SECOND,0);
            alarmManager.setExact(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), broadcast);

        }
    }

}
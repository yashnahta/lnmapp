package com.example.lnmapp;


import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;

import static com.firebase.ui.auth.AuthUI.getApplicationContext;

public class FeedFragment extends Fragment {

    View view;

    Switch swq;
    Switch swq2;
    Switch swq3;
    Switch swq4;
    Switch swq5;
    Switch swq6;
    Switch swq7;
    Switch swq8;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    String[] arrSplit;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference mDatabase;
    public FeedFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_feed, container, false);
        getActivity().setTitle("Feed");
        final ProgressDialog dialog = ProgressDialog.show(getContext(), "",
                "Loading. Please wait...", true);
        dialog.show();

        Runnable progressRunnable = new Runnable() {

            @Override
            public void run() {
                dialog.cancel();
            }
        };

        Handler pdCanceller = new Handler();

        pdCanceller.postDelayed(progressRunnable, 2000);

        mDatabase = database.getReference().child("FEED").child("feeds");
        mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String s = dataSnapshot.getValue(String.class);
                arrSplit = s.split("--");

                TextView textView ;
                textView = view.findViewById(R.id.t1);
                textView.setText(arrSplit[0]);
                textView2 = view.findViewById(R.id.t2);
                textView2.setText(arrSplit[1]);

                textView3 = view.findViewById(R.id.t3);
                textView3.setText(arrSplit[2]);

                textView4 = view.findViewById(R.id.t4);
                textView4.setText(arrSplit[3]);

                textView = view.findViewById(R.id.t5);
                textView.setText(arrSplit[4]);

                textView = view.findViewById(R.id.t6);
                textView.setText(arrSplit[5]);

                textView = view.findViewById(R.id.t7);
                textView.setText(arrSplit[6]);

                textView = view.findViewById(R.id.t8);
                textView.setText(arrSplit[7]);
                // Toast.makeText(getActivity(),arrSplit.length+"  1  "+arrSplit[i],Toast.LENGTH_SHORT).show();

                textView = view.findViewById(R.id.t8);
                textView.setText(arrSplit[8]);
                textView = view.findViewById(R.id.t9);
                textView.setText(arrSplit[10]);
                textView = view.findViewById(R.id.t10);
                textView.setText(arrSplit[9]);
                textView = view.findViewById(R.id.t11);
                textView.setText(arrSplit[12]);
                textView = view.findViewById(R.id.t12);
                textView.setText(arrSplit[11]);
                textView = view.findViewById(R.id.t13);
                textView.setText(arrSplit[14]);
                textView = view.findViewById(R.id.t14);
                textView.setText(arrSplit[13]);
                textView = view.findViewById(R.id.t15);
                textView.setText(arrSplit[0]);
                textView = view.findViewById(R.id.t16);
                textView.setText(arrSplit[1]);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

         swq= view.findViewById(R.id.feed_1);
        swq.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View view) {
                if(swq.isChecked()) {
                    AlarmManager alarmManager = (AlarmManager) getActivity().getSystemService(Context.ALARM_SERVICE);

                    Intent notificationIntent = new Intent(getActivity(), AlarmReceiver3.class);
                    PendingIntent broadcast = PendingIntent.getBroadcast(getActivity(), 100, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

                    Calendar cal = Calendar.getInstance();
                    cal.add(Calendar.SECOND, 0);
                    alarmManager.setExact(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), broadcast);

                }            }
        });

        swq2= view.findViewById(R.id.feed_2);
        swq2.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View view) {
                if(swq2.isChecked()==true) {
                    AlarmManager alarmManager = (AlarmManager) getActivity().getSystemService(Context.ALARM_SERVICE);

                    Intent notificationIntent = new Intent(getActivity(), AlarmReceiver3.class);
                    PendingIntent broadcast = PendingIntent.getBroadcast(getActivity(), 100, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

                    Calendar cal = Calendar.getInstance();
                    cal.add(Calendar.SECOND, 0);
                    alarmManager.setExact(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), broadcast);

                }            }
        });
        swq3= view.findViewById(R.id.feed_3);
        swq3.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View view) {
                if(swq3.isChecked()==true) {
                    AlarmManager alarmManager = (AlarmManager) getActivity().getSystemService(Context.ALARM_SERVICE);

                    Intent notificationIntent = new Intent(getActivity(), AlarmReceiver3.class);
                    PendingIntent broadcast = PendingIntent.getBroadcast(getActivity(), 100, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

                    Calendar cal = Calendar.getInstance();
                    cal.add(Calendar.SECOND, 0);
                    alarmManager.setExact(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), broadcast);

                }            }
        });
        swq4= view.findViewById(R.id.feed_4);
        swq4.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View view) {
                if(swq4.isChecked()==true) {
                    AlarmManager alarmManager = (AlarmManager) getActivity().getSystemService(Context.ALARM_SERVICE);

                    Intent notificationIntent = new Intent(getActivity(), AlarmReceiver3.class);
                    PendingIntent broadcast = PendingIntent.getBroadcast(getActivity(), 100, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

                    Calendar cal = Calendar.getInstance();
                    cal.add(Calendar.SECOND, 0);
                    alarmManager.setExact(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), broadcast);

                }            }
        });
        swq5= view.findViewById(R.id.feed_5);
        swq5.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View view) {
                if(swq5.isChecked()==true) {
                    AlarmManager alarmManager = (AlarmManager) getActivity().getSystemService(Context.ALARM_SERVICE);

                    Intent notificationIntent = new Intent(getActivity(), AlarmReceiver3.class);
                    PendingIntent broadcast = PendingIntent.getBroadcast(getActivity(), 100, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

                    Calendar cal = Calendar.getInstance();
                    cal.add(Calendar.SECOND, 0);
                    alarmManager.setExact(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), broadcast);

                }            }
        });

        swq6= view.findViewById(R.id.feed_6);
        swq6.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View view) {
                if(swq6.isChecked()==true) {
                    AlarmManager alarmManager = (AlarmManager) getActivity().getSystemService(Context.ALARM_SERVICE);

                    Intent notificationIntent = new Intent(getActivity(), AlarmReceiver3.class);
                    PendingIntent broadcast = PendingIntent.getBroadcast(getActivity(), 100, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

                    Calendar cal = Calendar.getInstance();
                    cal.add(Calendar.SECOND, 0);
                    alarmManager.setExact(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), broadcast);

                }            }
        });
        swq7= view.findViewById(R.id.feed_7);
        swq7.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View view) {
                if(swq7.isChecked()==true) {
                    AlarmManager alarmManager = (AlarmManager) getActivity().getSystemService(Context.ALARM_SERVICE);

                    Intent notificationIntent = new Intent(getActivity(), AlarmReceiver3.class);
                    PendingIntent broadcast = PendingIntent.getBroadcast(getActivity(), 100, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

                    Calendar cal = Calendar.getInstance();
                    cal.add(Calendar.SECOND, 0);
                    alarmManager.setExact(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), broadcast);

                }            }
        });
        swq8= view.findViewById(R.id.feed_8);
        swq8.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View view) {
                if(swq8.isChecked()==true) {
                    AlarmManager alarmManager = (AlarmManager) getActivity().getSystemService(Context.ALARM_SERVICE);

                    Intent notificationIntent = new Intent(getActivity(), AlarmReceiver3.class);
                    PendingIntent broadcast = PendingIntent.getBroadcast(getActivity(), 100, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

                    Calendar cal = Calendar.getInstance();
                    cal.add(Calendar.SECOND, 0);
                    alarmManager.setExact(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), broadcast);

                }            }
        });
        view.setFocusableInTouchMode(true);
        view.requestFocus();
        view.setOnKeyListener( new View.OnKeyListener()
        {
            @Override
            public boolean onKey( View v, int keyCode, KeyEvent event )
            {
                if( keyCode == KeyEvent.KEYCODE_BACK )
                {
                    getActivity().moveTaskToBack(true);
                    getActivity().finish();

                    return true;
                }
                return false;
            }
        } );
        return view;
    }

}
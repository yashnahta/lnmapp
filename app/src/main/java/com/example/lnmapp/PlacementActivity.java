package com.example.lnmapp;


import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;


/**
 * A simple {@link Fragment} subclass.
 */
public class PlacementActivity extends Fragment {

    private TextView textView;

    public PlacementActivity() {
        // Required empty public constructor
    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getActivity().setTitle("Placement Activities");
         View v = inflater.inflate(R.layout.fragment_placement, container, false);

        textView = v.findViewById(R.id.company1);
        textView.setText("COMPANY: Samsung");

        textView = v.findViewById(R.id.event1);
        textView.setText("EVENT: Pre-Placement Talk ");

        textView = v.findViewById(R.id.venue1);
        textView.setText("VENUE: LT-05");

        textView = v.findViewById(R.id.date1);
        textView.setText("DATE AND TIME: 28th Aug, 5 PM");

        textView = v.findViewById(R.id.dress1);
        textView.setText("DRESS CODE: Formals");

        textView = v.findViewById(R.id.company2);
        textView.setText("COMPANY: Amazon");

        textView = v.findViewById(R.id.event2);
        textView.setText("EVENT: Technical Round ");

        textView = v.findViewById(R.id.venue2);
        textView.setText("VENUE: CP-1");

        textView = v.findViewById(R.id.date2);
        textView.setText("DATE AND TIME: 5th Sept, 7 PM");

        textView = v.findViewById(R.id.dress2);
        textView.setText("DRESS CODE: Smart Casuals");

        textView = v.findViewById(R.id.company3);
        textView.setText("COMPANY: Addverb Technologies");

        textView = v.findViewById(R.id.event3);
        textView.setText("EVENT: Technical Round ");

        textView = v.findViewById(R.id.venue3);
        textView.setText("VENUE: CP-2");

        textView = v.findViewById(R.id.date3);
        textView.setText("DATE AND TIME: 15th Sept, 6 PM");

        textView = v.findViewById(R.id.dress3);
        textView.setText("DRESS CODE: Smart Casuals");

        Switch sw =  v.findViewById(R.id.switch1);

        sw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Switch sw =  view.findViewById(R.id.switch1);
                if(sw.isChecked()==true){
                //    Toast.makeText(getActivity(),"hello",Toast.LENGTH_SHORT).show();;
                    AlarmManager alarmManager = (AlarmManager) getActivity().getSystemService(Context.ALARM_SERVICE);

                    Intent notificationIntent = new Intent(getActivity(), AlarmReceiver.class);
                    PendingIntent broadcast = PendingIntent.getBroadcast(getActivity(), 100, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

                    Calendar cal = Calendar.getInstance();
                    cal.add(Calendar.SECOND, 0);
                    alarmManager.setExact(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), broadcast);
                }
            }
        });
        Switch sw1 =  v.findViewById(R.id.switch2);

        sw1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Switch sw =  view.findViewById(R.id.switch2);
                 if(sw.isChecked()==true){
                //    Toast.makeText(getActivity(),"hello",Toast.LENGTH_SHORT).show();;
                AlarmManager alarmManager = (AlarmManager) getActivity().getSystemService(Context.ALARM_SERVICE);

                Intent notificationIntent = new Intent(getActivity(), AlarmReceiver.class);
                PendingIntent broadcast = PendingIntent.getBroadcast(getActivity(), 100, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

                Calendar cal = Calendar.getInstance();
                cal.add(Calendar.SECOND, 0);
                alarmManager.setExact(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), broadcast);
                 }
            }
        });
        Switch sw3 =  v.findViewById(R.id.switch3);

        sw3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Switch sw3 =  view.findViewById(R.id.switch3);
                 if(sw3.isChecked()==true){
                //    Toast.makeText(getActivity(),"hello",Toast.LENGTH_SHORT).show();;
                AlarmManager alarmManager = (AlarmManager) getActivity().getSystemService(Context.ALARM_SERVICE);

                Intent notificationIntent = new Intent(getActivity(), AlarmReceiver.class);
                PendingIntent broadcast = PendingIntent.getBroadcast(getActivity(), 100, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

                Calendar cal = Calendar.getInstance();
                cal.add(Calendar.SECOND, 0);
                alarmManager.setExact(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), broadcast);
                 }
            }
        });
        v.setFocusableInTouchMode(true);
        v.requestFocus();
        v.setOnKeyListener( new View.OnKeyListener()
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
        return v;

    }
//    public void swi(View view){
//
//    }


}

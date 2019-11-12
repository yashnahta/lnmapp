package com.example.lnmapp;


import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import sun.bob.mcalendarview.MCalendarView;
import sun.bob.mcalendarview.MarkStyle;
import sun.bob.mcalendarview.listeners.OnDateClickListener;
import sun.bob.mcalendarview.vo.DateData;


public class CalenderFrag extends Fragment {

    //private CalendarView calendarView;
    private MCalendarView calendarView;

    public CalenderFrag() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_calender, container, false);

        getActivity().setTitle("Institute Calendar");

        calendarView = (MCalendarView) v.findViewById(R.id.calendar);

        ArrayList<DateData> dates = new ArrayList<>();
        dates.add(new DateData(2019,9,14));
        dates.add(new DateData(2019,11,27));

        for(int i=0;i<dates.size();i++){
            calendarView.markDate(dates.get(i).getYear(),dates.get(i).getMonth(),dates.get(i).getDay());
        }


        calendarView.setOnDateClickListener(new OnDateClickListener() {
            @Override
            public void onDateClick(View view, final DateData date) {

                if(date.getDay()== 14 && date.getMonth() == 9){
                    Toast.makeText(getActivity(), "LNMIIT Foundation Day", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getActivity(), "No Event Today", Toast.LENGTH_SHORT).show();
                    // calendarView.markDate(date);
                }

            }
        });


        //        getActivity().setTitle("Institute Calendar");
//        calendarView = (CalendarView) v.findViewById(R.id.calendarView);
//
//        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
//            @TargetApi(Build.VERSION_CODES.M)
//            @Override
//            public void onSelectedDayChange(CalendarView calendarView, int i, int i1, int i2) {
//                i1=i1+1;
//                if (i1 == 10 && i2 == 30) {
//                    Toast.makeText(getActivity(), "LNMIIT Foundation Day", Toast.LENGTH_SHORT).show();
//                } else {
//                    Toast.makeText(getActivity(), "No Event Today", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });

        return v;
    }
}




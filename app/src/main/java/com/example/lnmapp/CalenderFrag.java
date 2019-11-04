package com.example.lnmapp;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.Toast;


public class CalenderFrag extends Fragment {

    private CalendarView calendarView;

    public CalenderFrag() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_calender, container, false);

        calendarView = (CalendarView) v.findViewById(R.id.calendarView);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView calendarView, int i, int i1, int i2) {
                i1=i1+1;
                if (i1 == 10 && i2 == 30) {
                    Toast.makeText(getContext(), "LNMIIT Foundation Day", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), "No Event Today", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return v;
    }
}




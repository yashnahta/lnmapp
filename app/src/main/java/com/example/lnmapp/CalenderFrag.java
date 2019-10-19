package com.example.lnmapp;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.github.sundeepk.compactcalendarview.CompactCalendarView;
import com.github.sundeepk.compactcalendarview.domain.Event;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static com.firebase.ui.auth.AuthUI.getApplicationContext;



public class CalenderFrag extends Fragment {

     CompactCalendarView compactCalendar;
    private SimpleDateFormat dateFormatMonth = new SimpleDateFormat("MMMM -yyyy", Locale.getDefault());

    public CalenderFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view1= inflater.inflate(R.layout.fragment_calender, container, false);
        // Inflate the layout for this fragment

//        final ActionBar actionBar =((AppCompatActivity)getActivity()).getSupportActionBar();
//        actionBar.setDisplayHomeAsUpEnabled(false);
//        actionBar.setTitle(null);

        compactCalendar = (CompactCalendarView) view1.findViewById(R.id.compactcalendar_view);
//        compactCalendar.setUseThreeLetterAbbreviation(true);
//        Event ev1 = new Event(Color.RED, 1477054800000L,"LNMIIT Foundation Day");
//        compactCalendar.addEvent(ev1);

        compactCalendar.setListener(new CompactCalendarView.CompactCalendarViewListener() {
            @Override
            public void onDayClick(Date dateClicked) {
                Toast.makeText(getActivity(),"LNMIIT Foundation Day", Toast.LENGTH_SHORT).show();
                if(dateClicked.toString().compareTo("Fri Oct 21 09:00:00 AST 2016") == 0) {
                    Toast.makeText(getActivity(),"LNMIIT Foundation Day", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getActivity(),"No events on this day!", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onMonthScroll(Date firstDayOfNewMonth) {
                Toast.makeText(getActivity(),"LNMIIT Foundation Day", Toast.LENGTH_SHORT).show();
                //actionBar.setTitle(dateFormatMonth.format(firstDayOfNewMonth));
            }
        });
        return inflater.inflate(R.layout.fragment_calender, container, false);

    }

    public void dates(View view) {

    }
}

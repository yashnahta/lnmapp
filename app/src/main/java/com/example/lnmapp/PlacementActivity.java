package com.example.lnmapp;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class PlacementActivity extends Fragment {

    private TextView textView;

    public PlacementActivity() {
        // Required empty public constructor
    }


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

        return v;

    }

}

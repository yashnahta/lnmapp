package com.example.lnmapp;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



public class MessFrag extends Fragment {

    private TextView textView;
    private CardView cardView;
    public MessFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_mess, container, false);


        textView = view.findViewById(R.id.txt_display_b);
        textView.setText(getArguments().getString("message_b"));

        textView = view.findViewById(R.id.txt_display_l);
        textView.setText(getArguments().getString("message_l"));

        textView = view.findViewById(R.id.txt_display_s);
        textView.setText(getArguments().getString("message_s"));

        textView = view.findViewById(R.id.txt_display_d);
        textView.setText(getArguments().getString("message_d"));

        return view;
    }

}
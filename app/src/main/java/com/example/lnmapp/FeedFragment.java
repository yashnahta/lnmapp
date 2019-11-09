package com.example.lnmapp;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FeedFragment extends Fragment {

    private TextView textView;

    public FeedFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_feed, container, false);


        textView = view.findViewById(R.id.txt1_1);
        textView.setText("lorem ipsum");

        textView = view.findViewById(R.id.txt1_2);
        textView.setText("lorem ipsum");

        textView = view.findViewById(R.id.txt2_1);
        textView.setText("lorem ipsum");

        textView = view.findViewById(R.id.txt2_2);
        textView.setText("lorem ipsum");

        textView = view.findViewById(R.id.txt3_1);
        textView.setText("lorem ipsum");

        textView = view.findViewById(R.id.txt3_2);
        textView.setText("lorem ipsum");

        textView = view.findViewById(R.id.txt4_1);
        textView.setText("lorem ipsum");

        textView = view.findViewById(R.id.txt4_2);
        textView.setText("lorem ipsum");


        return inflater.inflate(R.layout.fragment_feed, container, false);
    }

}
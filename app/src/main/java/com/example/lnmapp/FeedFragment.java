package com.example.lnmapp;


import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FeedFragment extends Fragment {


    private TextView textView2;
    private TextView textView3;
    private TextView textView4;

    public FeedFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getActivity().setTitle("Feed");
        View view = inflater.inflate(R.layout.fragment_feed, container, false);

        String str = "dwekn.kcmlamsmwldn";

        TextView textView ;
        textView = view.findViewById(R.id.t1);
        textView.setText("parth");

        textView2 = view.findViewById(R.id.t2);
        textView2.setText("lahbfecnw");

        textView3 = view.findViewById(R.id.t3);
        textView3.setText("wjdbec");

        textView4 = view.findViewById(R.id.t4);
        textView4.setText(str);

        textView = view.findViewById(R.id.t5);
        textView.setText("parth");

        textView = view.findViewById(R.id.t6);
        textView.setText("lahbfecnw");

        textView = view.findViewById(R.id.t7);
        textView.setText("wjdbec");

        textView = view.findViewById(R.id.t8);
        textView.setText("swdefcndj");


        return view;
    }

}
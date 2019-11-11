package com.example.lnmapp;


import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static com.firebase.ui.auth.AuthUI.getApplicationContext;

public class FeedFragment extends Fragment {

View view;
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

        String str = "dwekn.kcmlamsmwldn";

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


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
//        for (int i=0; i < arrSplit.length; i++)
//        {
//            Toast.makeText(getActivity(),arrSplit.length+"  1  "+arrSplit[i],Toast.LENGTH_SHORT).show();
//        }

//        TextView textView ;
//        textView = view.findViewById(R.id.t1);
//        textView.setText(arrSplit[0]);
//
//        textView2 = view.findViewById(R.id.t2);
//        textView2.setText(arrSplit[1]);
//
//        textView3 = view.findViewById(R.id.t3);
//        textView3.setText(arrSplit[2]);
//
//        textView4 = view.findViewById(R.id.t4);
//        textView4.setText(arrSplit[3]);
//
//        textView = view.findViewById(R.id.t5);
//        textView.setText(arrSplit[4]);
//
//        textView = view.findViewById(R.id.t6);
//        textView.setText(arrSplit[5]);
//
//        textView = view.findViewById(R.id.t7);
//        textView.setText(arrSplit[6]);
//
//        textView = view.findViewById(R.id.t8);
//        textView.setText(arrSplit[7]);


        return view;
    }

}
package com.example.lnmapp;


import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


/**
 * A simple {@link Fragment} subclass.
 */
public class BusTime extends Fragment {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference mDatabase;
    public BusTime() {
        // Required empty public constructor
        //asdasdasf
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment



//        yaha se
//
//



        View view= inflater.inflate(R.layout.fragment_y17_cse, container, false);


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

        mDatabase = database.getReference().child("BUS TIMETABLE").child("MONDAY TO FRIDAY").child("11:001AM");
        mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String s=dataSnapshot.getValue(String.class);
                String[] arrSplit = s.split("-");
                for (int i=0; i < arrSplit.length; i++)
                {
                    Toast.makeText(getActivity(),arrSplit.length+"  1  "+arrSplit[i],Toast.LENGTH_SHORT).show();
                }
               // Toast.makeText(getActivity(), "yoo    " + dataSnapshot.getValue(String.class), Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        mDatabase = database.getReference().child("BUS TIMETABLE").child("SATURDAY,SUNDAY and HOLIDAYS").child("ssh");
        mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String s=dataSnapshot.getValue(String.class);
                String[] arrSplit = s.split("-");
                for (int i=0; i < arrSplit.length; i++)
                {
                    Toast.makeText(getActivity(),arrSplit.length+"  1  "+arrSplit[i],Toast.LENGTH_SHORT).show();
                }
                //Toast.makeText(getActivity(), "yoo    " + dataSnapshot.getValue(String.class), Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


//
//yaha tak

        return inflater.inflate(R.layout.fragment_bus_time, container, false);
    }

}

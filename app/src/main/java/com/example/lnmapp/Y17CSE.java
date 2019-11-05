package com.example.lnmapp;


import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


/**
 * A simple {@link Fragment} subclass.
 */
public class Y17CSE extends Fragment {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference mDatabase;
// ...

    public Y17CSE() {
        // Required empty public constructor
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
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





       // dialog.dismiss();
        final TextView m1=view.findViewById(R.id.txt_display_m1);
        final TextView m2=view.findViewById(R.id.txt_display_m2);
        final TextView m3=view.findViewById(R.id.txt_display_m3);
        final TextView m4=view.findViewById(R.id.txt_display_m4);
        final TextView t1=view.findViewById(R.id.txt_display_t1);
        final TextView t2=view.findViewById(R.id.txt_display_t2);
        final TextView w1=view.findViewById(R.id.txt_display_w1);
        final TextView w2=view.findViewById(R.id.txt_display_w2);
        final TextView w3=view.findViewById(R.id.txt_display_w3);
        final TextView w4=view.findViewById(R.id.txt_display_w4);
        final TextView th1=view.findViewById(R.id.txt_display_th1);
        final TextView th2=view.findViewById(R.id.txt_display_th2);
        final TextView f1=view.findViewById(R.id.txt_display_f1);
        final TextView f2=view.findViewById(R.id.txt_display_f2);
        final TextView f3=view.findViewById(R.id.txt_display_f3);
        final TextView f4=view.findViewById(R.id.txt_display_f4);

        final String[] day = new String[10];
        day[0]="MONDAY";
        day[1]="TUESDAY";
        day[2]="WEDNESDAY";
        day[3]="THURSDAY";
        day[4]="FRIDAY";
        for(int k=0;k<5;k++){
            final int l=k;
            if(day[k]=="TUESDAY" || day[k]=="THURSDAY"){
                    mDatabase = database.getReference().child("CLASS TIMETABLE").child("Y17").child("CSE").child(day[k]).child("02:30PM-04:00PM");
                    mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            if(day[l]=="TUESDAY"){
                                t1.setText("02:30PM-04:00PM : "+dataSnapshot.getValue(String.class));

                            }
                            else{
                                th1.setText("02:30PM-04:00PM : "+dataSnapshot.getValue(String.class));
                            }
                            //Toast.makeText(getActivity(), "yoo    " + dataSnapshot.getValue(String.class), Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                mDatabase = database.getReference().child("CLASS TIMETABLE").child("Y17").child("CSE").child(day[k]).child("04:00PM-05:30PM");
                mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        if(day[l]=="TUESDAY"){
                            t2.setText("04:00PM-05:30PM : "+dataSnapshot.getValue(String.class));

                        }
                        else{
                            th2.setText("04:00PM-05:30PM : "+dataSnapshot.getValue(String.class));
                        }
                        //Toast.makeText(getActivity(), "yoo    " + dataSnapshot.getValue(String.class), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
            else {
                for (int i = 1; i <= 5; i++) {
                    final int ii=i;
                    mDatabase = database.getReference().child("CLASS TIMETABLE").child("Y17").child("CSE").child(day[k]).child("0" + i + ":00PM-0" + (i + 1) + ":00PM");
                    mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if (dataSnapshot.getValue(String.class) == "BREAK"){
                                //do nothing
                            }
                                else{
                               // Toast.makeText(getActivity(), "yoo    " + dataSnapshot.getValue(String.class), Toast.LENGTH_SHORT).show();
                            if(day[l]=="MONDAY"){
                                if(ii==1)
                                    m1.setText("0" + ii + ":00PM-0:" + (ii + 1) + ":00PM : "+dataSnapshot.getValue(String.class));
                                else if(ii==2){
                                    m2.setText("0" + ii + ":00PM-0:" + (ii + 1) + ":00PM : "+dataSnapshot.getValue(String.class));
                                }
                                else if(ii==3){
                                    m3.setText("0" + ii + ":00PM-0:" + (ii + 1) + ":00PM : "+dataSnapshot.getValue(String.class));
                                }
                                else if(ii==4){
                                    m4.setText("0" + ii + ":00PM-0:" + (ii + 1) + ":00PM : "+dataSnapshot.getValue(String.class));
                                }
                            }
                                if(day[l]=="WEDNESDAY"){
                                    if(ii==1)
                                        w1.setText("0" + ii + ":00PM-0:" + (ii + 1) + ":00PM : "+dataSnapshot.getValue(String.class));
                                    else if(ii==2){
                                        w2.setText("0" + ii + ":00PM-0:" + (ii + 1) + ":00PM : "+dataSnapshot.getValue(String.class));
                                    }
                                    else if(ii==3){
                                        w3.setText("0" + ii + ":00PM-0:" + (ii + 1) + ":00PM : "+dataSnapshot.getValue(String.class));
                                    }
                                    else if(ii==5){
                                        w4.setText("0" + ii + ":00PM-0:" + (ii + 1) + ":00PM : "+dataSnapshot.getValue(String.class));
                                    }
                                }
                                if(day[l]=="FRIDAY"){
                                    if(ii==1)
                                        f1.setText("0" + ii + ":00PM-0:" + (ii + 1) + ":00PM : "+dataSnapshot.getValue(String.class));
                                    else if(ii==2){
                                        f2.setText("0" + ii + ":00PM-0:" + (ii + 1) + ":00PM : "+dataSnapshot.getValue(String.class));
                                    }
                                    else if(ii==4){
                                        f3.setText("0" + ii + ":00PM-0:" + (ii + 1) + ":00PM : "+dataSnapshot.getValue(String.class));
                                    }
                                    else if(ii==5){
                                        f4.setText("0" + ii + ":00PM-0:" + (ii + 1) + ":00PM : "+dataSnapshot.getValue(String.class));
                                    }
                                }

                                }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }
            }
        }


        return view;
    }

}


//package com.example.lnmapp;
//
//
//        import android.app.ProgressDialog;
//        import android.os.Bundle;
//
//        import androidx.annotation.NonNull;
//        import androidx.fragment.app.Fragment;
//
//        import android.os.Handler;
//        import android.view.LayoutInflater;
//        import android.view.View;
//        import android.view.ViewGroup;
//        import android.widget.Toast;
//
//        import com.google.firebase.database.DataSnapshot;
//        import com.google.firebase.database.DatabaseError;
//        import com.google.firebase.database.DatabaseReference;
//        import com.google.firebase.database.FirebaseDatabase;
//        import com.google.firebase.database.ValueEventListener;
//
//
///**
// * A simple {@link Fragment} subclass.
// */
//public class BusTime extends Fragment {
//
//    FirebaseDatabase database = FirebaseDatabase.getInstance();
//    private DatabaseReference mDatabase;
//    public BusTime() {
//        // Required empty public constructor
//    }
//
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//
//
//
////        yaha se
////
////
//
//
//
//        View view= inflater.inflate(R.layout.fragment_y17_cse, container, false);
//
//
//        final ProgressDialog dialog = ProgressDialog.show(getContext(), "",
//                "Loading. Please wait...", true);
//        dialog.show();
//
//        Runnable progressRunnable = new Runnable() {
//
//            @Override
//            public void run() {
//                dialog.cancel();
//            }
//        };
//
//        Handler pdCanceller = new Handler();
//        pdCanceller.postDelayed(progressRunnable, 2000);
//
//        mDatabase = database.getReference().child("BUS TIMETABLE").child("MONDAY TO FRIDAY").child("11:001AM");
//        mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                String s=dataSnapshot.getValue(String.class);
//                String[] arrSplit = s.split("-");
//                for (int i=0; i < arrSplit.length; i++)
//                {
//                    Toast.makeText(getActivity(),arrSplit.length+"  1  "+arrSplit[i],Toast.LENGTH_SHORT).show();
//                }
//                // Toast.makeText(getActivity(), "yoo    " + dataSnapshot.getValue(String.class), Toast.LENGTH_SHORT).show();
//            }
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
//
//        mDatabase = database.getReference().child("BUS TIMETABLE").child("SATURDAY,SUNDAY and HOLIDAYS").child("ssh");
//        mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                String s=dataSnapshot.getValue(String.class);
//                String[] arrSplit = s.split("-");
//                for (int i=0; i < arrSplit.length; i++)
//                {
//                    Toast.makeText(getActivity(),arrSplit.length+"  1  "+arrSplit[i],Toast.LENGTH_SHORT).show();
//                }
//                //Toast.makeText(getActivity(), "yoo    " + dataSnapshot.getValue(String.class), Toast.LENGTH_SHORT).show();
//            }
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
//
//
////
////yaha tak
//
//        return inflater.inflate(R.layout.fragment_bus_time, container, false);
//    }
//
//}

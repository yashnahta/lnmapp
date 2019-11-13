package com.example.lnmapp;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Complaint extends Fragment {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference mDatabase;

    private FirebaseAuth mAuth=FirebaseAuth.getInstance();
    EditText subject;
    EditText send;
    public Complaint() {
        // Required empty public constructor
    }

Button dial;
    Button dial2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_complaint, container, false);
        // Inflate the layout for this fragment
        getActivity().setTitle("Make Complaints");
        subject=view.findViewById(R.id.subject11);
        send=view.findViewById(R.id.comp1);
        dial = view.findViewById(R.id.dial);
        dial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri u = Uri.parse("tel:9680850226");
                Intent intent = new Intent(Intent.ACTION_DIAL,u);

                startActivity(intent);
            }
        });

        dial2 = view.findViewById(R.id.dial2);
        dial2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri u = Uri.parse("tel:9680850226");
                Intent intent = new Intent(Intent.ACTION_DIAL,u);

                startActivity(intent);
            }
        });
        Button b=view.findViewById(R.id.buttonSend);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String s=subject.getText().toString();
                String c=send.getText().toString();

              //  if(subject!=null && send!=null) {
                    if (mAuth.getCurrentUser() != null) {
                        FirebaseDatabase.getInstance().getReference().child("Complaints").child(mAuth.getCurrentUser().getUid()).child("Email").setValue(mAuth.getCurrentUser().getEmail());
                        FirebaseDatabase.getInstance().getReference().child("Complaints").child(mAuth.getCurrentUser().getUid()).child(s).setValue(c);
                        Toast.makeText(getContext(), "Complaint Sent", Toast.LENGTH_SHORT).show();
                    }
                //}
                else
                {
                    Toast.makeText(getContext(), "Please Login", Toast.LENGTH_SHORT).show();
                }
            }
        });

        view.setFocusableInTouchMode(true);
        view.requestFocus();
        view.setOnKeyListener( new View.OnKeyListener()
        {
            @Override
            public boolean onKey( View v, int keyCode, KeyEvent event )
            {
                if( keyCode == KeyEvent.KEYCODE_BACK )
                {
                    getActivity().moveTaskToBack(true);
                    getActivity().finish();

                    return true;
                }
                return false;
            }
        } );

        return view;
    }

}

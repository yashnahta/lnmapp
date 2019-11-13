package com.example.lnmapp;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import static com.firebase.ui.auth.AuthUI.getApplicationContext;


/**
 * A simple {@link Fragment} subclass.
 */
public class Settings extends Fragment {

    private FirebaseAuth mAuth=FirebaseAuth.getInstance();

    public Settings() {
        // Required empty=- public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getActivity().setTitle("Log Out");
        mAuth.signOut();

        Toast.makeText(getActivity(),"Successfully Signed out",Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(getActivity(),MainActivity.class);
        startActivity(intent);

        return inflater.inflate(R.layout.fragment_settings, container, false);

    }


}

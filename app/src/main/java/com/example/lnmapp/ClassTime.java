package com.example.lnmapp;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.Objects;

import static com.firebase.ui.auth.AuthUI.getApplicationContext;
import static java.util.Objects.*;

public class ClassTime extends Fragment {

    Spinner spinner;
    Y17CSE y17CSE;
    Y17ECE y17ECE;
    Y17ME y17ME;
    Y18CSE y18CSE;
    Y18ECE y18ECE;
    Y18ME y18ME;
    Y19CSE y19CSE;
    Y19ECE y19ECE;
    Y19ME y19ME;
     View view;
    public ClassTime() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         ListView lvHomePage;
        y17CSE = new Y17CSE();
        y17ECE = new Y17ECE();
        y17ME= new Y17ME();
        y18CSE = new Y18CSE();
        y18ECE = new Y18ECE();
        y18ME= new Y18ME();
        y19CSE = new Y19CSE();
        y19ECE = new Y19ECE();
        y19ME= new Y19ME();
         String[] items;

        getActivity().setTitle("Class Schedule");
        items=getActivity().getResources().getStringArray(R.array.fragmnents);

       view= inflater.inflate(R.layout.fragment_class_time, container, false);
        spinner=view.findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity().getApplicationContext(),
              R.layout.custom_spinner,
                items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch(i){
                    case 0:
                        setFragment(y17CSE);
                        break;
                    case 1:
                        setFragment(y17ECE);
                        break;
                    case 2:
                        setFragment(y17ME);
                        break;
                    case 3:
                        setFragment(y18CSE);
                    case 4:
                        setFragment(y18ECE);
                        break;
                    case 5:
                        setFragment(y18ME);
                        break;
                    case 6:
                        setFragment(y19CSE);
                    case 7:
                        setFragment(y19ECE);
                        break;
                    case 8:
                        setFragment(y19ME);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

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

    public void setFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame, fragment);
        fragmentTransaction.commit();
    }

}

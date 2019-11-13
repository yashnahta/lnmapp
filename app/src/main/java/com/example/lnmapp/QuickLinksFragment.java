package com.example.lnmapp;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import static com.firebase.ui.auth.AuthUI.getApplicationContext;


/**
 * A simple {@link Fragment} subclass.
 */
public class QuickLinksFragment extends Fragment {

    String[] urls = new String[12];

    public QuickLinksFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_quick_links, container, false);

        urls[0] = "https://www.lnmiit.ac.in";
        urls[1] = "https://placements.lnmiit.ac.in/";
        urls[2] = "https://erp.lnmiit.ac.in/mis/";
        urls[3] = "http://helpdesk.lnmiit.ac.in/login_page.php";
        urls[4] = "https://erp.lnmiit.ac.in/onlinechallan/";
        urls[5] = "https://www.lnmiit.ac.in/Library/Library_OPAC.html";

        urls[6] = "http://moodle.lnmiit.ac.in/";
        urls[7] = "http://172.22.2.20:8080/jspui/";
        urls[8] = "http://studentsgymkhana.lnmiit.ac.in/Gymkhana_website/main%20header/main%20page.html";
        urls[9] = "http://172.22.2.130/cse/";
        urls[10] = "http://172.22.2.130/ece/";

        ListView myListView = view.findViewById(R.id.myListView);

        ArrayList<String> quickLinks = new ArrayList<String>();

        quickLinks.add("LNMIIT Official Website");
        quickLinks.add("Training and Placement Cell");
        quickLinks.add("MIS Portal");
        quickLinks.add("Helpdesk");
        quickLinks.add("Fees Portal");
        quickLinks.add("Library Website");

        quickLinks.add("Moodle");
        quickLinks.add("Institutional Repository");
        quickLinks.add("Student Gymkhana");
        quickLinks.add("CSE Portal");
        quickLinks.add("ECE Portal");



        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_activated_1, quickLinks);

        myListView.setAdapter(arrayAdapter);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0){
                    Intent intent = new Intent(getActivity(),WebActivity.class);
                    intent.putExtra("links",urls[0]);
                    startActivity(intent);
                }else if(i==1){
                    Intent intent = new Intent(getActivity(),WebActivity.class);
                    intent.putExtra("links",urls[1]);
                    startActivity(intent);
                }else if(i==2){
                    Intent intent = new Intent(getActivity(),WebActivity.class);
                    intent.putExtra("links",urls[2]);
                    startActivity(intent);
                }else if(i==3){
                    Intent intent = new Intent(getActivity(),WebActivity.class);
                    intent.putExtra("links",urls[3]);
                    startActivity(intent);
                }else if(i==4){
                    Intent intent = new Intent(getActivity(),WebActivity.class);
                    intent.putExtra("links",urls[4]);
                    startActivity(intent);
                }else if(i==5){
                    Intent intent = new Intent(getActivity(),WebActivity.class);
                    intent.putExtra("links",urls[5]);
                    startActivity(intent);
                }else if(i==6){
                    Intent intent = new Intent(getActivity(),WebActivity.class);
                    intent.putExtra("links",urls[6]);
                    startActivity(intent);
                }else if(i==7){
                    Intent intent = new Intent(getActivity(),WebActivity.class);
                    intent.putExtra("links",urls[7]);
                    startActivity(intent);
                }else if(i==8){
                    Intent intent = new Intent(getActivity(),WebActivity.class);
                    intent.putExtra("links",urls[8]);
                    startActivity(intent);
                }else if(i==9){
                    Intent intent = new Intent(getActivity(),WebActivity.class);
                    intent.putExtra("links",urls[9]);
                    startActivity(intent);
                }else if(i==10){
                    Intent intent = new Intent(getActivity(),WebActivity.class);
                    intent.putExtra("links",urls[10]);
                    startActivity(intent);
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

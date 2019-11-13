package com.example.lnmapp;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    public String[] arrSplit;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference mDatabase;
    String ss;

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position){
        MessFrag demoFragment = new MessFrag();
        position = position+ 1;
        Bundle bundle = new Bundle();


        mDatabase = database.getReference().child("MESS MENU").child("01-MONDAY").child("mon");
        mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String s=dataSnapshot.getValue(String.class);

                arrSplit = s.split("--");
                ss=s;
                Log.i("mess",arrSplit[1]);

            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        if(position == 1) {
            bundle.putString("message", "Monday");
            bundle.putString("message_b","Cutlet");
            bundle.putString("message_l","Rajma, Lauki, Plain Rice, Roti, Boondi Raita");
            bundle.putString("message_s","Veg Pakora");
            bundle.putString("message_d","Black Masoor Daal, Dum Aloo, Fried Rice, Roti, Balushahi");
            demoFragment.setArguments(bundle);
            return demoFragment;

        }else if(position == 2){

            bundle.putString("message", "Tuesday");
            bundle.putString("message_b","Cutlet/Boiled Masala Sprouts");
            bundle.putString("message_l","Dal Makhani, Matar Paneer, Plain Rice, Roti, Butter Milk");
            bundle.putString("message_s","Stuffed Kulchs");
            bundle.putString("message_d","Puri, Matar Aloo, Biryani, Seviyan Kheer");
            demoFragment.setArguments(bundle);
            return demoFragment;

        }else if(position == 3){
            bundle.putString("message","Wednesday");
            bundle.putString("message_b","Plain Paratha + Chana/Omlette");
            bundle.putString("message_l","Dry Chole, Arhar Dal, Matr Pulao, Roti, Plain Curd");
            bundle.putString("message_s","Aloo Sandwich");
            bundle.putString("message_d","Malai Kofta, Chana Dal, Jeera Rice, Roti, Ice Cream");
            demoFragment.setArguments(bundle);
            return demoFragment;

        }else if(position == 4){
            bundle.putString("message","Thursday");
            bundle.putString("message_b","Sambhar Idli or Sambahr Vada/Boiled egg");
            bundle.putString("message_l","Kadhi + Pakoda, Aloo Fry, Roti, Plain Rice");
            bundle.putString("message_s","Samosa");
            bundle.putString("message_d","Nutrela Aloo, Panchsheel Dal, Jeera Rice, Roti, Rasgulla");
            demoFragment.setArguments(bundle);
            return demoFragment;

        }else if(position == 5){
            bundle.putString("message","Friday");
            bundle.putString("message_b","Chole-Kulche/Omlette");
            bundle.putString("message_l","Mix-Veg, Lobiya Dal, Plain Rice, Roti, Fruit Raita");
            bundle.putString("message_s","Bread Roll");
            bundle.putString("message_d","Kadai Paneer, Mutter Pulao, Masoor Dal, Roti, Gulab Jamun");
            demoFragment.setArguments(bundle);
            return demoFragment;

        }else if(position == 6){
            bundle.putString("message","Saturday");
            bundle.putString("message_b","Namkeen Poha/Omlette");
            bundle.putString("message_l","Aloo Paratha, Mutter Sabji, Plain Rice, Plain Curd");
            bundle.putString("message_s","Bhelpuri");
            bundle.putString("message_d","Gatta Masala, Moongmasur Dal, Jeera Rice, Roti, Fruit Custard");
            demoFragment.setArguments(bundle);
            return demoFragment;

        }

        bundle.putString("message","Sunday");
        bundle.putString("message_b","Samosa/Omlette");
        bundle.putString("message_l","Chhole Bhature, Matar Pulao, Boondi Raita");
        bundle.putString("message_s","Poha");
        bundle.putString("message_d","Bhindi Pyaaz, Arhar Dal, Jeera Rice, Roti, Boondi Laddoo");
        demoFragment.setArguments(bundle);
        return demoFragment;

    }

    @Override
    public int getCount(){
        return 7;
    }
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        position = position +1;

        if(position==1){
            return "MON";
        }else if(position==2){
            return "TUE";
        }else if(position==3){
            return "WED";
        }else if(position==4){
            return "THUR";
        }else if(position==5){
            return "FRI";
        }else if(position==6){
            return "SAT";
        }
        return "SUN";
    }
}
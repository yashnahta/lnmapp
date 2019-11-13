package com.example.lnmapp;

public class ExploreItem {
    private int mImageResourec;
    private String mText1;

    public ExploreItem(int imageResource,String text1){
        mImageResourec = imageResource;
        mText1 = text1;
    }

    public int getImageResource(){
        return mImageResourec;
    }

    public String getText1(){
        return mText1;
    }
}

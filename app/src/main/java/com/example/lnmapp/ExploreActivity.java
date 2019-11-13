package com.example.lnmapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class ExploreActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore);

        ArrayList<ExploreItem> exploreList = new ArrayList<>();
        exploreList.add(new ExploreItem(R.drawable.plinth,"PLINTH"));
        exploreList.add(new ExploreItem(R.drawable.despo,"DESPORTIVOS"));
        exploreList.add(new ExploreItem(R.drawable.viva,"VIVACITY"));
        exploreList.add(new ExploreItem(R.drawable.hacks,"LNM HACKS"));
        exploreList.add(new ExploreItem(R.drawable.gusto,"GUSTO"));

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        adapter = new ExploreAdapter(exploreList);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }


}

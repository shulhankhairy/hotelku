package com.hotelku.tourist.mainmenu;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hotelku.traveler.hotelku.R;

public class TouristHistoryFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_tourist_history, container, false);
        return view;
    }
}
/*
public class TouristHistoryFragment extends FragmentActivity {

    public TouristHistoryFragment() {
        // Required empty public constructor
    }

    private FragmentTabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_tourist_history);

        tabHost = (FragmentTabHost)findViewById(android.R.id.tabhost);

        tabHost.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);

        tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator("Ongoing", null),
                TouristHistoryTab1Fragment.class, null);

        tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator("Completed", null),
                TouristHistoryTab2Fragment.class, null);
    }
}*/

package com.hotelku.tourist.mainmenu;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.hotelku.traveler.hotelku.R;

public class TouristHistoryTab2Fragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_tourist_history_tab2, container, false);

        LinearLayout detailHistory = (LinearLayout)rootView.findViewById(R.id.tourist_detail_history_list);
        detailHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TouristBookingActivity.class);
                startActivity(intent);
            }
        });
        return rootView;
    }
}

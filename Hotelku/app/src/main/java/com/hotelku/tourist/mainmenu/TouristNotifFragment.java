package com.hotelku.tourist.mainmenu;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.hotelku.traveler.hotelku.R;

public class TouristNotifFragment extends Fragment {

    public TouristNotifFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_tourist_notif, container, false);

        LinearLayout notifDetail = (LinearLayout)rootView.findViewById(R.id.tourist_notif_detail_offer);
        notifDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), TouristNotifDetailActivity.class);
                startActivity(i);
            }
        });
        return rootView;
    }

}

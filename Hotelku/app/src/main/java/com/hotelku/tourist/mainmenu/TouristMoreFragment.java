package com.hotelku.tourist.mainmenu;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.hotelku.traveler.hotelku.R;

public class TouristMoreFragment extends Fragment {

    public TouristMoreFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_tourist_more, container, false);

        Button editProfileBtn = (Button)rootView.findViewById(R.id.tourist_more_edit);
        editProfileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TouristEditProfileActivity.class);
                startActivity(intent);
            }
        });

        Button termsCondBtn = (Button)rootView.findViewById(R.id.tourist_more_termscond);
        termsCondBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TouristTermsCondActivity.class);
                startActivity(intent);
            }
        });

        Button privacyBtn = (Button)rootView.findViewById(R.id.tourist_more_policy);
        privacyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TouristPolicyActivity.class);
                startActivity(intent);
            }
        });

        return rootView;
    }
}

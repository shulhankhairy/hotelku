package com.hotelku.tourist.mainmenu;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hotelku.traveler.hotelku.R;

public class TouristHomeFragment extends Fragment {

    public TouristHomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_tourist_home, container, false);

        TextView moreInfo = (TextView)rootView.findViewById(R.id.tourist_more_info);
        moreInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TouristInfoDestActivity.class);
                startActivity(intent);
            }
        });
        return rootView;
    }
}

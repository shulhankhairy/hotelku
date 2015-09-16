package com.hotelku.tourist.mainmenu;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hotelku.traveler.hotelku.R;

public class TouristHomeFragment extends Fragment {

    public TouristHomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_tourist_home, container, false);

        return super.onCreateView(inflater, container, savedInstanceState);
    }
}

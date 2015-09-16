package com.hotelku.tourist.mainmenu;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hotelku.traveler.hotelku.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TouristNotifFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TouristNotifFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TouristNotifFragment extends Fragment {

    public TouristNotifFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_tourist_notif, container, false);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

}

package com.hotelku.owner.mainmenu;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hotelku.traveler.hotelku.R;

/**
 * Created by noba on 9/17/2015.
 */
public class OwnerNotifFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_owner_notif, container, false);

        return view;
    }
}

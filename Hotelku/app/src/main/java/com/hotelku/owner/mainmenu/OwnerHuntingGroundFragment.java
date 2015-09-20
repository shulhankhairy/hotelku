package com.hotelku.owner.mainmenu;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.hotelku.traveler.hotelku.R;

/**
 * Created by noba on 9/17/2015.
 */
public class OwnerHuntingGroundFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_owner_hunting_ground, container, false);

        LinearLayout o = (LinearLayout)view.findViewById(R.id.owner_hg);
        o.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), OwnerHuntingGroundActivity.class);
                startActivity(i);
            }
        });

        return view;
    }
}

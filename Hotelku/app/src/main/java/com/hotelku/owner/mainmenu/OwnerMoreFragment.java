package com.hotelku.owner.mainmenu;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.hotelku.owner.register.OwnerRegister2Activity;
import com.hotelku.owner.register.OwnerRegister3Activity;
import com.hotelku.tourist.mainmenu.TouristEditProfileActivity;
import com.hotelku.traveler.hotelku.R;

/**
 * Created by noba on 9/17/2015.
 */
public class OwnerMoreFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_owner_more, container, false);

        Button editPropertyDetail = (Button)view.findViewById(R.id.owner_more_edit_property_detail);
        editPropertyDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), OwnerRegister2Activity.class);
                startActivity(i);

            }
        });

        Button roomDetail = (Button)view.findViewById(R.id.owner_more_room_detail);
        roomDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), OwnerRegister3Activity.class);
                startActivity(i);
            }
        });


        Button changePassword = (Button)view.findViewById(R.id.owner_more_change_password);
        changePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), TouristEditProfileActivity.class);
                startActivity(i);
            }
        });

        Button termAndCondition = (Button)view.findViewById(R.id.owner_more_term_and_condition);
        termAndCondition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), OwnerMoreTermAndConditionActivity.class);
                startActivity(i);
            }
        });

        Button aboutUs = (Button)view.findViewById(R.id.owner_more_about_us);

        Button logout = (Button)view.findViewById(R.id.owner_more_logout);

        return view;
    }
}

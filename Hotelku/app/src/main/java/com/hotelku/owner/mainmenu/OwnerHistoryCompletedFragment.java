package com.hotelku.owner.mainmenu;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.hotelku.owner.OwnerBookingVoucherDetailActivity;
import com.hotelku.owner.register.OwnerRegisterActivity;
import com.hotelku.traveler.hotelku.R;

/**
 * Created by noba on 9/18/2015.
 */
public class OwnerHistoryCompletedFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_owner_history_completed, container, false);
        LinearLayout i = (LinearLayout)view.findViewById(R.id.coba);
        i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), OwnerBookingVoucherDetailActivity.class);
                startActivity(i);
            }
        });
        return view;
    }
}

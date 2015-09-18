package com.hotelku.tourist.mainmenu;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.hotelku.owner.mainmenu.OwnerHistoryCompletedFragment;
import com.hotelku.owner.mainmenu.OwnerHistoryOngoingFragment;
import com.hotelku.traveler.hotelku.R;

public class TouristHistoryFragment extends Fragment {

    FragmentManager fm;
    LinearLayout completed;
    LinearLayout ongoing;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_tourist_history, container, false);

        fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.tourist_history_content, new TouristHistoryTab1Fragment(), "ongoing");
        ft.commit();

        ongoing = (LinearLayout)view.findViewById(R.id.tourist_history_ongoing);
        ongoing.setBackgroundColor(getResources().getColor(R.color.main_color));
        ongoing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                completed.setBackgroundColor(getResources().getColor(R.color.white));
                ongoing.setBackgroundColor(getResources().getColor(R.color.main_color));
                TouristHistoryTab1Fragment fragment = (TouristHistoryTab1Fragment) getFragmentManager().findFragmentByTag("ongoing");
                if (fragment==null) {
                    // start new Activity
                    TouristHistoryTab2Fragment fragment1 = (TouristHistoryTab2Fragment)getFragmentManager().findFragmentByTag("completed");
                    if(fragment1!=null)
                    {
                        FragmentTransaction ft = fm.beginTransaction();
                        ft.replace(R.id.tourist_history_content, new TouristHistoryTab1Fragment(), "ongoing");
                        ft.commit();
                    }
                }
            }
        });

        completed = (LinearLayout)view.findViewById(R.id.tourist_history_completed);
        completed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                completed.setBackgroundColor(getResources().getColor(R.color.main_color));
                ongoing.setBackgroundColor(getResources().getColor(R.color.white));
                TouristHistoryTab2Fragment fragment1 = (TouristHistoryTab2Fragment)getFragmentManager().findFragmentByTag("completed");
                if(fragment1==null)
                {
                    TouristHistoryTab1Fragment fragment = (TouristHistoryTab1Fragment)getFragmentManager().findFragmentByTag("ongoing");
                    if(fragment!=null)
                    {
                        FragmentTransaction ft = fm.beginTransaction();
                        ft.replace(R.id.tourist_history_content, new TouristHistoryTab2Fragment(), "completed");
                        ft.commit();
                    }
                }
            }
        });
        return view;
    }
}

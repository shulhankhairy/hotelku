package com.hotelku.owner.mainmenu;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.hotelku.traveler.hotelku.R;

/**
 * Created by noba on 9/17/2015.
 */
public class OwnerHistoryFragment extends Fragment {

    FragmentManager fm;
    LinearLayout completed;
    LinearLayout ongoing;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_owner_history, container, false);

        fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        OwnerHistoryOngoingFragment fragment = (OwnerHistoryOngoingFragment) getFragmentManager().findFragmentByTag("ongoing");
        if(fragment==null)
        {
            OwnerHistoryCompletedFragment fragment1 = (OwnerHistoryCompletedFragment)getFragmentManager().findFragmentByTag("completed");
            if(fragment1==null)
                ft.add(R.id.home_owner_history_fragment, new OwnerHistoryOngoingFragment(), "ongoing");
            else
                ft.replace(R.id.home_owner_history_fragment, new OwnerHistoryOngoingFragment(), "ongoing");
        }
        else
            ft.replace(R.id.home_owner_history_fragment, new OwnerHistoryOngoingFragment(), "ongoing");

        ft.commit();

        ongoing = (LinearLayout)view.findViewById(R.id.home_owner_history_ongoing);
        ongoing.setBackgroundColor(getResources().getColor(R.color.main_color));
        ongoing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                completed.setBackgroundColor(getResources().getColor(R.color.white));
                ongoing.setBackgroundColor(getResources().getColor(R.color.main_color));
                OwnerHistoryOngoingFragment fragment = (OwnerHistoryOngoingFragment) getFragmentManager().findFragmentByTag("ongoing");
                if (fragment==null) {
                    // start new Activity
                    OwnerHistoryCompletedFragment fragment1 = (OwnerHistoryCompletedFragment)getFragmentManager().findFragmentByTag("completed");
                    if(fragment1!=null)
                    {
                        FragmentTransaction ft = fm.beginTransaction();
                        ft.replace(R.id.home_owner_history_fragment, new OwnerHistoryOngoingFragment(), "ongoing");
                        ft.commit();
                    }
                }
            }
        });

        completed = (LinearLayout)view.findViewById(R.id.home_owner_history_completed);
        completed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                completed.setBackgroundColor(getResources().getColor(R.color.main_color));
                ongoing.setBackgroundColor(getResources().getColor(R.color.white));
                OwnerHistoryCompletedFragment fragment1 = (OwnerHistoryCompletedFragment)getFragmentManager().findFragmentByTag("completed");
                if(fragment1==null)
                {
                    OwnerHistoryOngoingFragment fragment = (OwnerHistoryOngoingFragment)getFragmentManager().findFragmentByTag("ongoing");
                    if(fragment!=null)
                    {
                        FragmentTransaction ft = fm.beginTransaction();
                        ft.replace(R.id.home_owner_history_fragment, new OwnerHistoryCompletedFragment(), "completed");
                        ft.commit();
                    }
                }
            }
        });
        return view;
    }

}

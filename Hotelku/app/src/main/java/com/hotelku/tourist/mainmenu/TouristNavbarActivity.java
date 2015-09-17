package com.hotelku.tourist.mainmenu;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Toast;

import com.hotelku.owner.mainmenu.OwnerHistoryFragment;
import com.hotelku.owner.mainmenu.OwnerHomeFragment;
import com.hotelku.traveler.hotelku.R;

/**
 * Created by Admin on 9/3/2015.
 */
public class TouristNavbarActivity extends Activity {

    FragmentManager fm;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tourist_home);

        fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.tourist_home_fragment, new TouristHomeFragment());
        ft.commit();
        RadioButton radioButton;
        radioButton = (RadioButton) findViewById(R.id.btnHome2);
        radioButton.setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.ic_home_active, 0, 0);
    }

    public void onClikButtonMenu(View v)
    {
        RadioButton radioButton;
        radioButton = (RadioButton) findViewById(R.id.btnHome2);
        radioButton.setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.ic_history_passive, 0, 0);
        radioButton = (RadioButton) findViewById(R.id.btnHistory2);
        radioButton.setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.ic_history_passive, 0, 0);
        radioButton = (RadioButton) findViewById(R.id.btnNotif2);
        radioButton.setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.ic_notif_passive, 0, 0);
        radioButton = (RadioButton) findViewById(R.id.btnOrder2);
        radioButton.setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.ic_request_passive, 0, 0);
        radioButton = (RadioButton) findViewById(R.id.btnMore2);
        radioButton.setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.ic_more_passive, 0, 0);
        boolean checked = ((RadioButton) v).isChecked();
        if(v.getId()==R.id.btnHistory2)
        {
            if(checked){
                ((RadioButton) v).setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.ic_history_active, 0, 0);
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.tourist_home_fragment, new TouristHistoryFragment());
                ft.commit();
            }
        }
        else if(v.getId()==R.id.btnNotif2)
        {
            if(checked){
                ((RadioButton) v).setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.ic_notif_active, 0, 0);
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.tourist_home_fragment, new TouristNotifFragment());
                ft.commit();
            }
        }
        else if(v.getId()==R.id.btnOrder2)
        {
            if(checked){
                ((RadioButton) v).setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.ic_request_active, 0, 0);
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.tourist_home_fragment, new TouristRequestFragment());
                ft.commit();
            }
        }
        else if(v.getId()==R.id.btnMore2)
        {
            if(checked){
                ((RadioButton) v).setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.ic_more_active, 0, 0);
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.tourist_home_fragment, new TouristMoreFragment());
                ft.commit();
            }
        }

    }
}

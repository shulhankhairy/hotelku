package com.hotelku.traveler.hotelku;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Toast;

/**
 * Created by Admin on 9/3/2015.
 */
public class TouristNavbarActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tourist_home);

        /*RadioButton radioButton;
        radioButton = (RadioButton) findViewById(R.id.btnHistory2);
        radioButton.setOnCheckedChangeListener(btnNavBarOnCheckedChangeListener);
        radioButton = (RadioButton) findViewById(R.id.btnNotif2);
        radioButton.setOnCheckedChangeListener(btnNavBarOnCheckedChangeListener);
        radioButton = (RadioButton) findViewById(R.id.btnOrder2);
        radioButton.setOnCheckedChangeListener(btnNavBarOnCheckedChangeListener);
        radioButton = (RadioButton) findViewById(R.id.btnSetting2);
        radioButton.setOnCheckedChangeListener(btnNavBarOnCheckedChangeListener);*/
    }

    public void onClikButtonMenu(View v)
    {
        RadioButton radioButton;
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
            if(checked)
                ((RadioButton) v).setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.ic_history_active, 0, 0);
        }
        else if(v.getId()==R.id.btnNotif2)
        {
            if(checked)
                ((RadioButton) v).setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.ic_notif_active, 0, 0);
        }
        else if(v.getId()==R.id.btnOrder2)
        {
            if(checked)
                ((RadioButton) v).setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.ic_request_active, 0, 0);
        }
        else if(v.getId()==R.id.btnMore2)
        {
            if(checked)
                ((RadioButton) v).setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.ic_more_active, 0, 0);
        }

    }
}

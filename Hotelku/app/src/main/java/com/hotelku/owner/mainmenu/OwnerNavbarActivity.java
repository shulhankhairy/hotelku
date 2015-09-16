package com.hotelku.owner.mainmenu;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Toast;

import com.hotelku.traveler.hotelku.R;

/**
 * Created by Admin on 9/3/2015.
 */
public class OwnerNavbarActivity  extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_home);
    }

    public void onClikButtonMenu(View v)
    {
        RadioButton radioButton;
        radioButton = (RadioButton) findViewById(R.id.btnHistory);
        radioButton.setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.ic_history_passive, 0, 0);
        radioButton = (RadioButton) findViewById(R.id.btnNotif);
        radioButton.setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.ic_notif_passive, 0, 0);
        radioButton = (RadioButton) findViewById(R.id.btnOrder);
        radioButton.setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.ic_hg_passive, 0, 0);
        radioButton = (RadioButton) findViewById(R.id.btnSetting);
        radioButton.setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.ic_more_passive, 0, 0);
        boolean checked = ((RadioButton) v).isChecked();
        if(v.getId()==R.id.btnHistory)
        {
            if(checked)
                ((RadioButton) v).setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.ic_history_active, 0, 0);
        }
        else if(v.getId()==R.id.btnNotif)
        {
            if(checked)
                ((RadioButton) v).setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.ic_notif_active, 0, 0);
        }
        else if(v.getId()==R.id.btnOrder)
        {
            if(checked)
                ((RadioButton) v).setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.ic_hg_active, 0, 0);
        }
        else if(v.getId()==R.id.btnSetting)
        {
            if(checked)
                ((RadioButton) v).setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.ic_more_active, 0, 0);
        }

    }

/*
    private CompoundButton.OnCheckedChangeListener btnNavBarOnCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() {
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                Toast.makeText(OwnerNavbarActivity.this, buttonView.getText(), Toast.LENGTH_SHORT).show();
            }
        }
    };
    */
}

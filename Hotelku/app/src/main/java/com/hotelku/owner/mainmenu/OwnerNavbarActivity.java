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
/*
        RadioButton radioButton;
        radioButton = (RadioButton) findViewById(R.id.btnHistory);
        radioButton.setOnCheckedChangeListener(btnNavBarOnCheckedChangeListener);
        radioButton = (RadioButton) findViewById(R.id.btnNotif);
        radioButton.setOnCheckedChangeListener(btnNavBarOnCheckedChangeListener);
        radioButton = (RadioButton) findViewById(R.id.btnOrder);
        radioButton.setOnCheckedChangeListener(btnNavBarOnCheckedChangeListener);
        radioButton = (RadioButton) findViewById(R.id.btnSetting);
        radioButton.setOnCheckedChangeListener(btnNavBarOnCheckedChangeListener);
        */
    }

    public void onClikButtonMenu(View v)
    {
        RadioButton radioButton;
        radioButton = (RadioButton) findViewById(R.id.btnHistory);
        radioButton.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_history, 0, 0);
        radioButton = (RadioButton) findViewById(R.id.btnNotif);
        radioButton.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_notification, 0, 0);
        radioButton = (RadioButton) findViewById(R.id.btnOrder);
        radioButton.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_list, 0, 0);
        radioButton = (RadioButton) findViewById(R.id.btnSetting);
        radioButton.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_setting, 0, 0);
        boolean checked = ((RadioButton) v).isChecked();
        if(v.getId()==R.id.btnHistory)
        {
            if(checked)
                ((RadioButton) v).setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_notification_clicked, 0, 0);
        }
        else if(v.getId()==R.id.btnNotif)
        {
            if(checked)
                ((RadioButton) v).setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_notification_clicked, 0, 0);
        }
        else if(v.getId()==R.id.btnOrder)
        {
            if(checked)
                ((RadioButton) v).setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_notification_clicked, 0, 0);
        }
        else if(v.getId()==R.id.btnSetting)
        {
            if(checked)
                ((RadioButton) v).setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_notification_clicked, 0, 0);
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

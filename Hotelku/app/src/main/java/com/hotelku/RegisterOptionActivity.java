package com.hotelku;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.hotelku.owner.register.OwnerRegisterActivity;
import com.hotelku.tourist.mainmenu.TouristNavbarActivity;
import com.hotelku.traveler.hotelku.R;
import com.hotelku.tourist.register.TouristRegisterActivity;

/**
 * Created by KHAIRY on 02-Sep-15.
 */
public class RegisterOptionActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_option);

        Button ownerButtonOption = (Button) findViewById(R.id.button_yes_owner);
        ownerButtonOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RegisterOptionActivity.this, OwnerRegisterActivity.class);
                startActivity(i);
            }
        });

        Button touristButtonOption = (Button) findViewById(R.id.button_just_traveller);
        touristButtonOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent(RegisterOptionActivity.this, TouristNavbarActivity.class);
                startActivity(j);
            }
        });
    }
}

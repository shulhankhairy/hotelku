package com.hotelku;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.hotelku.owner.register.OwnerRegisterActivity;
import com.hotelku.tourist.mainmenu.TouristNavbarActivity;
import com.hotelku.traveler.hotelku.R;
import com.hotelku.tourist.register.TouristRegisterActivity;

/**
 * Created by KHAIRY on 02-Sep-15.
 */
public class RegisterOptionActivity extends Activity {

    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_option);

        pref = getSharedPreferences("Hotelku", Context.MODE_PRIVATE);

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

    @Override
    protected void onResume() {
        super.onResume();
        String data = pref.getString("coba", "gagal");
        Toast.makeText(RegisterOptionActivity.this, data, Toast.LENGTH_SHORT).show();
    }
}

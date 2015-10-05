package com.hotelku.tourist.register;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.hotelku.traveler.hotelku.R;

/**
 * Created by KHAIRY on 02-Sep-15.
 */
public class TouristRegisterActivity extends Activity {

    Button touristRegisterProfPicBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tourist_register);

        touristRegisterProfPicBtn = (Button) findViewById(R.id.upload_profile_pict_button);
        touristRegisterProfPicBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setType("image/*");
                i.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(i, "Select Picture"), 1);
            }
        });

        TextView touristBirthDateText = (TextView) findViewById(R.id.register_tourist_birthdate);
        Button selectBirthDateBtn = (Button) findViewById(R.id.register_tourist_birthdate_button);
        selectBirthDateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TouristRegisterActivity.this,"ngkok isine datepicker iki",Toast.LENGTH_LONG).show();
            }
        });

        Button registerBtn = (Button) findViewById(R.id.register_tourist_button);
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TouristRegisterActivity.this,TouristRegisterSuccess.class);
                startActivity(i);
            }
        });
    }
}

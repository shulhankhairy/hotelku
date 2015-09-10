package com.hotelku.traveler.hotelku;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by KHAIRY on 02-Sep-15.
 */
public class TouristRegisterActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tourist_register);

        Button registerBtn = (Button) findViewById(R.id.tourist_register_button);
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TouristRegisterActivity.this,TouristRegisterSuccess.class);
                startActivity(i);
            }
        });
    }
}

package com.hotelku.owner.register;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.hotelku.traveler.hotelku.R;

/**
 * Created by noba on 9/11/2015.
 */
public class OwnerRegister2Activity extends Activity{

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_register_2);

        sharedPreferences = getSharedPreferences("Hotelku", Context.MODE_PRIVATE);

        Button uploadImageButton = (Button)findViewById(R.id.register_owner_property_upload_image_button);
        Button cancelButton = (Button)findViewById(R.id.register_owner_cancel_button);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putString("coba", "Haloo");
                editor.commit();

                finish();
            }
        });
        Button nextButton = (Button)findViewById(R.id.register_owner_next_button);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(OwnerRegister2Activity.this, OwnerRegister3Activity.class);
                startActivity(i);
            }
        });

    }
}

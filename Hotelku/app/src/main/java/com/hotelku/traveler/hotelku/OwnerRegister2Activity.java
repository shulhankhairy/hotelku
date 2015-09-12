package com.hotelku.traveler.hotelku;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by noba on 9/11/2015.
 */
public class OwnerRegister2Activity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_register_2);

        Button uploadImageButton = (Button)findViewById(R.id.register_owner_property_upload_image_button);
        Button cancelButton = (Button)findViewById(R.id.register_owner_cancel_button);
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

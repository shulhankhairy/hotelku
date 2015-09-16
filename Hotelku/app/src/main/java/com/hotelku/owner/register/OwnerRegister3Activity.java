package com.hotelku.owner.register;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.hotelku.traveler.hotelku.R;

/**
 * Created by noba on 9/12/2015.
 */
public class OwnerRegister3Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_register_3);

        Button addRoomButton = (Button)findViewById(R.id.register_owner_more_room_button);
        addRoomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        Button cancelButton = (Button)findViewById(R.id.register_owner_cancel_button);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        Button nextButton = (Button)findViewById(R.id.register_owner_next_button);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(OwnerRegister3Activity.this, OwnerRegisterSuccess.class);
                startActivity(i);
            }
        });

        Button deleteRoomButton = (Button)findViewById(R.id.register_owner_property_delete_room_button);
        deleteRoomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }
}

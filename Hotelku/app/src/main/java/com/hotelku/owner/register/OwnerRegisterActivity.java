package com.hotelku.owner.register;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.hotelku.traveler.hotelku.R;

/**
 * Created by KHAIRY on 02-Sep-15.
 */
public class OwnerRegisterActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_register);

        Button cancelButton = (Button)findViewById(R.id.button_register_owner_cancel);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(OwnerRegisterActivity.this, "Cancel", Toast.LENGTH_SHORT).show();
            }
        });

        Button nextButton = (Button)findViewById(R.id.button_register_owner_next);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(OwnerRegisterActivity.this, OwnerRegister2Activity.class);
                startActivity(i);
            }
        });

        Button findPositionButton = (Button)findViewById(R.id.button_register_owner_find_position);
        findPositionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(OwnerRegisterActivity.this, "Find", Toast.LENGTH_SHORT).show();
            }
        });
    }

}

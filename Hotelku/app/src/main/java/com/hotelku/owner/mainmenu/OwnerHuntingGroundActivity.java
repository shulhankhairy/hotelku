package com.hotelku.owner.mainmenu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.hotelku.owner.OwnerOfferActivity;
import com.hotelku.traveler.hotelku.R;

/**
 * Created by noba on 9/18/2015.
 */
public class OwnerHuntingGroundActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_hunting_ground_detail);

        Button makeOffer = (Button)findViewById(R.id.button_owner_make_offer);
        makeOffer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(OwnerHuntingGroundActivity.this, OwnerOfferActivity.class);
                startActivity(i);
            }
        });

    }
}

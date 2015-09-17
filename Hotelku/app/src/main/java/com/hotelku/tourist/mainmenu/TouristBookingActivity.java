package com.hotelku.tourist.mainmenu;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.hotelku.traveler.hotelku.R;

public class TouristBookingActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tourist_booking);

        Button cancelNextbtn = (Button)findViewById(R.id.tourist_cancel_next);
        cancelNextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TouristBookingActivity.this,TouristCancelActivity.class);
                startActivity(i);
            }
        });
    }
}

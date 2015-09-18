package com.hotelku.owner;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.hotelku.traveler.hotelku.R;

/**
 * Created by noba on 9/18/2015.
 */
public class OwnerBookingVoucherDetailActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_booking_voucher_detail);

        Button cancelBooking = (Button)findViewById(R.id.button_owner_cancel_booking);
        cancelBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        Button back = (Button)findViewById(R.id.button_owner_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}

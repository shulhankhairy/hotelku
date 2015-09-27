package com.hotelku.owner.register;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hotelku.traveler.hotelku.R;

/**
 * Created by KHAIRY on 02-Sep-15.
 */
public class OwnerRegisterActivity extends Activity {

    EditText propertyName, address, city, longitude, latitude, phoneNumber, email, password, rePassword;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_register);

        propertyName = (EditText)findViewById(R.id.register_owner_property_name);
        address = (EditText)findViewById(R.id.register_owner_property_address);
        city = (EditText)findViewById(R.id.register_owner_property_City);
        longitude = (EditText)findViewById(R.id.register_owner_longitude);
        latitude = (EditText)findViewById(R.id.register_owner_latitude);
        phoneNumber = (EditText)findViewById(R.id.register_owner_property_phone_number);
        email = (EditText)findViewById(R.id.register_owner_property_email);
        password = (EditText)findViewById(R.id.register_owner_property_password);
        rePassword = (EditText)findViewById(R.id.register_owner_property_repassword);
        sharedPreferences = getSharedPreferences("Hotelku", Context.MODE_PRIVATE);
    }

    public void nextButton(View v)
    {
        if(!propertyName.getText().toString().equals("") && !address.getText().toString().equals("") &&
                !city.getText().toString().equals("") && !longitude.getText().toString().equals("") &&
                !latitude.getText().toString().equals("") && !phoneNumber.getText().toString().equals("") &&
                !email.getText().toString().equals("") && !password.getText().toString().equals("") &&
                !rePassword.getText().toString().equals(""))
        {
            Toast.makeText(OwnerRegisterActivity.this, "Next", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(OwnerRegisterActivity.this, OwnerRegister2Activity.class);
            startActivity(i);
        }
        else
        {
            Toast.makeText(OwnerRegisterActivity.this, "Please, fill all data.", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(OwnerRegisterActivity.this, OwnerRegister2Activity.class);
            startActivity(i);
        }
    }

    public void cancelButton(View v)
    {
        Toast.makeText(OwnerRegisterActivity.this, "Cancel", Toast.LENGTH_SHORT).show();

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("coba", "Haloo");
        editor.commit();

        finish();
    }

    public void findPosition(View v)
    {
        Toast.makeText(OwnerRegisterActivity.this, "tombol buat cari posisi hotel\npake gmap", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();

        String data = sharedPreferences.getString("coba", "gagal");
        Toast.makeText(OwnerRegisterActivity.this, data, Toast.LENGTH_SHORT).show();
        email.setText(data);
    }
}

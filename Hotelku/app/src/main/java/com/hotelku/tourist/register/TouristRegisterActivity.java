package com.hotelku.tourist.register;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.hotelku.RoundImage;

import com.hotelku.traveler.hotelku.R;

/**
 * Created by KHAIRY on 02-Sep-15.
 */
public class TouristRegisterActivity extends Activity {

    Button touristRegisterProfPicBtn;
    EditText touristRegisterName;
    EditText touristRegisterBirthday;
    EditText touristRegisterGender;
    EditText touristRegisterPhone;
    EditText touristRegisterEmail;
    EditText touristRegisterPassword;
    ImageView touristPicture;
    RoundImage roundedImage;

    Bitmap bitmap;

    private static String KEY_NAME = "touristName";
    private static String KEY_BIRTHDAY = "touristBirthday";
    private static String KEY_GENDER = "touristGender";
    private static String KEY_PHONE = "touristPhone";
    private static String KEY_EMAIL = "touristEmail";
    private static String KEY_PASSWORD = "touristPassword";
    private static String KEY_SUCCESS = "success";
    private static String KEY_ERROR = "error";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tourist_register);

        touristPicture = (ImageView) findViewById(R.id.user_picture);
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

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Uri selectedImageUri = null;
        String filePath = null;
        if (resultCode == Activity.RESULT_OK) {
            selectedImageUri = data.getData();
        }

        if(selectedImageUri != null){
            try {
                // OI FILE Manager
                String filemanagerstring = selectedImageUri.getPath();

                // MEDIA GALLERY
                String selectedImagePath = getPath(selectedImageUri);

                if (selectedImagePath != null) {
                    filePath = selectedImagePath;
                } else if (filemanagerstring != null) {
                    filePath = filemanagerstring;
                } else {
                    Toast.makeText(getApplicationContext(), "Unknown path",
                            Toast.LENGTH_LONG).show();
                    Log.e("Bitmap", "Unknown path");
                }

                if (filePath != null) {
                    decodeFile(filePath);
                } else {
                    bitmap = null;
                }
            } catch (Exception e) {
                Toast.makeText(getApplicationContext(), "Internal error",
                        Toast.LENGTH_LONG).show();
                Log.e(e.getClass().getName(), e.getMessage(), e);
            }
        }

    }

    public String getPath(Uri uri) {
        String[] projection = { MediaStore.Images.Media.DATA };
        Cursor cursor = managedQuery(uri, projection, null, null, null);
        if (cursor != null) {
            // HERE YOU WILL GET A NULLPOINTER IF CURSOR IS NULL
            // THIS CAN BE, IF YOU USED OI FILE MANAGER FOR PICKING THE MEDIA
            int column_index = cursor
                    .getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            cursor.moveToFirst();
            return cursor.getString(column_index);
        } else
            return null;
    }

    public void decodeFile(String filePath) {
        // Decode image size
        BitmapFactory.Options o = new BitmapFactory.Options();
        o.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(filePath, o);

        // The new size we want to scale to
        final int REQUIRED_SIZE = 1024;

        // Find the correct scale value. It should be the power of 2.
        int width_tmp = o.outWidth, height_tmp = o.outHeight;
        int scale = 1;
        while (true) {
            if (width_tmp < REQUIRED_SIZE && height_tmp < REQUIRED_SIZE)
                break;
            width_tmp /= 2;
            height_tmp /= 2;
            scale *= 2;
        }

        // Decode with inSampleSize
        BitmapFactory.Options o2 = new BitmapFactory.Options();
        o2.inSampleSize = scale;
        bitmap = BitmapFactory.decodeFile(filePath, o2);

        touristPicture.setImageBitmap(bitmap);

    }
}

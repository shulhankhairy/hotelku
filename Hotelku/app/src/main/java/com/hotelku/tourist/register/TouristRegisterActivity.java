package com.hotelku.tourist.register;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.hotelku.RoundImage;
import com.hotelku.Base64;

import com.hotelku.traveler.hotelku.R;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by KHAIRY on 02-Sep-15.
 */
public class TouristRegisterActivity extends Activity {

    Button touristRegisterProfPicBtn;
    EditText touristRegisterName;
    Spinner touristRegisterGender;
    EditText touristRegisterPhone;
    EditText touristRegisterEmail;
    EditText touristRegisterPassword;
    TextView touristRegisterBirthday;
    ImageView touristPicture;
    RoundImage roundedImage;

    Bitmap bitmap;
    private ProgressDialog dialog;
    private DatePicker datePicker;
    private Calendar calendar;
    private TextView dateView;
    private int year, month, day;

    String touristName;
    String touristBitrhday;
    String touristGender;
    String touristPhone;
    String touristEmail;
    String touristPassword;

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

        touristPicture = (ImageView) findViewById(R.id.tourist_register_pict);
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

        touristRegisterName = (EditText) findViewById(R.id.tourist_register_fullname);

        touristRegisterBirthday = (TextView) findViewById(R.id.tourist_register_birthdate);
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);

        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        showDate(year, month+1, day);
        Button selectBirthDateBtn = (Button) findViewById(R.id.register_tourist_birthdate_button);
        /*selectBirthDateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                date
            }
        });*/

        touristRegisterGender = (Spinner)findViewById(R.id.tourist_register_genderspinner);
        touristRegisterPhone = (EditText)findViewById(R.id.tourist_register_phone);
        touristRegisterEmail = (EditText)findViewById(R.id.tourist_register_email);
        touristRegisterPassword = (EditText)findViewById(R.id.tourist_register_password);

        touristName = touristRegisterName.getText().toString();
        touristBitrhday = touristRegisterBirthday.getText().toString();
        touristGender = touristRegisterGender.getOnItemClickListener().toString();
        touristPhone = touristRegisterPhone.getText().toString();
        touristEmail = touristRegisterEmail.getText().toString();
        touristPassword = touristRegisterPassword.getText().toString();

        Button registerBtn = (Button) findViewById(R.id.register_tourist_button);
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bitmap == null) {
                    Toast.makeText(getApplicationContext(),
                            "Please select image", Toast.LENGTH_SHORT).show();
                } else {
                    dialog = ProgressDialog.show(TouristRegisterActivity.this, "Register your account",
                            "Please wait...", true);
                    new TouristRegisterSubmit().execute();
                }
            }
        });
    }

    @SuppressWarnings("deprecation")
    public void setDate(View view) {
        showDialog(999);
        Toast.makeText(getApplicationContext(), "ca", Toast.LENGTH_SHORT)
                .show();
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(this, myDateListener, year, month, day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {
            // TODO Auto-generated method stub
            // arg1 = year
            // arg2 = month
            // arg3 = day
            showDate(arg1, arg2+1, arg3);
        }
    };

    private void showDate(int year, int month, int day) {
        dateView.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
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

    class TouristRegisterSubmit extends AsyncTask<String, String, String> {
        @SuppressWarnings("unused")
        @Override
        protected String doInBackground(String... args) {
            InputStream is;
            BitmapFactory.Options bfo;
            Bitmap bitmapOrg;
            ByteArrayOutputStream bao ;

            bfo = new BitmapFactory.Options();
            bfo.inSampleSize = 2;
            //bitmapOrg = BitmapFactory.decodeFile(Environment.getExternalStorageDirectory() + "/" + customImage, bfo);

            bao = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 90, bao);
            byte [] ba = bao.toByteArray();
            String ba1 = Base64.encodeBytes(ba);
            ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
            nameValuePairs.add(new BasicNameValuePair("image",ba1));
            nameValuePairs.add(new BasicNameValuePair("cmd","imageuser"));
            nameValuePairs.add(new BasicNameValuePair(KEY_NAME,touristName));
            nameValuePairs.add(new BasicNameValuePair(KEY_BIRTHDAY,touristBitrhday));
            nameValuePairs.add(new BasicNameValuePair(KEY_GENDER,touristGender));
            nameValuePairs.add(new BasicNameValuePair(KEY_PHONE,touristPhone));
            nameValuePairs.add(new BasicNameValuePair(KEY_EMAIL,touristEmail));
            nameValuePairs.add(new BasicNameValuePair(KEY_PASSWORD,touristPassword));

            Log.v("log_tag", System.currentTimeMillis()+".jpg");
            try{
                HttpClient httpclient = new DefaultHttpClient();
                HttpPost httppost = new
                        //  Here you need to put your server file address
                        HttpPost("http://www.trikaryateknologi.com/hotelku/webservice/tourist_insert_data_register.php");
                httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
                HttpResponse response = httpclient.execute(httppost);
                HttpEntity entity = response.getEntity();
                is = entity.getContent();
                Log.v("log_tag", "In the try Loop" );
            }catch(Exception e){
                Log.v("log_tag", "Error in http connection "+e.toString());
            }
            return "Success";
            // (null);
        }

        @Override
        protected void onPostExecute(String sResponse) {
            try {
                if (dialog.isShowing())
                    dialog.dismiss();
            } catch (Exception e) {
                Toast.makeText(getApplicationContext(),
                        e.getMessage(),
                        Toast.LENGTH_LONG).show();
                Log.e(e.getClass().getName(), e.getMessage(), e);
            }
        }

    }

}

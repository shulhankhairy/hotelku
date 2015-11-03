package com.hotelku.tourist.mainmenu;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.hotelku.Base64;
import com.hotelku.LoginActivity;
import com.hotelku.traveler.hotelku.R;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;

public class TouristEditProfileActivity extends Activity {

    ImageView touristEditPicture;

    EditText editTouristName;
    EditText editTouristEmail;
    EditText editTouristPassword;

    String touristNameEdited;
    String touristEmailEdited;
    String touristPasswordEdited;

    Button touristEditPictureBtn;
    Button touristEditProfileButtonSave;
    Button touristEditProfileButtonCancel;

    Bitmap bitmap;
    private ProgressDialog dialog;

    SharedPreferences session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tourist_edit_profile);

        touristEditPicture = (ImageView)findViewById(R.id.tourist_edit_pict);
        touristEditPictureBtn = (Button)findViewById(R.id.tourist_edit_pict_button);
        touristEditPictureBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setType("image/*");
                i.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(i, "Select Picture"), 1);
            }
        });

        session = getSharedPreferences(LoginActivity.sessionPref, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = session.edit();

        editTouristName = (EditText)findViewById(R.id.tourist_edit_name);
        editTouristName.setText(session.getString("nama",""));
        editTouristEmail = (EditText)findViewById(R.id.tourist_edit_email);
        editTouristEmail.setText(session.getString("username",""));
        editTouristPassword = (EditText)findViewById(R.id.tourist_edit_password);
        editTouristPassword.setText(session.getString("password",""));

        touristNameEdited = editTouristName.getText().toString();
        touristEmailEdited = editTouristEmail.getText().toString();
        touristPasswordEdited = editTouristPassword.getText().toString();

        touristEditProfileButtonSave = (Button)findViewById(R.id.tourist_edit_save_button);
        touristEditProfileButtonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        touristEditProfileButtonCancel = (Button)findViewById(R.id.tourist_edit_cancel_button);
        touristEditProfileButtonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TouristEditProfileActivity.this,TouristNavbarActivity.class);
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

        touristEditPicture.setImageBitmap(bitmap);
    }

    class TouristEditGetData extends AsyncTask<String, String, String> {
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

            Log.v("log_tag", System.currentTimeMillis()+".jpg");
            try{
                HttpClient httpclient = new DefaultHttpClient();
                HttpPost httppost = new
                        //  Here you need to put your server file address
                        HttpPost("http://www.trikaryateknologi.com/hotelku/webservice/tourist_edit_profile_get_data.php");
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

    class TouristEditData extends AsyncTask<String, String, String> {
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
            nameValuePairs.add(new BasicNameValuePair("username",touristNameEdited));
            nameValuePairs.add(new BasicNameValuePair("email",touristEmailEdited));
            nameValuePairs.add(new BasicNameValuePair("password",touristPasswordEdited));

            Log.v("log_tag", System.currentTimeMillis()+".jpg");
            try{
                HttpClient httpclient = new DefaultHttpClient();
                HttpPost httppost = new
                        //  Here you need to put your server file address
                        HttpPost("http://www.trikaryateknologi.com/hotelku/webservice/tourist_edit_profile_insert_data.php");
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

package com.hotelku;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.app.LoaderManager.LoaderCallbacks;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hotelku.owner.mainmenu.OwnerNavbarActivity;
import com.hotelku.tourist.mainmenu.TouristNavbarActivity;
import com.hotelku.tourist.mainmenu.TouristRequestFragment;
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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;


public class LoginActivity extends Activity {

    EditText editTextUserName;
    EditText editTextPassword;
    Button turisLoginBtn;
    Button propertyLoginBtn;
    TextView register;

    public static final String USER_NAME = "USERNAME";

    String username;
    String password;

    SharedPreferences session;
    public static final String sessionPref = "sessionPref";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        session = getSharedPreferences(sessionPref, Context.MODE_PRIVATE);

        editTextUserName = (EditText) findViewById(R.id.username);
        editTextPassword = (EditText) findViewById(R.id.password);
        turisLoginBtn = (Button)findViewById(R.id.tourist_sign_in_button);
        propertyLoginBtn = (Button)findViewById(R.id.owner_sign_in_button);
        register = (TextView)findViewById(R.id.text_register_here);

        username = editTextUserName.getText().toString();
        password = editTextPassword.getText().toString();

        turisLoginBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                TurisLogin(username, password);
            }
        });

        propertyLoginBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        register.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this,RegisterOptionActivity.class);
                startActivity(i);
            }
        });
    }

    private void TurisLogin(final String username, final String password) {

        class LoginAsync extends AsyncTask<String, Void, String> {

            private Dialog loadingDialog;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loadingDialog = ProgressDialog.show(LoginActivity.this, "Please wait", "Loading...");
            }

            @Override
            protected String doInBackground(String... params) {
                String uname = params[0];
                String pass = params[1];

                InputStream is = null;
                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
                nameValuePairs.add(new BasicNameValuePair("username", uname));
                nameValuePairs.add(new BasicNameValuePair("password", pass));
                String result = null;

                try {
                    HttpClient httpClient = new DefaultHttpClient();
                    HttpPost httpPost = new HttpPost(
                            "http://trikaryateknologi/hotelku/webservice/tourist_login.php");
                    httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

                    HttpResponse response = httpClient.execute(httpPost);

                    HttpEntity entity = response.getEntity();

                    is = entity.getContent();

                    BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"), 8);
                    StringBuilder sb = new StringBuilder();

                    String line = null;
                    while ((line = reader.readLine()) != null) {
                        sb.append(line + "\n");
                    }
                    result = sb.toString();
                } catch (ClientProtocolException e) {
                    e.printStackTrace();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return result;
            }

            @Override
            protected void onPostExecute(String result) {
                String s = result.trim(); //s is fullname of user
                loadingDialog.dismiss();
                if (!s.isEmpty()) {
                    //Bundle bundle = new Bundle();
                    //bundle.putString("username", s);
                    // set Fragmentclass Arguments
                    //TouristRequestFragment fragobj = new TouristRequestFragment();
                    //fragobj.setArguments(bundle);
                    SharedPreferences.Editor editor = session.edit();
                    editor.putString("email",username);
                    editor.putString("password",password);
                    editor.putString("nama",s);

                    Intent intent = new Intent(LoginActivity.this, TouristNavbarActivity.class);
                    intent.putExtra(USER_NAME, s);
                    finish();
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Invalid User Name or Password", Toast.LENGTH_LONG).show();
                }
            }
        }

        LoginAsync la = new LoginAsync();
        la.execute(username, password);

    }
}


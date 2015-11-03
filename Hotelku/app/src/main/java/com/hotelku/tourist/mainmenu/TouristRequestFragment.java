package com.hotelku.tourist.mainmenu;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TouristRequestFragment extends Fragment {

    String destinasi;
    String nama;
    String tglCheckin;
    String jmlMalam;
    String opsiCari;
    String jmlSewa;
    String jmlOrang;
    String requestTmbh;
    String budget;

    String username;

    TextView touristReqName;
    EditText touristReqDest;
    EditText touristReqCheckInDate;
    EditText touristReqNight;
    EditText touristReqSearchFor;
    EditText touristReqRentNum;
    EditText touristReqTotalGuest;
    EditText touristReqAdd;
    EditText touristReqBudget;

    Button btnRequestOK;

    private ProgressDialog pDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_tourist_request, container, false);

        touristReqDest = (EditText)rootView.findViewById(R.id.editTextDest);
        touristReqName = (TextView)rootView.findViewById(R.id.tourist_request_name);
        touristReqCheckInDate = (EditText)rootView.findViewById(R.id.tourist_request_date);
        touristReqNight = (EditText)rootView.findViewById(R.id.tourist_request_nights);
        touristReqSearchFor = (EditText)rootView.findViewById(R.id.tourist_request_search);
        touristReqRentNum = (EditText)rootView.findViewById(R.id.tourist_request_num_rent);
        touristReqTotalGuest = (EditText)rootView.findViewById(R.id.tourist_request_guest);
        touristReqAdd = (EditText)rootView.findViewById(R.id.tourist_request_detail);
        touristReqBudget = (EditText)rootView.findViewById(R.id.tourist_request_budget);

        username = getArguments().getString("username");
        touristReqName.setText(username);

        destinasi = touristReqDest.getText().toString();
        nama = touristReqName.getText().toString();
        tglCheckin = touristReqCheckInDate.getText().toString();
        jmlMalam = touristReqNight.getText().toString();
        opsiCari = touristReqSearchFor.getText().toString();
        jmlSewa = touristReqRentNum.getText().toString();
        jmlOrang = touristReqTotalGuest.getText().toString();
        requestTmbh = touristReqAdd.getText().toString();
        budget = touristReqBudget.getText().toString();

        btnRequestOK = (Button)rootView.findViewById(R.id.tourist_request_ok_button);
        btnRequestOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(destinasi.isEmpty() ){
                    Context context = getActivity().getApplicationContext();
                    Toast.makeText(context, "Please fill the destination form", Toast.LENGTH_LONG).show();
                }
                else if(tglCheckin.isEmpty()){
                    Context context = getActivity().getApplicationContext();
                    Toast.makeText(context, "Please fill the check in date form", Toast.LENGTH_LONG).show();
                }
                else if(jmlMalam.isEmpty()){
                    Context context = getActivity().getApplicationContext();
                    Toast.makeText(context, "Please fill the nights to stay form", Toast.LENGTH_LONG).show();
                }
                else if(opsiCari.isEmpty()){
                    Context context = getActivity().getApplicationContext();
                    Toast.makeText(context, "Please fill the search form", Toast.LENGTH_LONG).show();
                }
                else if(jmlSewa.isEmpty()){
                    Context context = getActivity().getApplicationContext();
                    Toast.makeText(context, "Please fill the total rent form", Toast.LENGTH_LONG).show();
                }
                else if(jmlOrang.isEmpty()){
                    Context context = getActivity().getApplicationContext();
                    Toast.makeText(context, "Please fill the total guest form", Toast.LENGTH_LONG).show();
                }
                else if(budget.isEmpty()){
                    Context context = getActivity().getApplicationContext();
                    Toast.makeText(context, "Please fill the budget form", Toast.LENGTH_LONG).show();
                }
                else if(destinasi.isEmpty() || nama.isEmpty() || tglCheckin.isEmpty() || jmlMalam.isEmpty() ||
                        opsiCari.isEmpty() || jmlSewa.isEmpty() || jmlOrang.isEmpty() || budget.isEmpty()){
                    Context context = getActivity().getApplicationContext();
                    Toast.makeText(context, "Please fill the form", Toast.LENGTH_LONG).show();
                }
                else {
                    new InsertRequest().execute();
                }
            }
        });
        return rootView;
    }

    class InsertRequest extends AsyncTask<String, String, String> {

        /**
         * Before starting background thread Show Progress Dialog
         * */
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(getActivity());
            pDialog.setMessage("Sending Request");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(false);
            pDialog.show();
        }

        /**
         * Saving product
         * */
        protected String doInBackground(String... args) {

            // Building Parameters
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("destinasi", destinasi));
            params.add(new BasicNameValuePair("nama",nama));
            params.add(new BasicNameValuePair("checkin",tglCheckin));
            params.add(new BasicNameValuePair("malam",jmlMalam));
            params.add(new BasicNameValuePair("opsicari",opsiCari));
            params.add(new BasicNameValuePair("jmlsewa",jmlSewa));
            params.add(new BasicNameValuePair("jmlorang",jmlOrang));
            params.add(new BasicNameValuePair("requesttmbh",requestTmbh));
            params.add(new BasicNameValuePair("budget",budget));

            try {
                HttpClient httpClient = new DefaultHttpClient();
                HttpPost httpPost = new HttpPost("http://trikaryateknologi.com/hotelku/webservice/tourist_request.php");
                httpPost.setEntity(new UrlEncodedFormEntity(params));

                HttpResponse response = httpClient.execute(httpPost);

                HttpEntity entity = response.getEntity();
            } catch (ClientProtocolException e) {

            } catch (IOException e) {

            }

            return null;
        }


        /**
         * After completing background task Dismiss the progress dialog
         * **/
        protected void onPostExecute(String file_url) {
            // dismiss the dialog once product updated
            pDialog.setMessage("Make Request Success");
            pDialog.dismiss();
        }
    }

}

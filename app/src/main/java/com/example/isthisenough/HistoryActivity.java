package com.example.isthisenough;

import android.content.Context;
import android.content.Intent;
import android.media.MediaScannerConnection;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class HistoryActivity extends AppCompatActivity {

    //ArrayList<String> jobslist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history );
        ButterKnife.bind(this);
        getHistory();
    }

    /**
    public void getHistory() throws JSONException {

        String JSONString = null;

        try {
            InputStream inputStream = openFileInput("history.json");

            //File traceFile = new File(((Context) this).getExternalFilesDir(null), "history.json");
            if (inputStream == null)
                Log.e("NoJSON", "There are no entries in the software.");
            // Adds a line to the trace file
            //InputStreamReader inputStreamReader  = new InputStreamReader(inputStream);

            int sizeOfJSONFile = inputStream.available();

            //array that will store all the data
            byte[] bytes = new byte[sizeOfJSONFile];

            //reading data into the array from the file
            inputStream.read(bytes);

            //close the input stream
            inputStream.close();

            JSONString = new String(bytes, "UTF-8");
            //JSONObject = new JSONObject(JSONString);

            JSONArray jsonArray = new JSONArray(JSONString);
            String output = "";
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                //jobslist.add(obj.getString("jobTitle"));
                //String
                output += obj.getString("jobTitle") + " , " +
                        obj.getString("oHours") + " , " +
                        obj.getString("oMinutes") + " , " +
                        obj.getString("jodDescription");
                Toast.makeText(getApplicationContext(), output, Toast.LENGTH_LONG).show();
            }

        } catch(IOException e) {
            Log.e("Read", "IOException");
        } catch (JSONException e) {
            Log.e("Read", "JSONException");
        }
    }

        */
         // This is an old version

    public void getHistory() {
        String json = null;

        Gson gson = new Gson();

        try {
            File traceFile = new File(((Context) this).getExternalFilesDir(null), "gsontest.json");
            BufferedReader br = new BufferedReader(new FileReader(traceFile));

            //Checker. Not in use...
            //if (br == null)
                //Log.e("NoJSON", "There are no entries in the software.");

            HourObject hourObj = gson.fromJson(br, HourObject.class);

            /**
             * Test

            TypeToken<List<HourObject>> token = new TypeToken<List<HourObject>>(){};
            List<HourObject> jobslist = gson.fromJson(br, token.getType());

            for(int i=0; i<jobslist.size(); i++){
                HourObject p = jobslist.get(i);
                System.out.println(p);
            }

             //Test
            System.out.println("Reading JSON from a file");
            System.out.println("----------------------------");
            */
            System.out.println(hourObj);

            System.out.println("Job title: "+ hourObj.getJobTitle());
            System.out.println("Hours: "+ hourObj.getoHours());
            System.out.println("Minutes: "+ hourObj.getoMinutes());
            System.out.println("Description: "+ hourObj.getJodDescription());
            /**
            String title = hourObj.getJobTitle();
            int hours = hourObj.getoHours();
            int minutes = hourObj.getoMinutes();
            String description= hourObj.getJodDescription();

            //String tester = hourObj.toString();

            //String perkele = "Vittu saatana";

            //TextView textView = findViewById(R.id.teststring);
            //textView.setText(perkele);
            /**
             System.out.println("States are :");
             List listOfStates = countryObj.getListOfStates();
             for (int i = 0; i < listOfStates.size(); i++) {
             System.out.println(listOfStates.get(i));
             }

            TextView output = (TextView) findViewById(R.id.teststring);
            output.setText(hourObj.toString());
            */

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @OnClick(R.id.toMainFromHistory)
    public void toMainFromInfo() {
        Intent toMain = new Intent(this, MainActivity.class);
        startActivity(toMain);
    }
}

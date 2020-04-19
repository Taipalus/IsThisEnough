package com.example.isthisenough;

import android.content.Context;
import android.content.Intent;
import android.media.MediaScannerConnection;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

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

import butterknife.ButterKnife;
import butterknife.OnClick;

public class HistoryActivity extends AppCompatActivity {

    ArrayList<String> jobslist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history );
        ButterKnife.bind(this);
        //HourObject testi = new HourObject("Uli", 1 , 1 , "Perkele");
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
                InputStream inputStream = openFileInput("gsontest.json");

                System.out.println("Reading JSON from a file");
                System.out.println("----------------------------");

                File traceFile = new File(((Context) this).getExternalFilesDir(null), "gsontest.json");
                if (inputStream == null)
                    Log.e("NoJSON", "There are no entries in the software.");
                // Adds a line to the trace file
                InputStreamReader inputStreamReader  = new InputStreamReader(inputStream);

                BufferedReader br = new BufferedReader(inputStreamReader);

                //convert the json string back to object
                HourObject hourObj = gson.fromJson(br, HourObject.class);

                System.out.println("Date: "+ hourObj.getDate());
                System.out.println("Job title: "+ hourObj.getJobTitle());
                System.out.println("Hours: "+ hourObj.getoHours());
                System.out.println("Minutes: "+ hourObj.getoMinutes());
                System.out.println("Description: "+ hourObj.getJodDescription());

                /**
                System.out.println("States are :");

                List listOfStates = countryObj.getListOfStates();
                for (int i = 0; i < listOfStates.size(); i++) {
                    System.out.println(listOfStates.get(i));
                }
                 */

            } catch (IOException e) {
                e.printStackTrace();
            }
            /**
            try {
                //InputStream streamInput = getAssets().open("history.json");

                InputStream streamInput = openFileInput("history.json");
                //InputStreamReader inputStreamReader  = new InputStreamReader(inputStream);

                int size = streamInput.available();
                byte[] buffer = new byte[size];
                streamInput.read(buffer);
                streamInput.close();

                System.out.println(buffer);

                json = new String(buffer, "UTF-8");

                System.out.println(json);

                System.out.println("2");

                //Something funky here. Investigate...
                JSONArray jsonArray = new JSONArray(json);
                String output = "";

                System.out.println("3");

                for (int i = 0; i<jsonArray.length(); i++) {
                    JSONObject obj = jsonArray.getJSONObject(i);
                    //jobslist.add(obj.getString("jobTitle"));
                    //String
                    output += obj.getString("jobTitle") + " , " +
                            obj.getString("oHours") + " , " +
                            obj.getString("oMinutes") + " , " +
                            obj.getString("jodDescription");
                    System.out.println("Täällä");
                    Toast.makeText(getApplicationContext(), output, Toast.LENGTH_LONG).show();
                }

            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
             */
        }


    @OnClick(R.id.toMainFromHistory)
    public void toMainFromInfo() {
        Intent toMain = new Intent(this, MainActivity.class);
        startActivity(toMain);
    }
}

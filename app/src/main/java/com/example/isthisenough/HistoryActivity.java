package com.example.isthisenough;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
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
        HourObject testi = new HourObject("Uli", 1 , 1 , "Perkele");
        getHistory();
    }

    public void getHistory() {
        String json;
        try {
            InputStream streamInput = getAssets().open("history.json");
            int size = streamInput.available();
            byte[] buffer = new byte[size];
            streamInput.read(buffer);
            streamInput.close();

            json = new String(buffer, "UTF-8");
            JSONArray jsonArray = new JSONArray(json);

            for (int i = 0; i<jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                jobslist.add(obj.getString("jobTitle"));
                Toast.makeText(getApplicationContext(), jobslist.toString(), Toast.LENGTH_LONG).show();
            }


        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @OnClick(R.id.toMainFromHistory)
    public void toMainFromInfo() {
        Intent toMain = new Intent(this, MainActivity.class);
        startActivity(toMain);
    }
}

package com.example.isthisenough;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class InputActivity extends AppCompatActivity {

    private Spinner dropdown;
    private static String[] items = new String[]{"", "Job 1", "Job 2", "Job 3"};
    private int inputMinutes;
    private int inputHours;
    private String currentDate;

    public ArrayList<ArrayList> workinghours;

    public String jsonString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        ButterKnife.bind(this);

        //Time for input field
        TextView textView = findViewById(R.id.date);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
        currentDate = sdf.format(new Date());
        textView.setText(currentDate);

        //Dropdown menu
        dropdown = findViewById(R.id.chooser);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);

        workinghours = new ArrayList<>();
    }

    @OnClick(R.id.toMainFromInput)
    public void toMainFromInfo() {
        Intent toMain = new Intent(this, MainActivity.class);
        startActivity(toMain);
    }

    @OnClick(R.id.saveHours)
    public void saveHours() {

        EditText editHours = (EditText) findViewById(R.id.hours);
        String stringhoursHelper = editHours.getText().toString();

        EditText editMinutes = (EditText) findViewById(R.id.minutes);
        String stringminutesHelper = editMinutes.getText().toString();


        if ((stringhoursHelper.matches("")) || (stringminutesHelper.matches(""))) {
            emptyToast();
        }
        else {
            int hoursHelper = Integer.parseInt(editHours.getText().toString());
            int minutesHelper = Integer.parseInt(editMinutes.getText().toString());

            //Not implemented. Placeholder.
            //if ((minutesHelper != 0) || (hoursHelper != 0)) {
                if ((hoursHelper >= 0) && (hoursHelper <= 23)) {
                    if ((minutesHelper >= 0) && (minutesHelper <= 59)) {
                        inputHours = hoursHelper;
                        inputMinutes = minutesHelper;
                        saveToast();
                        Intent toMain = new Intent(this, MainActivity.class);
                        startActivity(toMain);
                    }
                }
            //}
            else {
                errorToast();
            }
        }
    }

    /**
    protected void saveJson() {
        String jsonStr = currentDate;
        if (jsonStr != null) {
            try {
                JSONObject jsonObj = new JSONObject(jsonStr);

                JSONArray whours = jsonObj.getJSONArray("whours");
                for (int i = 0; i < whours.length(); i++) {
                    JSONObject c = whours.getJSONObject(i);

                    String id = c.getString("id");
                    String date = c.getString("date");
                    int minutes = c.getInt("min");
                    int hours = c.getInt("h");
                    String jobtitle = c.getString("title");

                    //HashMap<String, String> contact = new HashMap<>();

                    //hours.put("id", id);
                    //hours.put("date", date);
                    //hours.put("min", minutes);
                    //hours.put("h", hours);

                    workinghours.add(workinghours);
                }
            } catch (final JSONException e) {

            }
        }
    }
    */

    public void saveToast() {
        Context context = getApplicationContext();
        CharSequence text = inputHours + " hours and " + inputMinutes + " minutes saved!";
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    public void errorToast() {
        Context context = getApplicationContext();
        CharSequence text = "Hours or minutes wrong";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    public void emptyToast() {
        Context context = getApplicationContext();
        CharSequence text = "Hours or minutes empty";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}

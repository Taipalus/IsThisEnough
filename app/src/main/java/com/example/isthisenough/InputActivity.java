package com.example.isthisenough;

import android.content.Context;
import android.content.Intent;
import android.media.MediaScannerConnection;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
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
    private String jobDescription;

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
        this.currentDate = sdf.format(new Date());
        textView.setText(currentDate);

        //Dropdown menu
        dropdown = findViewById(R.id.chooser);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);

        workinghours = new ArrayList<>();
    }

    @OnClick(R.id.toMainFromInput)
    public void toMainFromInput() {
        Intent toMain = new Intent(this, MainActivity.class);
        startActivity(toMain);
    }

    @OnClick(R.id.saveHours)
    public void saveHours() {

        EditText editHours = (EditText) findViewById(R.id.hours);
        String stringhoursHelper = editHours.getText().toString();

        EditText editMinutes = (EditText) findViewById(R.id.minutes);
        String stringminutesHelper = editMinutes.getText().toString();

        EditText editDescription = (EditText) findViewById(R.id.description);
        this.jobDescription = editDescription.getText().toString();

        if ((stringhoursHelper.matches("")) || (stringminutesHelper.matches(""))) {
            emptyToast();
        }
        else {
            int hoursHelper = Integer.parseInt(stringhoursHelper);
            int minutesHelper = Integer.parseInt(stringminutesHelper);

            //Not implemented. Placeholder.
            //if ((minutesHelper != 0) || (hoursHelper != 0)) {
                if ((hoursHelper >= 0) && (hoursHelper <= 23)) {
                    if ((minutesHelper >= 0) && (minutesHelper <= 59)) {

                        this.inputHours = hoursHelper;
                        this.inputMinutes = minutesHelper;
                        Gson gson = new Gson();
                        HourObject todaysinfo = new HourObject("test1", inputHours, inputMinutes, jobDescription , this.currentDate);
                        String json = gson.toJson(todaysinfo);
                        saveJson("gsontest.json", json);
                        System.out.println(json);

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

    public void saveJson(String filename, String input) {
        try {
            File jsonFile = new File(((Context) this).getExternalFilesDir(null), filename);
            if (!jsonFile.exists())
                jsonFile.createNewFile();
            /**
            FileOutputStream streamoutput = openFileOutput(filename, Context.MODE_PRIVATE);
            streamoutput.write(input.getBytes(), 0, input.length());
            streamoutput.close();
             */
            BufferedWriter writer = new BufferedWriter(new FileWriter(jsonFile, true /*append*/));
            writer.write(input);
            writer.close();
            //MediaScannerConnection.scanFile((Context) (this), new String[]{jsonFile.toString()},null,null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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

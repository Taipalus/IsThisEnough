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
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class InputActivity extends AppCompatActivity {

    private Spinner dropdown;
    private String[] items;
    private int inputMinutes;
    private int inputHours;
    private String currentDate;
    private String jobDescription;

    public ArrayList<ArrayList> workinghours;

    /**
     *  Creates the view.
     *  This view is for inputing data to software.
     *  Checks for the date and saves it to variable to be used at save.
     *  Generates spinner for the view depending on the system language.
     * @param savedInstanceState
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        ButterKnife.bind(this);

        TextView textView = findViewById(R.id.date);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        this.currentDate = sdf.format(new Date());
        textView.setText(getString(R.string.input_info) + currentDate);

        items = new String[]{getString(R.string.input_nojob), getString(R.string.input_job1), getString(R.string.input_job2), getString(R.string.input_job3)};
        dropdown = findViewById(R.id.chooser);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);
        workinghours = new ArrayList<>();
    }

    /**
     * Button for going to Main screen.
     */

    @OnClick(R.id.toMainFromInput)
    public void toMainFromInput() {
        Intent toMain = new Intent(this, MainActivity.class);
        startActivity(toMain);
    }

    /**
     * Function that converts data to proper form and check that everything is fine to be saved.
     * Does not actually save anything but calls for save after everything is checked.
     */

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

            if ((hoursHelper >= 0) && (hoursHelper <= 23)) {
                if ((minutesHelper >= 0) && (minutesHelper <= 59)) {

                    this.inputHours = hoursHelper;
                    this.inputMinutes = minutesHelper;
                    String selectedJob = dropdown.getSelectedItem().toString();

                    long spinnerID = dropdown.getSelectedItemId();
                    if (spinnerID == 0) {
                        selectedJob = getString(R.string.input_nojob);
                    }
                    Gson gson = new GsonBuilder()
                            .setLenient()
                            .create();
                    HourObject todaysinfo = new HourObject(selectedJob, inputHours, inputMinutes, jobDescription, this.currentDate);
                    String json = gson.toJson(todaysinfo);
                    saveJson("itehistory.json", json);
                    System.out.println(json);
                    saveToast();
                    Intent toMain = new Intent(this, MainActivity.class);
                    startActivity(toMain);
                }
                else {
                    errorToastM();
                }
            }
            else {
                errorToastH();
            }
        }
    }

    /**
     * Save function for the user input. Checks if there is a file where to save if not creates one.
     * @param filename hardcoded filename where the saving is done.
     * @param input JSON string that is saved to file.
     */

    public void saveJson(String filename, String input) {
        try {
            File jsonFile = new File(((Context) this).getExternalFilesDir(null), filename);
            if (!jsonFile.exists())
                jsonFile.createNewFile();
            BufferedWriter writer = new BufferedWriter(new FileWriter(jsonFile, true /*append*/));
            writer.write(input);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Toast message after save to file is done. Informs user what the input was.
     */

    public void saveToast() {
        Context context = getApplicationContext();
        CharSequence text = inputHours + getString(R.string.toast_1save) + inputMinutes +
                getString(R.string.toast_2save) + "\n" + getString(R.string.toast_3save) + currentDate;
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    /**
     * Toast message if user input is false on hours.
     */
    public void errorToastH() {
        Context context = getApplicationContext();
        CharSequence text = getString(R.string.toast_hours);
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    /**
     * Toast message if user input is false on minutes.
     */

    public void errorToastM() {
        Context context = getApplicationContext();
        CharSequence text = getString(R.string.toast_minutes);
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    /**
     * Toast message if user input is empty on hours or minutes.
     */

    public void emptyToast() {
        Context context = getApplicationContext();
        CharSequence text = getString(R.string.toast_empty);
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}

package com.example.isthisenough;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class InputActivity extends AppCompatActivity {

    private Spinner dropdown;
    private static String[] items = new String[]{"", "Job 1", "Job 2", "Job 3"};
    private int inputMinutes;
    private int inputHours;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        ButterKnife.bind(this);

        //Dropdown menu
        dropdown = findViewById(R.id.chooser);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);
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
            errorToast();
        }
        else {
            int hoursHelper = Integer.parseInt(editHours.getText().toString());
            int minutesHelper = Integer.parseInt(editMinutes.getText().toString());

            if ((minutesHelper == 0) != (hoursHelper == 0)) {
                if ((hoursHelper >= 0) && (hoursHelper <= 23)) {
                    if ((minutesHelper >= 0) && (minutesHelper <= 59)) {
                        inputHours = hoursHelper;
                        inputMinutes = minutesHelper;
                        saveToast();
                        Intent toMain = new Intent(this, MainActivity.class);
                        startActivity(toMain);
                    }
                }
            }
            else {
                errorToast();
            }
        }
    }

    public void saveToast() {
        Context context = getApplicationContext();
        CharSequence text = "Hours saved!";
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
}

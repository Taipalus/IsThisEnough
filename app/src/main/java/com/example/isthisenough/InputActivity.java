package com.example.isthisenough;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class InputActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        ButterKnife.bind(this);

        Spinner dropdown = findViewById(R.id.chooser);

        String[] items = new String[]{"", "Job 1", "Job 2", "Job 3"};

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
        saveToast();
        Intent toMain = new Intent(this, MainActivity.class);
        startActivity(toMain);
    }

    public void saveToast() {
        Context context = getApplicationContext();
        CharSequence text = "Hours saved!";
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}

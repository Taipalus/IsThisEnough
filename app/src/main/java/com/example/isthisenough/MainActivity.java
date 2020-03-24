package com.example.isthisenough;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.toInputFromMain)
    public void toInputFromMain() {
        System.out.println("toCalendar");
        Intent toInput = new Intent(this, InputActivity.class);
        startActivity(toInput);
    }

    @OnClick(R.id.toHistoryFromMain)
    public void toHistoryFromMain() {
        Intent toHistory = new Intent(this, HistoryActivity.class);
        startActivity(toHistory);
    }

    @OnClick(R.id.toInfoFromMain)
    public void toInfoFromMain() {
        Intent toInfo = new Intent(this, InfoActivity.class);
        startActivity(toInfo);
    }
}

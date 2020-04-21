package com.example.isthisenough;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    /**
     * Creates the view.
     *
     * @param savedInstanceState
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }

    /**
     * Button for going to Input screen.
     */

    @OnClick(R.id.toInputFromMain)
    public void toInputFromMain() {
        Intent toInput = new Intent(this, InputActivity.class);
        startActivity(toInput);
    }

    /**
     * Button for going to History screen.
     */

    @OnClick(R.id.toHistoryFromMain)
    public void toHistoryFromMain() {
        Intent toHistory = new Intent(this, HistoryActivity.class);
        startActivity(toHistory);
    }

    /**
     * Button for going to Info screen.
     */

    @OnClick(R.id.toInfoFromMain)
    public void toInfoFromMain() {
        Intent toInfo = new Intent(this, InfoActivity.class);
        startActivity(toInfo);
    }
}

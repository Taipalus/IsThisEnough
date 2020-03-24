package com.example.isthisenough;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.toMainFromHistory)
    public void toMainFromInfo() {
        Intent toMain = new Intent(this, MainActivity.class);
        startActivity(toMain);
    }
}

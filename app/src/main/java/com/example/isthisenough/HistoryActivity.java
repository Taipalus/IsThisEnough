package com.example.isthisenough;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collectors;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class HistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history );
        ButterKnife.bind(this);
        getHistory();
    }

    public void getHistory() {

        try {
            File traceFile = new File(((Context) this).getExternalFilesDir(null), "itehistory.json");
            BufferedReader br = new BufferedReader(new FileReader(traceFile));

            String random = br.lines().collect(Collectors.joining());

            System.out.println(random);

            TextView output = (TextView) findViewById(R.id.teststring);
            output.setText(random);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @OnClick(R.id.toMainFromHistory)
    public void toMainFromInfo() {
        Intent toMain = new Intent(this, MainActivity.class);
        startActivity(toMain);
    }
}

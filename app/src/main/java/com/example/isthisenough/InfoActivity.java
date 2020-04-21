package com.example.isthisenough;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 *  @author Tero Taipalus
 *  This class is for the info view.
 */

public class InfoActivity extends AppCompatActivity {

    /**
     * Creates the view.
     * This screen is for viewing the info of the software.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        ButterKnife.bind(this);
    }

    /**
     * Button for going to Main screen.
     */
    @OnClick(R.id.toMainFromInfo)
    public void toMainFromInfo() {
        Intent toMain = new Intent(this, MainActivity.class);
        startActivity(toMain);
    }
}

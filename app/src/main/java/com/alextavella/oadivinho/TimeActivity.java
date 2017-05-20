package com.alextavella.oadivinho;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;

public class TimeActivity extends AppCompatActivity {

    private TextInputLayout tilName;
    private TextInputLayout tilAge;
    private Spinner spTimes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
        init();
    }

    private void init() {
        tilName = (TextInputLayout) findViewById(R.id.tilName);
        tilAge = (TextInputLayout) findViewById(R.id.tilAge);
        spTimes = (Spinner) findViewById(R.id.spTimes);
    }

    public void register(View v) {
        Intent intentConfirm = new Intent(this, TimeDetailsActivity.class);
        intentConfirm.putExtra("NAME", tilName.getEditText().getText().toString());
        intentConfirm.putExtra("AGE", tilAge.getEditText().getText().toString());
        intentConfirm.putExtra("CLUB", spTimes.getSelectedItem().toString());
        startActivity(intentConfirm);
    }
}

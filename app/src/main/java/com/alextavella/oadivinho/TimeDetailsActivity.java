package com.alextavella.oadivinho;

import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class TimeDetailsActivity extends AppCompatActivity {

    private TextView tvInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_info);
        init();
        bind();
    }

    private void init() {
        tvInfo = (TextView) findViewById(R.id.tvInfo);
    }

    private void bind() {
        if (getIntent() != null) {

            String name = getIntent().getStringExtra("NAME");
            String age = getIntent().getStringExtra("AGE");
            String club = getIntent().getStringExtra("CLUB");

            tvInfo.setText(
                    getString(R.string.time_info_msg_confirm, name, club)
            );
        }
    }
}

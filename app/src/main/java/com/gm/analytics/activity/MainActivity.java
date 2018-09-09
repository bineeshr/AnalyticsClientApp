package com.gm.analytics.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.gm.analytics.R;

import static com.gm.analytics.util.AppUtil.setAlarmManager;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setAlarmManager(this);

    }




}

package com.diabin.festec.example;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class GuideActivity extends AppCompatActivity {

    public static final String FRAGMENT_MODE = "mode";
    public static final int NORMAL_MODE = 1;
    public static final int LAZY_MODE_ = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
    }
}

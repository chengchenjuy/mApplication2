package com.example.lenovo.mapplication.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.lenovo.mapplication.R;

public class baoyang extends AppCompatActivity implements View.OnClickListener {
    private TextView back3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baoyang);
        back3 = findViewById(R.id.back3);
        back3.setOnClickListener(this);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case (R.id.back3):
                finish();
                break;
        }
    }
}
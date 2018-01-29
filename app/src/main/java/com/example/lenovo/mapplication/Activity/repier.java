package com.example.lenovo.mapplication.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.lenovo.mapplication.R;

public class repier extends AppCompatActivity implements View.OnClickListener {
    private TextView back4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repier);
        back4 = findViewById(R.id.back4);
        back4.setOnClickListener(this);
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.back4:
                finish();
                break;
        }
    }
}

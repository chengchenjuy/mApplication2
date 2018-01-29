package com.example.lenovo.mapplication.Activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.mapplication.R;

public class myinfo extends AppCompatActivity implements View.OnClickListener {
    private TextView back2, changename, myname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myinfo);
        back2 = findViewById(R.id.back2);
        back2.setOnClickListener(this);
        changename = findViewById(R.id.changename);
        changename.setOnClickListener(this);
        SharedPreferences na = getSharedPreferences("usernames", Context.MODE_PRIVATE);
        String namer = (String)na.getString("name", "");
        myname = findViewById(R.id.myname);
        myname.setText(namer);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back2:
                finish();
                break;
            case R.id.changename:
                final EditText editText = new EditText(myinfo.this);
                AlertDialog.Builder inputDialog = new AlertDialog.Builder(myinfo.this);
                inputDialog.setTitle("请输入新的昵称").setView(editText);
                inputDialog.setPositiveButton("确定",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                SharedPreferences na = getSharedPreferences("usernames", Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor = na.edit();
                                editor.putString("name", editText.getText().toString());
                                editor.commit();
                                String namer = na.getString("name", "");
                                myname.setText(""+ namer);

                            }
                        }).show();


                break;

        }
    }



}

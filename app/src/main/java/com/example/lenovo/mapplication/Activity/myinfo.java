package com.example.lenovo.mapplication.Activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.mapplication.R;

import java.text.SimpleDateFormat;



public class myinfo extends AppCompatActivity implements View.OnClickListener {
    private TextView back2, changename, myname;
    private LinearLayout Useract2;
private Button bangding;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myinfo);
        back2 = findViewById(R.id.back2);
        back2.setOnClickListener(this);
        changename = findViewById(R.id.changename);
        changename.setOnClickListener(this);
        bangding = findViewById(R.id.bangding);
        bangding.setOnClickListener(this);
        Useract2 = findViewById(R.id.Useract2);
        SharedPreferences na = getSharedPreferences("usernames", Context.MODE_PRIVATE);
        String namer = (String)na.getString("name", "游客");
        myname = findViewById(R.id.myname);
        if(!namer.equals("")) {
            myname.setText(namer);
        }else {
            myname.setText("游客");
        }




    }


    //设置导航栏隐藏和滑动呼出

    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            hideSystemUI();
        }
    }

    private void showSystemUI() {
        Useract2.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }

    private void hideSystemUI() {
        Useract2.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
//                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back2:
                Intent intent = new Intent(this, UserActivity.class);
                startActivity(intent);
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
                                String namer = na.getString("name", "游客");
                                if(!namer.equals("")) {
                                    myname.setText(namer);
                                }else {
                                    myname.setText("游客");
                                }

                            }
                        }).show();


                break;
            case R.id.bangding:
                Intent intent3 = new Intent(this,CarReg.class);
                startActivity(intent3);

        }
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent intent = new Intent(this, UserActivity.class);
            startActivity(intent);
            finish();
        }
        return true;
    }

}

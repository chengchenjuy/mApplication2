package com.example.lenovo.mapplication.Activity;

import android.app.Activity;
import android.app.LauncherActivity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.lenovo.mapplication.R;

public class launcher extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //加载启动界面
        setContentView(R.layout.activity_launcher);
        Integer time = 3000;    //设置等待时间，单位为毫秒
        Handler handler = new Handler();
        //当计时结束时，跳转至主界面
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(launcher.this,MainActivity.class);
                launcher.this.finish();
                startActivity(intent);
                //startActivity(new Intent(launcher.this, MainActivity.class));

            }
        }, time);
    }
}


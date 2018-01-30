package com.example.lenovo.mapplication.Activity;

import android.app.Activity;
import android.app.LauncherActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.lenovo.mapplication.R;

import java.text.SimpleDateFormat;

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

//        SimpleDateFormat nian = new SimpleDateFormat("yyyy");
//        String datenian = nian.format(new java.util.Date());
//        SharedPreferences timenian = getSharedPreferences("nian", Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = timenian.edit();
//        editor.putString("nian1", datenian);
//        editor.commit();
//        //获取年份
//        SimpleDateFormat yue = new SimpleDateFormat("MM");
//        String dateyue = yue.format(new java.util.Date());
//        SharedPreferences timeyue = getSharedPreferences("yue", Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor2 = timeyue.edit();
//        editor2.putString("yue1", dateyue);
//        editor2.commit();
//        //获取月份
//        SimpleDateFormat ri = new SimpleDateFormat("dd");
//        String dateri = ri.format(new java.util.Date());
//        SharedPreferences timeri = getSharedPreferences("ri", Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor3 = timeri.edit();
//        editor3.putString("ri1", dateri);
//        editor3.commit();
//        //获取日份
    }
}


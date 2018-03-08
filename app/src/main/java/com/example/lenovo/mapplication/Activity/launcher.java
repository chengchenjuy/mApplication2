package com.example.lenovo.mapplication.Activity;

import android.Manifest;
import android.app.Activity;
import android.app.LauncherActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.example.lenovo.mapplication.R;

import java.io.File;
import java.text.SimpleDateFormat;


public class launcher extends Activity {
    private LinearLayout Useract5;
    private long exitTime = 0;
    String dir = Environment.getExternalStorageDirectory().getAbsolutePath() + "/carfh/image/";

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK
                && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {

//                Toast.makeText(getApplicationContext(), "应用正在加载中...", Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
//                Toast.makeText(getApplicationContext(), "应用正在加载中...", Toast.LENGTH_SHORT).show();
            }
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //动态申请权限
        if (Build.VERSION.SDK_INT >= 23) {
            int REQUEST_CODE_CONTACT = 101;
            String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
            //验证是否许可权限
            for (String str : permissions) {
                if (this.checkSelfPermission(str) != PackageManager.PERMISSION_GRANTED) {
                    //申请权限
                    this.requestPermissions(permissions, REQUEST_CODE_CONTACT);
                    return;
                }
            }
        }

//创建相册目录
        File file = new File(dir);
        file.mkdirs();



        SharedPreferences caca = getSharedPreferences("login", Context.MODE_PRIVATE);
        String dada = caca.getString("co", "");
        //加载启动界面
        if (dada.equals("yes")) {
            setContentView(R.layout.activity_launcher);
            Integer time = 3000;    //设置等待时间，单位为毫秒
            Handler handler = new Handler();
            //当计时结束时，跳转至主界面
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(launcher.this, UserActivity.class);
                    launcher.this.finish();
                    startActivity(intent);
                    //startActivity(new Intent(launcher.this, MainActivity.class));

                }
            }, time);
        } else {
            setContentView(R.layout.activity_launcher);
            Integer time = 3000;    //设置等待时间，单位为毫秒
            Handler handler = new Handler();
            //当计时结束时，跳转至主界面
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(launcher.this, MainActivity.class);
                    launcher.this.finish();
                    startActivity(intent);
                }
            },time);
        }



    }


    //设置导航栏隐藏和滑动呼出

    public void onWindowFocusChanged(boolean hasFocus) {
        Useract5 = findViewById(R.id.Useract5);
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            hideSystemUI();
        }
    }

    private void showSystemUI() {
        Useract5.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }

    private void hideSystemUI() {
        Useract5.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
//                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }
}

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
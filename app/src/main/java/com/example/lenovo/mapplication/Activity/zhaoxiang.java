package com.example.lenovo.mapplication.Activity;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.lenovo.mapplication.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class zhaoxiang extends AppCompatActivity {
    private Button btn_takephoto, choosephoto, btn_back;
    private ImageView nearview;
    private final static int TAKE_PHOTO = 100;
    private final static int CHOOSE_PHOTO = 200;
    String dir = Environment.getExternalStorageDirectory().getAbsolutePath() + "/carfh/image/";
    private Uri imageUri, uri;
    private String mFilePath;
    private FileInputStream is = null;

    @TargetApi(18)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhaoxiang);
        btn_takephoto = findViewById(R.id.btn_takephoto);
        btn_back = findViewById(R.id.btn_back);
        nearview = findViewById(R.id.nearview);
        //加载最后一张图片路径
        SharedPreferences uuri = getSharedPreferences("imageuri", Context.MODE_PRIVATE);
        String uri = uuri.getString("uris", "");
        Uri ui = Uri.parse(uri);
        //设置图片
        nearview.setImageURI(ui);

        // android 7.0系统解决拍照的问题
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
        builder.detectFileUriExposure();
        //创建以系统时间命名的文件
        Calendar now = new GregorianCalendar();
        SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy_MM_dd_HH_mmss", Locale.getDefault());
        String fileName = simpleDate.format(now.getTime());
        mFilePath = dir + fileName + ".jpg";
        //设置按钮点击事件
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btn_takephoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
        //调用系统相机，将输入流写入指定文件
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                Uri uri = Uri.fromFile(new File(mFilePath));
                cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
                startActivityForResult(cameraIntent, TAKE_PHOTO);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == TAKE_PHOTO && resultCode == RESULT_OK) {

            try {
                // 获取输入流
                is = new FileInputStream(mFilePath);
                // 把流解析成bitmap
                Bitmap bitmap = BitmapFactory.decodeStream(is);
                // 设置图片
                nearview.setImageBitmap(bitmap);
                //记录最后一张图片路径
                SharedPreferences imageuri = getSharedPreferences("imageuri", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = imageuri.edit();
                editor.putString("uris", mFilePath);
                editor.commit();
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } finally {
                // 关闭流
                try {
                    is.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }


        }
    }
}









package com.example.lenovo.mapplication.Activity;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.lenovo.mapplication.JavaUtils.takephotoutils;
import com.example.lenovo.mapplication.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import static android.media.MediaRecorder.VideoSource.CAMERA;

public class zhaoxiang extends AppCompatActivity {
    private Button btn_takephoto, choosephoto;
    private ImageView nearview;
    private final static int TAKE_PHOTO = 100;
    private final static int CHOOSE_PHOTO = 200;
    String dir = Environment.getExternalStorageDirectory().getAbsolutePath() + "/carfh/image/";
    private Uri imageUri, uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhaoxiang);
        btn_takephoto = findViewById(R.id.btn_takephoto);
        nearview = findViewById(R.id.nearview);

        btn_takephoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);

                startActivityForResult(cameraIntent, TAKE_PHOTO);
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == TAKE_PHOTO && resultCode == RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            nearview.setImageBitmap(photo);
            Calendar now = new GregorianCalendar();
            SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy_MM_dd_HH_mmss", Locale.getDefault());
            String fileName = simpleDate.format(now.getTime());



                        try {
                File file = new File(dir + fileName +".jpg");
                Log.i("uri","---------------"+file);
                FileOutputStream out = new FileOutputStream(file);
                Log.i("uri","---------------"+out);
                photo.compress(Bitmap.CompressFormat.JPEG, 100, out);
                out.flush();
                out.close();
                Log.i("uri","debug");
                Uri uri = Uri.fromFile(file);
                sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, uri));
                Log.i("uri","---------------"+uri);
            } catch (Exception e) {
                e.printStackTrace();
            }

//            void takePhoto(String cameraPhotoPath) {
//                File cameraPhoto = new File(cameraPhotoPath);
//                Intent takePhotoIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                Uri photoUri = FileProvider.getUriForFile(
//                        this,
//                        getPackageName() + ".provider",
//                        cameraPhoto);
//                takePhotoIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);
//                startActivityForResult(takePhotoIntent, REQUEST_TAKE_PHOTO);
//            }


        }
    }
}









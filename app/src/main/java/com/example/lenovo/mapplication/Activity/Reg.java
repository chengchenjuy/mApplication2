package com.example.lenovo.mapplication.Activity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lenovo.mapplication.R;

/**
 * Created by Lenovo on 2018/1/22.
 */

public class Reg extends AppCompatActivity implements View.OnClickListener {

    private Button back, btn_yanzheng, btn_qurenreg;
    private EditText phonenumber, zhuce1, zhuce2, yanzheng;
    private String yzm;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reg);
        back = findViewById(R.id.btn_back);
        back.setOnClickListener(this);
        btn_yanzheng = findViewById(R.id.btn_yanzheng);
        btn_yanzheng.setOnClickListener(this);
        btn_qurenreg = findViewById(R.id.btn_querenreg);
        btn_qurenreg.setOnClickListener(this);
        phonenumber = findViewById(R.id.phonenumber);
        zhuce1 = findViewById(R.id.et_zhuce1);
        zhuce2 = findViewById(R.id.et_zhuce2);
        yanzheng = findViewById(R.id.yanzheng);


    }

//    String passw = null ;

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                Log.i("msg", "msg--------->");

                finish();
                break;
            case R.id.btn_yanzheng:
                Log.i("msg", "------>>");


                int suijishu = (int) ((Math.random() * 9 + 1) * 100000);
                yzm = Integer.toString(suijishu);


                //实例化通知管理器
                NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                //实例化通知
                NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
                builder.setContentTitle("您获得的验证码");//设置通知标题
                builder.setContentText("" + yzm);//设置通知内容
                builder.setDefaults(NotificationCompat.DEFAULT_ALL);//设置通知的方式，震动、LED灯、音乐等
                builder.setAutoCancel(true);//点击通知后，状态栏自动删除通知
                builder.setSmallIcon(android.R.drawable.ic_media_play);//设置小图标
                builder.setContentIntent(PendingIntent.getActivity(this, 0x102, new Intent(this, Reg.class), 0));//设置点击通知后将要启动的程序组件对应的PendingIntent
                Notification notification = builder.build();

                //发送通知
                notificationManager.notify(0x101, notification);

                new CountDownTimer(60000, 1000) {

                    @Override
                    public void onTick(long l) {
                        //Log.i("msg", "还剩: " + l / 1000 + "秒，重新发送");
                        btn_yanzheng.setText(l / 1000 + "秒后重新发送");
                        btn_yanzheng.setEnabled(false);

                    }

                    @Override
                    public void onFinish() {
                        btn_yanzheng.setText("重新发送");
                        btn_yanzheng.setEnabled(true);
                    }
                }.start();
                break;
            case R.id.btn_querenreg:

//                Log.i("msg","------------------>"+yzm);
//                Log.i("msg","------------------>"+yanzheng.getText().toString());
                if (phonenumber.getText().toString().length() != 11) {
                    Toast.makeText(this, "请输入有效的手机号！", Toast.LENGTH_LONG).show();
                } else if (zhuce1.getText().toString().length() < 6 & zhuce2.getText().toString().length() < 6) {
                    Toast.makeText(this, "密码长度不能小于6位！", Toast.LENGTH_LONG).show();
                } else if (!zhuce1.getText().toString().equals(zhuce2.getText().toString())) {
                    Toast.makeText(this, "两次密码输入不一致！", Toast.LENGTH_LONG).show();
                } else if (!yanzheng.getText().toString().equals(yzm + "")) {
                    Toast.makeText(this, "验证码错误！", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(this, "注册成功！请返回登录", Toast.LENGTH_LONG).show();

//                    Intent intent2 = new Intent(this, UserActivity.class);
//                    startActivity(intent2);
                    SharedPreferences sp = getSharedPreferences("userinfomation", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("phone", phonenumber.getText().toString());
                    editor.putString("password", zhuce2.getText().toString());
                    editor.commit();
//                    Log.i("mag","=============>"+ sp.getString("phone",null));
                    finish();
                }
                break;
        }
    }

}





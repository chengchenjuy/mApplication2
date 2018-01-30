package com.example.lenovo.mapplication.Activity;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.mapplication.R;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;
import com.jude.rollviewpager.hintview.ColorPointHintView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.example.lenovo.mapplication.R.id;
import static com.example.lenovo.mapplication.R.layout;
import static com.example.lenovo.mapplication.R.mipmap;

public class UserActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private ImageView btn_xiala, menu, baoyang;
    private LinearLayout xiala2, baoyng, weixiu, jiyou, lingjian, wheel, bbs, fenxiang, jianding;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private RollPagerView mRollViewPager;
    private TextView username, baoyangtime, baoyangxiangmu, baoyangcishu, shanglu,driverkm;
    private CheckBox cbJantou;
    private String texts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_user);
//        initWindow();

        shanglu = findViewById(id.shanglu);
        drawerLayout = (DrawerLayout) findViewById(id.activity_na);
        navigationView = (NavigationView) findViewById(id.nav);
        menu = (ImageView) findViewById(id.btn_xiala);
        btn_xiala = findViewById(id.btn_xiala);
        View headerView = navigationView.getHeaderView(0);//获取头布局
        btn_xiala.setOnClickListener(this);
        xiala2 = findViewById(id.xiala2);
        baoyng = findViewById(id.baoyng);
        baoyng.setOnClickListener(this);
        cbJantou = findViewById(R.id.jiantou);
        cbJantou.setOnCheckedChangeListener(this);
        weixiu = findViewById(id.weixiu);
        weixiu.setOnClickListener(this);
        jiyou = findViewById(id.jiyou);
        jiyou.setOnClickListener(this);
        lingjian = findViewById(id.lingjian);
        lingjian.setOnClickListener(this);
        wheel = findViewById(id.wheel);
        wheel.setOnClickListener(this);
        bbs = findViewById(id.bbs);
        bbs.setOnClickListener(this);
        fenxiang = findViewById(id.fenxiang);
        fenxiang.setOnClickListener(this);
        jianding = findViewById(id.jianding);
        jianding.setOnClickListener(this);
        baoyangtime = findViewById(R.id.baoyangtime);
        baoyangxiangmu = findViewById(id.baoyangxiangmu);
        baoyangcishu = findViewById(id.baoyangcishu);
        driverkm = findViewById(id.driverkm);
        SharedPreferences na = getSharedPreferences("usernames", Context.MODE_PRIVATE);
        String namer = na.getString("name", "");
        Log.i("msg", "-=-=-=-=-=->" + namer);
        TextView username = navigationView.getHeaderView(0).findViewById(id.username);
        username.setText(namer);
        SharedPreferences time = getSharedPreferences("shijian", Context.MODE_PRIVATE);
        String t = time.getString("sj", "");
        baoyangtime.setText("上次保养日期：" + t);
        //获取保养日期
        SharedPreferences cs = getSharedPreferences("c19", Context.MODE_PRIVATE);
        int css = cs.getInt("d19", 0);
        baoyangcishu.setText("总计保养次数：" + css + "次");
        SharedPreferences a1 = getSharedPreferences("c1", Context.MODE_PRIVATE);
        String a = a1.getString("d1", "");
        SharedPreferences a2 = getSharedPreferences("c2", Context.MODE_PRIVATE);
        String b = a2.getString("d2", "");
        SharedPreferences a3 = getSharedPreferences("c3", Context.MODE_PRIVATE);
        String c = a3.getString("d3", "");
        SharedPreferences a4 = getSharedPreferences("c4", Context.MODE_PRIVATE);
        String d = a4.getString("d4", "");
        SharedPreferences a5 = getSharedPreferences("c5", Context.MODE_PRIVATE);
        String e = a5.getString("d5", "");
        SharedPreferences a6 = getSharedPreferences("c6", Context.MODE_PRIVATE);
        String f = a6.getString("d6", "");
        SharedPreferences a7 = getSharedPreferences("c7", Context.MODE_PRIVATE);
        String g = a7.getString("d7", "");
        SharedPreferences a8 = getSharedPreferences("c8", Context.MODE_PRIVATE);
        String h = a8.getString("d8", "");
        SharedPreferences a9 = getSharedPreferences("c9", Context.MODE_PRIVATE);
        String i = a9.getString("d9", "");
        SharedPreferences a11 = getSharedPreferences("c11", Context.MODE_PRIVATE);
        String j = a11.getString("d11", "");
        SharedPreferences a12 = getSharedPreferences("c12", Context.MODE_PRIVATE);
        String k = a12.getString("d12", "");
        SharedPreferences a13 = getSharedPreferences("c13", Context.MODE_PRIVATE);
        String l = a13.getString("d13", "");
        SharedPreferences a14 = getSharedPreferences("c14", Context.MODE_PRIVATE);
        String m = a14.getString("d14", "");
        SharedPreferences a15 = getSharedPreferences("c15", Context.MODE_PRIVATE);
        String n = a15.getString("d15", "");
        SharedPreferences a16 = getSharedPreferences("c16", Context.MODE_PRIVATE);
        String o = a16.getString("d16", "");
        SharedPreferences a17 = getSharedPreferences("c17", Context.MODE_PRIVATE);
        String p = a17.getString("d17", "");
        SharedPreferences a18 = getSharedPreferences("c18", Context.MODE_PRIVATE);
        String q = a18.getString("d18","");

        texts = a + b + c + d + e + f + g + h + i + j + k + l + m + n + o + p +q;
        baoyangxiangmu.setText("上次保养项目：" + texts);


        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date d1 = df.parse(df.format(new java.util.Date()));
            Date d2 = df.parse("2015-10-24");
            long diff = d1.getTime() - d2.getTime();//这样得到的差值是微秒级别
            long days = diff / (1000 * 60 * 60 * 24);
            shanglu.setText("" + days);
            long km = days*70;
            driverkm.setText("预估行驶里程："+km+"公里(km)");

        } catch (Exception ee) {
        }//获取时间差



//        int year = 2014;
//        int month = 6;
//        int day = 13;
//        SharedPreferences n1 = getSharedPreferences("nian", Context.MODE_PRIVATE);
//        String nian1 = n1.getString("nian1", "");
//        SharedPreferences n2 = getSharedPreferences("yue", Context.MODE_PRIVATE);
//        String yue2 = n2.getString("yue1", "");
//        SharedPreferences n3 = getSharedPreferences("ri", Context.MODE_PRIVATE);
//        String ri3 = n3.getString("ri1", "");//获取年月日
//
//        int cc1 = Integer.parseInt(nian1) - year;
//        int nianchazhi = cc1*365;
//        int cc2 = Integer.parseInt(yue2) - month;
//        int cc3 = Integer.parseInt(ri3) - day;


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case id.tuichu:
//                        System.exit(0);
//                        Intent intent = new Intent(UserActivity.this, MainActivity.class);
//                        startActivity(intent);
                        AlertDialog.Builder alertbBuilder = new AlertDialog.Builder(UserActivity.this);
                        alertbBuilder.setTitle("提示").setMessage("确认退出？").setPositiveButton("确定", new DialogInterface.OnClickListener() {


                            public void onClick(DialogInterface dialog, int which) {
                                //确定后要执行的语句
                                //结束这个Activity
                                UserActivity.this.finish();
                            }
                        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {


                            public void onClick(DialogInterface dialog, int which) {
//取消后要执行的语句
//取消
                                dialog.cancel();

                            }
                        }).create();
                        alertbBuilder.show();
                        break;
                    case id.myinf:
                        Intent intent1 = new Intent(UserActivity.this, myinfo.class);
                        startActivity(intent1);
                        finish();
                        break;
                    case id.report:
                        Intent intent2 = new Intent(UserActivity.this, BaoyangReport.class);
                        startActivity(intent2);

                }
                item.setChecked(true);
                Toast.makeText(UserActivity.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                drawerLayout.closeDrawer(navigationView);
                return true;
            }


        });


        mRollViewPager = (RollPagerView) findViewById(id.gggd);

        //设置播放时间间隔
        mRollViewPager.setPlayDelay(3000);
        //设置透明度
        mRollViewPager.setAnimationDurtion(500);
        //设置适配器
        mRollViewPager.setAdapter(new TestNormalAdapter());

        //设置指示器（顺序依次）
        //自定义指示器图片
        //设置圆点指示器颜色
        //设置文字指示器
        //隐藏指示器
        //mRollViewPager.setHintView(new IconHintView(this, R.drawable.point_focus, R.drawable.point_normal));
        mRollViewPager.setHintView(new ColorPointHintView(this, Color.YELLOW, Color.WHITE));
        //mRollViewPager.setHintView(new TextHintView(this));
        //mRollViewPager.setHintView(null);
    }





    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        switch (compoundButton.getId()) {
            case id.jiantou:

                if (b) {
                    xiala2.setVisibility(View.VISIBLE);
                } else {
                    xiala2.setVisibility(View.GONE);
                }

                break;
        }

    }


    private class TestNormalAdapter extends StaticPagerAdapter {
        private int[] imgs = {
                mipmap.gg1,
                mipmap.gg2,
                mipmap.gg3,
                mipmap.gg4,
        };


        @Override
        public View getView(ViewGroup container, int position) {
            ImageView view = new ImageView(container.getContext());
            view.setImageResource(imgs[position]);
            view.setScaleType(ImageView.ScaleType.CENTER_CROP);
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            return view;
        }


        @Override
        public int getCount() {
            return imgs.length;
        }
    }


    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case id.btn_xiala:
                SharedPreferences na = getSharedPreferences("usernames", Context.MODE_PRIVATE);
                String namer = na.getString("name", "");
                TextView username = navigationView.getHeaderView(0).findViewById(id.username);
                username.setText(namer);
                baoyangxiangmu.setText("上次保养项目：" + texts);
                SharedPreferences time = getSharedPreferences("shijian", Context.MODE_PRIVATE);
                String t = time.getString("sj", "");
                baoyangtime.setText("上次保养日期：" + t);

                Log.i("msg", "---------->");
                if (drawerLayout.isDrawerOpen(navigationView)) {
                    drawerLayout.closeDrawer(navigationView);
                } else {
                    drawerLayout.openDrawer(navigationView);
                }
                break;

            case id.baoyng:
                Intent intent3 = new Intent(this, BaoyangList.class);
                startActivity(intent3);
                finish();
                break;
            case id.weixiu:
                Intent intent4 = new Intent(this, repier.class);
                startActivity(intent4);
                break;
            case id.jiyou:
                Toast.makeText(getApplicationContext(), "该功能尚未开放，尽请期待", Toast.LENGTH_LONG).show();
                break;
            case id.lingjian:
                Intent intent = new Intent(this,baoyang.class);
                startActivity(intent);
                break;
            case id.wheel:
                Toast.makeText(getApplicationContext(), "该功能尚未开放，尽请期待", Toast.LENGTH_LONG).show();
                break;
            case id.fenxiang:
                Toast.makeText(getApplicationContext(), "该功能尚未开放，尽请期待", Toast.LENGTH_LONG).show();
                break;
            case id.bbs:
                Toast.makeText(getApplicationContext(), "该功能尚未开放，尽请期待", Toast.LENGTH_LONG).show();
                break;
            case id.jianding:
                Toast.makeText(getApplicationContext(), "该功能尚未开放，尽请期待", Toast.LENGTH_LONG).show();
                break;

        }
    }

//    private void initWindow() {//初始化窗口属性，让状态栏和导航栏透明
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
//            tintManager = new SystemBarTintManager(this);
//            int statusColor = Color.parseColor("#1976d2");
//            tintManager.setStatusBarTintColor(statusColor);
//            tintManager.setStatusBarTintEnabled(true);
//        }
//    }


    private long exitTime2 = 0;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK
                && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime2) > 2000) {

                Toast.makeText(getApplicationContext(), "再按一次退出车凤凰", Toast.LENGTH_LONG).show();
                exitTime2 = System.currentTimeMillis();
            } else {
                System.exit(0);
            }
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }


}

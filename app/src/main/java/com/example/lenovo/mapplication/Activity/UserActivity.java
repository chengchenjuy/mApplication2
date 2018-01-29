package com.example.lenovo.mapplication.Activity;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.Button;
import android.widget.TextView;

import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;
import com.jude.rollviewpager.hintview.ColorPointHintView;

import com.example.lenovo.mapplication.R;

import static com.example.lenovo.mapplication.R.*;

public class UserActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private ImageView btn_xiala, btn_user, menu, baoyang;
    private LinearLayout xiala2, baoyng, weixiu, jiyou, lingjian, wheel, bbs, fenxiang, jianding;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private RollPagerView mRollViewPager;
    private TextView username;
    private CheckBox cbJantou;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_user);
//        initWindow();

        btn_user = findViewById(id.btn_user);
        btn_user.setOnClickListener(this);
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

        SharedPreferences na = getSharedPreferences("usernames", Context.MODE_PRIVATE);
        String namer =na.getString("name", "");
        Log.i("msg","-=-=-=-=-=->" +namer);
        TextView username = navigationView.getHeaderView(0).findViewById(id.username);
        username.setText(namer);


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
                        break;
                    case id.report:
                        Intent intent2 = new Intent(UserActivity.this,BaoyangReport.class);
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
                String namer =na.getString("name", "");
                TextView username = navigationView.getHeaderView(0).findViewById(id.username);
                username.setText(namer);

                Log.i("msg", "---------->");
                if (drawerLayout.isDrawerOpen(navigationView)) {
                    drawerLayout.closeDrawer(navigationView);
                } else {
                    drawerLayout.openDrawer(navigationView);
                }
                break;
            case id.btn_user:
                Intent intent2 = new Intent(this, myinfo.class);
                startActivity(intent2);
                break;
            case id.baoyng:
                Intent intent3 = new Intent(this, BaoyangList.class);
                startActivity(intent3);
                break;
            case id.weixiu:
                Intent intent4 = new Intent(this, repier.class);
                startActivity(intent4);
                break;
            case id.jiyou:
                Toast.makeText(getApplicationContext(), "该功能尚未开放，尽请期待", Toast.LENGTH_LONG).show();
                break;
            case id.lingjian:
                Toast.makeText(getApplicationContext(), "该功能尚未开放，尽请期待", Toast.LENGTH_LONG).show();
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

                Toast.makeText(getApplicationContext(), "再按一次返回登录", Toast.LENGTH_LONG).show();
                exitTime2 = System.currentTimeMillis();
            } else {
                System.exit(0);
            }
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }


}

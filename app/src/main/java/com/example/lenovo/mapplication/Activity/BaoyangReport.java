package com.example.lenovo.mapplication.Activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.lenovo.mapplication.R;

import java.util.ArrayList;
import java.util.List;

public class BaoyangReport extends AppCompatActivity implements View.OnClickListener {
    private TextView back6, t1, t2, t3, t4, t5, t6, t7, t8, t9, t11, t12, t13, t14, t15, t16, t17, t18,t19;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baoyang_report);
        back6 = findViewById(R.id.back6);
        back6.setOnClickListener(this);
        t1 = findViewById(R.id.t1);
        t2 = findViewById(R.id.t2);
        t3 = findViewById(R.id.t3);
        t4 = findViewById(R.id.t4);
        t5 = findViewById(R.id.t5);
        t6 = findViewById(R.id.t6);
        t7 = findViewById(R.id.t7);
        t8 = findViewById(R.id.t8);
        t9 = findViewById(R.id.t9);
        t11 = findViewById(R.id.t11);
        t12 = findViewById(R.id.t12);
        t13 = findViewById(R.id.t13);
        t14 = findViewById(R.id.t14);
        t15 = findViewById(R.id.t15);
        t16 = findViewById(R.id.t16);
        t17 = findViewById(R.id.t17);
        t18 = findViewById(R.id.t18);
        t19 = findViewById(R.id.t19);
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
        SharedPreferences time = getSharedPreferences("shijian", Context.MODE_PRIVATE);
        String t = time.getString("sj","");

//        texts = a + b + c + d + e + f + g + h + i + j + k + l + m + n + o + p;
        if (a != "" | b != "" | c != "" | d != "" | e != "" | f != "" | g != "" | h != "" | i != "" | j != "" | k != "" | l != "" | m != "" | n != "" | o != "" | p != ""|q != "") {
            t1.setText("上次的保养时间为"+t+"\n"+"          保养项目：");
        } else {
            t1.setText("暂无保养记录");
        }
        if (a !=""){
            t2.setText(a);
        }else{
            t2.setVisibility(View.GONE);
        }
        if (b !=""){
            t3.setText(b);
        }else{
            t3.setVisibility(View.GONE);
        }
        if (c !=""){
            t4.setText(c);
        }else{
            t4.setVisibility(View.GONE);
        }
        if (d !=""){
            t5.setText(d);
        }else{
            t5.setVisibility(View.GONE);
        }
        if (e !=""){
            t6.setText(e);
        }else{
            t6.setVisibility(View.GONE);
        }
        if (f !=""){
            t7.setText(f);
        }else{
            t7.setVisibility(View.GONE);
        }
        if (g !=""){
            t8.setText(g);
        }else{
            t8.setVisibility(View.GONE);
        }
        if (h !=""){
            t9.setText(h);
        }else{
            t9.setVisibility(View.GONE);
        }
        if (i !=""){
            t11.setText(i);
        }else{
            t11.setVisibility(View.GONE);
        }
        if (j !=""){
            t12.setText(j);
        }else{
            t12.setVisibility(View.GONE);
        }
        if (k !=""){
            t13.setText(k);
        }else{
            t13.setVisibility(View.GONE);
        }
        if (l !=""){
            t14.setText(l);
        }else{
            t14.setVisibility(View.GONE);
        }
        if (m !=""){
            t15.setText(m);
        }else{
            t15.setVisibility(View.GONE);
        }
        if (n !=""){
            t16.setText(n);
        }else{
            t16.setVisibility(View.GONE);
        }
        if (o !=""){
            t17.setText(o);
        }else{
            t17.setVisibility(View.GONE);
        }
        if (p !=""){
            t18.setText(p);
        }else{
            t18.setVisibility(View.GONE);
        }
        if (q !=""){
            t19.setText("备注信息："+"\n"+"\n"+q);
        }else{
            t19.setVisibility(View.GONE);
        }
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back6:
                finish();
                break;
        }
    }
}
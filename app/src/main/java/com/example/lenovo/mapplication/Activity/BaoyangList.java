package com.example.lenovo.mapplication.Activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.mapplication.R;

import java.text.SimpleDateFormat;

public class BaoyangList extends AppCompatActivity implements View.OnClickListener {
    private Button tijiao;
    private TextView back5;
    private CheckBox checkBox, checkBox2, checkBox3, checkBox4, checkBox5, checkBox6, checkBox7, checkBox8, checkBox9;
    private CheckBox checkBox11, checkBox12, checkBox13, checkBox14, checkBox15, checkBox16, checkBox17;
    private EditText beizhu;
    private int BaoYangTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baoyang_list);
        tijiao = findViewById(R.id.tijiao);
        tijiao.setOnClickListener(this);
        beizhu = findViewById(R.id.beizhu);
        back5 = findViewById(R.id.back5);
        back5.setOnClickListener(this);
        checkBox = findViewById(R.id.checkBox);
        checkBox2 = findViewById(R.id.checkBox2);
        checkBox3 = findViewById(R.id.checkBox3);
        checkBox4 = findViewById(R.id.checkBox4);
        checkBox5 = findViewById(R.id.checkBox5);
        checkBox6 = findViewById(R.id.checkBox6);
        checkBox7 = findViewById(R.id.checkBox7);
        checkBox8 = findViewById(R.id.checkBox8);
        checkBox9 = findViewById(R.id.checkBox9);
        checkBox11 = findViewById(R.id.checkBox11);
        checkBox12 = findViewById(R.id.checkBox12);
        checkBox13 = findViewById(R.id.checkBox13);
        checkBox14 = findViewById(R.id.checkBox14);
        checkBox15 = findViewById(R.id.checkBox15);
        checkBox16 = findViewById(R.id.checkBox16);
        checkBox17 = findViewById(R.id.checkBox17);


    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back5:
                Intent intent = new Intent(this, UserActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.tijiao:


                if (checkBox.isChecked() | checkBox2.isChecked() | checkBox3.isChecked() | checkBox4.isChecked() | checkBox5.isChecked() | checkBox6.isChecked() | checkBox7.isChecked() | checkBox8.isChecked() | checkBox9.isChecked() | checkBox11.isChecked() | checkBox12.isChecked() | checkBox13.isChecked() | checkBox14.isChecked() | checkBox15.isChecked() | checkBox16.isChecked() | checkBox17.isChecked() | !beizhu.getText().toString().equals("")) {


                    AlertDialog.Builder alertbBuilder = new AlertDialog.Builder(BaoyangList.this);
                    alertbBuilder.setTitle("提示").setMessage("确认提交？").setPositiveButton("确定", new DialogInterface.OnClickListener() {


                        public void onClick(DialogInterface dialog, int which) {
                            //确定后要执行的语句
                            //结束这个Activity


                            if (checkBox.isChecked()) {

                                SharedPreferences a1 = getSharedPreferences("c1", Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor = a1.edit();
                                editor.putString("d1", checkBox.getText().toString());
                                editor.commit();
//                    String a = a1.getString("d1", "");
                                Toast.makeText(getApplicationContext(), "提交成功", Toast.LENGTH_LONG).show();
//                    Log.i("mmg", "..........." + a);


                            } else {
                                SharedPreferences a1 = getSharedPreferences("c1", Context.MODE_PRIVATE);
                                a1.edit().clear().commit();
//                    String a = a1.getString("d1", "");
//                    Log.i("mmg", "..........." + a);
                            }
                            if (checkBox2.isChecked()) {
                                SharedPreferences a2 = getSharedPreferences("c2", Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor = a2.edit();
                                editor.putString("d2", checkBox2.getText().toString());
                                editor.commit();
                                Toast.makeText(getApplicationContext(), "提交成功", Toast.LENGTH_LONG).show();
//                    String a = a2.getString("d2", "");
//                    Log.i("mmg", "..........." + a);
                            } else {
                                SharedPreferences a2 = getSharedPreferences("c2", Context.MODE_PRIVATE);
                                a2.edit().clear().commit();
//                    String a = a2.getString("d2", "");
//                    Log.i("mmg", "..........." + a);
                            }
                            if (checkBox3.isChecked()) {
                                SharedPreferences a3 = getSharedPreferences("c3", Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor = a3.edit();
                                editor.putString("d3", checkBox3.getText().toString());
                                editor.commit();
                                Toast.makeText(getApplicationContext(), "提交成功", Toast.LENGTH_LONG).show();

                            } else {
                                SharedPreferences a3 = getSharedPreferences("c3", Context.MODE_PRIVATE);
                                a3.edit().clear().commit();
                            }
                            if (checkBox4.isChecked()) {
                                SharedPreferences a4 = getSharedPreferences("c4", Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor = a4.edit();
                                editor.putString("d4", checkBox4.getText().toString());
                                editor.commit();
                                Toast.makeText(getApplicationContext(), "提交成功", Toast.LENGTH_LONG).show();

                            } else {
                                SharedPreferences a4 = getSharedPreferences("c4", Context.MODE_PRIVATE);
                                a4.edit().clear().commit();
                            }
                            if (checkBox5.isChecked()) {
                                SharedPreferences a5 = getSharedPreferences("c5", Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor = a5.edit();
                                editor.putString("d5", checkBox5.getText().toString());
                                editor.commit();
                                Toast.makeText(getApplicationContext(), "提交成功", Toast.LENGTH_LONG).show();

                            } else {
                                SharedPreferences a5 = getSharedPreferences("c5", Context.MODE_PRIVATE);
                                a5.edit().clear().commit();
                            }
                            if (checkBox6.isChecked()) {
                                SharedPreferences a6 = getSharedPreferences("c6", Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor = a6.edit();
                                editor.putString("d6", checkBox6.getText().toString());
                                editor.commit();
                                Toast.makeText(getApplicationContext(), "提交成功", Toast.LENGTH_LONG).show();

                            } else {
                                SharedPreferences a6 = getSharedPreferences("c6", Context.MODE_PRIVATE);
                                a6.edit().clear().commit();
                            }
                            if (checkBox7.isChecked()) {
                                SharedPreferences a7 = getSharedPreferences("c7", Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor = a7.edit();
                                editor.putString("d7", checkBox7.getText().toString());
                                editor.commit();
                                Toast.makeText(getApplicationContext(), "提交成功", Toast.LENGTH_LONG).show();

                            } else {
                                SharedPreferences a7 = getSharedPreferences("c7", Context.MODE_PRIVATE);
                                a7.edit().clear().commit();
                            }
                            if (checkBox8.isChecked()) {
                                SharedPreferences a8 = getSharedPreferences("c8", Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor = a8.edit();
                                editor.putString("d8", checkBox8.getText().toString());
                                editor.commit();
                                Toast.makeText(getApplicationContext(), "提交成功", Toast.LENGTH_LONG).show();

                            } else {
                                SharedPreferences a8 = getSharedPreferences("c8", Context.MODE_PRIVATE);
                                a8.edit().clear().commit();
                            }
                            if (checkBox9.isChecked()) {
                                SharedPreferences a9 = getSharedPreferences("c9", Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor = a9.edit();
                                editor.putString("d9", checkBox9.getText().toString());
                                editor.commit();
                                Toast.makeText(getApplicationContext(), "提交成功", Toast.LENGTH_LONG).show();

                            } else {
                                SharedPreferences a9 = getSharedPreferences("c9", Context.MODE_PRIVATE);
                                a9.edit().clear().commit();
                            }
                            if (checkBox11.isChecked()) {
                                SharedPreferences a11 = getSharedPreferences("c11", Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor = a11.edit();
                                editor.putString("d11", checkBox11.getText().toString());
                                editor.commit();
                                Toast.makeText(getApplicationContext(), "提交成功", Toast.LENGTH_LONG).show();

                            } else {
                                SharedPreferences a11 = getSharedPreferences("c11", Context.MODE_PRIVATE);
                                a11.edit().clear().commit();
                            }
                            if (checkBox12.isChecked()) {
                                SharedPreferences a12 = getSharedPreferences("c12", Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor = a12.edit();
                                editor.putString("d12", checkBox12.getText().toString());
                                editor.commit();
                                Toast.makeText(getApplicationContext(), "提交成功", Toast.LENGTH_LONG).show();

                            } else {
                                SharedPreferences a12 = getSharedPreferences("c12", Context.MODE_PRIVATE);
                                a12.edit().clear().commit();
                            }
                            if (checkBox13.isChecked()) {
                                SharedPreferences a13 = getSharedPreferences("c13", Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor = a13.edit();
                                editor.putString("d13", checkBox13.getText().toString());
                                editor.commit();
                                Toast.makeText(getApplicationContext(), "提交成功", Toast.LENGTH_LONG).show();

                            } else {
                                SharedPreferences a13 = getSharedPreferences("c13", Context.MODE_PRIVATE);
                                a13.edit().clear().commit();
                            }
                            if (checkBox14.isChecked()) {
                                SharedPreferences a14 = getSharedPreferences("c14", Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor = a14.edit();
                                editor.putString("d14", checkBox14.getText().toString());
                                editor.commit();
                                Toast.makeText(getApplicationContext(), "提交成功", Toast.LENGTH_LONG).show();

                            } else {
                                SharedPreferences a14 = getSharedPreferences("c14", Context.MODE_PRIVATE);
                                a14.edit().clear().commit();
                            }
                            if (checkBox15.isChecked()) {
                                SharedPreferences a15 = getSharedPreferences("c15", Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor = a15.edit();
                                editor.putString("d15", checkBox15.getText().toString());
                                editor.commit();
                                Toast.makeText(getApplicationContext(), "提交成功", Toast.LENGTH_LONG).show();

                            } else {
                                SharedPreferences a15 = getSharedPreferences("c15", Context.MODE_PRIVATE);
                                a15.edit().clear().commit();
                            }
                            if (checkBox16.isChecked()) {
                                SharedPreferences a16 = getSharedPreferences("c16", Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor = a16.edit();
                                editor.putString("d16", checkBox16.getText().toString());
                                editor.commit();
                                Toast.makeText(getApplicationContext(), "提交成功", Toast.LENGTH_LONG).show();

                            } else {
                                SharedPreferences a16 = getSharedPreferences("c16", Context.MODE_PRIVATE);
                                a16.edit().clear().commit();
                            }
                            if (checkBox17.isChecked()) {
                                SharedPreferences a17 = getSharedPreferences("c17", Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor = a17.edit();
                                editor.putString("d17", checkBox17.getText().toString());
                                editor.commit();
                                Toast.makeText(getApplicationContext(), "提交成功", Toast.LENGTH_LONG).show();

                            } else {
                                SharedPreferences a17 = getSharedPreferences("c17", Context.MODE_PRIVATE);
                                a17.edit().clear().commit();
                            }
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
                            String date = sdf.format(new java.util.Date());
                            SharedPreferences time = getSharedPreferences("shijian", Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = time.edit();
                            editor.putString("sj", date);
                            editor.commit();
                            SharedPreferences a18 = getSharedPreferences("c18", Context.MODE_PRIVATE);
                            SharedPreferences.Editor jilu = a18.edit();
                            jilu.putString("d18", beizhu.getText().toString());
                            jilu.commit();

                            SharedPreferences byTimes = getSharedPreferences("c19", Context.MODE_PRIVATE);
                            int times = byTimes.getInt("d19", 0);
                            if (times == 0) {
                                times = 1;
                                byTimes.edit().putInt("d19", times).commit();
                            } else {
                                byTimes.edit().putInt("d19", times + 1).commit();
                            }
                    /*SharedPreferences a19 = getSharedPreferences("c19", Context.MODE_PRIVATE);
                    SharedPreferences.Editor cs = a19.edit();
                    cs.putInt("d19", 0);
                    cs.commit();*/


                            Intent intent2 = new Intent(BaoyangList.this, UserActivity.class);
                            startActivity(intent2);
                            finish();


                        }
                    }).setNegativeButton("取消", new DialogInterface.OnClickListener() {


                        public void onClick(DialogInterface dialog, int which) {
//取消后要执行的语句
//取消
                            dialog.cancel();

                        }
                    }).create();
                    alertbBuilder.show();

                } else {
                    SharedPreferences time = getSharedPreferences("shijian", Context.MODE_PRIVATE);
                    time.edit().clear().commit();
                    Toast.makeText(getApplicationContext(), "提交数据为空，请选择保养项目！", Toast.LENGTH_LONG).show();
                }

                break;
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


//        checkBox.setOnCheckedChangeListener(listener);
//        checkBox2.setOnCheckedChangeListener(listener);
//        checkBox3.setOnCheckedChangeListener(listener);
//        checkBox4.setOnCheckedChangeListener(listener);
//        checkBox5.setOnCheckedChangeListener(listener);
//        checkBox6.setOnCheckedChangeListener(listener);
//        checkBox7.setOnCheckedChangeListener(listener);
//        checkBox8.setOnCheckedChangeListener(listener);
//        checkBox9.setOnCheckedChangeListener(listener);
//        checkBox11.setOnCheckedChangeListener(listener);
//        checkBox12.setOnCheckedChangeListener(listener);
//        checkBox13.setOnCheckedChangeListener(listener);
//        checkBox14.setOnCheckedChangeListener(listener);
//        checkBox15.setOnCheckedChangeListener(listener);
//        checkBox16.setOnCheckedChangeListener(listener);
//        checkBox17.setOnCheckedChangeListener(listener);
//
//
//    }
//
//    private OnCheckedChangeListener listener = new OnCheckedChangeListener() {
//        @Override
//        public void onCheckedChanged(CompoundButton tijiao, boolean isChecked) {
//            switch (tijiao.getId()) {
//                case R.id.tijiao:
//
//
//            }
//
//
//        }
//    };
//}




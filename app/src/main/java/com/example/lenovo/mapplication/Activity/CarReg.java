package com.example.lenovo.mapplication.Activity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.mapplication.R;

import java.util.Calendar;

public class CarReg extends AppCompatActivity implements View.OnClickListener {
    private TextView didian,regtime,back3, carid,changedidian, changecarid, changeregtime, didian1, chengshi1, chengshi2, chengshi3, chengshi4, chengshi5,baoxiantime,changebaoxiantime,nianjiantime,changenianjiantime;
    private Button tureinf;
    private LinearLayout shenhui, city;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_reg);
        back3 = findViewById(R.id.back3);
        back3.setOnClickListener(this);
        changedidian = findViewById(R.id.changedidian);
        changedidian.setOnClickListener(this);
        carid = findViewById(R.id.carid);
        changecarid = findViewById(R.id.changecarid);
        changecarid.setOnClickListener(this);
        changeregtime = findViewById(R.id.changeregtime);
        changeregtime.setOnClickListener(this);
        didian1 = findViewById(R.id.didian1);
        didian1.setOnClickListener(this);
        chengshi1 = findViewById(R.id.chengshi1);
        chengshi1.setOnClickListener(this);
        chengshi2 = findViewById(R.id.chengshi2);
        chengshi2.setOnClickListener(this);
        chengshi3 = findViewById(R.id.chengshi3);
        chengshi3.setOnClickListener(this);
        chengshi4 = findViewById(R.id.chengshi4);
        chengshi4.setOnClickListener(this);
        chengshi5 = findViewById(R.id.chengshi5);
        chengshi5.setOnClickListener(this);
        tureinf = findViewById(R.id.tureinf);
        tureinf.setOnClickListener(this);
        regtime = findViewById(R.id.regtime);
        shenhui = findViewById(R.id.shenhui);
        city = findViewById(R.id.city);
        didian = findViewById(R.id.didian);
        baoxiantime = findViewById(R.id.baoxiantime);
        nianjiantime = findViewById(R.id.nianjiantime);
        changebaoxiantime = findViewById(R.id.changebaoxiantime);
        changebaoxiantime.setOnClickListener(this);
        changenianjiantime = findViewById(R.id.changenianjiantime);
        changenianjiantime.setOnClickListener(this);



    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back3:
                finish();
                break;

            case R.id.changeregtime:

                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);//当前年
                int month = calendar.get(Calendar.MONTH);//当前月
                int day = calendar.get(Calendar.DAY_OF_MONTH);//当前日
                //new一个日期选择对话框的对象,并设置默认显示时间为当前的年月日时间.
                DatePickerDialog dialog = new DatePickerDialog(this, mdateListener, year, month, day);
                dialog.show();
                break;
            case R.id.tureinf:
                AlertDialog.Builder alertbBuilder = new AlertDialog.Builder(CarReg.this);
                alertbBuilder.setTitle("提示").setMessage("确认提交吗？").setPositiveButton("确定", new DialogInterface.OnClickListener() {


                    public void onClick(DialogInterface dialog, int which) {
                        //确定后要执行的语句
                        //结束这个Activity
                        String datxx = didian.getText().toString();
                        String dataa = regtime.getText().toString();
                        String datbb = baoxiantime.getText().toString();
                        String datcc = nianjiantime.getText().toString();
                        String datdd = carid.getText().toString();
                        SharedPreferences shanglu = getSharedPreferences("firsttime", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor =shanglu.edit();
                        editor.putString("n",dataa);
                        editor.putString("b",datbb);
                        editor.putString("v",datcc);
                        editor.putString("c",datxx);
                        editor.putString("x",datdd);
                        editor.commit();
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

                break;
            case R.id.changedidian:
                shenhui.setVisibility(View.VISIBLE);
                break;
            case R.id.didian1:
                city.setVisibility(View.VISIBLE);
                break;
            case R.id.chengshi1:
                didian.setText("宁夏-银川");
                shenhui.setVisibility(View.GONE);
                city.setVisibility(View.GONE);
                break;
            case R.id.chengshi2:
                didian.setText("宁夏-中卫");
                shenhui.setVisibility(View.GONE);
                city.setVisibility(View.GONE);
                break;
            case R.id.chengshi3:
                didian.setText("宁夏-青铜峡");
                shenhui.setVisibility(View.GONE);
                city.setVisibility(View.GONE);
                break;
            case R.id.chengshi4:
                didian.setText("宁夏-灵武");
                shenhui.setVisibility(View.GONE);
                city.setVisibility(View.GONE);
                break;
            case R.id.chengshi5:
                didian.setText("宁夏-吴忠");
                shenhui.setVisibility(View.GONE);
                city.setVisibility(View.GONE);
                break;
            case R.id.changebaoxiantime:
                Calendar calendar2 = Calendar.getInstance();
                int year2 = calendar2.get(Calendar.YEAR);//当前年
                int month2 = calendar2.get(Calendar.MONTH);//当前月
                int day2 = calendar2.get(Calendar.DAY_OF_MONTH);//当前日
                //new一个日期选择对话框的对象,并设置默认显示时间为当前的年月日时间.
                DatePickerDialog dialog2 = new DatePickerDialog(this, ndateListener, year2, month2, day2);
                dialog2.show();
                break;
            case R.id.changenianjiantime:
                Calendar calendar3 = Calendar.getInstance();
                int year3 = calendar3.get(Calendar.YEAR);//当前年
                int month3 = calendar3.get(Calendar.MONTH);//当前月
                int day3 = calendar3.get(Calendar.DAY_OF_MONTH);//当前日
                //new一个日期选择对话框的对象,并设置默认显示时间为当前的年月日时间.
                DatePickerDialog dialog3 = new DatePickerDialog(this, bdateListener, year3, month3, day3);
                dialog3.show();
                break;
            case R.id.changecarid:
                final EditText editText = new EditText(CarReg.this);
                AlertDialog.Builder inputDialog = new AlertDialog.Builder(CarReg.this);
                inputDialog.setTitle("请输入车牌号").setView(editText);
                inputDialog.setPositiveButton("确定",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                if(editText.getText().toString().length()<6) {
                                    Toast.makeText(CarReg.this, "无效车牌！", Toast.LENGTH_LONG).show();
                                }else {
                                    carid.setText(editText.getText().toString());
                                }

                            }
                        }).show();
        }

    }




    /**
     * 日期选择的回调监听1
     */
    private DatePickerDialog.OnDateSetListener mdateListener = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int years, int month, int day) {
            int i = month + 1;
            regtime.setText(years+"-"+i+"-"+day);
            Log.i("dataa", "年" + years + "月" + i + "日" + day);
            //这里月份是从0开始的,所以monthOfYear的值是0时就是1月.以此类推,加1就是实际月份了.
        }
    };

    /**
     * 日期选择的回调监听2
     */
    private DatePickerDialog.OnDateSetListener ndateListener = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int years2, int month2, int day2) {
            int i2 = month2 + 1;
            baoxiantime.setText(years2+"-"+i2+"-"+day2);
            Log.i("dataa", "年" + years2 + "月" + i2 + "日" + day2);
            //这里月份是从0开始的,所以monthOfYear的值是0时就是1月.以此类推,加1就是实际月份了.
        }
    };

    /**
     * 日期选择的回调监听3
     */
    private DatePickerDialog.OnDateSetListener bdateListener = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int years3, int month3, int day3) {
            int i3 = month3 + 1;
            nianjiantime.setText(years3+"-"+i3+"-"+day3);
            Log.i("dataa", "年" + years3 + "月" + i3 + "日" + day3);
            //这里月份是从0开始的,所以monthOfYear的值是0时就是1月.以此类推,加1就是实际月份了.
        }
    };

}


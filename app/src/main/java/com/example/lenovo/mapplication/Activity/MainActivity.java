package com.example.lenovo.mapplication.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.mapplication.R;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView text;
    private EditText etID;
    private EditText etPrssword;
    private Button btnLogin;
    private Button zhuce;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etID = findViewById(R.id.et_id);
        etPrssword = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(this);
        zhuce = findViewById(R.id.btn_zhuce);
        zhuce.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:

                SharedPreferences sp = getSharedPreferences("userinfomation", Context.MODE_PRIVATE);
                String phone = sp.getString("phone", "");
                String password = sp.getString("password","");
                Log.i("msg", "showMsg----->" + phone);
                if (etID.getText().toString().equals("139") & etPrssword.getText().toString().equals("cc")) {
                    Toast.makeText(this, "登录成功！", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(this, UserActivity.class);
                    startActivity(intent);
                    etID.setText("");
                    etPrssword.setText("");

                } else if (etID.getText().toString().equals(phone) & etPrssword.getText().toString().equals(password)) {
                    Toast.makeText(this, "登录成功！", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(this, UserActivity.class);
                    startActivity(intent);
                    etID.setText("");
                    etPrssword.setText("");
                } else {
                    Toast.makeText(this, "账号或密码错误！", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.btn_zhuce:
//                Log.i("msg","--------<");
                Intent intent = new Intent(this, Reg.class);
                startActivity(intent);
                break;
        }
    }

    private long exitTime = 0;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK
                && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {

                Toast.makeText(getApplicationContext(), "再按一次退出车凤凰", Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                System.exit(0);
            }
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }
}



package com.example.workflowmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class SplashActivity2 extends AppCompatActivity {
    LinearLayout linearLayout;
    Button button_sign,button_login;
    TextInputEditText edit_name,edit_password;
    TextView textView;
    TextInputLayout textInputLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash2);
        AnhXa();

        button_sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SplashActivity2.this, SignActivity2.class);
                startActivity(intent);
            }
        });
        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickLogin();
            }
        });
        linearLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                return false;
            }
        });
    }

    private void AnhXa() {
        linearLayout = (LinearLayout) findViewById (R.id.linear);
        button_sign = (Button) findViewById(R.id.button_sign);
        button_sign = (Button) findViewById(R.id.button_sign);
        button_login = (Button) findViewById(R.id.button_login);
        edit_name = (TextInputEditText) findViewById(R.id.user);
        edit_password = (TextInputEditText)  findViewById(R.id.password);
        textView = (TextView) findViewById(R.id.textview);
        textInputLayout = (TextInputLayout)  findViewById(R.id.textinputlayout);
    }
    private void clickLogin(){
        String name = edit_name.getText().toString().trim();
        String passWord = edit_password.getText().toString().trim();
        User user1 = new User (name,passWord);
        textView.setVisibility(View.VISIBLE);
        if(user1.isValiName()&&user1.isValiPassWord()){
            Intent intent = new Intent(SplashActivity2.this,HomepageActivity2.class);
            startActivity(intent);
        }
        else{
            textView.setText("Đăng nhập thất bại");
            textView.setTextColor(getResources().getColor(R.color.purple_200));
        }

    }

}
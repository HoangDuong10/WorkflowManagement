package com.example.workflowmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.workflowmanagement.api.ApiService;
import com.example.workflowmanagement.model.ErrorResponse;
import com.example.workflowmanagement.model.LoginReponse;
import com.example.workflowmanagement.model.User;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private LinearLayout linearLayout;
    private Button button_sign, button_login;
    private TextInputEditText edit_name, edit_password;
    private TextView textView;
    private TextInputLayout textInputLayout;
    private List<User> listUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        anhXa();

        button_sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
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

        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(clickLogin()){
                    Intent intent = new Intent(LoginActivity.this, HomepageActivity2.class);
                    startActivity(intent);
                }
            }
        });

    }

    private void anhXa() {
        linearLayout = (LinearLayout) findViewById(R.id.linear);
        button_sign = (Button) findViewById(R.id.button_sign);
        button_sign = (Button) findViewById(R.id.button_sign);
        button_login = (Button) findViewById(R.id.button_login);
        edit_name = (TextInputEditText) findViewById(R.id.user);
        edit_password = (TextInputEditText) findViewById(R.id.password);
        textView = (TextView) findViewById(R.id.textview);
        textInputLayout = (TextInputLayout) findViewById(R.id.textinputlayout);
    }

    private boolean clickLogin() {
        String name = edit_name.getText().toString().trim();
        String passWord = edit_password.getText().toString().trim();
        User user1 = new User(name, passWord);
        textView.setVisibility(View.VISIBLE);
        if(user1.isValiName()&&user1.isValiPassWord()){
            return true;
        }else if (!user1.isValiName()) {
            textView.setText("Bạn phải nhập tên đăng nhập");
            textView.setTextColor(getResources().getColor(R.color.red));
        } else if (!user1.isValiPassWord()) {
            textView.setText("Bạn phải nhập mật khẩu từ 6 kí tự trỏ lên");
            textView.setTextColor(getResources().getColor(R.color.red));
        }
        return false;
    }

        private void getListUser () {
            User user = new User(edit_name.getText().toString(), edit_password.getText().toString());
            ApiService.apiService.getListUser(user).enqueue(new Callback<LoginReponse>() {
                @Override
                public void onResponse(Call<LoginReponse> call, Response<LoginReponse> response) {
                    if (response.isSuccessful()) {
                        Intent intent = new Intent(LoginActivity.this, HomepageActivity2.class);
                        startActivity(intent);

                    }else{
                        try {
                            String errorBody = response.errorBody().string();
                            ErrorResponse errorResponse = new Gson().fromJson(errorBody, ErrorResponse.class);
                            String errorMessage = errorResponse.getMessage();
                            if(errorMessage.equals("Access Denied")) {
                                textView.setText("Tài khoản hoặc mật khẩu không chính xác");
                                textView.setTextColor(getResources().getColor(R.color.red));
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }

                @Override
                public void onFailure(Call<LoginReponse> call, Throwable t) {

                }
            });
        }

    }

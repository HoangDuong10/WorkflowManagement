package com.example.workflowmanagement;



import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.workflowmanagement.api.ApiService;
import com.example.workflowmanagement.model.ErrorResponse;
import com.example.workflowmanagement.model.User;
import com.google.android.material.textfield.TextInputEditText;
import com.google.gson.Gson;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {
    private LinearLayout linearLayout;
    private Button button;
    private TextInputEditText email,userName,passWord;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        anhXa();
        linearLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                return false;
            }
        });
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(checkLogup())  {
//                    addUser();
//                }
//
//
//            }
//        });
    }
    private void anhXa(){
        linearLayout=findViewById(R.id.linear);
        button = findViewById(R.id.button_sign);
        email =findViewById(R.id.email);
        userName=findViewById(R.id.username);
        passWord=findViewById(R.id.password);
        textView = findViewById(R.id.textview);
    }
    private void addUser(){
        Handler handler = new Handler();
        User user = new User(email.getText().toString(),
                userName.getText().toString(),passWord.getText().toString());
        ApiService.apiService.register(user).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(RegisterActivity.this, "thành công", Toast.LENGTH_SHORT).show();
                    textView.setText("email đã đăng kí");
                    textView.setTextColor(getResources().getColor(R.color.red));
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            textView.setVisibility(View.GONE);

                        }
                    }, 5000);
                } else {
                   try {
                           String errorBody = response.errorBody().string();
                           ErrorResponse errorResponse = new Gson().fromJson(errorBody, ErrorResponse.class);
                           String errorMessage = errorResponse.getMessage();
                           if(errorMessage.equals("email đã tồn tại")) {
                               textView.setText("email đã tồn tại");
                               textView.setTextColor(getResources().getColor(R.color.red));
                           }else if(errorMessage.equals(("username đã tồn tại"))){
                                textView.setText("username đã tồn tại");
                                textView.setTextColor(getResources().getColor(R.color.red));
                           }
                         } catch (IOException e) {
                           e.printStackTrace();
                         }


                }
            }
            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(RegisterActivity.this, "Không gọi được API", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private boolean checkLogup(){
        String name  = userName.getText().toString().trim();
        String email1=  email.getText().toString().trim();
        String passWord1=passWord.getText().toString().trim();
        User user = new User(email1,name,passWord1);
        textView.setVisibility(View.VISIBLE);
        if(user.isValiEmail()&&user.isValiName()&&user.isValiPassWord()){
            return true;
        }else if(!user.isValiEmail()){
            textView.setText("Email không hợp lệ");
            textView.setTextColor(getResources().getColor(R.color.red));

        }    else if(!user.isValiName()){
            textView.setText("Bạn phải nhập tên đăng nhập");
            textView.setTextColor(getResources().getColor(R.color.red));

        }  else if(!user.isValiPassWord()){
            textView.setText("Bạn phải nhập mật khẩu từ 6 kí tự trỏ lên");
            textView.setTextColor(getResources().getColor(R.color.red));
             
        }else if(!user.checkEmail()){
            textView.setText("Bạn nhập sai định dạng email");
            textView.setTextColor(getResources().getColor(R.color.red));
        }
        return false;

    }
}
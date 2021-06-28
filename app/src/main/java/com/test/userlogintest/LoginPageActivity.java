package com.test.userlogintest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginPageActivity extends AppCompatActivity {

    TextView signUp;
    EditText loginUserName, loginPwd;
    Button loginBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        signUp=findViewById(R.id.textView2);
        loginUserName=findViewById(R.id.editTextTextEmailAddress);
        loginPwd=findViewById(R.id.editTextTextPassword);
        loginBtn=findViewById(R.id.button);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(loginUserName.getText().toString().isEmpty() || loginPwd.getText().toString().isEmpty()){
                    Toast.makeText(LoginPageActivity.this, "Please enter your user name & password", Toast.LENGTH_SHORT).show();
                } else {

                    String getUserName = loginUserName.getText().toString();
                    String getPwd = loginPwd.getText().toString();

                    if (SignUpActivity.userList.size() > 0) {
                        for(int x = 0; x < SignUpActivity.userList.size(); x++){
                            if(getUserName.equals(SignUpActivity.userList.get(x).getStrUserName()) &&
                                    getPwd.equals(SignUpActivity.userList.get(x).getStrPwd())){
                                startActivity(new Intent(LoginPageActivity.this, DashBoard.class));
                                Toast.makeText(LoginPageActivity.this, "Login success", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(LoginPageActivity.this, "Your user name and Password is invalid", Toast.LENGTH_SHORT).show();
                            }
                        }
                    } else {
                        Toast.makeText(LoginPageActivity.this, "No user found", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });


        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginPageActivity.this, SignUpActivity.class));

            }
        });

    }


}
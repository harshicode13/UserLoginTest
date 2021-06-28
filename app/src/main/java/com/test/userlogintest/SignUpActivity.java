package com.test.userlogintest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;


public class SignUpActivity extends AppCompatActivity {


    Button signupCancel, signupSubmit;
    EditText signupFirstName, signupSecondName, signupUserName, signupPhoneNumber, signupCreatePwd, signupConfirmPwd;
    RadioButton radioBtnMale, radioBtnFemale;

    static ArrayList<UserDetails> userList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        signupSubmit = findViewById(R.id.button5);
        signupCancel = findViewById(R.id.button3);

        signupFirstName = findViewById(R.id.editTextTextPersonName);
        signupSecondName = findViewById(R.id.editTextTextPersonName2);
        signupUserName = findViewById(R.id.editTextTextPersonName3);
        signupPhoneNumber = findViewById(R.id.editTextTextPersonName4);
        signupCreatePwd = findViewById(R.id.editTextTextPersonName5);
        signupConfirmPwd = findViewById(R.id.editTextTextPersonName6);

        radioBtnMale = findViewById(R.id.radioButtonmale);
        radioBtnFemale = findViewById(R.id.radioButtonfemale);


        signupCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        signupSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                UserDetails objUserDetail = new UserDetails();
                objUserDetail.setStrFirstName(signupFirstName.getText().toString());
                objUserDetail.setStrSecondName(signupSecondName.getText().toString());
                objUserDetail.setStrUserName(signupUserName.getText().toString());
                objUserDetail.setStrPhoneNumber(signupPhoneNumber.getText().toString());

                if (radioBtnMale.isChecked()) {
                    objUserDetail.setStrGender("Male");
                } else if (radioBtnFemale.isChecked()) {
                    objUserDetail.setStrGender("Female");
                }


                if (signupFirstName.getText().toString().isEmpty() || signupUserName.getText().toString().isEmpty()) {

                    Toast.makeText(SignUpActivity.this, "Please add first & user name", Toast.LENGTH_SHORT).show();

                } else {

                    if (signupCreatePwd.getText().toString().equals(signupConfirmPwd.getText().toString())) {
                        objUserDetail.setStrPwd(signupConfirmPwd.getText().toString());

                        userList.add(objUserDetail);
                        Toast.makeText(SignUpActivity.this, "Account successfully created", Toast.LENGTH_SHORT).show();

                        finish();

                    } else {
                        Toast.makeText(SignUpActivity.this, "Mismatching password", Toast.LENGTH_SHORT).show();
                    }

                }


            }
        });


    }


    class UserDetails {

        String strFirstName, strSecondName, strUserName, strPhoneNumber, strGender, strPwd;

        public String getStrFirstName() {
            return strFirstName;
        }

        public void setStrFirstName(String strFirstName) {
            this.strFirstName = strFirstName;
        }

        public String getStrSecondName() {
            return strSecondName;
        }

        public void setStrSecondName(String strSecondName) {
            this.strSecondName = strSecondName;
        }

        public String getStrUserName() {
            return strUserName;
        }

        public void setStrUserName(String strUserName) {
            this.strUserName = strUserName;
        }

        public String getStrPhoneNumber() {
            return strPhoneNumber;
        }

        public void setStrPhoneNumber(String strPhoneNumber) {
            this.strPhoneNumber = strPhoneNumber;
        }

        public String getStrGender() {
            return strGender;
        }

        public void setStrGender(String strGender) {
            this.strGender = strGender;
        }

        public String getStrPwd() {
            return strPwd;
        }

        public void setStrPwd(String strPwd) {
            this.strPwd = strPwd;
        }


    }


}
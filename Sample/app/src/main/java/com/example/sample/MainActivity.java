package com.example.sample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    EditText EditText_email, EditText_password;
    RelativeLayout RelativeLayout_login;
    String emailOK = "123@gmail.com";
    String passwordOK = "1234";

    String inputEmail = "";
    String inputPassword = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText_email          = findViewById(R.id.EditText_email);
        EditText_password       = findViewById(R.id.EditText_password);
        RelativeLayout_login    = findViewById(R.id.RelativeLayout_login);

        //1. 값을 가져온다. - 검사 (123@gmail.com / 1234)
        //2. 클릭감지
        //3. 1의 값을 다음 액티비티로 넘긴다.

        RelativeLayout_login.setClickable(false);
        EditText_email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s != null) {
                    Log.d("SENTI", s.toString());
                    inputEmail = s.toString();
                    RelativeLayout_login.setEnabled(validation());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        EditText_password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s != null) {
                    Log.d("SENTI", s.toString());
                    inputPassword = s.toString();
                    RelativeLayout_login.setEnabled(validation());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


//        RelativeLayout_login.setClickable(true);
        RelativeLayout_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = EditText_email.getText().toString();
                String password = EditText_password.getText().toString();

                Intent intent = new Intent(MainActivity.this, LoginResultActivity.class);
                intent.putExtra( "email", email);
                intent.putExtra( "password", password);
                startActivity(intent);
            }
        });
    }

    public boolean validation() {
        return inputEmail.equals(emailOK) && inputPassword.equals(passwordOK);
    }
}

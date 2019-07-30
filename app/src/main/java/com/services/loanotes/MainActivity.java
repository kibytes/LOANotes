package com.services.loanotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;


public class MainActivity extends AppCompatActivity {

    private LOANotesOpenHelper dbHelper;
    private String userName;
    private String password;

    private EditText loginUserName;
    private EditText loginPass;
    private Button btnLogin;

    private EditText regName;
    private EditText regEmail;
    private EditText regPhone;
    private EditText regPass;
    private EditText regConfirm;
    private Button btnRegister;

    private LOAUser loaUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = new LOANotesOpenHelper(this);

        loginUserName = findViewById(R.id.login_user_name);
        loginPass = findViewById(R.id.login_pass);
        btnLogin = findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(loginUser()) {
                    startActivity(new Intent(MainActivity.this, Home.class));
                } else {
                    Snackbar.make(view, "Invalid credentials. Try again!",
                            Snackbar.LENGTH_LONG).show();
                }

            }
        });
    }

    @Override
    protected void onDestroy() {
        dbHelper.close();;
        super.onDestroy();
    }

    private boolean loginUser() {
        userName = loginUserName.getText().toString();
        password = loginPass.getText().toString();

        if(userName.length() <= 0 || password.length() <= 0) {
            return false;
        }
        DataManager manager = new DataManager();
        loaUser = manager.loadFromDatabase(dbHelper);

        if(userName.equals(loaUser.getEmail()) || userName.equals(loaUser.getPhone())){
            if(password.equals(loaUser.getPassword())) {
                return true;
            }
        }
        return false;
    }
}

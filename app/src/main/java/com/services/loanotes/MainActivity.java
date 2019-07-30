package com.services.loanotes;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
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
                    Snackbar.make(view, "You are " + userName,
                            Snackbar.LENGTH_LONG).show();
                } else {
                    Snackbar.make(view, "Clicked Login without credentials!",
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
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        userName = loginUserName.getText().toString();
        password = loginPass.getText().toString();
        if(userName.length() <= 0 || password.length() <= 0) {
            return false;
        }
        return true;
    }
}

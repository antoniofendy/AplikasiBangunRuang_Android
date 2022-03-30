package com.kelompok15.aplikasihitungbangunruang;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity
{
    private EditText etUsername, etPassword;
    private DBController dbController;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_login);

        etUsername = findViewById(R.id.edittext_username);
        etPassword = findViewById(R.id.edittext_password);

        dbController = new DBController(this, null, 1);
    }

    public void login(View view)
    {
        etUsername.clearFocus();
        etPassword.clearFocus();

        User currentUser = dbController.auth(new User(null, etUsername.getText().toString(), etPassword.getText().toString()));

        if(currentUser != null)
        {
            Toast.makeText(LoginActivity.this, "Login sukses", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            intent.putExtra("username", etUsername.getText().toString());
            startActivity(intent);
            finish();
        }
        else
        {
            Toast.makeText(LoginActivity.this, "Login gagal", Toast.LENGTH_SHORT).show();
        }
    }

    public void toRegister(View view)
    {
        etUsername.clearFocus();
        etPassword.clearFocus();

        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);
        finish();
    }

}

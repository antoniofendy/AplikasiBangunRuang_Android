package com.kelompok15.aplikasihitungbangunruang;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class RegisterActivity extends AppCompatActivity
{
    private EditText etUsername, etPassword, etPasswordRepeat;
    private DBController dbController;
    private String message;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_register);

        etUsername = findViewById(R.id.edittext_username);
        etPassword = findViewById(R.id.edittext_password);
        etPasswordRepeat = findViewById(R.id.edittext_password_repeat);

        dbController = new DBController(this, null, 1);
    }

    public void register(View view)
    {
        etUsername.clearFocus();
        etPassword.clearFocus();
        etPasswordRepeat.clearFocus();

        try
        {
            if(validasiInput(etUsername.getText().toString(), "username"))
            {
                Toast.makeText(RegisterActivity.this, message, Toast.LENGTH_SHORT).show();
            }
            else if(validasiInput(etPassword.getText().toString(), "password"))
            {
                Toast.makeText(RegisterActivity.this, message, Toast.LENGTH_SHORT).show();
            }
            else if(validasiInput(etPasswordRepeat.getText().toString(), "ulangi password"))
            {
                Toast.makeText(RegisterActivity.this, message, Toast.LENGTH_SHORT).show();
            }
            else if(validasiInput(etUsername.getText().toString(), "username"))
            {
                Toast.makeText(RegisterActivity.this, message, Toast.LENGTH_SHORT).show();
            }
            else
            {
                dbController.insertUser(new User(null, etUsername.getText().toString(), etPassword.getText().toString()));
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }
        catch (SQLiteConstraintException ce) {
            Toast.makeText(RegisterActivity.this, "Username tidak tersedia.", Toast.LENGTH_SHORT).show();
        }
        catch (SQLiteException e)
        {
            Toast.makeText(RegisterActivity.this, "Register gagal", Toast.LENGTH_SHORT).show();
        }
    }

    public void toLogin(View view)
    {
        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    //Fungsi untuk validasi input
    public boolean validasiInput (String inputValue, String inputType)
    {
        if(inputValue.length() == 0)
        {
            message = "Anda harus mengisi field " +  inputType + "!";
            return true;
        }
        else if(inputValue.length() < 5)
        {
            message = "Field " + inputType + " membutuhkan minimum 5 karakter";
            return true;
        }
        else if(inputType.equals("ulangi password") && inputValue.compareTo(etPassword.getText().toString()) != 0)
        {
            message = "Field " + inputType + " tidak sama dengan field password";
            return true;
        }

        return false;
    }
}

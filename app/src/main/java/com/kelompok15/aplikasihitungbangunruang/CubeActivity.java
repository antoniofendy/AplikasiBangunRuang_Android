package com.kelompok15.aplikasihitungbangunruang;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;

import java.util.Objects;

public class CubeActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cube);
        Objects.requireNonNull(getSupportActionBar()).hide();

        MaterialToolbar toolbar = (MaterialToolbar) findViewById(R.id.topAppBar);

        //Setting listener untuk navigation icon
        toolbar.setNavigationOnClickListener(view -> {
            Intent intent = new Intent(CubeActivity.this, MainActivity.class);

            //Flag digunakan untuk berpindah activity sebelumnya, tanpa membuat activity baru
            intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT | Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP);
            startActivity(intent);
            finish();
        });
        //Setting listener untuk submenu
        toolbar.setOnMenuItemClickListener(menuItem -> {
            if(menuItem.getItemId() == R.id.submenu_logout)
            {
                Toast.makeText(CubeActivity.this, "Anda mengklik logout", Toast.LENGTH_SHORT).show();
            }
            else if(menuItem.getItemId() == R.id.submenu_help)
            {
                Toast.makeText(CubeActivity.this, "Anda mengklik help", Toast.LENGTH_SHORT).show();
            }
            return false;
        });
    }

    public void calculate(View view)
    {
        Toast.makeText(CubeActivity.this, "Ok", Toast.LENGTH_SHORT).show();
    }
}

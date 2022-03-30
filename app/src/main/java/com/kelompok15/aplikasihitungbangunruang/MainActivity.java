package com.kelompok15.aplikasihitungbangunruang;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity
{

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textViewTitle = findViewById(R.id.textview_title);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if(bundle != null)
        {
            textViewTitle.setText("Halo, " + bundle.getString("username"));
        }

        findViewById(R.id.card_cube).setOnClickListener(view -> {
            Intent shape = new Intent(MainActivity.this, CubeActivity.class);
            startActivity(shape);
        });

        findViewById(R.id.card_cone).setOnClickListener(view -> {
            Intent shape = new Intent(MainActivity.this, ConeActivity.class);
            startActivity(shape);
        });

        findViewById(R.id.card_cuboid).setOnClickListener(view -> {
            Intent shape = new Intent(MainActivity.this, CuboidActivity.class);
            startActivity(shape);
        });
    }

    //Setting menu item
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    //Setting submenu
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        if(item.getItemId() == R.id.submenu_logout)
        {
            //Jika yang diklik adalah submenu logout
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();

        }
        else if(item.getItemId() == R.id.submenu_help)
        {
            //Jika yang diklik adalah submenu help
            Intent intent = new Intent(MainActivity.this, HelpActivity.class);
            startActivity(intent);

        }
        return super.onOptionsItemSelected(item);
    }
}
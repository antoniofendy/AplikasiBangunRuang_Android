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
            textViewTitle.setText("Halo " + bundle.getString("username"));
        }
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
            Toast.makeText(MainActivity.this, "Anda mengklik logout", Toast.LENGTH_SHORT).show();
        }
        else if(item.getItemId() == R.id.submenu_help)
        {
            //Jika yang diklik adalah submenu help
            Toast.makeText(MainActivity.this, "Anda mengklik help", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    public void toCube(View view)
    {
        Intent intent = new Intent(MainActivity.this, CubeActivity.class);
        startActivity(intent);
    }
}
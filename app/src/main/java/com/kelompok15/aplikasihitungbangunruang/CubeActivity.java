package com.kelompok15.aplikasihitungbangunruang;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;

import java.util.Objects;

public class CubeActivity extends AppCompatActivity
{
    EditText etEdgeInput;
    TextView tvSurfaceResult, tvVolumeResult;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cube);
        Objects.requireNonNull(getSupportActionBar()).hide();

        etEdgeInput = findViewById(R.id.edittext_edge);
        tvSurfaceResult = findViewById(R.id.textview_surface_result);
        tvVolumeResult = findViewById(R.id.textview_volume_result);

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
        if(etEdgeInput.length() != 0)
        {
            double edge = Double.parseDouble(String.valueOf(etEdgeInput.getText()));
            double surface = 6 * (Math.pow(edge, 2));
            double volume = Math.pow(edge, 3);

            tvSurfaceResult.setText(String.valueOf(surface));
            tvVolumeResult.setText(String.valueOf(volume));
        }
        else
        {
            Toast.makeText(CubeActivity.this, "Anda belum menginput nilai sisi a", Toast.LENGTH_SHORT).show();
        }
    }

    public void delete(View view)
    {
        etEdgeInput.setText("");
        tvSurfaceResult.setText("-");
        tvVolumeResult.setText("-");
    }
}

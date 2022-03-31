package com.kelompok15.aplikasihitungbangunruang;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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

        MaterialToolbar toolbar = findViewById(R.id.appbar_toolbar);

        //Setting listener untuk navigation icon
        toolbar.setNavigationOnClickListener(view -> {
            Intent intent = new Intent(CubeActivity.this, MainActivity.class);

            //Flag digunakan untuk berpindah activity sebelumnya, tanpa membuat activity baru
            intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT | Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP);
            startActivity(intent);
            finish();
        });

        findViewById(R.id.button_calculate).setOnClickListener(view -> {
            etEdgeInput.clearFocus();

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
                Toast.makeText(CubeActivity.this, "Semua field belum terisi.", Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.button_clear).setOnClickListener(view -> {
            etEdgeInput.clearFocus();

            etEdgeInput.setText("");
            tvSurfaceResult.setText("-");
            tvVolumeResult.setText("-");
        });
    }
}

package com.kelompok15.aplikasihitungbangunruang;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.appbar.MaterialToolbar;

import java.util.Objects;

public class CuboidActivity extends AppCompatActivity {
    EditText etLength, etWidth, etHeight;
    TextView tvSurfaceResult, tvVolumeResult;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuboids);
        Objects.requireNonNull(getSupportActionBar()).hide();

        etLength = findViewById(R.id.edittext_length);
        etWidth = findViewById(R.id.edittext_width);
        etHeight = findViewById(R.id.edittext_height);
        tvSurfaceResult = findViewById(R.id.textview_surface_result);
        tvVolumeResult = findViewById(R.id.textview_volume_result);

        MaterialToolbar toolbar = findViewById(R.id.appbar_toolbar);

        //Setting listener untuk navigation icon
        toolbar.setNavigationOnClickListener(view -> {
            Intent intent = new Intent(CuboidActivity.this, MainActivity.class);

            //Flag digunakan untuk berpindah activity sebelumnya, tanpa membuat activity baru
            intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT | Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP);
            startActivity(intent);
            finish();
        });

        findViewById(R.id.button_calculate).setOnClickListener(view -> {
            etLength.clearFocus();
            etHeight.clearFocus();
            etWidth.clearFocus();

            if(etLength.length() != 0 && etWidth.length()!=0 && etHeight.length() !=0)
            {
                double Length = Double.parseDouble(String.valueOf(etLength.getText()));
                double Width = Double.parseDouble(String.valueOf(etWidth.getText()));
                double Height = Double.parseDouble(String.valueOf(etHeight.getText()));

                double surface = 2* ((Length * Width) + (Length * Height) + (Width * Height));
                double volume = Length * Width * Height;

                tvSurfaceResult.setText(String.valueOf(surface));
                tvVolumeResult.setText(String.valueOf(volume));
            }
            else
            {
                Toast.makeText(CuboidActivity.this, "Semua field belum terisi.", Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.button_clear).setOnClickListener(view -> {
            etLength.clearFocus();
            etHeight.clearFocus();
            etWidth.clearFocus();

            etLength.setText("");
            etWidth.setText("");
            etHeight.setText("");
            tvSurfaceResult.setText("-");
            tvVolumeResult.setText("-");
        });
    }
}

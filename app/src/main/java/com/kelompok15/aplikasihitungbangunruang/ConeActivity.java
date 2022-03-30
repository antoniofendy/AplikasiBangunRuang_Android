package com.kelompok15.aplikasihitungbangunruang;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.appbar.MaterialToolbar;

import java.text.DecimalFormat;
import java.util.Objects;

public class ConeActivity extends AppCompatActivity {

    EditText etRadInput, etHeightInput;
    TextView tvSurfaceResult, tvVolumeResult;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cone);
        Objects.requireNonNull(getSupportActionBar()).hide();

        etRadInput = findViewById(R.id.edittext_rad);
        etHeightInput = findViewById(R.id.edittext_height);
        tvSurfaceResult = findViewById(R.id.textview_surface_result);
        tvVolumeResult = findViewById(R.id.textview_volume_result);

        MaterialToolbar toolbar = (MaterialToolbar) findViewById(R.id.topAppBar);

        //Setting listener untuk navigation icon
        toolbar.setNavigationOnClickListener(view -> {
            Intent intent = new Intent(ConeActivity.this, MainActivity.class);

            //Flag digunakan untuk berpindah activity sebelumnya, tanpa membuat activity baru
            intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT | Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP);
            startActivity(intent);
            finish();
        });
    }

    public void calculate(View view){
        etRadInput.clearFocus();
        etHeightInput.clearFocus();

        float phi = 3.14f;                                                                          //Deklarasi variabel Phi

        if(etRadInput.length() != 0 && etHeightInput.length() != 0)
        {
            double rad = Double.parseDouble(String.valueOf(etRadInput.getText()));
            double height = Double.parseDouble(String.valueOf(etHeightInput.getText()));

            double slant =  Math.sqrt(Math.pow(rad,2) + Math.pow(height,2));                        // (Pythagoras (Akar dari r^2 + t^2))
            double surface = (phi * (Math.pow(rad,2))) + (phi * rad * slant) ;                      // (Phi * r^2) + (Phi * r * s)
            double volume = (phi * (Math.pow(rad, 2)) * height) / 3;                                // (Phi * r^2 * t)/3

            tvSurfaceResult.setText(String.format("%.3f", surface));
            tvVolumeResult.setText(String.format("%.3f", volume));
        }
        else if(etRadInput.length() == 0)
        {
            Toast.makeText(ConeActivity.this, "Anda belum menginput nilai jari-jari (r)", Toast.LENGTH_SHORT).show();
        }
        else if(etHeightInput.length() == 0)
        {
            Toast.makeText(ConeActivity.this, "Anda belum menginput nilai tinggi (h)", Toast.LENGTH_SHORT).show();
        }else
        {
            Toast.makeText(ConeActivity.this, "Anda belum menginput nilai jari-jari (r) dan tinggi (h)", Toast.LENGTH_SHORT).show();
        }
    }

    public void delete(View view)
    {
        etRadInput.clearFocus();
        etHeightInput.clearFocus();

        etRadInput.setText("");
        etHeightInput.setText("");
        tvSurfaceResult.setText("-");
        tvVolumeResult.setText("-");
    }

}

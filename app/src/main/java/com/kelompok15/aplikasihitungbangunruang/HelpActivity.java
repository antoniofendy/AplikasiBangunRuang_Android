package com.kelompok15.aplikasihitungbangunruang;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.card.MaterialCardView;

import java.util.Objects;

public class HelpActivity  extends AppCompatActivity {
    MaterialCardView card;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String mailTitle = "Butuh bantuan | Aplikasi Hitung Bangun Ruang";

        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_help);

        findViewById(R.id.card_help_contact_fendy).setOnClickListener(view -> {
            String[] mail = {"s31190038@student.ubm.ac.id"};
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_EMAIL, mail);
            intent.putExtra(Intent.EXTRA_SUBJECT, mailTitle);
            startActivity(intent);
        });

        findViewById(R.id.card_help_contact_johanes).setOnClickListener(view -> {
            String[] mail = {"s31190042@student.ubm.ac.id"};
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_EMAIL, mail);
            intent.putExtra(Intent.EXTRA_SUBJECT, mailTitle);
            startActivity(intent);
        });

        findViewById(R.id.card_help_contact_kosasi).setOnClickListener(view -> {
            String[] mail = {"s31190050@student.ubm.ac.id"};
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_EMAIL, mail);
            intent.putExtra(Intent.EXTRA_SUBJECT, mailTitle);
            startActivity(intent);
        });

        findViewById(R.id.card_help_contact_michelle).setOnClickListener(view -> {
            String[] mail = {"s31190052@student.ubm.ac.id"};
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_EMAIL, mail);
            intent.putExtra(Intent.EXTRA_SUBJECT, mailTitle);
            startActivity(intent);
        });

        findViewById(R.id.card_help_contact_phone).setOnClickListener(view -> {
            String no = "081234567890";
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.fromParts("tel", no, null));
            startActivity(intent);
        });

        findViewById(R.id.card_help_contact_source).setOnClickListener(view -> {
            String url = "https://bit.ly/BangunRuangAppSource";
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(url));
            startActivity(intent);
        });
    }


}

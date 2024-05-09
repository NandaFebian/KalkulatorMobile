package com.example.kalkulator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnMove = findViewById(R.id.btnMove);
        Button btnShare = findViewById(R.id.btnShare);

        btnMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perintah Intent Explicit pindah halaman ke activity_detail
                startActivity(new Intent(MainActivity.this, DetailActivity.class));
            }
        });

        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perintah Intent Implicit untuk share ke sosmed
                Intent intent = new Intent(Intent.ACTION_SEND);

                // Membawa data / pesan yang ingin dishare
                intent.putExtra(Intent.EXTRA_TEXT, "Hallo saya share ke sosial media");
                intent.setType("text/plain");

                // Menjalankan perintah Intent Implicit
                startActivity(Intent.createChooser(intent, "Share to :"));
            }
        });
    }
}

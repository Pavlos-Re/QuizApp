package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;

public class About extends AppCompatActivity {
    Button coolButton;
    MediaPlayer media;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        media = MediaPlayer.create(About.this, R.raw.pop );
        coolButton = (Button) findViewById(R.id.button_cool);
        coolButton.setOnClickListener(v -> {
            media.start();
            finish();
        });
    }
}

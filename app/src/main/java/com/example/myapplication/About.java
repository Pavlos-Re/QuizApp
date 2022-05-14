package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;

import java.util.Locale;

public class About extends localeHelper {
    Button coolButton;
    MediaPlayer media;
    private Locale locale;
    private static Context context;
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
    public static Context getAppContext() {
        return context;
    }

}
